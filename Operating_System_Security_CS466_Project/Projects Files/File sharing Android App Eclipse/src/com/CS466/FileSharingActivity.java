package com.CS466;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class FileSharingActivity extends Activity {

	

	
	public static String [] can = null;
	public static String areaa;
	public  final FileSharingActivity myActivity = this;
	private ProgressDialog mServerProgressDialog;
	private ProgressDialog mObserverServerProgressDialog;
	private ProgressDialog mVoteRecordProgressDialog;
	private ProgressDialog mVoteProgressDialog;
	

	SSLServerSocket serverSocket = null;
	SSLSocket client = null;
	ObjectInputStream ois = null;
	String OutputFilePath;
	String fileName = "noFileName";
	
	String filePathTextField = "";
	
	 public static RadioGroup radioGroup;


	 

     private void startFileSharingServer() {
    	 new Thread(new MyThread(myActivity)).start();
     }

     public static boolean createDirIfNotExists(String path) {
		    boolean ret = true;

		    File file = new File(path);

		    if (!file.exists()) {
		        if (!file.mkdirs()) {
		            
		        }
		    }
		    
		 
		    
		   
		    if(ret)
		    	Log.d("creat Folder :: ", "creating Image folder");
		    return ret;
		}
	 
	 private void findAllAvalivaleDevicesInLan() {


	    	
	    	new AsyncTask<String, Void, String>() {
				@Override
				protected void onPreExecute() {
					super.onPreExecute();
					
					mServerProgressDialog =  ProgressDialog.show(myActivity, "", "trying to get ip addresses");
					
				}

				
				@Override
				protected String doInBackground(String... params) {
					 try {

                         InetAddress localHost = Inet4Address.getLocalHost();
                         String temp  = localHost.getHostAddress();
                         String temp2 = UtilsNetwork.getIPAddress(true);
                        
                         temp2 = temp2.substring(0,temp2.lastIndexOf("."));
                         checkHosts(temp2);


                    } catch (IOException ex) {
                         Logger.getLogger(FileSharingActivity.class.getName()).log(Level.SEVERE, null, ex);
                         return null;
                    }
                    return null;
				}
				
				
				public void checkHosts(String subnet) throws IOException {
                    int timeout = 1000;
                    for (int i = 1; i < 254; i++) {
                         String host = subnet + "." + i;
                        // new Thread(new MyThread(host,myActivity)).start();
                         
                    }
                    Log.d("checkHosts", "finish");
               }

              
				protected void onPostExecute(String msg) {
					super.onPostExecute(null);
					
					if (mServerProgressDialog != null && mServerProgressDialog.isShowing()) {
						mServerProgressDialog.dismiss();
						
					}
					
				
					
					}
			}.execute();
	    	
	    	
	    	
	    	
	         // Find the server using UDP broadcast
	        

	    }
	
	 
	 
	 
	 
	 @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		stopService(new Intent(FileSharingActivity.this,LocalService.class));
		super.onDestroy();
		
	}


	 



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_voting);
		
		startService(new Intent(FileSharingActivity.this, LocalService.class));
		 radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
		

		 startFileSharingServer();
		//tryToFindServer();
		
		
		
		//showFileChooser() ;
	

		Button vote = (Button) findViewById(R.id.sendButton);
		
		vote.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				 sendFile();
			}
		});

		
		
	}

	
	private void sendFile()
	{
		
		
		showFileChooser(2);
		
		
	}
	
	private static final int FILE_SELECT_CODE = 0;

    private void showFileChooser(int selectcode) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT); 
        intent.setType("*/*"); 
        
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    selectcode);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.", 
                    Toast.LENGTH_SHORT).show();
        }
    }
	
	
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		try{
        switch (requestCode) {
 
            	
            	  // Get the Uri of the selected file 

            case 2:
            	 if (resultCode == RESULT_OK) { 
            		 Uri uri = data.getData();
                     Log.d("bla", "File Uri: " + uri.toString());
                     // Get the path
                     
                     String path = getPath(this, uri);
                     Log.d("", "File Path: " + path);
                     // Get the file instance
                     
                     
                     filePathTextField = path;


                     new Thread(new senderThread(this,filePathTextField)).start();
            		 
            		 
            		 
            		 
            	 
            	 }
            	
            	
            	
            	break;
        }
		}catch(Exception e)
		{
			Log.e("bla", e.toString());
			
		}
    super.onActivityResult(requestCode, resultCode, data);
    }
		


