package com.CS466;

import java.awt.Component;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class MainFrame extends javax.swing.JFrame {
    public static final String READY = "Ready";
    public static final String BUSY = "Busy";
    public static final String spliter = "#";
    public static final String broadcastMessage = "IAmFileShareingApp";
    public static String broadcastName = "";
    public static String serverState = READY;
    public static int broadcastPort = 8887;
    
     public static DefaultListModel items;

     private void startFileSharingServer() {
          new SwingWorker<Void, String>() {
               String OutputFilePath;
               boolean answered = false;
               boolean accept = false;
               private int dialogButton;

               protected Void doInBackground() throws Exception {
                    //publish("choseFile");

                    SSLServerSocketFactory serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();


                    SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(54322);
                    serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());

                    while (true) {
                        
                        answered = false;
                        accept = false;
                        
                        System.out.println("wating for neew client");
                        SSLSocket client = (SSLSocket) serverSocket.accept();
                        //Socket Temp = (Socket) serverSocket.accept();
                        System.out.println("accept client");
                        String fileName = "noFileName";
                        serverState = BUSY;
                        try
                        {
                            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

                            fileName = (String)ois.readObject();
                        }catch(Exception e)
                        {
                        System.err.println();}
                        publish(client.getInetAddress().getHostAddress(),fileName);
                        
                        while (answered == false) {
                                Thread.sleep(500);
                                }
                        
                        if(accept == true)
                        {
                            
                            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

                            oos.writeObject("YES");

                            OutputFilePath = "";
                            publish("choseFolder");
                            while (OutputFilePath.length()==0) {
                                Thread.sleep(500);
                                }
                            InputStream is = null;

                            try {
                                is = client.getInputStream();
                            } catch (IOException ex) {
                                // Do exception handling
                            }


                            byte[] aByte = new byte[1];
                            int bytesRead;

                            ByteArrayOutputStream baos = new ByteArrayOutputStream();

                            if (is != null) {

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
                                    serverState = READY;
                                } catch (IOException ex) {
                                    // Do exception handling
                                    serverState = READY;
                                }
                                serverState = READY;
                            }
                        
                        }else{
                            //oos.writeObject("NO");
                        }
                        
                        
                        

                    }

                    

               }

               @Override
               protected void process(List<String> chunks) {
                    super.process(chunks);
                    
                    if (chunks.toArray()[0].equals("choseFolder")) {
                        JFileChooser chooser = new JFileChooser();
                        //chooser.setCurrentDirectory(new java.io.File("."));
                        chooser.setDialogTitle("choosertitle");
                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        chooser.setAcceptAllFileFilterUsed(true);

                        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                            OutputFilePath = chooser.getSelectedFile().toString();
                        } else {
                            System.out.println("No Selection ");
                        }

                    } else {

                        JOptionPane.showConfirmDialog(null, "this ip :" + chunks.toArray()[0] + " trying to send to you "+chunks.toArray()[1]+"\nWould you accept?", "Warning", dialogButton);

                        if (dialogButton == JOptionPane.YES_OPTION)//The ISSUE is here
                        {

                            accept = true;
                            answered = true;
                        } else {
                            accept = false;
                            answered = true;
                        }

                    }

                    
               }

               @Override
               protected void done() {
                    super.done();


               }
          }
                  .execute();
     }

     private void startIPBroadcastService() {

          new Thread() {
               @Override
               public void run() {
                    while (true) {
                         super.run();
                         new SwingWorker<Void, String>() {
                              @Override
                              protected Void doInBackground() throws Exception {
                                   DatagramSocket c = new DatagramSocket();
                                   c.setBroadcast(true);


                                   byte[] sendData = (broadcastMessage + spliter + broadcastName  + spliter + serverState).getBytes();

                                   
                                   //Try the 255.255.255.255 first
                                   try {
                                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), broadcastPort);
                                        c.send(sendPacket);
                                        System.out.println(getClass().getName() + ">>> Request packet sent to: 255.255.255.255 (DEFAULT)");
                                   } catch (Exception e) {
                                   }

                                   // Broadcast the message over all the network interfaces
                                   Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
                                   while (interfaces.hasMoreElements()) {
                                        NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();

                                        if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                                             continue; // Don't want to broadcast to the loopback interface
                                        }

                                        for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                                             InetAddress broadcast = interfaceAddress.getBroadcast();
                                             if (broadcast == null) {
                                                  continue;
                                             }

                                             // Send the broadcast package!
                                             try {
                                                  DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, broadcast, broadcastPort);
                                                  String message = new String(sendData).trim();
                                                  c.send(sendPacket);
                                             } catch (Exception e) {
                                             }

                                        }
                                   }



                                   //Close the port!
                                   c.close();
                                   return null;

                              }

                              @Override
                              protected void process(List<String> chunks) {
                                   super.process(chunks);
                              }

                              @Override
                              protected void done() {
                                   super.done();
                              }
                         }.execute();
                         try {
                              Thread.sleep(5000);
                         } catch (InterruptedException ex) {
                              Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    }

               }
          }.start();
     }

     private void startBroadcastReciverService() {

          new SwingWorker<Void, String>() {
               @Override
               protected Void doInBackground() {


                    try {

                         InetAddress localHost = Inet4Address.getLocalHost();
                         String MyIp = localHost.getHostAddress();


                         DatagramSocket c = new DatagramSocket(broadcastPort,InetAddress.getByName("0.0.0.0"));
                         c.setBroadcast(true);
                         // Wait for a response
                         byte[] recvBuf = new byte[15000];
                         DatagramPacket receivePacket;

                         receivePacket = new DatagramPacket(recvBuf, recvBuf.length);

                         while (true) {
                              c.receive(receivePacket);


                              String message = new String(receivePacket.getData());
                              String[] msgs = message.split(spliter);
                              if (msgs[0].equals(broadcastMessage)) {

                                   System.out.println(receivePacket.getAddress().getHostName()
                                           + ": " + message);
                                   String theIP = receivePacket.getAddress().getHostAddress();
                                   if (! MyIp.equals(theIP)) {
                                        publish(theIP+spliter+msgs[1]+spliter+msgs[2]);
                                   }

                              }
                              recvBuf = new byte[15000];
                              receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
                              
                         }

                    } catch (Exception e) {
                         System.out.println(e);
                    }
                    return null;



               }

               @Override
               protected void process(List<String> chunks) {
                    super.process(chunks);
                    for (String person : chunks) {
                         if (!ifHeExistModfyIt(person)) {
                              String[] msgs = person.split(spliter);
                              items.addElement(person);
                         }
                    }
               }

               private boolean ifHeExistModfyIt(String person) {
                    String[] msgs = person.split(spliter);
                    for (int i=0; i < items.getSize();i++)
                    {
                         String item = (String) items.elementAt(i);
                         String sub = item.substring(0, msgs[0].length());

                         if (sub.equalsIgnoreCase(msgs[0])) {
                              items.set(i,person);
                              return true;
                              //IPList.setSelectedIndex(i);
                              //IPList.scrollRectToVisible(IPList.getCellBounds(i, i));

                         }
                    }
                    return false;
               }

               @Override
               protected void done() {
                    super.done();
               }
          }.execute();

     }

     private void getDevicesIP() {

          new SwingWorker<Void, Void>() {
               HashSet<String> ipList = new HashSet<String>();

               protected Void doInBackground() throws Exception {
                    try {

                         InetAddress localHost = Inet4Address.getLocalHost();
                         String temp = localHost.getHostAddress();
                         NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
                         //networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();

                         for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
                              if (!address.getAddress().isLoopbackAddress()) {
                                   System.out.println("&&&&&" + address.getNetworkPrefixLength());
                                   System.out.println("*****" + address.getAddress());
                              }
                         }
                         System.out.println(temp);

                         temp = temp.substring(0, temp.lastIndexOf("."));
                         System.out.println(temp);
                         checkHosts(temp);


                    } catch (IOException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                         return null;
                    }
                    return null;
               }

               @Override
               protected void process(List<Void> chunks) {
                    super.process(chunks);
               }

               public InetAddress getIPv4LocalNetMask(InetAddress ip, int netPrefix) {

                    try {
                         // Since this is for IPv4, it's 32 bits, so set the sign value of
                         // the int to "negative"...
                         int shiftby = (1 << 31);
                         // For the number of bits of the prefix -1 (we already set the sign bit)
                         for (int i = netPrefix - 1; i > 0; i--) {
                              // Shift the sign right... Java makes the sign bit sticky on a shift...
                              // So no need to "set it back up"...
                              shiftby = (shiftby >> 1);
                         }
                         // Transform the resulting value in xxx.xxx.xxx.xxx format, like if
                         /// it was a standard address...
                         String maskString = Integer.toString((shiftby >> 24) & 255) + "." + Integer.toString((shiftby >> 16) & 255) + "." + Integer.toString((shiftby >> 8) & 255) + "." + Integer.toString(shiftby & 255);
                         // Return the address thus created...
                         return InetAddress.getByName(maskString);
                    } catch (Exception e) {
                         e.printStackTrace();
                    }
                    // Something went wrong here...
                    return null;
               }

               public void checkHosts(String subnet) throws IOException {
                    int timeout = 1000;
                    for (int i = 1; i < 254; i++) {
                         String host = subnet + "." + i;
                         new Thread(new MyThread(host)).start();

                    }
               }

               @Override
               protected void done() {
                    super.done();

                    for (int i = 0; i < ipList.toArray().length; i++) {
                         items.addElement(ipList.toArray()[i]);
                    }

                    hideProgress();
               }
          }.execute();



     }

     private void showProgress(String msg) {
          setEnabled(false);
          circleProgress.setVisible(true);
          prgressMsg.setVisible(true);
          prgressMsg.setText(msg);


     }

     public void setEnabled(boolean enabled) {
          super.setEnabled(enabled);
          for (Component component : MainPanel.getComponents()) {
               component.setEnabled(enabled);
          }
     }

     private void hideProgress() {
          setEnabled(true);
          circleProgress.setVisible(false);
          prgressMsg.setVisible(false);
          startBroadcastReciverService();



     }

     public MainFrame() {
          initComponents();
          items = new DefaultListModel();
          IPList.setModel(items);
          InetAddress localHost;
          try {
               localHost = Inet4Address.getLocalHost();

               String MyIp = localHost.getHostAddress();


               myIP.setText("My IP  : " + MyIp);
          } catch (UnknownHostException ex) {
               Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
          }

          broadcastName = JOptionPane.showInputDialog(null, "Enter your name : ", "Broadcast Name", 1);

          if (broadcastName == null) {
               broadcastName = "noName";
          }
          startBroadcastReciverService();
          startIPBroadcastService();
          //showProgress("getting devices ip in lan ");
          //getDevicesIP();
          
          
          startFileSharingServer();
     }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IPList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        selectFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        filePathTextField = new javax.swing.JTextField();
        fileNameTextField = new javax.swing.JTextField();
        fileSizeLabel = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        circleProgress = new javax.swing.JLabel();
        prgressMsg = new javax.swing.JLabel();
        myIP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(IPList);

        jLabel1.setText("Devices IP on Lan");

        selectFile.setText("Select a file"); // NOI18N
        selectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("File Details:");

        jLabel3.setText("File Name:");

        jLabel4.setText("File Path  :");

        jLabel5.setText("File Size  :");

        filePathTextField.setText("null");
        filePathTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathTextFieldActionPerformed(evt);
            }
        });

        fileNameTextField.setText("null");

        fileSizeLabel.setText("null");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("<html><p>You must select an IP to send.<p></html>");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectFile)
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(5, 5, 5)
                                                .addComponent(fileNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(fileSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(filePathTextField)))))))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(sendButton))
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(selectFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fileSizeLabel))
                        .addGap(18, 18, 18)
                        .addComponent(sendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        myIP.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(circleProgress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prgressMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(circleProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prgressMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(myIP)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void selectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileActionPerformed
          // TODO add your handling code here:
          //showProgress("yeaaaaa");

          //startFileSharingServer();
         

          new SwingWorker<Void, String>() {
               String FilePath;
               boolean startTransfer = false;
               private int dialogButton;

               protected Void doInBackground() throws Exception {
                    publish("choseFile");
                    //publish("accept");

                    
                    return null;
                    
               }

               @Override
               protected void process(List<String> chunks) {
                    super.process(chunks);
                    for (String msg : chunks) {
                         if (msg.equals("choseFile")) {
                              JFileChooser chooser = new JFileChooser();
                              //chooser.setCurrentDirectory(new java.io.File("."));
                              chooser.setDialogTitle("choosertitle");
                              chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                              chooser.setAcceptAllFileFilterUsed(true);
                              
                              if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                                   FilePath = chooser.getSelectedFile().getAbsolutePath();
                                   
                                   fileNameTextField.setText(chooser.getSelectedFile().getName());
                                   filePathTextField.setText(chooser.getSelectedFile().getAbsolutePath());
                                   fileSizeLabel.setText(chooser.getSelectedFile().length()+" byte");
                              } else {
                                   System.out.println("No Selection ");
                              }
                              
                         }

                    }
               }

               @Override
               protected void done() {
                    super.done();


               }
          }.execute();
         
         
         
     }//GEN-LAST:event_selectFileActionPerformed

    private void filePathTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filePathTextFieldActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        
        new SwingWorker<Void, String>() {

               protected Void doInBackground() throws Exception {
                    //publish("accept");
                   
                   serverState = BUSY;
                    SSLSocketFactory factory =null;
                    SSLSocket tempSocket =null;
                    //InputStream is = null;
                    
                    BufferedOutputStream outToClient = null;
                    try {
                        factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        String selectedIP = IPList.getSelectedValue().toString().substring(0, IPList.getSelectedValue().toString().indexOf("#"));
                        tempSocket = (SSLSocket) factory.createSocket(selectedIP, 54322);
                        tempSocket.setEnabledCipherSuites(tempSocket.getSupportedCipherSuites());
                        ObjectOutputStream oos = new ObjectOutputStream(tempSocket.getOutputStream());

                        oos.writeObject(fileNameTextField.getText().toString());
                        //is = tempSocket.getInputStream();
                        outToClient = new BufferedOutputStream(tempSocket.getOutputStream());
                    } catch (IOException ex) {
                        // Do exception handling
                    }
                    
                    //InetAddress IPAddress =InetAddress.getByName("localhost");


                    if (outToClient != null) {
                        File myFile = new File( filePathTextField.getText() );
                        byte[] mybytearray = new byte[(int) myFile.length()];

                        FileInputStream fis = null;

                        try {
                            fis = new FileInputStream(myFile);
                        } catch (FileNotFoundException ex) {
                            // Do exception handling
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);

                        try {
                            bis.read(mybytearray, 0, mybytearray.length);
                            outToClient.write(mybytearray, 0, mybytearray.length);
                            outToClient.flush();
                            outToClient.close();
                            tempSocket.close();
                            serverState = READY;
                            // File sent, exit the main method
                            return null;
                        } catch (IOException ex) {
                            // Do exception handling
                            serverState = READY;
                        }
                        serverState = READY;
                    }
                    
                    
                    serverState = READY;
                    return null;
                    
               }

               @Override
               protected void process(List<String> chunks) {
                    super.process(chunks);
                    for (String msg : chunks) {
                         if (msg.equals("choseFile")) {
                              JFileChooser chooser = new JFileChooser();
                              //chooser.setCurrentDirectory(new java.io.File("."));
                              chooser.setDialogTitle("choosertitle");
                              chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                              chooser.setAcceptAllFileFilterUsed(true);
                              
                              if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                                   
                                   fileNameTextField.setText(chooser.getSelectedFile().getName());
                                   filePathTextField.setText(chooser.getSelectedFile().getAbsolutePath());
                                   fileSizeLabel.setText(chooser.getSelectedFile().length()+" byte");
                              } else {
                                   System.out.println("No Selection ");
                              }
                              
                         }

                    }
               }

               @Override
               protected void done() {
                    super.done();


               }
          }.execute();
         
        
    }//GEN-LAST:event_sendButtonActionPerformed

     public static void main(String args[]) throws UnknownHostException {
          /* InetAddress in = InetAddress.getLocalHost();
           InetAddress[] all = InetAddress.getAllByName(in.getHostName());
           for (int i = 0; i < all.length; i++) {
           System.out.println("  address = " + all[i]);
           } 

           System.out.println(">>>>>>>>" + Inet4Address.getLocalHost());

           */


          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
           * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
           */
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;
                    }
               }
          } catch (ClassNotFoundException ex) {
               java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new MainFrame().setVisible(true);
               }
          });
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList IPList;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel circleProgress;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JLabel fileSizeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myIP;
    private javax.swing.JLabel prgressMsg;
    private javax.swing.JButton selectFile;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}

class MyThread implements Runnable {

     String ipTest;

     public MyThread(String ip) {
          ipTest = ip;
     }

     public void run() {
          try {
               System.out.println(ipTest);
               if (InetAddress.getByName(ipTest).isReachable(50000)) {
                    System.out.println(ipTest + " is reachable");

                    MainFrame.items.addElement(ipTest);
               }
               // else
               //System.out.println(ipTest + " is not reachable");
          } catch (Exception ex) {
               Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
}
