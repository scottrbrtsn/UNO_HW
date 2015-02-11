//package Risk;


public class Game{

			private GameBoard board;

			private RiskCardDeck deck;
		
	/**
	* Sets up the GameBoard by populating, territories, 
	* neighbors for each territory, and then continents
	*
	* also sets up the Deck
	**/
		
		public Game()
		{
			this.board = new GameBoard();
			this.deck = new RiskCardDeck();
			//Add Territories to Continents
		}//end constructor



			//set up riskcards 
			//add riskcards to deck
		
		public GameBoard getGameBoard()
		{
				return this.board;
		}

	public void newGame(int numPlayers)
		{
			System.out.println ("Set up your territories");

			
		}//endNewGame
		
	//public void saveGame   i.e. fileOut
	//public void loadGame   i.e. fileIn
	//public void quit       i.e. exit game


}//end game