public  String getPath(Context context, Uri uri) throws URISyntaxException {
    if ("content".equalsIgnoreCase(uri.getScheme())) {
        String[] projection = { "_data" };
        Cursor cursor = null;

        try {
            cursor = context.getContentResolver().query(uri, projection, null, null, null);
            int column_index = cursor
            .getColumnIndexOrThrow("_data");
            if (cursor.moveToFirst()) {
                return cursor.getString(column_index);
            }
        } catch (Exception e) {
            // Eat it
        }
    }

    else if ("file".equalsIgnoreCase(uri.getScheme())) {
        return uri.getPath();
    }

    return null;
}

}

class MyThread implements Runnable {


    FileSharingActivity myActiv;

    
    
    
 public MyThread(FileSharingActivity myActivity) {

     myActiv = myActivity;
     
 }

 
 boolean answered = false;
 boolean accept = false;
 private int dialogButton;


 DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
	    @Override
	    public void onClick(DialogInterface dialog, int which) {
	        switch (which){
	        case DialogInterface.BUTTON_POSITIVE:
	            //Yes button clicked
	        	 accept = true;
               answered = true;
	            break;

	        case DialogInterface.BUTTON_NEGATIVE:
	            //No button clicked
	        	 accept = false;
               answered = true;
	            break;
	        }
	    }
	};
 
	SSLServerSocket serverSocket = null;
	SSLSocket client = null;
	ObjectInputStream ois = null;
	String OutputFilePath;
	String fileName = "noFileName";
	
	String filePathTextField = "";
 
	public static boolean createDirIfNotExists(String path) {
	    boolean ret = true;

	    File file = new File(path);

	    if (!file.exists()) {
	        if (!file.mkdirs()) {
	            
	        }
	    }
	    
	 
	    
	   
	    if(ret)
	    	Log.d("creat Folder :: ", "creating Image folder");
	    return ret;
	}
 
 public void run() {
         try {
        	 SSLServerSocketFactory serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();


             
				try {
					serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(54322);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
              serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());

              while (true) {
                  
                  
                  
                  System.out.println("wating for neew client");
                  
					try {
						client = (SSLSocket) serverSocket.accept();
						LocalService.serverState = LocalService.BUSY;
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                  //Socket Temp = (Socket) serverSocket.accept();
                  System.out.println("accept client");
                  
                  try
                  {
                      ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

                      fileName = (String)ois.readObject();
                  }catch(Exception e)
                  {e.printStackTrace();
                  System.err.println();}
                  
                  

                  
                  myActiv.runOnUiThread(new Runnable() {
                      public void run() {
                    	  AlertDialog.Builder builder = new AlertDialog.Builder(myActiv);
                      	builder.setMessage("this ip ktry to send to you file"+client.getInetAddress().getHostAddress()).setPositiveButton("Yes", dialogClickListener)
                      	    .setNegativeButton("No", dialogClickListener).show();
                      }
                  });
                  
                  
                  while (answered == false) {
                          try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                          }
                  
                  if(accept == true)
                  {
                      OutputFilePath = "";
                      
                      
                  
                  }
                  OutputFilePath =  Environment.getExternalStorageDirectory() +"/FileSharingAppFolder";
                  String temp1= OutputFilePath;
                  createDirIfNotExists(OutputFilePath);
                  while (OutputFilePath.length()==0) {
                      try {
  						Thread.sleep(500);
  					} catch (InterruptedException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
                      }
                  String temp2= OutputFilePath;
                  InputStream is = null;

                  try {
                      is = client.getInputStream();
                  } catch (IOException e) {
                 	 e.printStackTrace();
                      // Do exception handling
                  }

                  String temp3= OutputFilePath;
                  byte[] aByte = new byte[1];
                  int bytesRead;

                  ByteArrayOutputStream baos = new ByteArrayOutputStream();

                  if (is != null) {
                 	 String temp4= OutputFilePath;
                      FileOutputStream fos = null;
                      BufferedOutputStream bos = null;
                      try {
                          fos = new FileOutputStream( OutputFilePath + "/" + fileName );
                          bos = new BufferedOutputStream(fos);
                          bytesRead = is.read(aByte, 0, aByte.length);

                          do {
                                  baos.write(aByte);
                                  bytesRead = is.read(aByte);
                          } while (bytesRead != -1);

                          bos.write(baos.toByteArray());
                          bos.flush();
                          bos.close();
                          client.close();
                          LocalService.serverState = LocalService.READY;
                      } catch (IOException e) {
                     	 e.printStackTrace();
                          // Do exception handling

                         LocalService.serverState = LocalService.READY;
                      }

                      LocalService.serverState = LocalService.READY;
                  }
                
                
/*				 handler.post(new Runnable() {
			            public void run() {
			            	
			            }
			        });*/
				
         }
             // else
                 //System.out.println(ipTest + " is not reachable");
         } catch (Exception ex) {

             LocalService.serverState = LocalService.READY;
              Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
         }
 }
}



class senderThread implements Runnable {

	Handler myHandler;
	FileSharingActivity myActiv;

	DatagramPacket receivePacket;
	String theIP;
	String filePathTextField;

	public senderThread(Context service , String path) {
		myHandler = new Handler();
		myActiv = (FileSharingActivity) service;
		filePathTextField= path;

	}
	
	  String FilePath;
      boolean startTransfer = false;
      private int dialogButton;

      String tempppp = "";
	public void run() {
		
		

        LocalService.serverState = LocalService.BUSY;
		 SSLSocketFactory factory =null;
         SSLSocket tempSocket =null;
         //InputStream is = null;
         
         
         int idd = myActiv.radioGroup.getCheckedRadioButtonId();
         String ipp= "";
			if(idd != -1)
			{
				RadioButton checkedRadioButton = (RadioButton)myActiv.radioGroup.findViewById(idd);
				ipp = checkedRadioButton.getText().toString();
				ipp = (ipp.split("#"))[0];

			}
			
         BufferedOutputStream outToClient = null;
         try {
             factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
             tempSocket = (SSLSocket) factory.createSocket(ipp, 54322);
             tempSocket.setEnabledCipherSuites(tempSocket.getSupportedCipherSuites());
             
            
            int index = filePathTextField.lastIndexOf("/");

            
     		String part = filePathTextField.substring(index+1, filePathTextField.length());
     		ObjectOutputStream oos = new ObjectOutputStream(tempSocket.getOutputStream());
             oos.writeObject(part);
             //is = tempSocket.getInputStream();
             
             
             ObjectInputStream ooois = new ObjectInputStream(tempSocket.getInputStream());

				tempppp = (String) ooois.readObject();
            
     			outToClient = new BufferedOutputStream(tempSocket.getOutputStream());
     		

         } catch (Exception e) {
        	 e.printStackTrace();
             // Do exception handling
         } 
         
				
		
         if(tempppp.equals("YES"));
         {
         
         
         //InetAddress IPAddress =InetAddress.getByName("localhost");


         if (outToClient != null) {
             File myFile = new File( filePathTextField);
             byte[] mybytearray = new byte[(int) myFile.length()];

             FileInputStream fis = null;

             try {
                 fis = new FileInputStream(myFile);
             } catch (FileNotFoundException e) {
            	 e.printStackTrace();
                 // Do exception handling
             }
             BufferedInputStream bis = new BufferedInputStream(fis);

             try {
                 bis.read(mybytearray, 0, mybytearray.length);
                 outToClient.write(mybytearray, 0, mybytearray.length);
                 outToClient.flush();
                 outToClient.close();
                 tempSocket.close();


                 LocalService.serverState = LocalService.READY;
                 // File sent, exit the main method

             } catch (IOException e) {
            	 e.printStackTrace();

                 LocalService.serverState = LocalService.READY;
                 // Do exception handling
             }

             LocalService.serverState = LocalService.READY;
         }
         }
         
         

		


							
	}
}
