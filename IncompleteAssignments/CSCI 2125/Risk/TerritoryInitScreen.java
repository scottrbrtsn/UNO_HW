/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  Provides text box to occupy a territory
* To do:
*	Find a way to link text with an action button
* 
* If time allots, add list of instruction Strings to update the textbox
* E.g. territory occupied, choose another
**/

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TerritoryInitScreen extends JPanel{
	private JPanel buttonPanel;
	private JPanel territoryInitPanel;
	private JComboBox territoryInput;
	private JTextField instruct;  
	private JButton selectTerritoryButton;
	private JButton rollDieButton;
	private RiskGameModel myModel;
	private TabScreen tabScreen;
	private int territoryCounter;



	public TerritoryInitScreen(RiskGameModel model, TabScreen screen){
	
	//total number of territories, the iterates through territories, @0: game state changes to add armies
			territoryCounter = 9;  

			myModel = model;
			tabScreen = screen;
			
					//add textUI
			territoryInitPanel = new JPanel();
			territoryInitPanel.setLayout ( new FlowLayout() );

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


		instruct = 	new JTextField (myModel.getPlayerRotation().getFirst().getName() + 
			" choose an unoccupied territory to occupy by using the drop-menu and selecting your next territory.", 75);
		territoryInitPanel.add(instruct);

		JComboBox <String> territoryInput = new JComboBox <String> (territories);
		territoryInput.setSelectedIndex(0);
		territoryInitPanel.add(territoryInput);

		add(territoryInitPanel, BorderLayout.NORTH);
		
		InitHandler handler = new InitHandler();
		territoryInput.addActionListener(handler);
	}

	private class InitHandler implements ActionListener{
		public InitHandler(){
		
		}
		public void actionPerformed (ActionEvent event){
											JComboBox cb = (JComboBox) event.getSource();
											String territoryName = (String)cb.getSelectedItem();
											Territory territory = myModel.getGameBoard().getTerritoryByName( territoryName );
							if (territoryCounter != 1) 
							{											
									if ( territory.isOccupied() == false ){
											Player player =  myModel.getNextPlayer();
											String nextPlayer = myModel.getPlayerRotation().getFirst().getName();
											player.addTerritory(myModel.getGameBoard().getTerritoryByName( territoryName ));
											myModel.addContinent(player);
											player.deployArmy();
											myModel.getGameBoard().getTerritoryByName( territoryName ).setOccupant( player );
											myModel.getGameBoard().getTerritoryByName( territoryName ).addArmy();
											myModel.returnPlayer(player);
											instruct.setText( "                         " + nextPlayer + " choose an unoccupied territory.");
											territoryCounter --;
									}else instruct.setText( "Territory is occupied by " + territory.getOccupant().getName() );

							} else
									{										
											if ( territory.isOccupied() == false )
											{
											//change to add a button to continue to armiesInitScreen
													Player player =  myModel.getNextPlayer();
													String nextPlayer = myModel.getPlayerRotation().getFirst().getName();
													player.addTerritory (myModel.getGameBoard().getTerritoryByName( territoryName ));
													myModel.getGameBoard().getTerritoryByName( territoryName ).setOccupant( player );
													player.deployArmy();
													myModel.getGameBoard().getTerritoryByName( territoryName ).addArmy();
													myModel.returnPlayer(player);
													tabScreen.openArmiesInitScreen(); //change to optimize MVC: set state: 5
											}else instruct.setText("Territory is occupied by " + territory.getOccupant().getName() );
											
									} 
			}
	}
}// end TerritoryInitScreen
