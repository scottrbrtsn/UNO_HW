/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  Loads the image and changes it accordingly 
*  Holds all data for game
*  Holds all methods to update game state
*  To Do:  review MVC to verify all info for game use is stored in model for I/O to save/load games
**/

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.Serializable;

public class RiskGameModel extends Observable implements Serializable {
	private BufferedImage testImage;
	private BufferedImage currentText;
	private BufferedImage riskMap;
	private int numPlayers;
	private String gameName;
	private ArrayDeque <Player> playerRotation;
	private Player [] players;
	private GameBoard gameBoard;
	private Dice dice;
	private int diceRoll;
	private RiskCardDeck deck;
	private ArrayList <String> playerTerritories;
	private String p1Territories;
	int state;
	private Battle battle;
	private Player winner; //generic winner used for decideBattle()
	private Player loser; 
	private Player winner1;//actual winner of first battle
	private Player winner2;//actual winner of second battle if there is a second
	private String atkRolls;
	private String defRolls;
	/**
	*
	* Rather than imagining use case scenarios and constructing everything I'd need,
	* in hindsight, I realize I did not construct the game model like the foundation classes.
	*	This part of the project was definitely constructed on an "as needed" basis
	* I'd want to move a lot of methods and variables into this model, where it's being constructed in the action handler
	* for instance, a currentPlayer could've made my life easier, and thus a getCurrentPlayer(), and setCurrentPlayer() method as well
	* 
	* This will clean up the View and the Controller classes.
	* This was a daunting project to be completed in such a short time, especially alone.
	* At the end, I am satisfied with my first attempt at MVC and will be aptly prepared for more to come.
	*/
	
	public RiskGameModel(){
		try{
			riskMap = ImageIO.read(new File("RiskBoard.jpg"));

		} catch (IOException e){
			System.out.println("Image not loaded!: " + e);
		}
			testImage = riskMap;
			this.gameBoard = new GameBoard(); //initialize everything for game
			this.dice = new Dice();
			this.deck = new RiskCardDeck();
			this.atkRolls = "";
			this.defRolls = "";
			state = 1;
	}
	/**
	 * 
	 * State
	 * 1: Create Game/GameBoard
	 * 2: Add Players/GameName
	 * 3: Established Turn Order 
	 * 4: Initialize Territories 
	 * 5: Armies placed
	 *
	 * 10: Beginning of Player turn
	 * 21: Battle Init 
	 * 22: Dice Init 
	 * 23: Battle Result
	 * 30: End of game
	 */

//returns the state of the game	
	public int getState()
	{
			return this.state;
	}

//sets the state of the game for the GUI to update accordingly
	public void setState (int state)
	{
		this.state = state;
		setChanged();
		notifyObservers();
	}

//sets the number of players
//requires an integer 	
	public void setNumPlayers (int numPlayers)
	{
		this.numPlayers = numPlayers;
		this.playerRotation = new ArrayDeque<Player>( getNumPlayers() );
		setChanged();
		notifyObservers();
	}

//returns the number of players
	public int getNumPlayers()
	{
		return this.numPlayers;
	}
	
//sets the name of the game
	public void setGameName (String gameName)
	{
		this.gameName = gameName;
		setChanged();
		notifyObservers();
	}
	
//returns the name of the game
	public String getGameName()
	{
		return this.gameName;
	}
	
// returns the array of players
	public Player[] getPlayers()
	{
		return this.players;
	}

//The array is created to store the original order of players
//It remains stored in memory and can be used in the event the program requires resetting the order of the Deque
//e.g. 4 players, 42 territories, at the end of initializing territories, player1 is not at the front of the Deque, so it is reset
	public void addPlayers(Player []  players)
	{
			this.players = players;
			populatePlayerDeque();
			setChanged();
			notifyObservers();
	}

//uses the array to create the Player Deque, 
//a Deque is used for easy access of players and the simulation of player turn ordering
	private void populatePlayerDeque()
	{
		this.playerRotation = new ArrayDeque<Player>( getNumPlayers() );
			for (int i = 0; i < getNumPlayers(); i++)
			{
				this.playerRotation.addLast(this.players[i]);
			}
	}
	
	public ArrayDeque<Player> getPlayerRotation()
	{
			return this.playerRotation;
	}

	public Player getNextPlayer ()
	{
			return this.playerRotation.removeFirst();
	}

	public void returnPlayer (Player player)
	{
			this.playerRotation.addLast (player);
	}

	public void startBattle()
	{
			battle = new Battle (this);
			setChanged();
			notifyObservers();
	}

//String getAtkRolls() is created for the GUI output

	public String getAtkRolls() 
	{
			return this.atkRolls;
	}

//String getDefRolls() is created for the GUI output
	public String getDefRolls()
	{
			return this.defRolls;
	}

	//Fight simulates the dice rolls
	 public void fight(int atk, int def)
	 {
			this.battle.setAtkDice(atk);
			this.battle.setDefDice(def);
			this.battle.battle();
			defRolls = getBattle().getDefenseRolls().toString();
			atkRolls = getBattle().getAttackRolls().toString();
			winner1 = decideBattle();
			if (def == 2)
			{
				winner2 = decideBattle();
			}
			
			setChanged();
			notifyObservers();
	 }

