/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  TabScreen Class
*  Contains each tab for game stats
*  and a tab for the main game activity
*
**/

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import java.io.File;
import javax.swing.JFileChooser;
import java.lang.StringBuilder;


public class TabScreen extends JTabbedPane{
	private JPanel mainScreen;
	private TerritoryInitScreen territoryInitScreen;

	private JTabbedPane tabs;
	private JPanel gameStats;
	private JPanel playerStats;
	private RiskGameModel myModel;
	private RiskFrame mainFrame;
	private ArmiesInitScreen armiesInitScreen;
	private PlayerTurnScreen playerTurnScreen;
	private RiskMap riskMap;
	private RiskTextPrompt prompt;

	public TabScreen(RiskGameModel model, RiskFrame frame){
			myModel = model;
			mainFrame = frame;
			mainScreen = new JPanel();
			mainScreen.setLayout ( new BorderLayout() );
			riskMap = new RiskMap(myModel);

			
			territoryInitScreen = new TerritoryInitScreen( myModel, this );
			mainScreen.add(territoryInitScreen, BorderLayout.NORTH);
			mainScreen.add(riskMap);
			
			gameStats = new JPanel ();
			gameStats.setLayout ( new GridLayout(45, 1 ) );
					//add JLabel to be an observer of player attributes, add class for this below
					//i.e. lists of territories, countries, armies, and riskcards.
			for (String territory : myModel.getGameBoard().getTerritoriesList())
			{
					Territory t = myModel.getGameBoard().getTerritoryByName(territory);
					TerritoryJLabel label = new TerritoryJLabel (myModel, t);
					gameStats.add(label);
					t.addObserver(label);									
			}	

			playerStats = new JPanel();
			playerStats.setLayout ( new GridLayout ( myModel.getNumPlayers() * 3 + 1, 1 ) );
			
			Player [] pList = myModel.getPlayers();
			for ( int i = 0; i <= myModel.getNumPlayers() - 1; i++)
			{
					Player p = pList[i];
					PlayerJLabel pLabel = new PlayerJLabel (myModel, p);
					TerrListJLabel tLabel = new TerrListJLabel (myModel, p);
					ContListJLabel cLabel = new ContListJLabel (myModel, p);
					playerStats.add(pLabel);
					playerStats.add(tLabel);
					playerStats.add(cLabel);
					p.addObserver(pLabel);
					p.addObserver(tLabel);
					p.addObserver(cLabel);
			}
							//	tabs.addTab (stringTabs[i], null, tabList[i], "Click for Player Attributes");
			addTab("Risk", null, mainScreen, "Click for main Game");
			addTab("Game Stats", null, gameStats, "Click for Territory Attributes");
			addTab("Player Stats", null, playerStats, "Click for Player Attributes");
	}
	
	public class TerritoryJLabel extends JLabel implements Observer
{
					RiskGameModel model;
					Territory territory;
					
				public TerritoryJLabel(RiskGameModel model, Territory territory)
				{
					super("0");
					this.territory = territory;
					this.model = model;
				}

			//displays stats of each territory to be referenced by players during gameplay
				public void update  (Observable obs, Object obj)
				{
						this.setText( territory.getName() + " is occupied by " + territory.getOccupant().getName() + " and has " + territory.getNumArmies() + " armies." );
				}
}

//Displays Player hand
	public class PlayerJLabel extends JLabel implements Observer
{
					RiskGameModel model;
					Player p;				
				public PlayerJLabel(RiskGameModel model, Player player )
				{
					super("0");
					this.p = player;
					this.model = model;
				}

			//displays each player's hand to be referenced during gameplay
			//a way to hide hands needs to be implemented so each player is only able to see their own hand
				public void update  (Observable obs, Object obj)
				{
						this.setText( p.getName() + "'s hand includes: " + p.getHand().getNames() );
				}
}

//Displays Players Territories
public class TerrListJLabel extends JLabel implements Observer
{
					RiskGameModel model;
					Player p;				
				public TerrListJLabel(RiskGameModel model, Player player )
				{
					super("0");
					this.p = player;
					this.model = model;
				}

			//displays each player's hand to be referenced during gameplay
			//a way to hide hands needs to be implemented so each player is only able to see their own hand
				public void update  (Observable obs, Object obj)
				{
						this.setText( p.getName() + "'s territories: " + p.getTerritoryList().toString() );
				}
}

//displays player's continents
public class ContListJLabel extends JLabel implements Observer
{
					RiskGameModel model;
					Player p;				
				public ContListJLabel(RiskGameModel model, Player player )
				{
					super("0");
					this.p = player;
					this.model = model;
				}

			//displays each player's hand to be referenced during gameplay
			//a way to hide hands needs to be implemented so each player is only able to see their own hand
				public void update  (Observable obs, Object obj)
				{
						this.setText( p.getName() + "'s continents: " + p.getContinentList().toString() );
				}
}

/**
* removes the current panels 
* adds the panels for adding armies to territories
*
**/
	public void openArmiesInitScreen ()
	{
			Player[] players = myModel.getPlayers();
			if (myModel.getPlayerRotation().getFirst() == players[0])
			{
					mainScreen.remove(territoryInitScreen);
					mainScreen.repaint();
					armiesInitScreen = new ArmiesInitScreen (myModel, this);
					mainScreen.add(armiesInitScreen, BorderLayout.NORTH);
					mainScreen.revalidate();
					mainScreen.repaint();
			}else
			{
				Player player = myModel.getNextPlayer();
				myModel.returnPlayer(player);
				this.openArmiesInitScreen(); 
			}
	}


/**
* removes the current panels 
* adds the panels for main game activity
*
**/	
		public void openPlayerTurnScreen ()
	{
	//creates an array of players, checks to see if the first player is at the front of the line 
	//and adjusts if the number of territories on the gameBoard shifted the rotation
			Player[] players = myModel.getPlayers();
			if (myModel.getPlayerRotation().getFirst() == players[0])
			{
					mainScreen.remove(armiesInitScreen);
					mainScreen.repaint();
					playerTurnScreen = new PlayerTurnScreen (myModel, this, mainFrame);
					mainScreen.add(playerTurnScreen, BorderLayout.NORTH);
					mainScreen.revalidate();
					mainScreen.repaint();
			}else
			{
				Player player = myModel.getNextPlayer();
				myModel.returnPlayer(player);
				this.openPlayerTurnScreen(); 
			}
	}
/**
*
* Removes the current panels
* adds panels for battle simulation
*
**/
	public void openBattleScreen ()
	{
				BattleScreen battleScreen = new BattleScreen (myModel);
				battleScreen.setWindow (battleScreen);
				battleScreen.setSize(700, 100);
				battleScreen.setVisible(true);
				System.out.println ("Open battle screen");
	}
	
	public RiskMap getImageComponent(){
		return riskMap;
	}
	
}
