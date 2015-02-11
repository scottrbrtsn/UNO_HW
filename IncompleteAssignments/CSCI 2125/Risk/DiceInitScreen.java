/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  DiceInitScreen Class
*  Players choose how many dice to roll to simulate the battle
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

public class DiceInitScreen extends JPanel{
	private JPanel attackPanel;
	private JPanel defensePanel;
	private JPanel fightPanel;
	private JTextField attackPrompt;
	private JTextField defensePrompt;
	private JTextField fightPrompt;
	private JTextField addFightPrompt;
	//private JTextField result;
	private JButton enterButton;
	private JButton atk1Button;
	private JButton atk2Button;
	private JButton atk3Button;
	private JButton def1Button;
	private JButton def2Button;	
	private JButton fightButton;
	private RiskGameModel myModel;
	private String attacker;
	private String defender;
	private Territory atk;
	private Territory def;
	private int a;
	private int d;


	public DiceInitScreen(RiskGameModel model){
	
				myModel = model;
				setLayout( new BorderLayout() );	
				atk = myModel.getBattle().getAttacker();
				def = myModel.getBattle().getDefender();
				attacker = myModel.getBattle().getAttacker().getOccupant().getName();
				defender = myModel.getBattle().getDefender().getOccupant().getName();
				a = 0;
				d = 0;
				
		attackPanel = new JPanel();
		attackPanel.setLayout( new BorderLayout() ); //set layout

		defensePanel = new JPanel();
		defensePanel.setLayout( new BorderLayout() ); //set layout
		
		attackPrompt = new JTextField(attacker + ": How many dice will you roll to attack?", 30);
		attackPanel.add(attackPrompt, BorderLayout.PAGE_START);


		defensePrompt = new JTextField(defender + ": How many dice will you roll to defend?", 30);
		defensePanel.add(defensePrompt, BorderLayout.PAGE_START);


		atk1Button = new JButton("1");
		atk2Button = new JButton("2");
		atk3Button =  new JButton("3");
		
		if ( atk.getNumArmies() > 3)
		{
		attackPanel.add( atk1Button, BorderLayout.LINE_START);
		attackPanel.add( atk2Button, BorderLayout.CENTER);
		attackPanel.add( atk3Button, BorderLayout.LINE_END);
		} else if (atk.getNumArmies() == 3)
		{
		attackPanel.add( atk1Button, BorderLayout.LINE_START );
		attackPanel.add( atk2Button, BorderLayout.LINE_END );
		} else if (atk.getNumArmies() == 2)
		{
		attackPanel.add( atk1Button, BorderLayout.LINE_START );
		}
	
		def1Button = new JButton(" 1 ");
		def2Button = new JButton(" 2 ");

		if (def.getNumArmies() > 1)
		{
			if (atk.getNumArmies() > 1)
			{
					defensePanel.add( def1Button, BorderLayout.LINE_START );
					defensePanel.add( def2Button, BorderLayout.LINE_END );
			}
		} else
		{
		defensePanel.add( def1Button, BorderLayout.LINE_END );
		}
		fightPanel = new JPanel();
		fightPanel.setLayout( new BorderLayout() );	
		fightButton = new JButton ("FIGHT!!!");
		fightPrompt = new JTextField("Highest rolls are compared, ties go to the defender.", 30);
		addFightPrompt = new JTextField("If defender rolls 2, 2nd highest rolls are compared", 30);
		fightPanel.add(fightPrompt, BorderLayout.PAGE_START);
		fightPanel.add(addFightPrompt, BorderLayout.CENTER);
		fightPanel.add(fightButton, BorderLayout.PAGE_END);

	//	attackPanel.add(rollDieButton, BorderLayout.PAGE_START);
		
	  add(attackPanel, BorderLayout.LINE_START);
	  add(defensePanel,  BorderLayout.LINE_END );
		add(fightPanel, BorderLayout.CENTER);
		
		DiceHandler handler = new DiceHandler();
		fightButton.addActionListener( handler );		
		atk1Button.addActionListener( handler );
		atk2Button.addActionListener( handler );
		atk3Button.addActionListener( handler );
		def1Button.addActionListener( handler );
		def2Button.addActionListener( handler );		
	}

	private class DiceHandler implements ActionListener{ 
						
		public DiceHandler(){

		}
						
		public void actionPerformed (ActionEvent event){
			if( event.getActionCommand().equals("1") )
			{
					a = 1;
			}

			if( event.getActionCommand().equals("2") )
			{
					a = 2;
			}

			if( event.getActionCommand().equals("3") )
			{
					a = 3;
			}

			if( event.getActionCommand().equals(" 1 ") )
			{
					d = 1;
			}

			if( event.getActionCommand().equals(" 2 ") )
			{
					d = 2;
			}

			attackPrompt.setText(attacker + " chooses to roll " + a + ".");
			defensePrompt.setText(defender + " chooses to roll " + d + ".");
			
			if( event.getActionCommand().equals("FIGHT!!!") )
			{
					if (a== 0)
					{
							attackPrompt.setText(attacker + ": choose the number of dice to roll.");
					}else if (d == 0)
					{
							defensePrompt.setText(defender + ": choose the number of dice to roll.");
					}else{
					myModel.fight(a, d);
					myModel.setState(23);

				System.out.println("FIGHT!!!!!!");
					} 
			}

		}//end actionPerformed
		}// end BattleHandler

		


	
}// end BattleScreen

