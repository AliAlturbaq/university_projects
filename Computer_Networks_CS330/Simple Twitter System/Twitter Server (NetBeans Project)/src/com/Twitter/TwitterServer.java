package com.Twitter;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TwitterServer
{
   private static ServerSocket serverSocket ;

   
   public static void main (String args[]) 
   {
      try
      {
         serverSocket = new ServerSocket(6788);
      }
      catch (IOException e)
      {
         System.out.println("Unable To Attach Port");
        //System.exit(1);
      }
      
      while ( true )
      {
         
           
                System.out.println("waiting.....");
               
            
         
         // send Socket to CleintHandling
          ClientHandling   cHandling = null;
            try {
                cHandling = new ClientHandling(serverSocket.accept());
                System.out.println("New Client Accpeted.........");
                cHandling.start();  
          } catch (IOException ex) {
                //Logger.getLogger(MultiThreadEchoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
   }
}

class ClientHandling extends Thread  // my thread
{
  
  
   private Socket clientSocket ;
  

   private Scanner  fromClient ;
   private ObjectOutputStream oos;
   Twee  twieets[];
   String url = "jdbc:mysql://localhost:3307/";
   String dbName = "twitter";
   String driver = "com.mysql.jdbc.Driver";
   String DBUserName = "root"; 
   String DBPassword = "asdwsx";
   private Connection connect;
   Statement statement;
   ResultSet result;
   String sqlStatement;
   PreparedStatement pStatement;
   //ObjectInputStream ois;
   
   
   private String username;
   private String password;
   
   
   public ClientHandling (Socket cSocket) throws IOException
   {
         clientSocket = cSocket ;
      

         clientSocket.getOutputStream().flush();
         fromClient = new   Scanner(clientSocket.getInputStream());
         
         oos = new ObjectOutputStream(clientSocket.getOutputStream());
         

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
           try{
         connect = DriverManager.getConnection(url+dbName,DBUserName,DBPassword);
         statement = connect.createStatement();
         //statement.executeUpdate("INSERT INTO followers (follower,uName)VALUES(IDENT_CURRENT('Users'),111, 123456789)");
        System.out.println("yeaaaaaaaaaaaaaaaaa");
         }catch(SQLException e){
   
        System.out.println(e.getMessage());
         }
        

         
   }
     

  
   
    @Override
   public void run () 
   {
       outsideloops:;
      
        
       signInOrSignUp();
        
      String clientMsg , clientCmand;
      while(true)
      {
      System.out.println("waiting for cmmand ........");
      clientMsg = fromClient.nextLine();
      System.out.println("w1");
      clientCmand = clientMsg;
      System.out.println(clientCmand);
      
     
      System.out.println("w2");

     
      switch (clientCmand)
      {
      
          case "1":           // add tweet
                    clientMsg = fromClient.nextLine();
                    addTweet(clientMsg);
                    sendInfoToClient();
                    System.out.println("add tweet");
                     break;
                   
          case "2":           // add Following 
                    clientMsg = fromClient.nextLine();
                    addFollowing(clientMsg);
                    sendInfoToClient();
                    System.out.println("add following");
                    break;
              
          case "3":           //remove  tweet
              
                     clientMsg = fromClient.nextLine();
                     removeTweet(clientMsg);
                     sendInfoToClient();
                     System.out.println("remove tweet");
                     break;
              
         
          case "4":            //remove  Following
              
                     clientMsg = fromClient.nextLine();
                     removeFollowing(clientMsg);
                     sendInfoToClient();
                     System.out.println("remove following");
                     break;
              
           case "5":
               
               
                     sendInfoToClient();
                     System.out.println("refreash");
                     break;
          
           case "6":
               
                         signInOrSignUp();
                         break;
                       
               
               
              
          default:     // try {
                                // result.close();
                                // pStatement.close();
                                 //statement.close();
                                // connect.close();
                           //  } catch (SQLException ex) {
                            // System.out.println("11");
                          //   }
                    //    try {
                        //          clientSocket.close();
                        //     } catch (IOException ex) {
                        //         System.out.println("12");
                       //      }
                             
                            // this.destroy();
              
                              break;
      
      }
      }

   }
    
    
    
    public void signInOrSignUp()
    {
    
        String clientCmand ,clientMsg  ;
        OUTER:
        do {
            clientMsg = fromClient.nextLine();
            clientCmand = clientMsg;
            System.out.println(clientMsg);
            
            
            clientMsg = fromClient.nextLine();
            username = clientMsg;
            System.out.println(clientMsg);

            
            clientMsg = fromClient.nextLine();
            password =  clientMsg;
            System.out.println(clientMsg);
            
            boolean tempIsUsernameExist = false;
            
            tempIsUsernameExist = isUsernameExist();
            boolean passwordValied = false;
            
            if(tempIsUsernameExist)
                System.out.println("exist");
            
            
            
            if(tempIsUsernameExist && clientCmand.equals("1")){
                passwordValied = isPasswordValied();
            }
             
            
            
            try {
            
            switch (clientCmand) {
                case "1":
                            
                              if (tempIsUsernameExist && passwordValied)
                              {
                                
               
                                oos.writeObject("ok");
                                sendInfoToClient();
                                 
                
                                
                               
                                
                                break OUTER;
                              } 
                              
                              else 
                              {
                                
                                  oos.writeObject("error");
                              }
                            
                              break;
               
                
                case "2":
                             if (tempIsUsernameExist) 
                             {
                               
                                 oos.writeObject("error");
                                 System.out.println("wwwwwwwwwwwwwhy");
                             } 
                    
                    
                             else 
                             {
                                  oos.writeObject("ok");
                                   addNewUser();
                                    try {
                                        sendAllUsers();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(ClientHandling.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                   break OUTER;
                             }
                                   
                             break;
            }
            
            } catch (IOException ex) {
                    Logger.getLogger(ClientHandling.class.getName()).log(Level.SEVERE, null, ex);
                }
        } while (true);
      
       System.out.println("out");

    
    }
    
    
   public String[] toStringArray(ResultSet resultSet, String columnLabel) {
    LinkedList<String> resultList = new LinkedList<>();
 
    try {
        while (resultSet.next()) {
            resultList.add(resultSet.getString(columnLabel));
        }
    } catch (SQLException e) {
    }
 
    return resultList.toArray(new String[0]);
}    
   
   public  Twee[]  timeLineToTweetArray(ResultSet resultSet, String tweetID ,String tweet,String username,String dateTime ) throws SQLException {

    int resultSize =0 ;
    while(resultSet.next())
    {
        resultSize++;
    }
    
      //resultSet.beforeFirst();      
     
        
    int i = 0;
    Twee [] tempTwieets = new Twee[resultSize];
   
    try {
        while (i<resultSize) {
             resultSet.previous();
             tempTwieets[i] = new Twee();
            tempTwieets[i].setTweetID(resultSet.getString(tweetID));
            
            
            tempTwieets[i].setTweet(resultSet.getString(tweet));
            
            tempTwieets[i].setUsername(resultSet.getString(username));
            
            tempTwieets[i].setTimeAndDate(resultSet.getString(dateTime));
            
            i++;
            

        }

       
    } catch (SQLException e) {
        System.out.println("\n****\n*****\n"+"problem :"+e+"\n****\n*****\n");
    }
    
       return tempTwieets;
   
}  
   
   
   
   public boolean isUsernameExist()
   {
       sqlStatement = "SELECT username from users where username ='"+username+ "';";
        try {
            result = statement.executeQuery(sqlStatement);
            //result.next();
            if(result.next())
               return true;
            
            else
                return false;
        } catch (SQLException ex) {
            System.out.println("there is problem");
            Logger.getLogger(ClientHandling.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
   
   }
   
   
   
   public boolean isPasswordValied( )
   {
       String passwordFromDB=null;
       sqlStatement = "SELECT password from Users where username ='"+username+"';";
        try {
            result = statement.executeQuery(sqlStatement);
        result.next();
         passwordFromDB = result.getString("password");
        } catch (SQLException ex) {
            Logger.getLogger(ClientHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(passwordFromDB.equals(password))
            return true;
        
        return false;
   
   }
   
   public void sendInfoToClient()
   {
                    
       
       String [] Following;
       String [] Followers ;
       
       sqlStatement = "select * from tweets where tweets.Users_username in "
               + "(select follow_usernam from following where following.Users_username ='"+username+"') "
               + "or tweets.Users_username ='"+username+"' "
               + "order by CreationDate;";
        try {
            result = statement.executeQuery(sqlStatement);
       
            
             twieets = timeLineToTweetArray(result, "tweetId","tweet","Users_username","CreationDate");
            
            sqlStatement = "select * from tweets where Users_username = '"+username+"'"
                        + "order by CreationDate;";
       
            result = statement.executeQuery(sqlStatement);
       
            
             Twee [] mytwieets = timeLineToTweetArray(result, "tweetId","tweet","Users_username","CreationDate");               

                         


            
            sqlStatement = "select follow_usernam from following where Users_username ='"+username+"';";
            
            result = statement.executeQuery(sqlStatement);
            Following = toStringArray(result, "follow_usernam");
            
            sqlStatement = "select Users_username  from following where follow_usernam  ='"+username+"';";
            
            result = statement.executeQuery(sqlStatement);
            Followers  = toStringArray(result, "Users_username");
            try {
                        sendAllUsers();
                        oos.writeObject(mytwieets);
                        oos.writeObject(twieets);
                        oos.writeObject(Following);
                        oos.writeObject(Followers);
                        
                        } catch (IOException ex) {
                Logger.getLogger(ClientHandling.class.getName()).log(Level.SEVERE, null, ex);
            }
                   
    } catch (SQLException ex) {
            Logger.getLogger(ClientHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   
   }
   public void sendAllUsers() throws SQLException, IOException
   {
       String [] allUsers;
       sqlStatement = "select username from users ;";
            
            result = statement.executeQuery(sqlStatement);
            allUsers = toStringArray(result, "username");
            
            oos.writeObject(allUsers);
   
   }
   public void addNewUser()
   {
                        sqlStatement = "INSERT INTO users (username,password)VALUES('"+ username + "','"+ password + "');";
                        try {
                            statement.executeUpdate(sqlStatement);
                        
                        
                      

                        } catch (SQLException ex) {
                            System.out.println("cant add new user");
                            System.out.println(ex);
                        }
   
   }
   
   public void addTweet(String tweet)
   {
   
       sqlStatement = "INSERT INTO tweets(tweetId,tweet,Users_username,CreationDate)VALUES(NULL,'"+tweet+"','"+username+"',NULL);";
          try {
              statement.executeUpdate(sqlStatement);
                    
                    
         

          } catch (SQLException ex) {
           System.out.println("cant add tweet");
           System.out.println(ex);
           }
   
   }
   public void addFollowing(String followingUsername)
   {
   
       sqlStatement = "INSERT INTO following(followID,follow_usernam,Users_username)VALUES(NULL,'"+followingUsername+"','"+username+"');";
          try {
               statement.executeUpdate(sqlStatement);
                    

          } catch (SQLException ex) {
           System.out.println("cant add follow");
           System.out.println(ex);
           }
   
   }
   
   public void removeTweet(String tweetID)
   {
       sqlStatement = "DELETE FROM tweets WHERE tweetid ='"+tweetID+"';";
          try {
               statement.executeUpdate(sqlStatement);
                    

          } catch (SQLException ex) {
           System.out.println("cnat rmove tweet");
           }
       
   }
   

   public void removeFollowing(String followingUsername)
   {
       sqlStatement = "DELETE FROM following WHERE follow_usernam ='"+ followingUsername+"' and Users_username = '"+username + "';";
          try {
               statement.executeUpdate(sqlStatement);
                    

          } catch (SQLException ex) {
           System.out.println("cant remove following");
           System.out.println(ex);
           }
   }
}