	/**
	* Scott Robertson Risk Project
	* CSCI 2120
	*
  * Player Class
  * Specifies players participating in an active game
  * Player objects will be contained in Gameobjects
  **/
import java.util.ArrayList;
import java.util.Observable;

  public class Player extends Observable
  {
					 private String name;
					 private ArrayList<Territory> territories; 
					 private int numTerritories;
					 private ArrayList<Continent> continents;
					 private ArrayList<String> territoryList;
					 private ArrayList<String> continentList;
					 private RiskCardHand hand;
					 private int totalArmies;
					 private int numAttackDice;
					 private int numDefendDice;
					 private int firstRoll;
					 private int additionalArmies;
					 private boolean conqueredNewTerritory;


		public Player (String name)
		{
				this.name = name;
				this.territories = new ArrayList <Territory>();
				this.territoryList = new ArrayList <String>();
				this.numTerritories = territoryList.size();
				this.continents = new ArrayList <Continent>();
				this.continentList = new ArrayList <String>();
				this.hand = new RiskCardHand();
				this.totalArmies = 0;
				this.numAttackDice = 0;
				this.numDefendDice = 0;
				this.additionalArmies = 0;
				this.conqueredNewTerritory = false;
		}
		/**
		*  Sets the Player's name as a Sring
    *  @param name: the name of the Player (String)
  	**/
  		// public String setName(Player name)
  		

  	/**
    *  @return Player's name
  	**/
  		public String getName()
  		{
  				return this.name;
  		}


  		public int getFirstRoll()
  		{
					return firstRoll;
  		}
		/**
    *  @return ArrayList of territories occupied by Player
  	**/  		
			public ArrayList <Territory> getTerritories()
			{
					return this.territories;
			}

		/**
    *  @return int of the number of territories occupied by Player
  	**/  		
			public int getNumTerritories()
			{
					return this.numTerritories;
			}

		/**
    *  @return ArrayList of string of territory names occupied by Player
  	**/  		
			public ArrayList <String> getTerritoryList()
			{
					return this.territoryList;
			}

		/**
    *  @return ArrayList of continents occupied by Player
    *  could return null if no continents are occupied by Player
  	**/
			public ArrayList <Continent> getContinents()
			{
					return this.continents;
			}
		/**
    *  @return ArrayList of string of territory names occupied by Player
  	**/  		
			public ArrayList <String> getContinentList()
			{
					return this.continentList;
			}
		/**
    *  @return ArrayList of Cards held by Player in their Hand
  	**/
			public RiskCardHand getHand()
			{
					return this.hand;
			}

		/**
		*  Adds a territory to the list of Player's occupied territories
    *  @param newTerritory: ref to the Territory object to be added to the list of Player's occupied territories
  	**/
			public void addTerritory(Territory newTerritory)
			{
					this.territories.add(newTerritory);
					this.territoryList.add( newTerritory.getName() );
					setChanged();
					notifyObservers();
			}

		/**
		*  removes a territory from the list of Player's occupied territories, when Player is defeated in battle
    *  @param territory: ref to the Territory object to be removed to the list of Player's occupied territories

  	**/
	public void removeTerritory(Territory territory)
	{
			this.territories.remove(territory);
			this.territoryList.remove(territory.getName() );
			setChanged();
			notifyObservers();
	}

	//to see who goes first, used with class comparable
	public void setFirstRoll(int roll)
	{
			this.firstRoll = roll;
	}
	
		/**
		*  Adds a continent to the list of Player's occupied continents
    *  @param continent: ref to the Continent object to be added to the list of Player's occupied continents
  	**/		
			public void addContinent(Continent newContinent)
			{
					this.continents.add( newContinent );
					this.continentList.add( newContinent.getName() );
					setChanged();
					notifyObservers();
			}		
		/**
		*  removes a continent from the list of Player's occupied continents, when Player is defeated in battle, 
    *  @param continent: ref to the continent object to be removed to the list of Player's occupied continents

  	**/
	public void removeContinent(Continent continent)
			{
					this.continents.remove(continent);
					this.continentList.remove( continent.getName() );
					setChanged();
					notifyObservers();
			}		
		/**
		*  @return number of armies Player has to place on board
  	**/
			public int getTotalArmies()
			{
					return this.totalArmies;
			}

		/**
		*returns true if player has any armies to place on the board for initializing the territories
		*returns false if player is out of armies
		**/
			public boolean hasArmies()
			{
					if (this.getTotalArmies() == 0) 
					{
					return false;
					} else return true;
			}

		/**
		*returns true if player has enough armies to attack
		*returns false if player lacks more than 1 army in a single territory
		**/
			public boolean hasEnoughArmies()
			{
					
					for (Territory t: territories)
					{		
							if (t.getNumArmies() > 1)
							{
							return true;
							} 
					}
					return false;
			}

					//sets additional armies based on number of territories and continents this player occupies
			public void setAdditionalArmies ()
			{
				if (numTerritories > 9)
				{
					this.additionalArmies = this.numTerritories/3;
				} else {
					this.additionalArmies = 3;
				}

				if ( continentList.contains("North America") )
				{
					this.additionalArmies = this.additionalArmies + 5;
				}

				if ( continentList.contains("South America") )
				{
					this.additionalArmies = this.additionalArmies + 2;
				}

				if ( continentList.contains("Europe") )
				{
					this.additionalArmies = this.additionalArmies + 5;
				}

				if ( continentList.contains("Africa") )
				{
					this.additionalArmies = this.additionalArmies + 3;
				}

				if ( continentList.contains("Asia") )
				{
					this.additionalArmies = this.additionalArmies + 7;
				}

				if ( continentList.contains("Australia") )
				{
					this.additionalArmies = this.additionalArmies + 2;
				}
			}
		/**
		*  @return number of additional armies Player has to place on board
  	**/
			public int getAdditionalArmies()
			{
					return this.additionalArmies;
			}

		/**
		*  @return true if player has additional armies to place
  	**/
			public boolean hasAddArmies()
			{
					if (this.getAdditionalArmies() == 0) 
					{
					return false;
					} else return true;
			}
		/**
		*  Increases the number of armies to be placed on the board by Player
    *  @param newArmies: ref to the number of armies Player received at the beginning of the turn
  	**/
			public void addArmies(int newArmies)
			{
					this.totalArmies = this.totalArmies + newArmies;
					setChanged();
					notifyObservers();
			}

		//deploys an army when initializing a territory
			public void deployArmy()
			{
					this.totalArmies --;
					setChanged();
					notifyObservers();
			}

			//deploys any additional armies earned turing player turn
			public void deployAddArmy()
			{
				this.additionalArmies --;
				setChanged();
				notifyObservers();
			}

		/**
		*  Used to give Player's Hand a new Card
    *  @param newCard: ref to the Card object to be given to Player
  	**/
			public void addRiskCard(RiskCard newCard)
			{
					this.hand.acceptCard(newCard);
					setChanged();
					notifyObservers();
			}

		/**
		*  Initiates attack from Player
    *  @param attacker: reference to the attacking Territory object
    *  @param defender: reference to the defending Territory object
    *  @param numAttackingArmies: an integer representing the number of attacking armies
  	**/
			public String attack(String attackingTerritory, String defendingTerritory, int numAttackDice) 
			{
					this.numAttackDice = numAttackDice;
					String attackPrompt = this.name  + " is attacking " + defendingTerritory + " from " + attackingTerritory;
					return attackPrompt;
			}

			//sets to true if this player conquered a territory during their turn
			public void setConqueredNewTerrVar()
			{
					if (getConqueredTerrVar() == false)
					{
							this.conqueredNewTerritory = true;
							setChanged();
							notifyObservers();
							return;
					}
					
					if (getConqueredTerrVar() == true)
					{
							this.conqueredNewTerritory = false;
							setChanged();
							notifyObservers();
							return;
					}
				
			}

			//returns conqueredNewTerritory
			public boolean getConqueredTerrVar()
			{
					return conqueredNewTerritory;
			}
  } //  end Player
