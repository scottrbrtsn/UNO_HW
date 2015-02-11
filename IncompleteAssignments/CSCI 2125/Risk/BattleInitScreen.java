/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  BattleInitScreen Class
*  Player chooses territory to attack from
*  Player chooses territory to attack
*
**/

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.util.Observer;
import java.util.Observable;

public class BattleInitScreen extends JPanel{
	private JPanel attackPanel;
	private JTextField attackingTerritory;
	private JTextField defendingTerritory;
	private JTextField result;
	private JButton enterButton;
	private JButton atk1Button;
	private JButton atk2Button;
	private JButton atk3Button;
	private JButton def1Button;
	private JButton def2Button;	
	private JButton fightButton;
	private RiskGameModel myModel;
	private Dice dice;


	public BattleInitScreen(RiskGameModel model){
	
				myModel = model;
				setLayout( new BorderLayout() );	

				
		attackPanel = new JPanel();
		attackPanel.setLayout( new BorderLayout() ); //set layout

		attackingTerritory = new JTextField("Enter territory to attack from.", 30);
		attackPanel.add(attackingTerritory, BorderLayout.LINE_START);

		defendingTerritory = new JTextField("Enter territory to attack.", 30);
		attackPanel.add(defendingTerritory, BorderLayout.LINE_END);

		enterButton = new JButton ("Enter");
		attackPanel.add(enterButton, BorderLayout.CENTER);

	
	  add(attackPanel, BorderLayout.CENTER);

		BattleHandler handler = new BattleHandler();
		enterButton.addActionListener ( handler );
	
	}

	private class BattleHandler implements ActionListener{ 
	
					private Territory atk;
					private Territory def;
					private Player currentPlayer;
					private Player defendingPlayer;
					
		public BattleHandler(){

		}
						
		public void actionPerformed (ActionEvent event){
			if(event.getActionCommand().equals("Enter"))
			{					
				if ( myModel.getGameBoard().getTerritoriesList().contains( attackingTerritory.getText() ) )
				{
					if ( myModel.getGameBoard().getTerritoriesList().contains(defendingTerritory.getText() ) )
					{
								atk = myModel.getGameBoard().getTerritoryByName( attackingTerritory.getText() );
								def = myModel.getGameBoard().getTerritoryByName( defendingTerritory.getText() );
								currentPlayer = myModel.getPlayerRotation().getFirst();
								defendingPlayer = def.getOccupant();
					
							if (atk.getNumArmies() > 1)  //player must have more than one army to attack
							{
										if ( currentPlayer.getTerritoryList().contains( atk.getName() ) == true) //Player must occupy territory to attack from it
										{
													myModel.getBattle().setAttacker(atk);

													if ( atk.getNeighbors().contains( def.getName() ) == true) //Player's territory must neighbor the territory they want to attack
													{
															myModel.getBattle().setDefender(def);		
															myModel.setState(22);													
													} else defendingTerritory.setText ( "TERRITORY DOES NOT NEIGHBOR DESIRED TERRITORY." ) ;

													if ( atk.getNeighbors().contains( atk.getName() ) == true) //attacker can't attack themself
													{
															attackingTerritory.setText("YOU OCCUPY THE DEFENDING TERRITORY");
													}												
										} else attackingTerritory.setText("YOU DO NOT OCCUPY THE ATTACKING TERRITORY.");
										
							}else attackingTerritory.setText("YOU DO NOT HAVE ENOUGH ARMIES TO ATTACK");
						}else defendingTerritory.setText ( "Please choose a valid territory to attack." ) ;
					} else attackingTerritory.setText("Please choose a valid territory to attack from.");
			} //end "Enter"


				

		}//end actionPerformed
	}// end BattleHandler
	
}// end BattleScreen

