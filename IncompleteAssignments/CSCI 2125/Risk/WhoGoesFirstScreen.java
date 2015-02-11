/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  Dice roll to establish order of player turns.
*  Includes ActionHandler and DiceTextField classes
*  TO DO:  initialize dice, display roll result text
**/

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.util.Observer;
import java.util.Observable;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

public class WhoGoesFirstScreen extends JPanel
{
	private JPanel whoGoesFirstPanel;
	private JPanel buttonPanel;
	private JButton rollDieButton;
	private JButton startButton;
	private DiceTextField rollResult;
	private RiskGameModel myModel;
	private RiskFrame mainFrame;
	private int numPlayers;
	private int playerCounter;
	private List <Player> players;
	private Player player;


	public WhoGoesFirstScreen(RiskGameModel model, RiskFrame frame, int numPlayers)
	{
		myModel = model;
		mainFrame = frame;

		whoGoesFirstPanel = new JPanel();
		whoGoesFirstPanel.setLayout ( new FlowLayout() );

				//add textfield to display roll result
		rollResult = new DiceTextField(myModel, "Result displays here.");
		//java rollResult.setEnabled (false);
		myModel.addObserver(rollResult);
		whoGoesFirstPanel.add(rollResult);

		add(whoGoesFirstPanel, BorderLayout.NORTH);

		//add buttons
		buttonPanel = new JPanel();
		buttonPanel.setLayout( new FlowLayout() ); //set layout

		rollDieButton = new JButton ("Roll Die");
		buttonPanel.add(rollDieButton);

		startButton = new JButton ("Start Setup");
		

		add(buttonPanel);

		WhoGoesFirstHandler handler = new WhoGoesFirstHandler();
		rollDieButton.addActionListener( handler );
		startButton.addActionListener( handler );

		playerCounter = numPlayers;

	}
	
	private class WhoGoesFirstHandler implements ActionListener{
						

		public WhoGoesFirstHandler(){
					
		}

		public void actionPerformed (ActionEvent event){

						if(event.getActionCommand().equals("Start Setup")){
									//if (diceRoll loops), create new PlayerRotation, add in the order of dice
									mainFrame.openTabs();
							}
					//instead of if loops, add for loop to populate diceRoll array: "rolls", loop X numPlayers
					//if current roll == any previous rolls, rollAgain
					
					if(event.getActionCommand().equals("Roll Die"))
					{
							if (playerCounter != 1){
									player = myModel.getNextPlayer();
									myModel.rollDice();
									player.setFirstRoll( myModel.getRoll() );
									myModel.returnPlayer(player);
									playerCounter --;
							}
							else if (playerCounter == 1)
							{
									player = myModel.getNextPlayer();
									myModel.rollDice();
									player.setFirstRoll( myModel.getRoll() );
									myModel.returnPlayer(player);
									players = Arrays.asList( myModel.getPlayers() );
									Collections.sort( players, new Comparator <Player> () 
									{
												public int compare(Player p1, Player p2){
													if (p1.getFirstRoll() > p2.getFirstRoll() ){
															return -1;
													} else if (p1.getFirstRoll() < p2.getFirstRoll() )
													{
														return 1;
													} else return 0;
												}
									} );
									myModel.addPlayers((Player[])players.toArray());
									playerCounter --;
									buttonPanel.remove (rollDieButton);
									buttonPanel.add (startButton);
									buttonPanel.revalidate();
									buttonPanel.repaint();
							}
					//once 'rolls' is populated, sort and then populate playerRotation
					}		
			} 
		} //end handler class
					
private class DiceTextField extends JTextField implements Observer
{
			//Instance Variables
					RiskGameModel model;
					
				public DiceTextField (RiskGameModel model, String string)
				{
					super(string, 15);
					this.model = model;
				}

				public void update  (Observable obs, Object obj)
				{
					this.setText( String.valueOf (player.getName() + " rolled a " + this.model.getRoll() + ".") );
				}

}



											


				
		
	

	
}//end player creation screen class
