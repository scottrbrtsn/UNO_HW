import java.util.ArrayList;
//package Risk;
/**
  * Risk Classes
  * Scott Robertson
  **/

/**
 * Continent
 * Specifies continents on the board
 * Continent objects will be contained in GameBoard objects
 **/
  public class Continent  
  {

				private String name;
				private Player occupant;
				private ArrayList<Territory> territories;
				private int bonusArmies;


				public Continent (String name, int bonusArmies) 
				{
						this.name = name;
						this.occupant = null;
						this.territories = null;
						this.bonusArmies = bonusArmies;
				}

			/**
			*  @param occupant ref the player object who occupies all territories in the continent
			**/
			 public void setTerritories(ArrayList<Territory> territories)
					{
						 this.territories = territories;
					}				
  	/**
    *  @return ArrayList of territories contained within the continent object
  	**/
			 public ArrayList<Territory> getTerritories()
					{
						  return this.territories; 
					}
		/**
    *  @return name of continent as a String
  	**/
				 public String getName()
					{
						  return this.name;
					}
		/**
		*  @param occupant ref the player object who occupies all territories in the continent
  	**/
				public void setOccupant( Player player )
						{
								this.occupant = player;
						}
		/**
    *  @return reference continent's occupant (player object)
    *		Return null if no player occupies all territories in each continent
    **/
					public Player getOccupant()
						{
								return this.occupant;
						}
		/**
		*  Sets the number of bonus armies given when player controls all territories in the continent
		*  @param occupant ref the player object who occupies all territories in the continent

  	**/
					public void setBonusArmies( int bonusArmies )
						{
								this.bonusArmies = bonusArmies;
						}	

		/**
    *  @return number of additional armies given to player as a result of
    *  occupying this continent
  	**/
			 public int getBonusArmies()
			 {
					return this.bonusArmies;

			 }
			 
		/**
    *  @return true if all territories occupied by single player
  	**/


		  public boolean isOccupied() {
			
					if (this.name == null)
					{
						return false;
					}else {
					return true;
					}
					
		  }
			
  } //end Continent
