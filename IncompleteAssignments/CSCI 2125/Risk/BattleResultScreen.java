/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  BattleResultScreen Class
*  Displays the result of the battle
*  Offers options to end war or continue attacking territories
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

public class BattleResultScreen extends JPanel{
	private JPanel resultPanel;
	private JTextField resultPrompt;
	private JTextField diceRollPrompt;
	private JButton returnButton;
	private JButton attackAgainButton;
	private RiskGameModel myModel;
	private String attacker;
	private String defender;
	private Territory atk;
	private Territory def;
	private Player currentPlayer;


	public BattleResultScreen(RiskGameModel model){
	
				myModel = model;
				setLayout( new BorderLayout() );	
				atk = myModel.getBattle().getAttacker();
				def = myModel.getBattle().getDefender();
				attacker = myModel.getBattle().getAttacker().getOccupant().getName();
				defender = myModel.getBattle().getDefender().getOccupant().getName();
				currentPlayer = myModel.getBattle().getAttacker().getOccupant();
				
		resultPanel = new JPanel();
		resultPanel.setLayout( new BorderLayout() ); //set layout

		diceRollPrompt = new JTextField(attacker + " rolls a " + myModel.getAtkRolls() + "   " + defender + " rolls a " + myModel.getDefRolls() + ".");
		
		if (myModel.getBattle().getDefDice() == 2)
		{
			if (def.getOccupant() == atk.getOccupant() )
			{
						resultPrompt = new JTextField(myModel.getWinner1().getName() + " wins the battle! and now occupies " + def.getName(), 50);
			}else
			{
						resultPrompt = new JTextField(myModel.getWinner1().getName() + " wins the first battle! and " + myModel.getWinner2().getName() + " wins the second battle!", 50);
			}

		}else
		{

			if (def.getOccupant() == atk.getOccupant() )
			{
						resultPrompt = new JTextField(myModel.getWinner1().getName() + " wins the battle! and now occupies " + def.getName(), 50);
			}else
			{
						resultPrompt = new JTextField(myModel.getWinner1().getName() + " wins the battle!", 50);
			}

			//add condition for when the player is annihilated from game
		}

		returnButton = new JButton("End war.");
		attackAgainButton = new JButton("Attack again!");
		resultPanel.add(resultPrompt, BorderLayout.PAGE_START);
		resultPanel.add(returnButton, BorderLayout.LINE_START);
		resultPanel.add(attackAgainButton, BorderLayout.LINE_END);
		resultPanel.add(diceRollPrompt, BorderLayout.CENTER);	
		add(resultPanel, BorderLayout.PAGE_START);
		
		RestartHandler handler = new RestartHandler();
		returnButton.addActionListener( handler );
		attackAgainButton.addActionListener( handler );
	}

	private class RestartHandler implements ActionListener{ 
						
		public RestartHandler(){
					
		}
						
		public void actionPerformed (ActionEvent event){
			if( event.getActionCommand().equals("End war.") )
			{
						myModel.setState(10);
			}

			if( event.getActionCommand().equals("Attack again!") )
			{
					if (currentPlayer.hasEnoughArmies() == true)
					{
							myModel.setState(21);
							myModel.startBattle();
					}
					else
					{
							resultPrompt.setText("You do not have enough armies to attack any territories");
					}
			}
		}//end actionPerformed
	}// end RestartHandler
	
}// end BattleScreen

