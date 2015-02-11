/**
  * Risk Classes
  * Scott Robertson
  **/
 // package Risk;
import java.util.ArrayList;

/**
 *  RiskCardHand specifies the player's Hand
 *  contained by Player objects
 **/
 public class RiskCardHand  
 {
 				private ArrayList <RiskCard> hand;
 				private ArrayList <String> names;
 		public RiskCardHand ()
 		{
 				this.hand = new ArrayList <RiskCard> ();
				this.names = new ArrayList <String> ();
 		}

  	/**
    *  Add a card to the Player's hand
    *  @param newCard the new Card added to player.hand
  	**/
			public void acceptCard(RiskCard newCard)
			{
					this.hand.add(newCard);
					setNames();
			}

		/**
    *  @return cards in Player's hand
  	**/
			public ArrayList <RiskCard> getCards()
			{
					return this.hand;
			}

			private void setNames()
			{
						String name;
						for (RiskCard card : hand)
						{
								name = card.getName();
								names.add(name);
						}
			}

			public ArrayList<String> getNames()
			{
						return names;
			}

		/**
		*  Removes a set of cards from the Player's Hand
		*  @param set: an array of integers indicating the indices of the cards to turn in
  	**/
  		public RiskCard[] turnInCards (RiskCard [] set)  //must accept cards from deck class in main method
  		{
				this.hand.remove(set);
				return set;
  		}
			
  }  //end RiskCardHand
