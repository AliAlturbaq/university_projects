/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Twitter;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author SONY
 */
public class mainWindow extends javax.swing.JFrame {

    /**
     * Creates new form mainWindow
     */
    public mainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        MainPane = new javax.swing.JTabbedPane();
        timeLinePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        timeLineList = new javax.swing.JList();
        followersPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        followersList = new javax.swing.JList();
        followingPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        followingList = new javax.swing.JList();
        allUsersPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        allUsersList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        myTweetList = new javax.swing.JList();
        refreshButton = new javax.swing.JButton();
        unFollowButton = new javax.swing.JButton();
        followButton = new javax.swing.JButton();
        FolloweField = new javax.swing.JTextField();
        tweetField = new javax.swing.JTextField();
        addTweetButton = new javax.swing.JButton();
        deleteTweetButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        usernamLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Twitter");

        timeLineList.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane1.setViewportView(timeLineList);

        javax.swing.GroupLayout timeLinePanelLayout = new javax.swing.GroupLayout(timeLinePanel);
        timeLinePanel.setLayout(timeLinePanelLayout);
        timeLinePanelLayout.setHorizontalGroup(
            timeLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeLinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addContainerGap())
        );
        timeLinePanelLayout.setVerticalGroup(
            timeLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeLinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPane.addTab("TimeLine", timeLinePanel);

        followersList.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane2.setViewportView(followersList);

        javax.swing.GroupLayout followersPanelLayout = new javax.swing.GroupLayout(followersPanel);
        followersPanel.setLayout(followersPanelLayout);
        followersPanelLayout.setHorizontalGroup(
            followersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(followersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addContainerGap())
        );
        followersPanelLayout.setVerticalGroup(
            followersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        MainPane.addTab("Followers", followersPanel);

        followingList.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane4.setViewportView(followingList);

        javax.swing.GroupLayout followingPanelLayout = new javax.swing.GroupLayout(followingPanel);
        followingPanel.setLayout(followingPanelLayout);
        followingPanelLayout.setHorizontalGroup(
            followingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(followingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addContainerGap())
        );
        followingPanelLayout.setVerticalGroup(
            followingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(followingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPane.addTab("Following", followingPanel);

        allUsersList.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane6.setViewportView(allUsersList);

        javax.swing.GroupLayout allUsersPanelLayout = new javax.swing.GroupLayout(allUsersPanel);
        allUsersPanel.setLayout(allUsersPanelLayout);
        allUsersPanelLayout.setHorizontalGroup(
            allUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addContainerGap())
        );
        allUsersPanelLayout.setVerticalGroup(
            allUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPane.addTab("All Users", allUsersPanel);

        myTweetList.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane5.setViewportView(myTweetList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPane.addTab("My Tweets", jPanel1);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        unFollowButton.setText("UnFollow");
        unFollowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unFollowButtonActionPerformed(evt);
            }
        });

        followButton.setText("Follow");
        followButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followButtonActionPerformed(evt);
            }
        });

        FolloweField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tweetField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        addTweetButton.setText("Add Tweet");
        addTweetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTweetButtonActionPerformed(evt);
            }
        });

        deleteTweetButton.setText("Delete Tweet");
        deleteTweetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTweetButtonActionPerformed(evt);
            }
        });

        signOutButton.setText("Sign out");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        usernamLabel.setFont(new java.awt.Font("Tahoma", 3, 17)); // NOI18N

        jLabel1.setText("Add Or Delete Tweet");

        jLabel2.setText("Follow or UnFollow");

        jMenu1.setText("File");

        jMenu6.setText("jMenu6");

        jMenu8.setText("jMenu8");
        jMenu6.add(jMenu8);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("jMenuItem1");
        jMenu2.add(jMenuItem1);

        jMenu7.setText("jMenu7");
        jMenu2.add(jMenu7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FolloweField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(unFollowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(followButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tweetField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteTweetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addTweetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refreshButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signOutButton))
                            .addComponent(usernamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(MainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(refreshButton)
                                    .addComponent(signOutButton))
                                .addGap(18, 18, 18)
                                .addComponent(usernamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tweetField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteTweetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addTweetButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FolloweField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(unFollowButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(followButton)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed

      
       
       toServer.println("5");
      
       clear();
       refresh();
        
       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void unFollowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unFollowButtonActionPerformed
        boolean isHeInMyFollowList = false;
        if(FolloweField.getText().trim().equals(""))
            JOptionPane.showMessageDialog(this,"Enter username to unFollow");

      else{
            if(Following != null)
            for(int i = 0 ; i<Following.length ; i++ )
                if(FolloweField.getText().equals( Following[i]))
                    isHeInMyFollowList = true;

                
                if(isHeInMyFollowList)
                {
                    toServer.println("4");
                    toServer.println(FolloweField.getText().trim());
                    clear();
                    refresh();
                }
                else
                    JOptionPane.showMessageDialog(this,"the username is not in your follow list");
        
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_unFollowButtonActionPerformed

    private void deleteTweetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTweetButtonActionPerformed
       
        boolean isThisTweetIsMine = false;
        
        if(tweetField.getText().trim().equals(""))
             JOptionPane.showMessageDialog(this,"Tweet Field is empty");
      else{
            if(myTweets != null)
            for(int i =0 ; i<myTweets.length ; i++)
                if(tweetField.getText().equals( myTweets[i].getTweetID()))
                    isThisTweetIsMine = true;
                if(isThisTweetIsMine)
                {
                        toServer.println("3");
                        toServer.println(tweetField.getText());
                        clear();
                        refresh();
                }
                else 
                    JOptionPane.showMessageDialog(this,"this tweet ID not in your tweets list");
        
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteTweetButtonActionPerformed

    private void followButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followButtonActionPerformed
        boolean isUserExist = false;
        boolean isHeInMyFollowList = false;
        
        if(FolloweField.getText().trim().equals(""))
             JOptionPane.showMessageDialog(this,"Enter username to Follow");

      else{
            for(int i = 0 ; i <allUsers.length ; i++) 
                if(FolloweField.getText().equals( allUsers[i]))
                    isUserExist = true;
            if(Following != null)
            for(int i = 0 ; i<Following.length ; i++ )
                if(FolloweField.getText().equals( Following[i]))
                    isHeInMyFollowList = true;
            
            
            if(isUserExist && !isHeInMyFollowList)
            {
                toServer.println("2");
                toServer.println(FolloweField.getText());
                clear();
                refresh();
            }
            else
               JOptionPane.showMessageDialog(this,"User is currently in your list or it does not exist in All user list");


       
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_followButtonActionPerformed

    private void addTweetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTweetButtonActionPerformed
        if(tweetField.getText().trim().equals(""))
            JOptionPane.showMessageDialog(this,"Tweet Field is empty");
      else{
       
       toServer.println("1");
       toServer.println(tweetField.getText());
       clear();
       refresh();
        
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_addTweetButtonActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed

       
        toServer.println("6");
        
        signWindow a = new signWindow();
        a.setVisible(true);
        this.dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_signOutButtonActionPerformed
    public mainWindow(ObjectInputStream in ,PrintWriter out , boolean isHeNewUser , String name) {
       
        
       
            toServer = out;
            fromServer = in;
            System.out.println("nice");
        
        System.out.println("imhere");
       
        username = name;
        System.out.println("yeeeeees");
        initComponents();
        //jTabbedPane1.addTab("first", null, rootPane, "this is first");
        twieetsModel = new DefaultListModel();
        followingModel = new DefaultListModel();
        followersModel = new DefaultListModel();
        myTweetModel = new DefaultListModel();
        allUsersModel = new DefaultListModel();
        
        timeLineList.setModel(twieetsModel);
        followersList.setModel(followersModel);
        followingList.setModel(followingModel);
        myTweetList.setModel(myTweetModel);
        allUsersList.setModel(allUsersModel);
        if(!isHeNewUser)
        {
          refresh();
        }
        else{
            
            try {
                allUsers = (String[]) fromServer.readObject();
            } catch (IOException ex) {
                Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0 ; i<allUsers.length ;i++)
              {
                  if(!allUsers[i].equals(username))
                  allUsersModel.addElement(allUsers[i]);
              }
        }
        usernamLabel.setText(username);
    }
    
  
    void clear()
    {
        allUsersModel.removeAllElements();
        followingModel.removeAllElements();
        followersModel.removeAllElements();
        twieetsModel.removeAllElements();
        myTweetModel.removeAllElements();
        
    
    
    }
     void refresh()
    {
        
        
        
        String ttt="";
        String ppp="";
        try {
             
            allUsers = (String[]) fromServer.readObject();
            for(int i=0 ; i<allUsers.length ;i++)
              {
                  if(!allUsers[i].equals(username))
                  allUsersModel.addElement(allUsers[i]);
              }
            
            myTweets = (Twee[]) fromServer.readObject();
            for(int i=0 ; i<myTweets.length ;i++)
             {
              ttt = "                "+ myTweets[i].getTweet()  +"\t        ";
              ppp = "tweetID     :    "+ myTweets[i].getTweetID()+"\t        "
                     + "TimeAndDate :    "+ myTweets[i].getTimeAndDate()+"\t    ";
              
              myTweetModel.addElement(ttt);
              myTweetModel.addElement(ppp);
              myTweetModel.addElement("****************************************************************");
             }
            
              twieets = (Twee[]) fromServer.readObject();
           ttt="";
           ppp="";
             for(int i=0 ; i<twieets.length ;i++)
             {
              ttt = "              "+ twieets[i].getTweet()  +"\t        ";
              ppp = "TimeAndDate :    "+ twieets[i].getTimeAndDate()+"\t    "
                  + "username    :    "+ twieets[i].getUsername()+"\t       ";
              twieetsModel.addElement(ttt);
              twieetsModel.addElement(ppp);
              twieetsModel.addElement("****************************************************************");
             }
             
             
             
             Following = (String[]) fromServer.readObject();
             for(int i=0 ; i<Following.length ;i++)
              {followingModel.addElement(Following[i]);
              }
             
             Followers = (String[]) fromServer.readObject();
             for(int i=0 ; i<Followers.length ;i++)
                {followersModel.addElement(Followers[i]);
                }
             
             
             
             
            
        } catch (IOException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
         // twieetsArea.setRows(5);
        
          
         
          
          
    
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new mainWindow().setVisible(true);
            }
        });
    }
    DefaultListModel twieetsModel;
    DefaultListModel followingModel ;
    DefaultListModel followersModel; 
    DefaultListModel myTweetModel;
    DefaultListModel allUsersModel;
    Socket clientSocket;
    ObjectInputStream  fromServer;
    PrintWriter toServer;
    transient Twee  twieets[];
    String Following[];
    String Followers[];
    String allUsers[];
    Twee myTweets[];
    String username;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FolloweField;
    private javax.swing.JTabbedPane MainPane;
    private javax.swing.JButton addTweetButton;
    private javax.swing.JList allUsersList;
    private javax.swing.JPanel allUsersPanel;
    private javax.swing.JButton deleteTweetButton;
    private javax.swing.JButton followButton;
    private javax.swing.JList followersList;
    private javax.swing.JPanel followersPanel;
    private javax.swing.JList followingList;
    private javax.swing.JPanel followingPanel;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JList myTweetList;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton signOutButton;
    private javax.swing.JList timeLineList;
    private javax.swing.JPanel timeLinePanel;
    private javax.swing.JTextField tweetField;
    private javax.swing.JButton unFollowButton;
    private javax.swing.JLabel usernamLabel;
    // End of variables declaration//GEN-END:variables
}
