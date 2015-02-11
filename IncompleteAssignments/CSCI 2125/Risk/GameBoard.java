/**
  * Risk Classes
  * GameBoard Class
  * Specifies the game board
  * GameBoard objects will be contained in Game objects
  * Scott Robertson
  **/

//package Risk;
import java.util.ArrayList;
import java.util.HashMap;

  public class GameBoard  {
  
					private HashMap <String, Territory> territories; 
					private HashMap <String, Continent> continents; 
					private ArrayList <String> territoriesList;  
					private ArrayList <String> continentsList;  
					/**
					* Start by setting up territory objects
					**/
						//NorthAmerica (5)//9 territories
					private Territory alaska;
					private Territory alberta;
					private Territory centralAmerica;
					private Territory easternUnitedStates;
					private Territory greenland;
					private Territory northwestTerritory;
					private Territory ontario;
					private Territory quebec;
					private Territory westernUnitedStates;
						//SouthAmerica (2)  //3 territories
					private Territory argentina;
					private Territory brazil;
					private Territory venezuela;
						//Europe (5)   //7 territories
					private Territory greatBritain;
					private Territory iceland;
					private Territory northernEurope;
					private Territory scandinavia;
					private Territory southernEurope;
					private Territory ukraine;
					private Territory westernEurope;
						//Africa (3)  //6 territories
					private Territory congo;
					private Territory eastAfrica;
					private Territory egypt;
					private Territory madagascar;
					private Territory northAfrica;
					private Territory southAfrica;
						//Asia (7)  //12 territories
					private Territory afghanistan;
					private Territory china;
					private Territory india;
					private Territory irkutsk;
					private Territory japan;
					private Territory kamchatka;
					private Territory middleEast;
					private Territory mongolia;
					private Territory siam ;
					private Territory siberia;
					private Territory ural;
					private Territory yakutsk;
						//Australia (2)  //4 territories
					private Territory easternAustralia;
					private Territory indonesia;
					private Territory newGuinea;
					private Territory westernAustralia;
					private Territory lotR;
				/**
				 * Set up continents
				 **/
					private Continent northAmerica;
					private Continent southAmerica;
					private Continent europe;
					private Continent africa;
					private Continent asia;
					private Continent australia;

					private ArrayList <Territory> northAmericaList;
					private ArrayList <Territory> southAmericaList;
					private ArrayList <Territory> europeList;
					private ArrayList <Territory> africaList;
					private ArrayList <Territory> asiaList;
					private ArrayList <Territory> australiaList;
					
			public GameBoard()
			{
					this.territories = new HashMap <String, Territory> ();
					this.continents = new HashMap <String, Continent> ();
					this.territoriesList = new ArrayList <String> ();
					this.continentsList = new ArrayList <String> ();
				/**
				* Start by setting up territory objects
				*/
					//NorthAmerica (5)
					this.alaska = new Territory("Alaska");
					this.alberta = new Territory("Alberta");
					this.centralAmerica = new Territory("Central America");
					this.easternUnitedStates = new Territory("Eastern United States");
					this.greenland = new Territory("Greenland");
					this.northwestTerritory = new Territory("Northwest Territory");
					this.ontario = new Territory("Ontario");
					this.quebec = new Territory("Quebec");
					this.westernUnitedStates = new Territory("Western United States");
						//SouthAmerica (2)
					this.argentina = new Territory("Argentina");
					this.brazil = new Territory("Brazil");
					this.venezuela = new Territory("Venezuela");
						//Europe (5)
					this.greatBritain = new Territory("Great Britain");
					this.iceland = new Territory("Iceland");
					this.northernEurope = new Territory("Northern Europe");
					this.scandinavia = new Territory("Scandinavia");
					this.southernEurope = new Territory("Southern Europe");
					this.ukraine = new Territory("Ukraine");
					this.westernEurope = new Territory("Western Europe");
						//Africa (3)
					this.congo = new Territory("Congo");
					this.eastAfrica = new Territory("East Africa");
					this.egypt = new Territory("Egypt");
					this.madagascar = new Territory("Madagascar");
					this.northAfrica = new Territory("North Africa");
					this.southAfrica = new Territory("South Africa");
						//Asia (7)
					this.afghanistan = new Territory("Afghanistan");
					this.china = new Territory("China");
					this.india = new Territory("India");
					this.irkutsk = new Territory("Irkutsk");
					this.japan = new Territory("Japan");
					this.kamchatka = new Territory("Kamchatka");
					this.middleEast = new Territory("Middle East");
					this.mongolia = new Territory("Mongolia");
					this.siam = new Territory("Siam");
					this.siberia = new Territory("Siberia");
					this.ural = new Territory("Ural");
					this.yakutsk = new Territory("Yakutsk");
						//Australia (2)
					this.easternAustralia = new Territory("Eastern Australia");
					this.indonesia = new Territory("Indonesia");
					this.newGuinea = new Territory("New Guinea");
					this.westernAustralia = new Territory("Western Australia");			
					this.lotR = new Territory("Lot R");			
				/**
				 * Continue by adding territories to the game board
				 **/
						//NorthAmerica
					addTerritory(this.alaska.getName(), this.alaska);
					addTerritory(this.alberta.getName(), this.alberta);
					addTerritory(this.centralAmerica.getName(), this.centralAmerica);
					addTerritory(this.easternUnitedStates.getName(), this.easternUnitedStates);
					addTerritory(this.greenland.getName(), this.greenland);
					addTerritory(this.northwestTerritory.getName(), this.northwestTerritory);
					addTerritory(this.ontario.getName(), this.ontario);
					addTerritory(this.quebec.getName(), this.quebec);
					addTerritory(this.westernUnitedStates.getName(), this.westernUnitedStates);
						//South America
					addTerritory(this.argentina.getName(), this.argentina);
					addTerritory(this.brazil.getName(), this.brazil);
					addTerritory(this.venezuela.getName(), this.venezuela);
						//Europe (5)
					addTerritory(this.greatBritain.getName(), this.greatBritain);
					addTerritory(this.iceland.getName(), this.iceland);
					addTerritory(this.northernEurope.getName(), this.northernEurope);
					addTerritory(this.scandinavia.getName(), this.scandinavia);
					addTerritory(this.southernEurope.getName(), this.southernEurope);
					addTerritory(this.ukraine.getName(), this.ukraine);
					addTerritory(this.westernEurope.getName(), this.westernEurope);
						//Africa (3)
					addTerritory(this.congo.getName(), this.congo);
					addTerritory(this.eastAfrica.getName(), this.eastAfrica);
					addTerritory(this.egypt.getName(), this.egypt);
					addTerritory(this.madagascar.getName(), this.madagascar);
					addTerritory(this.northAfrica.getName(), this.northAfrica);
					addTerritory(this.southAfrica.getName(), this.southAfrica);
						//Asia (7)
					addTerritory(this.afghanistan.getName(), this.afghanistan);
					addTerritory(this.china.getName(), this.china);
					addTerritory(this.india.getName(), this.india);
					addTerritory(this.irkutsk.getName(), this.irkutsk);
					addTerritory(this.japan.getName(), this.japan);
					addTerritory(this.kamchatka.getName(), this.kamchatka);
					addTerritory(this.middleEast.getName(), this.middleEast);
					addTerritory(this.mongolia.getName(), this.mongolia);
					addTerritory(this.siam.getName(), this.siam);
					addTerritory(this.siberia.getName(), this.siberia);
					addTerritory(this.ural.getName(), this.ural);
					addTerritory(this.yakutsk.getName(), this.yakutsk);
						//Australia (2)
					addTerritory(this.easternAustralia.getName(), this.easternAustralia);
					addTerritory(this.indonesia.getName(), this.indonesia);
					addTerritory(this.newGuinea.getName(), this.newGuinea);
					addTerritory(this.westernAustralia.getName(), this.westernAustralia);
					addTerritory(this.lotR.getName(), this.lotR);
				/**
				 * Set up each territory's neighbors
				 **/
						//NorthAmerica (5)
					ArrayList<String> alaskaNeighbors = new ArrayList<String>();
					alaskaNeighbors.add("Northwest Territory");
					alaskaNeighbors.add("Kamchatka");
					alaskaNeighbors.add("Alberta");
					this.alaska.setNeighbors (alaskaNeighbors);

					ArrayList<String> albertaNeighbors = new ArrayList<String>();
					albertaNeighbors.add("Alaska");
					albertaNeighbors.add("Northwest Territory");
					albertaNeighbors.add("Ontario");
					albertaNeighbors.add("Western United States");
					this.alberta.setNeighbors (albertaNeighbors);

					ArrayList<String> centralAmericaNeighbors = new ArrayList<String>();
					centralAmericaNeighbors.add("Western United States");
					centralAmericaNeighbors.add("Eastern United States");
					centralAmericaNeighbors.add("Venezuela");
					this.centralAmerica.setNeighbors (centralAmericaNeighbors);
					
					ArrayList<String> easternUnitedStatesNeighbors = new ArrayList<String>();
					easternUnitedStatesNeighbors.add("Western United States");
					easternUnitedStatesNeighbors.add("Ontario");
					easternUnitedStatesNeighbors.add("Quebec");
					easternUnitedStatesNeighbors.add("Central America");
					this.easternUnitedStates.setNeighbors(easternUnitedStatesNeighbors);
					
					ArrayList<String> greenlandNeighbors = new ArrayList<String>();
					greenlandNeighbors.add("Northwest Territory");
					greenlandNeighbors.add("Ontario");
					greenlandNeighbors.add("Quebec");
					greenlandNeighbors.add("Iceland");
					this.greenland.setNeighbors (greenlandNeighbors);

					
					ArrayList<String> northwestTerritoryNeighbors = new ArrayList<String>();
					northwestTerritoryNeighbors.add("Alaska");
					northwestTerritoryNeighbors.add("Alberta");
					northwestTerritoryNeighbors.add("Quebec");
					northwestTerritoryNeighbors.add("Greenland");
					this.northwestTerritory.setNeighbors (northwestTerritoryNeighbors);
					
					ArrayList<String> ontarioNeighbors = new ArrayList<String>();
					ontarioNeighbors.add("Quebec");
					ontarioNeighbors.add("Greenland");
					ontarioNeighbors.add("Northwest Territory");
					ontarioNeighbors.add("Alberta");
					ontarioNeighbors.add("Eastern United States");
					ontarioNeighbors.add("Western United States");					
					this.ontario.setNeighbors (ontarioNeighbors);
					
					ArrayList<String> quebecNeighbors = new ArrayList<String>();
					quebecNeighbors.add("Greenland");
					quebecNeighbors.add("Ontario");
					quebecNeighbors.add("Eastern United States");
					this.quebec.setNeighbors (quebecNeighbors);
					
					ArrayList<String> westernUnitedStatesNeighbors = new ArrayList<String>();
					westernUnitedStatesNeighbors.add("Eastern United States");
					westernUnitedStatesNeighbors.add("Alberta");
					westernUnitedStatesNeighbors.add("Ontario");
					westernUnitedStatesNeighbors.add("CentralAmerica");
					this.westernUnitedStates.setNeighbors(westernUnitedStatesNeighbors);
					
						//SouthAmerica (2)
					ArrayList<String> argentinaNeighbors = new ArrayList<String>();
					argentinaNeighbors.add("Venezuela");
					argentinaNeighbors.add("Brazil");
					this.argentina.setNeighbors (argentinaNeighbors);
					
					ArrayList<String> brazilNeighbors = new ArrayList<String>();
					brazilNeighbors.add("Venezuela");
					brazilNeighbors.add("Argentina");
					brazilNeighbors.add("North Africa");
					this.brazil.setNeighbors (brazilNeighbors);
					
					ArrayList<String> venezuelaNeighbors = new ArrayList<String>();
					venezuelaNeighbors.add("Central America");
					venezuelaNeighbors.add("Brazil");
					venezuelaNeighbors.add("Argentina");
					this.venezuela.setNeighbors (venezuelaNeighbors);
						//Europe (5)
					ArrayList<String> greatBritainNeighbors = new ArrayList<String>();
					greatBritainNeighbors.add("Iceland");
					greatBritainNeighbors.add("Western Europe");
					greatBritainNeighbors.add("Scandinavia");
					greatBritainNeighbors.add("Northern Europe");
					this.greatBritain.setNeighbors (greatBritainNeighbors);
					
					ArrayList<String> icelandNeighbors = new ArrayList<String>();
					icelandNeighbors.add("Greenland");
					icelandNeighbors.add("Great Britain");
					icelandNeighbors.add("Scandinavia");
					this.iceland.setNeighbors (icelandNeighbors);
					
					ArrayList<String> northernEuropeNeighbors = new ArrayList<String>();
					northernEuropeNeighbors.add("Great Britain");
					northernEuropeNeighbors.add("Scandinavia");
					northernEuropeNeighbors.add("Western Europe");
					northernEuropeNeighbors.add("Southern Europe");
					northernEuropeNeighbors.add("Ukraine");
					this.northernEurope.setNeighbors (northernEuropeNeighbors);
					
					ArrayList<String> scandinaviaNeighbors = new ArrayList<String>();
					scandinaviaNeighbors.add("Great Britain");
					scandinaviaNeighbors.add("Iceland");
					scandinaviaNeighbors.add("Northern Europe");
					scandinaviaNeighbors.add("Ukraine");
					this.scandinavia.setNeighbors (scandinaviaNeighbors);
					
					ArrayList<String> southernEuropeNeighbors = new ArrayList<String>();
					southernEuropeNeighbors.add("Ukraine");
					southernEuropeNeighbors.add("Northern Europe");
					southernEuropeNeighbors.add("Western Europe");
					southernEuropeNeighbors.add("Egypt");
					southernEuropeNeighbors.add("North Africa");
					this.southernEurope.setNeighbors (southernEuropeNeighbors);
					
					ArrayList<String> ukraineNeighbors = new ArrayList<String>();
					ukraineNeighbors.add("Northern Europe");
					ukraineNeighbors.add("Southern Europe");
					ukraineNeighbors.add("Scandinavia");
					ukraineNeighbors.add("Afghanistan");
					ukraineNeighbors.add("Yakutsk");
					ukraineNeighbors.add("Middle East");					
					this.ukraine.setNeighbors (ukraineNeighbors);
					
					ArrayList<String> westernEuropeNeighbors = new ArrayList<String>();
					westernEuropeNeighbors.add("Great Britain");
					westernEuropeNeighbors.add("Northern Europe");
					westernEuropeNeighbors.add("Southern Europe");
					westernEuropeNeighbors.add("North Africa");
					this.westernEurope.setNeighbors (westernEuropeNeighbors);
						//Africa (3)
					ArrayList<String> 	congoNeighbors = new ArrayList<String>();
					congoNeighbors.add("North Africa");
					congoNeighbors.add("East Africa");
					congoNeighbors.add("South Africa");
					congoNeighbors.add("Egypt");
					this.congo.setNeighbors (congoNeighbors);
					
					ArrayList<String>	eastAfricaNeighbors = new ArrayList<String>();
					eastAfricaNeighbors.add("Egypt");
					eastAfricaNeighbors.add("Middle East");
					eastAfricaNeighbors.add("Congo");
					eastAfricaNeighbors.add("South Africa");
					eastAfricaNeighbors.add("Madagascar");
					this.eastAfrica.setNeighbors (eastAfricaNeighbors);
					
					ArrayList<String>	egyptNeighbors = new ArrayList<String>();
					egyptNeighbors.add("North Africa");
					egyptNeighbors.add("Southern Europe");
					egyptNeighbors.add("Middle East");
					egyptNeighbors.add("East Africa");
					this.egypt.setNeighbors (egyptNeighbors);
					
					ArrayList<String>	madagascarNeighbors = new ArrayList<String>();
					madagascarNeighbors.add("East Africa");
					madagascarNeighbors.add("South Africa");
					this.madagascar.setNeighbors (madagascarNeighbors);
					
					ArrayList<String> 	northAfricaNeighbors = new ArrayList<String>();
					northAfricaNeighbors.add("Egypt");
					northAfricaNeighbors.add("Western Europe");
					northAfricaNeighbors.add("Southern Europe");
					northAfricaNeighbors.add("Congo");			
					northAfricaNeighbors.add("East Africa");
					this.northAfrica.setNeighbors (northAfricaNeighbors);
					
					ArrayList<String> 	southAfricaNeighbors = new ArrayList<String>();
					southAfricaNeighbors.add("Congo");
					southAfricaNeighbors.add("East Africa");
					southAfricaNeighbors.add("Madagascar");
					this.southAfrica.setNeighbors (southAfricaNeighbors);
						//Asia (7)
						
					ArrayList<String> 	afghanistanNeighbors = new ArrayList<String>();
					afghanistanNeighbors.add("Ukraine");
					afghanistanNeighbors.add("Middle East");
					afghanistanNeighbors.add("China");
					afghanistanNeighbors.add("India");			
					afghanistanNeighbors.add("Ural");
					this.afghanistan.setNeighbors (afghanistanNeighbors);
					
					ArrayList<String> 	chinaNeighbors = new ArrayList<String>();
					chinaNeighbors.add("Mongolia");
					chinaNeighbors.add("Afghanistan");
					chinaNeighbors.add("Ural");
					chinaNeighbors.add("India");			
					chinaNeighbors.add("Siam");
					chinaNeighbors.add("Siberia");
					this.china.setNeighbors (chinaNeighbors);
					
					ArrayList<String>	indiaNeighbors = new ArrayList<String>();
					indiaNeighbors.add("Siam");
					indiaNeighbors.add("Middle East");
					indiaNeighbors.add("Afghanistan");
					indiaNeighbors.add("China");
					this.india.setNeighbors (indiaNeighbors);
					
					ArrayList<String>	irkutskNeighbors = new ArrayList<String>();
					irkutskNeighbors.add("Mongolia");
					irkutskNeighbors.add("Siberia");
					irkutskNeighbors.add("Kamchatka");
					irkutskNeighbors.add("Yakutsk");
					this.irkutsk.setNeighbors (irkutskNeighbors);
					
					ArrayList<String>	japanNeighbors = new ArrayList<String>();
					japanNeighbors.add("Mongolia");
					japanNeighbors.add("Irkutsk");
					this.japan.setNeighbors (japanNeighbors);

					ArrayList<String> 	kamchatkaNeighbors = new ArrayList<String>();
					kamchatkaNeighbors.add("Japan");
					kamchatkaNeighbors.add("Irkutsk");
					kamchatkaNeighbors.add("Yakutsk");
					kamchatkaNeighbors.add("Alaska");
					this.kamchatka.setNeighbors (kamchatkaNeighbors);
					
					ArrayList<String>	middleEastNeighbors = new ArrayList<String>();
					middleEastNeighbors.add("Ukraine");
					middleEastNeighbors.add("Egypt");
					middleEastNeighbors.add("Southern Europe");			
					middleEastNeighbors.add("Afghanistan");
					middleEastNeighbors.add("India");
					this.middleEast.setNeighbors (middleEastNeighbors);
					
					ArrayList<String> 	mongoliaNeighbors = new ArrayList<String>();
					mongoliaNeighbors.add("China");
					mongoliaNeighbors.add("Kamchatka");
					mongoliaNeighbors.add("Siberia");			
					mongoliaNeighbors.add("Japan");
					mongoliaNeighbors.add("Irkutsk");
					this.mongolia.setNeighbors (mongoliaNeighbors);
					
					ArrayList<String>	siamNeighbors =new ArrayList<String>();
					siamNeighbors.add("Indonesia");			
					siamNeighbors.add("India");
					siamNeighbors.add("China");
					this.siam.setNeighbors (siamNeighbors);
					
					ArrayList<String> 	siberiaNeighbors = new ArrayList<String>();
					siberiaNeighbors.add("Ural");
					siberiaNeighbors.add("Irkutsk");			
					siberiaNeighbors.add("Mongolia");
					siberiaNeighbors.add("Yakutsk");
					this.siberia.setNeighbors (siberiaNeighbors);
					
					ArrayList<String> 	uralNeighbors = new ArrayList<String>();
					uralNeighbors.add("Ukraine");
					uralNeighbors.add("Afghanistan");			
					uralNeighbors.add("Siberia");
					uralNeighbors.add("China");
					this.ural.setNeighbors (uralNeighbors);
					
					ArrayList<String>	yakutskNeighbors = new ArrayList<String>();
					yakutskNeighbors.add("Kamchatka");			
					yakutskNeighbors.add("Irkutsk");
					yakutskNeighbors.add("Siberia");
					this.yakutsk.setNeighbors (yakutskNeighbors);
					
						//Australia (2)
					ArrayList<String>	easternAustraliaNeighbors = new ArrayList<String>();
					easternAustraliaNeighbors.add("Western Australia");
					easternAustraliaNeighbors.add("New Guinea");
					this.easternAustralia.setNeighbors (easternAustraliaNeighbors);
					
					ArrayList<String> 	indonesiaNeighbors = new ArrayList<String>();
					indonesiaNeighbors.add("Siam");			
					indonesiaNeighbors.add("New Guinea");
					indonesiaNeighbors.add("Western Australia");
					this.indonesia.setNeighbors (indonesiaNeighbors);
					
					ArrayList<String> 	newGuineaNeighbors = new ArrayList<String>();
					newGuineaNeighbors.add("Indonesia");			
					newGuineaNeighbors.add("Western Australia");
					newGuineaNeighbors.add("Eastern Australia");
					this.newGuinea.setNeighbors (newGuineaNeighbors);
					
					ArrayList<String> 	westernAustraliaNeighbors = new ArrayList<String>();
					westernAustraliaNeighbors.add("Eastern Australia");			
					westernAustraliaNeighbors.add("New Guinea");
					westernAustraliaNeighbors.add("Indonesia");
					this.westernAustralia.setNeighbors (westernAustraliaNeighbors);

					ArrayList<String> 	lotRNeighbors = new ArrayList<String>();
					lotRNeighbors.add("Eastern Australia");			
					lotRNeighbors.add("New Guinea");
					lotRNeighbors.add("Indonesia");
					this.lotR.setNeighbors (lotRNeighbors);

					
			 	/**
				 * Set up continents
				 * 
				 **/
					this.northAmerica = new Continent ("North America", 5);
					this.southAmerica = new Continent ("South America", 2);
					this.europe = new Continent ("Europe", 5);
					this.africa = new Continent ("Africa", 3);
					this.asia = new Continent ("Asia", 7);
					this.australia = new Continent ("Australia", 2);
					/**
				 * Add Territories to Continents
				 **/
					 northAmericaList = new ArrayList <Territory>();
					 southAmericaList = new ArrayList <Territory>();
					 europeList = new ArrayList <Territory>();
					 africaList = new ArrayList <Territory>();
					 asiaList = new ArrayList <Territory>();
					 australiaList = new ArrayList <Territory>();

					 northAmericaList.add (alaska);
					 northAmericaList.add (alberta);
					 northAmericaList.add (centralAmerica);
					 northAmericaList.add (easternUnitedStates);
					 northAmericaList.add (greenland);
					 northAmericaList.add (northwestTerritory);
					 northAmericaList.add (ontario);
					 northAmericaList.add (quebec);
					 northAmericaList.add (westernUnitedStates);

					 southAmericaList.add (argentina);
					 southAmericaList.add (brazil);
					 southAmericaList.add (venezuela);

					 europeList.add (greatBritain);
					 europeList.add (iceland);
					 europeList.add (northernEurope);
					 europeList.add (scandinavia);
					 europeList.add (southernEurope);
					 europeList.add (ukraine);
					 europeList.add (westernEurope);

					 africaList.add (congo);
					 africaList.add (eastAfrica);
					 africaList.add (egypt);
					 africaList.add (madagascar);
					 africaList.add (northAfrica);
					 africaList.add (southAfrica);

					 asiaList.add (afghanistan);
					 asiaList.add (china);
					 asiaList.add (india);
					 asiaList.add (irkutsk);
					 asiaList.add (japan);
					 asiaList.add (kamchatka);
					 asiaList.add (middleEast);
					 asiaList.add (mongolia);
					 asiaList.add (siam);
					 asiaList.add (siberia);
					 asiaList.add (ural);
					 asiaList.add (yakutsk);

					 australiaList.add (easternAustralia);
					 australiaList.add (indonesia);
					 australiaList.add (newGuinea);
					 australiaList.add (westernAustralia);
					 australiaList.add (lotR);
			
				/**
				 * Add Continents to gameboard
				 **/
					addContinent(this.northAmerica.getName(), this.northAmerica);
					addContinent(this.southAmerica.getName(), this.southAmerica);
					addContinent(this.europe.getName(), this.europe);
					addContinent(this.africa.getName(), this.africa);
					addContinent(this.asia.getName(), this.asia);
					addContinent(this.australia.getName(), this.australia);
			}
 	/**
  	*  Returns the gameBoard's territories
  	*  @return ArrayList of Territory refs
  	**/
			public ArrayList <String> getTerritoriesList()
			{
					return this.territoriesList; 
			}
	/**
	*  Adds territory object to the HashMap
	*  @ param name of territory && territory object
	**/
			private void addTerritory (String name, Territory territory)
			{
					this.territories.put(name, territory);
					this.territoriesList.add(name);
			}
		/**
  	*  Returns the gameBoard's continents
  	*  @return ArrayList of Territory refs
  	**/
  		public ArrayList <String> getContinentsList()
  		{
  				return this.continentsList;
  		}

  	/**
  	*  Adds continent object to the HashMap
  	*  @ param name of continent && continent object
  	**/
  		public void addContinent(String name, Continent continent)
  		{
					this.continents.put(name, continent);
					this.continentsList.add(name);
  		}

  	/**
  	*  Retrieves territory object by name
  	*  @param the String containing the name of territory to get
    *  @return a reference to the territory object
  	**/

			public Territory getTerritoryByName(String name)
			{
					
					return this.territories.get(name);  
			}

		/**
  	*  Retrieves continent object by name
  	*  @param the String containing the name of continent to get
    *  @return a reference to the continent object
  	**/
			
			public Continent getContinentByName(String name)
			{
					return this.continents.get(name);  //incomplete
			}

  } //end GameBoard
