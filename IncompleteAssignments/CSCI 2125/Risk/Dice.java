/**
  * Risk Classes
  * Scott Robertson
  **/

import java.util.ArrayList;
import java.lang.Math;

/**
 * Dice
 * Specifies dice used to resolve battles
 * Dice objects will be contained in Game objects
 **/
  public class Dice {  //rename to battle?
				private int diceValue;


		/*
    *  @param attackDice: an integer representing number of dice used in attack (1-3)
    *  @param defendDice: an integer representing number of dice used in defense (1-2)
		*/
				public Dice ()
				{
					this.diceValue = 0;

				}

		/**
    *  Simulates dice-roll)
    *  @return an integer array with the results of the rolls
  	**/
			 public int roll()
			 {
						return (int)(Math.random()* 6 + 1);
			 }


  } //end Dice
