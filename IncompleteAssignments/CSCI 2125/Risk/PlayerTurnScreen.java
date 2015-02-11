/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  PlayerTurnScreen Class
*  Cycles through players through main game behavior:
*
*  Place armies
*  Attack
*  Draw Cards
*  Fortify Position
*	 Pass Dice (ends turn)
*
**/

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Observer;
import java.util.Observable;


public class PlayerTurnScreen extends JPanel implements Observer
{

	private JPanel buttonPanel;
	private JPanel playerTurnPanel;
	private JButton tradeInCardsButton;
	private JButton fortifyPosition;
	private JButton passDiceButton;
	private JButton placeArmiesButton;
	private JButton attackButton;
	private JButton drawCardButton;
	private JTextField inputField;
	private JTextField outputField;
	private RiskGameModel myModel;
	private TabScreen tabScreen;
	private Player currentPlayer;
	private JComboBox territoryInput;
	private BattleInitScreen battleInitScreen;
	private DiceInitScreen diceInitScreen;
	private BattleResultScreen battleResultScreen;
	private RiskFrame mainFrame;



	public PlayerTurnScreen(RiskGameModel model, TabScreen screen, RiskFrame frame){
	mainFrame = frame;
	myModel = model;
	tabScreen = screen;
	myModel.addObserver(this);
	//initiate all screens for permanence to be used at various times during a Player's Turn
	
							String[] territories = {
							//North America (5)
							"Alaska", "Alberta", "Central America", "Eastern United States",
							"Greenland", "Northwest Territory", "Ontario", "Quebec", "Western United States",
						//South America
							"Argentina", "Brazil", "Venezuela",
							//Europe
							"Great Britain", "Iceland", "Northern Europe", "Scandinavia", "Southern Europe", "Ukraine", "Western Europe",
							//Africa
							"Congo", "East Africa", "Egypt", "Madagascar", "North Africa", "South Africa",
							//Asia
							"Afghanistan", "China", "India", "Irkutsk", "Japan", "Kamchatka", "Middle East", "Mongolia", "Siam", "Siberia", "Ural", "Yakutsk",
							//Australia 
							"Eastern Australia", "Indonesia", "New Guinea", "Western Australia", "Lot R"
									};

		
		currentPlayer = myModel.getPlayerRotation().getFirst();
		 //add method to calculate
		//add buttons
		buttonPanel = new JPanel();
		buttonPanel.setLayout( new BorderLayout() ); //set layout

		//if player has matching cards
		tradeInCardsButton = new JButton ("Trade in card sets");
		buttonPanel.add(tradeInCardsButton, BorderLayout.PAGE_START);

		passDiceButton = new JButton("Pass Dice to Next Player");
		buttonPanel.add(passDiceButton, BorderLayout.LINE_END);

		fortifyPosition = new JButton("Fortify Position");
		buttonPanel.add(fortifyPosition, BorderLayout.CENTER);

		attackButton = new JButton ("Declare War");
		buttonPanel.add(attackButton, BorderLayout.LINE_START);
		//if player occupied a new territory during current turn
		System.out.println(currentPlayer.getName());
		
		add(buttonPanel);

		drawCardButton = new JButton ("Draw Risk Card");
		ButtonHandler handler = new ButtonHandler();
		tradeInCardsButton.addActionListener( handler );
		passDiceButton.addActionListener( handler );
		attackButton.addActionListener( handler );
		drawCardButton.addActionListener( handler );

		//add text fields
		playerTurnPanel = new JPanel();
		playerTurnPanel.setLayout ( new BorderLayout() );

		JComboBox <String> territoryInput = new JComboBox <String> (territories);
		territoryInput.setSelectedIndex(0);
		playerTurnPanel.add(territoryInput, BorderLayout.CENTER);

		ComboHandler cHandler = new ComboHandler();
		territoryInput.addActionListener(cHandler);
		
		inputField = new JTextField(currentPlayer.getName() + " choose a Territory from the drop-menu to place armies", 50);   
		playerTurnPanel.add(inputField, BorderLayout.PAGE_START);
		currentPlayer.setAdditionalArmies();  //sets additional armies. maybe should be autoupdated for MVC?
		outputField = new JTextField("You can place " + currentPlayer.getAdditionalArmies() + "  armies.", 50);
		playerTurnPanel.add(outputField, BorderLayout.PAGE_END);
		
		add(playerTurnPanel);
	
	}
	public void update  (Observable obs, Object obj)
				{

				/**
				*		Primary display of this.developer's ability to demonstrate MVC
				*
				*		The game model's state is updated during game behavior (i.e. button clicks)
				*   This panel updates its displayed components in accordance with game behavior
				*		
				*
				*
				**/
						if (myModel.getState() == 10)
						{
							removeAll();
							tabScreen.revalidate();
							tabScreen.repaint();
								//The button/option to draw a card is only added when a player conquers a territory								
							if ( currentPlayer.getConqueredTerrVar() == true )
							{
									buttonPanel.add(drawCardButton, BorderLayout.PAGE_END);	
							}
							
							add(buttonPanel);
							add(playerTurnPanel);
							buttonPanel.revalidate();
							buttonPanel.repaint();
							tabScreen.revalidate();
							tabScreen.repaint();
						}

						if (myModel.getState() == 21)//current player chooses territories to attack from and attack
						{
							removeAll();
							tabScreen.revalidate();
							tabScreen.repaint();
							battleInitScreen = new BattleInitScreen(myModel);
							add(battleInitScreen, BorderLayout.NORTH);
							tabScreen.revalidate();
							tabScreen.repaint();
						} 

						if (myModel.getState() == 22) //current player and defending territory's occupant choose the number of dice to roll
						{
							this.removeAll();
							tabScreen.revalidate();
							tabScreen.repaint();
							diceInitScreen = new DiceInitScreen (myModel);
							add(diceInitScreen, BorderLayout.NORTH);
							tabScreen.revalidate();
							tabScreen.repaint();
						}

						if (myModel.getState() == 23) //displays winner of battle(s) and options to contiue attacking or end the war
						{
							remove(diceInitScreen);   
							tabScreen.revalidate();
							tabScreen.repaint();
							battleResultScreen = new BattleResultScreen (myModel);
							add(battleResultScreen, BorderLayout.NORTH);
							tabScreen.revalidate();
							tabScreen.repaint();
						}

						if (myModel.getState() == 30) //ends the game
						{
							mainFrame.removeAll();
							mainFrame.getPrompt().setPrompt(currentPlayer.getName() + "CONQUERS THE GLOBE!!!!!!!!!!!");
						}

				}

