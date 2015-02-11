/**
  * Risk Classes
  * Scott Robertson
  **/
//package Risk;

/**
 * RiskCard Class
 * Specifies cards
 * 
 **/
  public class RiskCard  {   //maps?

  		private String type;  
  		private String country;

  		public RiskCard (String country, String type)
  		{

  				this.country = country;
  				this.type = type;  				
  		}
  
		/**
    *  @return type (infantry, cavalry, artillery, wild) of this card as String
  	**/
  		 public String getName()
  		 {
					return country + " " + type;
  		 }
			 public String getType()
			 {
			 		return this.type;
			 }

		/**
    *  @return ref to the territory object associtated to the RiskCard
  	**/
			 public String getCountry()
			 {
			 		return this.country;
			 }


  } //end RiskCard