	// decideBattle automatically evaluates the dice rolls and declares a winner
	 private Player decideBattle()
	 {
	 		Territory l = this.battle.decideLoser();
	 		Territory w = this.battle.getWinner();	 		
	 		winner = w.getOccupant();
	 		loser = l.getOccupant();
	 			if (l.getNumArmies() == 0)
					{
							loser.removeTerritory(l);
							l.setOccupant( winner );
							winner.addTerritory(l);
							winner.deployArmy();
							l.addArmy();
							if (winner.getConqueredTerrVar() == false)
							{
								winner.setConqueredNewTerrVar();
							}
							addContinent(winner);
							addContinent (loser); //actually removes continent
					}

				if (loser.getTerritories() == null)
				{
						playerRotation.remove(loser);
				}

			//need to add condition when player no longer occupies territores.  i.e. playerRotation.remove(player) 		
			setChanged();
			notifyObservers();
			return winner;
	 }

	/**
	* checks territories list of each player
	*adds a Continent to Player if player occupies all territories, 
	* used after deciding battles and during Territory Init
	* removes a continent of player loses control of continent
	**/
	 public void addContinent(Player player)  
	 {	
	 //add continent
				if ( player.getTerritoryList().contains("Alaska") == true && 
			player.getTerritoryList().contains("Alberta") == true &&
			player.getTerritoryList().contains("Central America") == true &&
			player.getTerritoryList().contains("Eastern United States") == true &&
			player.getTerritoryList().contains("Greenland") == true &&
			player.getTerritoryList().contains("Northwest Territory") == true &&
			player.getTerritoryList().contains("Ontario") == true &&
			player.getTerritoryList().contains("Quebec") == true &&
			player.getTerritoryList().contains("Western United States") == true )
			{
				if ( player.getContinentList().contains ("North America") == false )
				{
				player.addContinent( getGameBoard().getContinentByName("North America") );
				getGameBoard().getContinentByName("North America").setOccupant(player);
				}
			}

			if ( player.getTerritoryList().contains("Argentina") == true && 
			player.getTerritoryList().contains("Brazil") == true &&
			player.getTerritoryList().contains("Venezuela") == true)
			{

				if ( player.getContinentList().contains ("South America") == false )
				{
						player.addContinent( getGameBoard().getContinentByName("South America") );
						getGameBoard().getContinentByName("South America").setOccupant(player);
				}
			}

			if ( player.getTerritoryList().contains("Great Britain") == true &&
			player.getTerritoryList().contains("Iceland") == true &&
			player.getTerritoryList().contains("Northern Europe") == true &&
			player.getTerritoryList().contains("Scandinavia") == true &&
			player.getTerritoryList().contains("Southern Europe") == true &&
			player.getTerritoryList().contains("Ukraine") == true &&
			player.getTerritoryList().contains("Western Europe") == true )
			{
				if ( player.getContinentList().contains ("Europe") == false )
				{
				player.addContinent( getGameBoard().getContinentByName("Europe") );
				getGameBoard().getContinentByName("Europe").setOccupant(player);
				}
			}

			if ( player.getTerritoryList().contains("Congo") == true &&
			player.getTerritoryList().contains("East Africa") == true &&
			player.getTerritoryList().contains("Egypt") == true &&
			player.getTerritoryList().contains("Madagascar") == true &&
			player.getTerritoryList().contains("North Africa") == true &&
			player.getTerritoryList().contains("South Africa") == true )
			{
				if ( player.getContinentList().contains ("Africa") == false )
				{
				player.addContinent( getGameBoard().getContinentByName("Africa") );
				getGameBoard().getContinentByName("Africa").setOccupant(player);
				}
			}

			if ( player.getTerritoryList().contains("Afghanistan") == true &&
			player.getTerritoryList().contains("China") == true &&
			player.getTerritoryList().contains("India") == true &&
			player.getTerritoryList().contains("Irkutsk") == true &&
			player.getTerritoryList().contains("Japan") == true &&
			player.getTerritoryList().contains("Kamchatka") == true &&
			player.getTerritoryList().contains("Middle East") == true &&
			player.getTerritoryList().contains("Mongolia") == true &&
			player.getTerritoryList().contains("Siam") == true &&
			player.getTerritoryList().contains("Siberia") == true &&
			player.getTerritoryList().contains("Ural") == true &&
			player.getTerritoryList().contains("Yakutsk") == true )
			{
				if ( player.getContinentList().contains ("Asia") == false )
				{
				player.addContinent( getGameBoard().getContinentByName("Asia") );
				getGameBoard().getContinentByName("Asia").setOccupant(player);
				}
			}

			if ( player.getTerritoryList().contains("Eastern Australia") == true &&
			player.getTerritoryList().contains("Indonesia") == true &&
			player.getTerritoryList().contains("New Guinea") == true &&
			player.getTerritoryList().contains("Western Australia") == true &&
			player.getTerritoryList().contains("Lot R") == true )
			{
				if ( player.getContinentList().contains ("Australia") == false )
				{
				player.addContinent( getGameBoard().getContinentByName("Australia") );
				getGameBoard().getContinentByName("Australia").setOccupant(player);
				}
			}
	// check and remove continent
				if ( player.getTerritoryList().contains("Alaska") == false || 
			player.getTerritoryList().contains("Alberta") == false || 
			player.getTerritoryList().contains("Central America") == false || 
			player.getTerritoryList().contains("Eastern United States") == false || 
			player.getTerritoryList().contains("Greenland") == false || 
			player.getTerritoryList().contains("Northwest Territory") == false || 
			player.getTerritoryList().contains("Ontario") == false || 
			player.getTerritoryList().contains("Quebec") == false || 
			player.getTerritoryList().contains("Western United States") == false )
			{
				if ( player.getContinentList().contains ("North America") == true )
				{
						player.removeContinent( getGameBoard().getContinentByName("North America") );
				}
			}

			if ( player.getTerritoryList().contains("Argentina") == false || 
			player.getTerritoryList().contains("Brazil") == false || 
			player.getTerritoryList().contains("Venezuela") == false  )
			{
				if (player.getContinentList().contains ("South America") == true )
						{
								player.removeContinent( getGameBoard().getContinentByName("South America") );
						}
			}

			if ( player.getTerritoryList().contains("Great Britain") == false || 
			player.getTerritoryList().contains("Iceland") == false || 
			player.getTerritoryList().contains("Northern Europe") == false || 
			player.getTerritoryList().contains("Scandinavia") == false || 
			player.getTerritoryList().contains("Southern Europe") == false || 
			player.getTerritoryList().contains("Ukraine") == false || 
			player.getTerritoryList().contains("Western Europe") == false  )
			{
					if (player.getContinentList().contains ("Europe") == true)
						{
								player.removeContinent( getGameBoard().getContinentByName("Europe") );
						}
			}

			if ( player.getTerritoryList().contains("Congo") == false || 
			player.getTerritoryList().contains("East Africa") == false || 
			player.getTerritoryList().contains("Egypt") == false || 
			player.getTerritoryList().contains("Madagascar") == false || 
			player.getTerritoryList().contains("North Africa") == false || 
			player.getTerritoryList().contains("South Africa") == false )
			{
					if (player.getContinentList().contains ("Africa") == true )
						{
								player.removeContinent( getGameBoard().getContinentByName("Africa") );
						}
			}

			if ( player.getTerritoryList().contains("Afghanistan") == false || 
			player.getTerritoryList().contains("China") == false || 
			player.getTerritoryList().contains("India") == false || 
			player.getTerritoryList().contains("Irkutsk") == false || 
			player.getTerritoryList().contains("Japan") == false || 
			player.getTerritoryList().contains("Kamchatka") == false || 
			player.getTerritoryList().contains("Middle East") == false || 
			player.getTerritoryList().contains("Mongolia") == false || 
			player.getTerritoryList().contains("Siam") == false || 
			player.getTerritoryList().contains("Siberia") == false || 
			player.getTerritoryList().contains("Ural") == false || 
			player.getTerritoryList().contains("Yakutsk") == false )
			{
				if (player.getContinentList().contains ("Asia") == true )
						{
								player.removeContinent( getGameBoard().getContinentByName("Asia") );
						}
			}

			if ( player.getTerritoryList().contains("Eastern Australia") == false || 
			player.getTerritoryList().contains("Indonesia") == false || 
			player.getTerritoryList().contains("New Guinea") == false || 
			player.getTerritoryList().contains("Western Australia") == false || 
			player.getTerritoryList().contains("Lot R") == false )
			{
				if (player.getContinentList().contains ("Australia") == true )
						{
								player.removeContinent( getGameBoard().getContinentByName("Australia") );
						}
			}
	 }

//returns the current battle
	public Battle getBattle()
	{
			return this.battle;
	}

//winner 1 and winner 2 are set to store the instance when the defender rolls 2 dice
//returns winner 1, winner of the first battle
	public Player getWinner1()
	{
			return this.winner1;
	}

//returns winner2, winner of the second battle
	public Player getWinner2()
	{
			return this.winner2;
	}

//returns the game board
	public GameBoard getGameBoard ()
	{
			return this.gameBoard;
	}

//Dice  and methods

//returns the dice
	public Dice getDice()
	{
			return this.dice;
	}

//rolls the dice
	public void rollDice()
	{
			diceRoll = this.dice.roll();
			setChanged();
			notifyObservers();
	}

//returns the dice-roll
	public int getRoll()
	{
			return this.diceRoll;
	}

//returns the deck of risk cards
	public RiskCardDeck getDeck()
	{
		return this.deck;
	}

	public BufferedImage getCurrentImage(){
		return riskMap;
	}

	public BufferedImage getCurrentText()
	{
		return currentText;
	}
}