	private class ButtonHandler implements ActionListener{
		public ButtonHandler(){

		}

		public void actionPerformed (ActionEvent event){

			//checks for a valid set, removes cards from hand and adds to Player's list of sets
			//adds armies accordingly
			if( event.getActionCommand().equals("Trade in card sets") ){
				System.out.println ("Code needed");
			}

			if( event.getActionCommand().equals("Fortify Position") ){
					System.out.println ("Code needed");
			}

			if( event.getActionCommand().equals("Declare War") )
			{ 
					if(currentPlayer.hasEnoughArmies() == true)
					{
						myModel.startBattle();
						myModel.setState(21);	
					}else 
					{	outputField.setText("None of your territories have enough armies to attack.");
					}
			}

			if( event.getActionCommand().equals("Draw Risk Card") ){
					//After player draws a card, this button/option is removed from the panel
					currentPlayer.addRiskCard( myModel.getDeck().dealCard() );
					buttonPanel.remove(drawCardButton);
					buttonPanel.revalidate();
					buttonPanel.repaint();
					currentPlayer.setConqueredNewTerrVar();
			}

			if( event.getActionCommand().equals("Pass Dice to Next Player") ){
							//adds the current player to the end of the list and gets the next player
							currentPlayer = myModel.getNextPlayer();
							myModel.returnPlayer(currentPlayer);
							currentPlayer = myModel.getPlayerRotation().getFirst();
							currentPlayer.setAdditionalArmies();
							outputField.setText("You can place " + currentPlayer.getAdditionalArmies() + "  armies.");
							inputField.setText(currentPlayer.getName() + " enter Territory Name to place armies");

			//end of game scenario
					if (myModel.getPlayerRotation().size() == 1)
					{
							myModel.setState(30);
							
					 		System.out.println( myModel.getNextPlayer().getName() + " CONQUERS THE GLOBE!");
					}
			}
		}
	}
private class ComboHandler implements ActionListener{
		public ComboHandler(){

		}

		public void actionPerformed (ActionEvent event){
					JComboBox cb = (JComboBox) event.getSource();
					String territoryName = (String)cb.getSelectedItem();
					Territory territory = myModel.getGameBoard().getTerritoryByName( territoryName );
					Player player =  myModel.getPlayerRotation().getFirst();
												if ( player.hasAddArmies() == true)
												{
														if ( player == territory.getOccupant() )
														{
															player.deployAddArmy();
															territory.addArmy();
															outputField.setText( player.getName() + " added an army to: " + territoryName + ".    " + player.getAdditionalArmies() + " armies left.");
															
														}  else 
																{
																outputField.setText("You do not occupy territory");
																}
														
												} else 
													{
																	outputField.setText("You are out of armies to deploy");
													}
		}// end actionPerformed
	}
	
}// end PlayerTurnScreen class
