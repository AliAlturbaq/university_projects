/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.scheduling.ai.project;

import java.util.LinkedList;

/**
 *
 * @author SONY
 */
public class Match {

   public int HOME;
   public int AWAY;
   
   public int backTrackHome;
   
   public int counterForHome;
   public int counterForAway;
   
   public boolean [] homeDomain;
   public boolean [] awayDomain;
   
   public LinkedList<Integer> theValuesITriedForHome = new LinkedList<Integer>();
   public LinkedList<Integer> theValuesITriedForAway = new LinkedList<Integer>();
    
    public int backTrackTypeHome;
    public int backTrackTypeAway;
    
   
   
    Match(int numberOfTeams)
   {
      HOME = 0;
      AWAY = 0;
      backTrackTypeHome=0;
      backTrackTypeAway=0;
      homeDomain = new boolean[numberOfTeams +1];
      awayDomain = new boolean[numberOfTeams +1];
      setHomeDomainTrue();
      setAwayDomainTrue();

   }
   
   
   public void setHome(int teamNumber)
   {
        HOME = teamNumber;
   }
   
   
   public void setAway(int teamNumber)
   {
        AWAY = teamNumber;
   }
   
   public int getHome()
   {
       return HOME;
   }
   
   
   public int getAway()
   {
       return AWAY;
   }
   public void setHomeDomainTrue()
   {
       for (int i=0 ; i<homeDomain.length ; i++)
       {
           homeDomain[i]= true;
       }
   }
   public void setAwayDomainTrue()
   {
       for (int i=0 ; i<awayDomain.length ; i++)
       {
           awayDomain[i]= true;
       }
   }
}
