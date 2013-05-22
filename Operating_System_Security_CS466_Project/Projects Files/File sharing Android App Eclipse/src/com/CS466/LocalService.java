package com.CS466;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class LocalService extends Service {
	private static Timer timer = new Timer();
	private Context ctx;
	public static final String READY = "Ready";
    public static final String BUSY = "Busy";
    public static final String spliter = "#";
    public static final String broadcastMessage = "IAmFileShareingApp";
    public static String broadcastName = "Android";
    public static String serverState = READY;
    public static int broadcastPort = 8887;

	public IBinder onBind(Intent arg0) {
		return null;
	}

	public void onCreate() {
		super.onCreate();
		ctx = this;
		startService();
	}

	private void startService() {
		timer.scheduleAtFixedRate(new mainTask(), 0, 15000);
		startBroadcastReciverService();

	}

	private void startBroadcastReciverService() {

		new Thread(new reciverThread(LocalService.this)).start();

	}

	private class mainTask extends TimerTask {
		public void run() {
			try {
				DatagramSocket c = new DatagramSocket();
				c.setBroadcast(true);

                byte[] sendData = (broadcastMessage + spliter + broadcastName  + spliter + serverState).getBytes();

				//byte[] sendData = "I AM File Share App".getBytes();

				// Try the 255.255.255.255 first

				DatagramPacket sendPacketTO255 = new DatagramPacket(sendData,
						sendData.length,
						InetAddress.getByName("255.255.255.255"), broadcastPort);
				c.send(sendPacketTO255);
				System.out
						.println(getClass().getName()
								+ ">>> Request packet sent to: 255.255.255.255 (DEFAULT)");

				// Broadcast the message over all the network interfaces
				Enumeration interfaces = NetworkInterface
						.getNetworkInterfaces();
				while (interfaces.hasMoreElements()) {
					NetworkInterface networkInterface = (NetworkInterface) interfaces
							.nextElement();

					if (networkInterface.isLoopback()
							|| !networkInterface.isUp()) {
						continue; // Don't want to broadcast to the loopback
									// interface
					}

					for (InterfaceAddress interfaceAddress : networkInterface
							.getInterfaceAddresses()) {
						InetAddress broadcast = interfaceAddress.getBroadcast();
						if (broadcast == null) {
							continue;
						}

						// Send the broadcast package!

						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, broadcast, broadcastPort);
						c.send(sendPacket);

					}
				}

				c.close();

			} catch (Exception e) {
				Log.e("LocalService", "Exception", e);
			}
		}
	}

	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Service Stopped ...", Toast.LENGTH_SHORT).show();
	}

	private final Handler toastHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Bundle b = msg.getData();
			String key = b.getString("My Key");

			Toast.makeText(getApplicationContext(), key, Toast.LENGTH_SHORT)
					.show();
			RadioButton temp = new RadioButton(getApplicationContext());
			temp.setText(key);

			FileSharingActivity.radioGroup.addView(temp);
		}
	};
}

class reciverThread implements Runnable {

	Handler myHandler;
	LocalService mySevice;

	DatagramPacket receivePacket;
	String theIP;

	public reciverThread(Context service) {
		myHandler = new Handler();
		mySevice = (LocalService) service;

	}

	public void run() {
		try {

			String MyIp = UtilsNetwork.getIPAddress(true);


			DatagramSocket c = new DatagramSocket(LocalService.broadcastPort,
					InetAddress.getByName("0.0.0.0"));
			c.setBroadcast(true);
			// Wait for a response
			byte[] recvBuf = new byte[15000];
			receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
			Message msg = new Message();
			while (true) {
				c.receive(receivePacket);

				String message = new String(receivePacket.getData()).trim();
				String[] msgs = message.split(LocalService.spliter);
				if (msgs[0].equals(LocalService.broadcastMessage)) {


					System.out.println(receivePacket.getAddress().getHostName()
							+ ": " + message);
					theIP = (receivePacket.getAddress().getHostAddress());
					if (!MyIp.equals(theIP)) {
						theIP = theIP+LocalService.spliter+msgs[1]+LocalService.spliter+msgs[2];
						myHandler.post(new Runnable() {
							public void run() {

								if(!ifHeExistModfyIt(theIP))
								{
								RadioButton temp = new RadioButton(mySevice);
								temp.setText(theIP);
								

								FileSharingActivity.radioGroup.addView(temp);
								}
							}

							private boolean ifHeExistModfyIt(String theIP) {
								// TODO Auto-generated method stub
								String[] msgs = theIP.split(LocalService.spliter);
								
								int count = FileSharingActivity.radioGroup.getChildCount();
								for (int i=0;i<count;i++) {
						            View o = FileSharingActivity.radioGroup.getChildAt(i);
						            if (o instanceof RadioButton) {
						            	 String sub = (((RadioButton) o).getText().toString()).substring(0, msgs[0].length());
						            	 if (sub.equalsIgnoreCase(msgs[0])) {
				                              ((RadioButton) o).setText(theIP);
				                              return true;
				                         }
						            }
						        }
								
								
								
								return false;
							}
						});
					}

				}

				 recvBuf = new byte[15000];
                 receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
			}

		} catch (Exception e) {

			Log.e("LocalService", "Exception", e);

		}
	}
}