/**
* Scott Robertson Risk Project
* CSCI 2120
*
*	Loops through players to add armies after all territories are occupied
*
*	To do
* loop through players to add armies
* then open player turn screen
**/

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ArmiesInitScreen extends JPanel{
				private JPanel buttonPanel;
				private JPanel armiesInitPanel;
				private JTextField instruct;  
				private RiskGameModel myModel;
				private TabScreen tabScreen;
				private JComboBox territoryInput;
	
	public ArmiesInitScreen(RiskGameModel model, TabScreen screen){
		myModel = model;
		tabScreen = screen;	
										
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
		armiesInitPanel = new JPanel();
		armiesInitPanel.setLayout ( new FlowLayout() );

		instruct = 	new JTextField (myModel.getPlayerRotation().getFirst().getName() + ", choose one of your territories to add an army to", 75);
		armiesInitPanel.add(instruct);
	
		JComboBox <String> territoryInput = new JComboBox <String> (territories);
		territoryInput.setSelectedIndex(0);
		armiesInitPanel.add(territoryInput);
		add(armiesInitPanel, BorderLayout.NORTH);

		InitHandler handler = new InitHandler();
		territoryInput.addActionListener(handler);

	}


	private class InitHandler implements ActionListener{
		public InitHandler(){

		}

		public void actionPerformed (ActionEvent event){    //add exceptions for improper territory "territory does not exist" or "you do not occupy territory"
		
											JComboBox cb = (JComboBox) event.getSource();
											String territoryName = (String)cb.getSelectedItem();
											Territory territory = myModel.getGameBoard().getTerritoryByName( territoryName );
	
													Player player =  myModel.getNextPlayer();
												if ( player.hasArmies() == true)
												{
														if ( player == territory.getOccupant() )
														{
															player.deployArmy();
															System.out.println ( player.getName() + "'s remaining armies:" + player.getTotalArmies() );
															myModel.getGameBoard().getTerritoryByName( territoryName ).addArmy();
															myModel.returnPlayer(player);
															instruct.setText( player.getName() + " added an army to: " 
																	+ territoryName + ".         " + myModel.getPlayerRotation().getFirst().getName()
																			 + ", choose one of your territories to add an army to");														
														}  else 
																{
																instruct.setText("You do not occupy territory.  " + player.getName() + " choose one of your territories to add an army to.");
																myModel.getPlayerRotation().addFirst(player);
																}					
												} else 
													{
															myModel.returnPlayer(player);  
															tabScreen.openPlayerTurnScreen();					 //update to MVC optimization:  set state to 10
													}
			} //end ActionPerformed
		}//end InitHandler
}
