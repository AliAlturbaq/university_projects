/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Twitter;

import java.io.Serializable;

/**
 *
 * @author SONY
 */
public class Twee extends Object implements Serializable  {
    
    
     private String tweetID;
     private String tweet;
     private String timaAndDate;
     private String username;

    
     public Twee()
     {
         tweetID = new String();
         tweet = new String();
         timaAndDate = new String();
         username  = new String();     
     }
     
    public void setTweetID(String twID)
    {
        tweetID = twID;
    }
    public void setTweet(String tw)
    {
        tweet = tw;
    }
    public void setTimeAndDate(String tAndD)
    {
            timaAndDate = tAndD;
    }
    public void setUsername(String user)
    {
            username = user;
    }
    
    
    public String getTweetID()
    {
        return tweetID;
    }
    
    public String getTweet()
    {
        return tweet;
    }
    public String getTimeAndDate()
    {
        return timaAndDate;
    }
    public String getUsername()
    {
        return username;
    }
}
