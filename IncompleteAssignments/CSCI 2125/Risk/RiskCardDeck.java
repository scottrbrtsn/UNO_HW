/**
  * Risk Classes
  * Scott Robertson
  **/
  //package Risk;
  import java.util.LinkedList;
  import java.util.Collections;
/**
 * RiskCardDeck
 * Specifies deck of Risk game cards
 * RiskCardDeck objects will be contained in Game objects
 **/
  public class RiskCardDeck 
  {
  
  				private LinkedList <RiskCard> deck; //change to LinkedList  addLast, getFirst methods for deck implementation
					private RiskCard alaskaRC;
					private RiskCard albertaRC;
					private RiskCard centralAmericaRC;
					private RiskCard easternUnitedStatesRC;
					private RiskCard greenlandRC;
					private RiskCard northwestTerritoryRC;
					private RiskCard ontarioRC;
					private RiskCard quebecRC;
					private RiskCard westernUnitedStatesRC;
						//SouthAmerica (2)  //3 territories
					private RiskCard argentinaRC;
					private RiskCard brazilRC;
					private RiskCard venezuelaRC;
						//Europe (5)   //7 territories
					private RiskCard greatBritainRC;
					private RiskCard icelandRC;
					private RiskCard northernEuropeRC;
					private RiskCard scandinaviaRC;
					private RiskCard southernEuropeRC;
					private RiskCard ukraineRC;
					private RiskCard westernEuropeRC;
						//Africa (3)  //6 territories
					private RiskCard congoRC;
					private RiskCard eastAfricaRC;
					private RiskCard egyptRC;
					private RiskCard madagascarRC;
					private RiskCard northAfricaRC;
					private RiskCard southAfricaRC;
						//Asia (7)  //11 territories
					private RiskCard afghanistanRC;
					private RiskCard chinaRC;
					private RiskCard indiaRC;
					private RiskCard irkutskRC;
					private RiskCard japanRC;
					private RiskCard kamchatkaRC;
					private RiskCard middleEastRC;
					private RiskCard mongoliaRC;
					private RiskCard siamRC;
					private RiskCard siberiaRC;
					private RiskCard uralRC;
					private RiskCard yakutskRC;
						//Australia (2)  //4 territories
					private RiskCard easternAustraliaRC;
					private RiskCard indonesiaRC;
					private RiskCard newGuineaRC;
					private RiskCard westernAustraliaRC;

  		public RiskCardDeck ()
  		{	
  		//initialize cards
  				this.deck = new LinkedList <RiskCard>();
					alaskaRC = new RiskCard("Alaska", "Infantry");
					albertaRC = new RiskCard("Alberta", "Cavalry");
					centralAmericaRC= new RiskCard("Central America", "Artillery");
					easternUnitedStatesRC = new RiskCard("Eastern United States", "Infantry");
					greenlandRC = new RiskCard("Greenland", "Cavalry");
					northwestTerritoryRC = new RiskCard("Northwest Territory", "Artillery");
					ontarioRC = new RiskCard("Ontario", "Infantry");
					quebecRC = new RiskCard("Quebec", "Cavalry");
					westernUnitedStatesRC = new RiskCard("Western United States", "Artillery");
						//SouthAmerica (2)  //3 territories
					argentinaRC = new RiskCard("Argentina", "Infantry");
					brazilRC = new RiskCard("Brazil", "Cavalry");
					venezuelaRC = new RiskCard("Venezuela", "Artillery");
						//Europe (5)   //7 territories
					greatBritainRC = new RiskCard("Great Britain", "Infantry");
					icelandRC = new RiskCard("Iceland", "Cavalry");
					northernEuropeRC = new RiskCard("Northern Europe", "Artillery");
					scandinaviaRC = new RiskCard("Scandinavia", "Infantry");
					southernEuropeRC = new RiskCard("Southern Europe", "Cavalry");
					ukraineRC = new RiskCard("Ukraine", "Artillery");
					westernEuropeRC = new RiskCard("Western Europe", "Infantry");
						//Africa (3)  //6 territories
					congoRC = new RiskCard("Congo", "Cavalry");
					eastAfricaRC = new RiskCard("East Africa", "Artillery");
					egyptRC = new RiskCard("Alberta", "Infantry");
					madagascarRC = new RiskCard("Madagascar", "Cavalry");
					northAfricaRC = new RiskCard("North Africa", "Artillery");
					southAfricaRC = new RiskCard("South Africa", "Infantry");
						//Asia (7)  //11 territories
					afghanistanRC = new RiskCard("Afghanistan", "Cavalry");
					chinaRC = new RiskCard("China", "Artillery");
					indiaRC = new RiskCard("India", "Infantry");
					irkutskRC = new RiskCard("Irkutsk", "Cavalry");
					japanRC = new RiskCard("Japan", "Artillery");
					kamchatkaRC = new RiskCard("Kamchatka", "Infantry");
					middleEastRC = new RiskCard("Middle East", "Cavalry");
					mongoliaRC = new RiskCard("Mongolia", "Artillery");
					siamRC = new RiskCard("Siam", "Infantry");
					siberiaRC = new RiskCard("Siberia", "Cavalry");
					uralRC = new RiskCard("Ural", "Artillery");
					yakutskRC = new RiskCard("Yakutsk", "Infantry");
						//Australia (2)  //4 territories
					easternAustraliaRC = new RiskCard("Eastern Australia", "Cavalry");
					indonesiaRC = new RiskCard("Indonesia", "Artillery");
					newGuineaRC = new RiskCard("New Guinea", "Infantry");
					westernAustraliaRC = new RiskCard("Western Australia", "Cavalry");

					//add cards to deck

					deck.add(alaskaRC);
					deck.add(albertaRC);
					deck.add(centralAmericaRC);
					deck.add(easternUnitedStatesRC);
					deck.add(greenlandRC);
					deck.add(northwestTerritoryRC);
					deck.add(ontarioRC);
					deck.add(quebecRC);
					deck.add(westernUnitedStatesRC);
						//SouthAmerica (2)  //3 territories
					deck.add(argentinaRC);
					deck.add(brazilRC);
					deck.add(venezuelaRC);
						//Europe (5)   //7 territories
					deck.add(greatBritainRC);
					deck.add(icelandRC);
					deck.add(northernEuropeRC);
					deck.add(scandinaviaRC);
					deck.add(southernEuropeRC);
					deck.add(ukraineRC);
					deck.add(westernEuropeRC);
						//Africa (3)  //6 territories
					deck.add(congoRC);
					deck.add(eastAfricaRC);
					deck.add(egyptRC);
					deck.add(madagascarRC);
					deck.add(northAfricaRC);
					deck.add(southAfricaRC);
						//Asia (7)  //11 territories
					deck.add(afghanistanRC);
					deck.add(chinaRC);
					deck.add(indiaRC);
					deck.add(irkutskRC);
					deck.add(japanRC);
					deck.add(kamchatkaRC);
					deck.add(middleEastRC);
					deck.add(mongoliaRC);
					deck.add(siamRC);
					deck.add(siberiaRC);
					deck.add(uralRC);
					deck.add(yakutskRC);
						//Australia (2)  //4 territories
					deck.add(easternAustraliaRC);
					deck.add(indonesiaRC);
					deck.add(newGuineaRC);
					deck.add(westernAustraliaRC);

					shuffle();
  		}

  	/**
  	*  deals a single card to be given to a player
    *  @return Card from the top of the deck
  	**/
			public RiskCard dealCard()
			{
					RiskCard card = this.deck.getFirst(); 
					this.deck.remove(card);
			 		return card;
			}

		/**
    * Shuffles deck
  	**/
			 public void shuffle()
			 {
			 		Collections.shuffle(deck);
			 }
			 
		/**
    *  @param set an ArrayList of cards turned in by player to bottom of deck
  	**/
			 public void acceptCards(RiskCard [] set)
			 { 
						
			 		for (RiskCard card : set)
			 		{
							this.deck.addLast(card); //add to the bottom of the deck
			 		}
			 }

		/**
    *  @return true if deck has cards
  	**/
			public boolean hasCards()
			{
			if (deck == null)
				{
						return false;
				} else 
				{
						return true;
				}
			}
			
  }// end RiskCardDeck
