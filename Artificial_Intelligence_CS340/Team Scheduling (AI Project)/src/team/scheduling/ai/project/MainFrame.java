
package team.scheduling.ai.project;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class MainFrame extends javax.swing.JFrame {

   
    public MainFrame() {
        

        initComponents();
        this.setLocationRelativeTo(null);
        improveButton.setEnabled(false);
        Integer[] numbers = {2,4,6,8,10,12,14,16,18,20};
        numberOfTeamsComboBox.addItem("");
        for (int i = 0 ; i<numbers.length ; i++)
        numberOfTeamsComboBox.addItem(numbers[i]);

        schedulModel = new DefaultListModel();
        schedulList.setModel(schedulModel);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        improveButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        schedulList = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        HoursLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        numberOfTeamsComboBox = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create and Imporve Solution", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        startButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        startButton.setText("Create Solution");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        improveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        improveButton.setLabel("Try To Improve");
        improveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                improveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(improveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(improveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        improveButton.getAccessibleContext().setAccessibleName("fe");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 1, 24), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        schedulList.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jScrollPane1.setViewportView(schedulList);
        schedulList.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Properties of results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setText("Time To Creat Solution :");

        HoursLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        HoursLabel.setText(" ");
        HoursLabel.setMaximumSize(new java.awt.Dimension(50, 20));
        HoursLabel.setMinimumSize(new java.awt.Dimension(50, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("Number Of Breaks :");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText(" ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setText("Time To Improve Solution :");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setText("Number Of Breaks After Improving :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText(" ");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setText(" ");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel9.setText("Total Time (create Solution + Improve Solution) :");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HoursLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(HoursLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Number Of Teams", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Choose number of Teams");

        numberOfTeamsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfTeamsComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(numberOfTeamsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfTeamsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Close", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        closeButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numberOfTeamsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfTeamsComboBoxActionPerformed
      
              

    }//GEN-LAST:event_numberOfTeamsComboBoxActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
           
        String check = numberOfTeamsComboBox.getSelectedItem().toString();
        if (!check.equals("")&&algorithmIsNotRunning){
            algorithmIsNotRunning=false;
            //startButton.setEnabled(false);
             closeButton.setEnabled(false);
            NumberOfTeams = (int)  numberOfTeamsComboBox.getSelectedItem();
            
            HoursLabel.setText("");
            jLabel1.setText("");
            jLabel7.setText("");
            jLabel8.setText("");
            jLabel10.setText("");
            schedulModel.removeAllElements();
            
            

                Thread algorithem = new Thread()
            {
            /**********************************************************************************************************************/        
                    @Override
                            public void run() {

                                s.start();

                                boolean homeFirst = true;
                                boolean backTrack = false;

                                int firstHomeValue ;
                                int firstAwayValue ;

                                int awayBackTrackTeam ;
                                int hoemBackTrackTeam ;
                                int homeBackTrackValue;
                                int homeValue;



                                NumberOfRounds = (NumberOfTeams-1);
                                NumberOfMatchesEachRound = (NumberOfTeams/2);

                                schedul = new Match[NumberOfRounds][NumberOfMatchesEachRound];
                                whoPlayWithWho = new boolean[NumberOfTeams+1][NumberOfTeams+1];
                                teamsCountersForEachRound = new int[NumberOfTeams+1][NumberOfRounds];

                                for(int i =0 ; i<NumberOfRounds ; i++)
                                    for(int j =1 ; j<NumberOfTeams+1 ; j++)
                                        teamsCountersForEachRound[j][i]=0;

                                for(int i = 1; i<NumberOfTeams+1 ; i++)
                                for(int j=1 ;j<NumberOfTeams+1 ; j++)
                                    whoPlayWithWho[i][j] = false;
                                //Match  currentMatch;

                                declarationSchedul();
                                    /***************************************/
                                for (int roundNumber = 0 ;roundNumber<NumberOfRounds  ;roundNumber ++ )
                                {

                                    for (int matchNumber =0 ;matchNumber<NumberOfMatchesEachRound ;matchNumber++ )
                                    {

                                        if(homeFirst)
                                                    {



                                                            if(backTrack) 
                                                            {
                                                                hoemBackTrackTeam = schedul[roundNumber][matchNumber].HOME;
                                                                schedul[roundNumber][matchNumber].homeDomain[hoemBackTrackTeam] = false;
                                                                schedul[roundNumber][matchNumber].theValuesITriedForHome.add(hoemBackTrackTeam);



                                                                backTrack = false;

                                                            }

                                                            firstHomeValue = firstHomeValidTeam(matchNumber,roundNumber);

                                                            if (firstHomeValue == -1)
                                                                {

                                                                            if(matchNumber >  0)
                                                                            {
                                                                            while(!schedul[roundNumber][matchNumber].theValuesITriedForHome.isEmpty())
                                                                                schedul[roundNumber][matchNumber].homeDomain[schedul[roundNumber][matchNumber].theValuesITriedForHome.remove()] = true;


                                                                                matchNumber --;
                                                                                homeFirst = false;
                                                                                backTrack = true;


                                                                            }

                                                                            else 
                                                                            {
                                                                                while(!schedul[roundNumber][matchNumber].theValuesITriedForHome.isEmpty())
                                                                                schedul[roundNumber][matchNumber].homeDomain[schedul[roundNumber][matchNumber].theValuesITriedForHome.remove()] = true;

                                                                                matchNumber = (NumberOfMatchesEachRound-1);
                                                                                roundNumber--;
                                                                                homeFirst = false;
                                                                                backTrack = true;

                                                                            }



                                                                }
                                                                else 
                                                                {


                                                                        schedul[roundNumber][matchNumber].HOME = firstHomeValue;

                                                                            homeFirst = false;


                                                            } 
                                                    }

                                                    if(!homeFirst)
                                                    {

                                                                if(backTrack) 
                                                            {
                                                                awayBackTrackTeam = schedul[roundNumber][matchNumber].AWAY;
                                                                homeBackTrackValue =schedul[roundNumber][matchNumber].HOME;


                                                                whoPlayWithWho[homeBackTrackValue][awayBackTrackTeam]=false;
                                                                whoPlayWithWho[awayBackTrackTeam][homeBackTrackValue]=false;


                                                                schedul[roundNumber][matchNumber].awayDomain[awayBackTrackTeam] = false;
                                                                schedul[roundNumber][matchNumber].theValuesITriedForAway.add(awayBackTrackTeam);
                                                                if(matchNumber != (NumberOfMatchesEachRound-1))
                                                                backTrackAway(matchNumber ,roundNumber,awayBackTrackTeam ,schedul[roundNumber][matchNumber].backTrackTypeAway );

                                                                if(teamsCountersForEachRound[awayBackTrackTeam][roundNumber] == ( -maxConsecutiveBreaks) && roundNumber<(NumberOfRounds-1))
                                                                    for(int i= 0 ; i<NumberOfMatchesEachRound ; i++)
                                                                            schedul[roundNumber+1][i].awayDomain[awayBackTrackTeam]=true;




                                                            /********************************************************************************************************/

                                                                    if(matchNumber != (NumberOfMatchesEachRound-1))
                                                                    backTrackFromHome(matchNumber ,roundNumber,homeBackTrackValue , schedul[roundNumber][matchNumber].backTrackTypeHome  ); 

                                                                    if(teamsCountersForEachRound[homeBackTrackValue][roundNumber]  == maxConsecutiveBreaks &&  roundNumber<(NumberOfRounds-1))
                                                                    for(int i= 0 ; i<NumberOfMatchesEachRound ; i++)
                                                                            schedul[roundNumber+1][i].homeDomain[homeBackTrackValue]=true;


                                                                backTrack = false;

                                                            }


                                                                firstAwayValue =  firstAwayValidTeam(matchNumber,roundNumber);
                                                                homeValue =schedul[roundNumber][matchNumber].HOME;

                                                                if (firstAwayValue == -1)
                                                                {
                                                                    while(!schedul[roundNumber][matchNumber].theValuesITriedForAway.isEmpty())
                                                                        schedul[roundNumber][matchNumber].awayDomain[schedul[roundNumber][matchNumber].theValuesITriedForAway.remove()] = true;


                                                                    matchNumber--;
                                                                    homeFirst = true;
                                                                    backTrack = true;


                                                                }

                                                                else 
                                                                {

                                                                            if(whoPlayWithWho[homeValue][firstAwayValue])
                                                                                {
                                                                                    schedul[roundNumber][matchNumber].theValuesITriedForAway.add(firstAwayValue);
                                                                                    schedul[roundNumber][matchNumber].awayDomain[firstAwayValue] = false;
                                                                                    matchNumber--;
                                                                                    homeFirst = false;


                                                                                }

                                                                                else
                                                                                {     
                                                                                        schedul[roundNumber][matchNumber].AWAY = firstAwayValue; 


                                                                                        if(matchNumber != (NumberOfMatchesEachRound-1))
                                                                                        schedul[roundNumber][matchNumber].backTrackTypeAway = updateFromAway( matchNumber , roundNumber, firstAwayValue);

                                                                                        if(roundNumber == 0 )
                                                                                            teamsCountersForEachRound[firstAwayValue][roundNumber] = -1;
                                                                                        else
                                                                                            {
                                                                                                    if(teamsCountersForEachRound[firstAwayValue][roundNumber-1]>0 )
                                                                                                        teamsCountersForEachRound[firstAwayValue][roundNumber] = -1;

                                                                                                    else
                                                                                                    teamsCountersForEachRound[firstAwayValue][roundNumber]= teamsCountersForEachRound[firstAwayValue][roundNumber-1]-1; 
                                                                                            }

                                                                                        if(teamsCountersForEachRound[firstAwayValue][roundNumber] == ( -(maxConsecutiveBreaks)) && roundNumber<(NumberOfRounds-1))
                                                                                        for(int i= 0 ; i<NumberOfMatchesEachRound ; i++)
                                                                                            schedul[roundNumber+1][i].awayDomain[firstAwayValue]=false;



                                                                        /********************************************************************************************************/

                                                                                        if(matchNumber != (NumberOfMatchesEachRound-1))
                                                                                        schedul[roundNumber][matchNumber].backTrackTypeHome = updateFromHome( matchNumber , roundNumber,  homeValue);

                                                                                        if(roundNumber == 0 )
                                                                                            teamsCountersForEachRound[homeValue][roundNumber] = 1;

                                                                                        else 
                                                                                        {
                                                                                            if(teamsCountersForEachRound[homeValue][roundNumber-1]<0 )
                                                                                                teamsCountersForEachRound[homeValue][roundNumber] = 1;

                                                                                            else
                                                                                            teamsCountersForEachRound[homeValue][roundNumber]= teamsCountersForEachRound[homeValue][roundNumber-1]+1;

                                                                                        }

                                                                                        if(teamsCountersForEachRound[homeValue][roundNumber] == maxConsecutiveBreaks && roundNumber<(NumberOfRounds-1))
                                                                                        for(int i= 0 ; i<NumberOfMatchesEachRound ; i++)
                                                                                            schedul[roundNumber+1][i].homeDomain[homeValue]=false;




                                                                    /********************************************************************************************************/

                                                                                        homeFirst= true;

                                                                                        whoPlayWithWho[homeValue][firstAwayValue]=true;
                                                                                        whoPlayWithWho[firstAwayValue][homeValue]=true;


                                                                                }

                                                            }
                                                }

                                        }


                                }
                                    /********************************************************************************************************/
                                s.stop();
                                long remainder   = 0;
                                long MilliSecond = 0;
                                int Seconds     = 0;
                                int Minutes     = 0;
                                int Hours       = 0;

                                //if(s.getElapsedTime() != 0 )

                                MilliSecond = s.getElapsedTime();
                                Hours     = (int) (MilliSecond/3600000);
                                remainder = MilliSecond %3600000;
                                Minutes   =  (int) (remainder/60000);
                                remainder = remainder %60000;
                                Seconds   = (int) (remainder/1000);
                                remainder = remainder % 1000;
                                MilliSecond = remainder;

                                HoursLabel.setText(Hours +" : "+Minutes+" : "+Seconds+" : "+MilliSecond);
                                HoursLabel.setForeground(Color.red);

                                jLabel1.setText("  "+getCost(teamsCountersForEachRound));
                                jLabel1.setForeground(Color.red);
                                if (SwingUtilities.isEventDispatchThread( ))

                                            printSchedul();

                                else try {
                            try {
                                SwingUtilities.invokeAndWait(new Runnable( ) {

                                    @Override
                                public void run( ) {

                                printSchedul();

                            }

                            });
                            } 
                            catch (InvocationTargetException ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                } 
                            catch (InterruptedException ie) {}


                            for(int i=0 ; i<NumberOfRounds ; i++ ){
                                for(int j=1 ; j<NumberOfTeams+1;j++)
                                    System.out.print("\t"+teamsCountersForEachRound[j][i]);

                                System.out.println();
                                    }

                                    improveButton.setEnabled(true);
                                    algorithmIsNotRunning = true;





                            }








            };


            
            
            algorithem.start();
           
        }
        else
          JOptionPane.showMessageDialog(this,"You Must Select Number of Teams");
       
       
       
    }//GEN-LAST:event_startButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
       this.dispose();
        
    }//GEN-LAST:event_closeButtonActionPerformed

    private void improveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_improveButtonActionPerformed

       
        improveButton.setEnabled(false);
        if(NumberOfTeams>2)
        {
                schedulModel.removeAllElements();
                Thread algorithem2 = new Thread()
            {
                @Override
                        public void run()
                        {

                            s2.start();
                            System.out.println("1");
                            tempSchedul = schedul;
                            tempTaemsCountersForEachRound = teamsCountersForEachRound;
                            boolean exlientSwap;
                            int numberOfSwaps = 0;
                            int lasetRound = NumberOfRounds-1;

                            System.out.println("2");

                        for (int matchNumber=0; matchNumber < NumberOfMatchesEachRound; matchNumber++)
                                {
                                    System.out.println("3");
                                    exlientSwap = upDateTempTaemsCountersForEachRound(tempSchedul[0][matchNumber].HOME ,tempSchedul[0][matchNumber].AWAY,0,matchNumber);
                                    System.out.println("4");
                                    if(exlientSwap)
                                        numberOfSwaps++;


                                }  

                                System.out.println("5");

                        for (int matchNumber=0; matchNumber < NumberOfMatchesEachRound; matchNumber++)
                                {
                                    System.out.println("3");
                                    exlientSwap = upDateTempTaemsCountersForEachRound(tempSchedul[lasetRound][matchNumber].HOME ,tempSchedul[lasetRound][matchNumber].AWAY,lasetRound,matchNumber);
                                    System.out.println("4");
                                    if(exlientSwap)
                                        numberOfSwaps++;


                                }      





                        schedul  = tempSchedul;
                        teamsCountersForEachRound =   tempTaemsCountersForEachRound;

                        System.out.println("6");
                        for(int i=0 ; i<NumberOfRounds ; i++ ){
                                for(int j=1 ; j<NumberOfTeams+1;j++)
                                    System.out.print("\t"+teamsCountersForEachRound[j][i]);

                                System.out.println();
                                    }

                                    getCost(teamsCountersForEachRound);

                                    System.out.println("7");


                                    s2.stop();
                                long remainder   = 0;
                                long MilliSecond = 0;
                                int Seconds     = 0;
                                int Minutes     = 0;
                                int Hours       = 0;

                                //if(s.getElapsedTime() != 0 )

                                MilliSecond = s2.getElapsedTime();
                                Hours     = (int) (MilliSecond/3600000);
                                remainder = MilliSecond %3600000;
                                Minutes   =  (int) (remainder/60000);
                                remainder = remainder %60000;
                                Seconds   = (int) (remainder/1000);
                                remainder = remainder % 1000;
                                MilliSecond = remainder;

                                jLabel7.setText(Hours +" : "+Minutes+" : "+Seconds+" : "+MilliSecond);
                                jLabel7.setForeground(Color.red);


                                MilliSecond =  s.getElapsedTime() + s2.getElapsedTime();
                                Hours     = (int) (MilliSecond/3600000);
                                remainder = MilliSecond %3600000;
                                Minutes   =  (int) (remainder/60000);
                                remainder = remainder %60000;
                                Seconds   = (int) (remainder/1000);
                                remainder = remainder % 1000;
                                MilliSecond = remainder; 

                                jLabel10.setText(Hours +" : "+Minutes+" : "+Seconds+" : "+MilliSecond);
                                jLabel10.setForeground(Color.red);

                                jLabel8.setText("  "+getCost(teamsCountersForEachRound));
                                jLabel8.setForeground(Color.red);

                            if (SwingUtilities.isEventDispatchThread( ))

                                            printSchedul();

                            else try {
                                        try {
                                                SwingUtilities.invokeAndWait(new Runnable( ) 
                                                {

                                                    @Override
                                                    public void run( )
                                                    {

                                                        printSchedul();

                                                    }

                                                });
                                            } 
                                            catch (InvocationTargetException ex) 
                                            {
                                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                                }

                                        } 
                                        catch (InterruptedException ie) {}
                             


                        }




                public void swap(int matchNumber,int roundNumber){
                    int temp;

                    temp = tempSchedul[roundNumber][matchNumber].HOME;
                    tempSchedul[roundNumber][matchNumber].HOME = tempSchedul[roundNumber][matchNumber].AWAY;
                    tempSchedul[roundNumber][matchNumber].AWAY = temp;


            }

            public boolean upDateTempTaemsCountersForEachRound(int homeTeam , int awayTeam ,int roundNumber,int matchNumber)
            {

                        if(roundNumber == 0)
                        {
                            if( tempTaemsCountersForEachRound[homeTeam][roundNumber+1] == 2 && tempTaemsCountersForEachRound[awayTeam][roundNumber+1] == -2)
                            {    

                                System.out.println("Swaaaaaaaaaaaaaap first round");
                                tempTaemsCountersForEachRound[homeTeam][roundNumber] = -1;
                                tempTaemsCountersForEachRound[homeTeam][roundNumber+1] = 1;
                                tempTaemsCountersForEachRound[awayTeam][roundNumber] = 1;
                                tempTaemsCountersForEachRound[awayTeam][roundNumber+1] = -1;
                                swap(matchNumber,roundNumber);
                                return true;
                            }
                            else
                                return false;
                        }


                        else
                        {


                            if( tempTaemsCountersForEachRound[homeTeam][roundNumber] == 2 && tempTaemsCountersForEachRound[awayTeam][roundNumber] == -2)
                            {    

                                System.out.println("Swaaaaaaaaaaaaaap last round");
                                tempTaemsCountersForEachRound[homeTeam][roundNumber] = -1;

                                tempTaemsCountersForEachRound[awayTeam][roundNumber] = 1;
                                swap(matchNumber,roundNumber);

                                return true;
                            }
                            else
                                return false;


                        }

            }


            };

 
        
        algorithem2.start();
        }
        else
           JOptionPane.showMessageDialog(this,"Are you serious You want to improve for one match and one round and 0 braks  (0_0 you want -1 braks)"); 
        
        
    }//GEN-LAST:event_improveButtonActionPerformed

    
    
 
   
    public static void main(String args[]) {
       
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {

                new MainFrame().setVisible(true);
               
            }
            
            
        });
    }
    
    
    
    private Match [][] schedul; 
    private int NumberOfTeams;
    private int NumberOfRounds;
    private int NumberOfMatchesEachRound;
    private int maxConsecutiveBreaks =2;
    boolean [][] whoPlayWithWho;//reset
    int [][] teamsCountersForEachRound;//reset
    boolean algorithmIsNotRunning = true;
    StopWatch s = new StopWatch();
    StopWatch s2 = new StopWatch();
    DefaultListModel schedulModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HoursLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton improveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox numberOfTeamsComboBox;
    private javax.swing.JList schedulList;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
            Match [][] tempSchedul;
            int [][] tempTaemsCountersForEachRound;
    
    
         
    
    
     
     
/**********************************************************************************************************************/
    
  public int getCost(int [][] TempCounter){
       int cost = 0 ;
       for (int j=0; j<NumberOfRounds; j++){
                  for (int i=1; i <= NumberOfTeams; i++){                   
                      if (TempCounter[i][j]==2 || TempCounter[i][j]==-2)
                       cost++;
                          
                      }
                  }
                  System.out.println("Cost : "+cost);
               
                
          
    return cost;  
   }  
    
    
/**********************************************************************************************************************/          
    
/**********************************************************************************************************************/ 
    
    
    
        
        public void declarationSchedul()
        {
        
            for(int i =0 ; i<NumberOfRounds ;i++)
            {

                for(int j=0 ; j<NumberOfMatchesEachRound ; j++)
                {

                    schedul[i][j] = new Match(NumberOfTeams);

                }


            }
    
    
        }
        
 /**********************************************************************************************************************/        
        public int firstHomeValidTeam(int matchNumber ,int roundNumber)
        {
           
                for (int i = 1 ; i<NumberOfTeams+1 ; i++)
                    if (schedul[roundNumber][matchNumber].homeDomain[i])
                        return i;
                    
           

            return -1;
        }
    
        
/**********************************************************************************************************************/        
        public int firstAwayValidTeam(int matchNumber ,int roundNumber)
        {
            

            for (int i = 1 ; i<NumberOfTeams+1 ; i++)
                    if (schedul[roundNumber][matchNumber].awayDomain[i] && ( i  != schedul[roundNumber][matchNumber].HOME ) )
                        return i;
                   

           return -1;
        }
    

        
 /**********************************************************************************************************************/        
        
         public int updateFromAway(int matchNumber ,int roundNumber,int teamNumber  )
    {
                            
        
                              if(matchNumber <NumberOfMatchesEachRound-1)
                                {
                                    if(schedul[roundNumber][matchNumber+1].homeDomain[teamNumber])
                                    {
                                        for (int i =matchNumber+1 ;i<NumberOfMatchesEachRound ;i++ )
                                        {

                                            schedul[roundNumber][i].homeDomain[teamNumber]=false;
                                            schedul[roundNumber][i].awayDomain[teamNumber]=false;


                                        }
                                        return 2;
                                    }
                                    else
                                    {
                                        for (int i =matchNumber+1 ;i<NumberOfMatchesEachRound ;i++ )
                                        {

                                            schedul[roundNumber][i].awayDomain[teamNumber]=false;
                                            


                                        }
                                        return 1;
                                    
                                    
                                    }
                                }

                            return 1;
    
    }    
   
 
   
         
    /**********************************************************************************************************************/        
        
         public int updateFromHome(int matchNumber ,int roundNumber,int teamNumber )
    {
                           
                                if(schedul[roundNumber][matchNumber].awayDomain[teamNumber] == true)
                                {
                                   
                                    for (int i =matchNumber+1 ;i<NumberOfMatchesEachRound ;i++ )
                                        {

                                            schedul[roundNumber][i].homeDomain[teamNumber]=false;
                                            schedul[roundNumber][i].awayDomain[teamNumber]=false;


                                        }

                                        return 2;
                                }
                                
                                
                                else 
                                {
                                    for (int i =matchNumber+1 ;i<NumberOfMatchesEachRound ;i++ )
                                        {

                                            schedul[roundNumber][i].homeDomain[teamNumber]=false;
                                            


                                        }
                                    return 1;
                                }
                            
                           
        
                            
                           
    
    }    
        
         
/**********************************************************************************************************************/   
        
        
        public void backTrackAway(int matchNumber ,int roundNumber,int teamNumber ,int backTrackType  )
        {
                            
                                   if(backTrackType == 2)
                                    {
                                        for (int i =matchNumber+1 ;i<NumberOfMatchesEachRound ;i++ )
                                        {

                                            schedul[roundNumber][i].homeDomain[teamNumber]=true;
                                            schedul[roundNumber][i].awayDomain[teamNumber]=true;


                                        }
                                        
                                    }
                                   
                                   
                                   else
                                    {
                                        for (int i =matchNumber+1 ;i<NumberOfMatchesEachRound ;i++ )
                                        {

                                            schedul[roundNumber][i].awayDomain[teamNumber]=true;
                                            


                                        }
                                        
                                    
                                    
                                    }
                     
    
        }
  
 /**********************************************************************************************************************/             
    
        public void backTrackFromHome(int matchNumber ,int roundNumber,int teamNumber ,int backTrackType )
        {
                            
                            
                                if(backTrackType == 2)
                                {
                                   
                                    for (int i =matchNumber+1 ;i<NumberOfMatchesEachRound ;i++ )
                                        {

                                            schedul[roundNumber][i].homeDomain[teamNumber]=true;
                                            schedul[roundNumber][i].awayDomain[teamNumber]=true;


                                        }
                                        
                                }
                                
                                
                                
                                else 
                                {
                                    for (int i =matchNumber+1 ;i<NumberOfMatchesEachRound ;i++ )
                                        {

                                            schedul[roundNumber][i].homeDomain[teamNumber]=true;
                                            


                                        }
                                    
                                }
                            
                        
                            
                            
                            
                            
                           
    
        }
  
        
        

       
 /**********************************************************************************************************************/  
 
 public void printDomain(int roundNumber , int matchNumber)
 {
 
     System.out.println("domain for home");
     for(int i =1 ; i<NumberOfTeams+1 ; i++)
     {
         if(schedul[roundNumber][matchNumber].homeDomain[i])
         System.out.print(i+"  ");
     }
     System.out.println("  ");
     System.out.println("domain for away");
     for(int i =1 ; i<NumberOfTeams+1 ; i++)
     {
         if(schedul[roundNumber][matchNumber].awayDomain[i])
         System.out.print(i+"  ");
     }
     System.out.println("  ");
 }
 
 
 /**********************************************************************************************************************/
 
  public void printSchedulOnSystemOut()
    {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.print("XX");
        for(int j =0 ;j<NumberOfMatchesEachRound ;j++ )
        {
          System.out.print("\t\tM"+(j+1));
        }
        System.out.println("");
         for (int roundNumber = 0 ;roundNumber<NumberOfRounds  ;roundNumber ++ )
                       {
                           
                           System.out.print("R"+(roundNumber+1));
                           
                           
                           for (int matchNumber =0 ;matchNumber<NumberOfMatchesEachRound ;matchNumber++ )
                           {
                               

                               System.out.print("\t\t"+schedul[roundNumber][matchNumber].getHome()+ " VS "+schedul[roundNumber][matchNumber].getAway());
                               
                               
                           }
                       
                       System.out.println();
                       
                       
                      }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    
    }
    
 
/**********************************************************************************************************************/

   
    public void printSchedul()
    {
        System.out.println("printing");
         for (int roundNumber = 0 ;roundNumber<NumberOfRounds  ;roundNumber ++ )
                       {
                           
                           schedulModel.addElement("*********** Round"+(roundNumber+1)+" *************");
                           schedulModel.addElement(" ");
                           schedulModel.addElement("                  Home          Away ");
                           
                           
                           for (int matchNumber =0 ;matchNumber<NumberOfMatchesEachRound ;matchNumber++ )
                           {
                               System.out.println("Match  " +(matchNumber+1)+ "       round   "+(roundNumber+1));

                               schedulModel.addElement("Match  "+(matchNumber+1)+" : team "+ schedul[roundNumber][matchNumber].getHome()+ "  VS   team "+schedul[roundNumber][matchNumber].getAway());
                               
                               
                           }
                       
                       schedulModel.addElement("**********************************");
                       schedulModel.addElement(" ");
                       schedulModel.addElement(" ");
                       schedulModel.addElement(" ");
                       
                       
                      }
         System.out.println("finsh printing");
                        closeButton.setEnabled(true);
                       
                        
    
    }
    


            


}
