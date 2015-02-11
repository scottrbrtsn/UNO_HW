/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  Battle Class
*  Cycles through wartime behavior
*  Sets territories, number of dice,  returns results
*  Battles will be contained in Risk Game Model objects
*
**/
import java.util.ArrayList;
import java.lang.Math;

  public class Battle {  //rename to battle?
				private Dice dice;
				private ArrayList <Integer> attackRolls;
				private ArrayList <Integer> defendRolls;
				private Territory attacker;
				private Territory defender;
				private Territory loser;
				private Territory winner;
				private Player atkPlayer;
				private Player defPlayer;
				private RiskGameModel myModel;
				private int atkDice;
				private int defDice;
				
				public Battle (RiskGameModel model)
				{
					myModel = model;
					atkPlayer = myModel.getPlayerRotation().getFirst();

					dice = new Dice();
					attackRolls = new ArrayList<Integer>();
					defendRolls = new ArrayList<Integer>();					
					
					loser = null;
					atkDice = 0;
					defDice = 0;

				}

		/*
		* setAttacker sets the attacking territory
    *  @param territory: a territory object representing the attacking territory
		*/
			public void setAttacker (Territory territory)
			{
					attacker = territory;
			}

			//returns the attacking territory
			public Territory getAttacker()
			{
					return attacker;
			}
			
		/*
		* setDefender sets the defending territory
    *  @param territory: a territory object representing the defending territory
		*/
			public void setDefender (Territory territory)
			{
					defender = territory;
					defPlayer = defender.getOccupant();
			}

			//returns the defending territory
			public Territory getDefender()
			{
					return defender;
			}

			//returns the list of attack rolls for this battle
			public ArrayList <Integer> getAttackRolls()
			{
					return this.attackRolls;
			}
			//returns the list of defense rolls for this battle
			public ArrayList <Integer> getDefenseRolls()
			{
					return this.defendRolls;
			}

			//sets the number of attack dice
			public void setAtkDice (int numDice)
			{
					this.atkDice = numDice;

			}
			//sets the number of defending dice
			public void setDefDice (int numDice)
			{
					this.defDice = numDice;
			}

			//returns thenumber of attack dice
			public int getAtkDice()
			{
					return this.atkDice;
			}

			//returns the number of defense dice
			public int getDefDice()
			{
					return this.defDice;
			}			

			//simulates the battle
			public void battle()
			{
					for (int i = 0; i < atkDice; i++)
					{
						this.attackRolls.add( dice.roll() );
					}

					for (int i = 0; i < defDice; i++)
					{
						this.defendRolls.add( dice.roll() );
					}
			}

			//decides who wins/loses
				public Territory decideLoser()
			{
					int atkHi = getHighestRoll(attackRolls);
					int defHi = getHighestRoll(defendRolls);

					if (atkHi > defHi)
					{
							this.loser = defender;
							this.winner = attacker;
					}else 
					{
							this.loser = attacker;
							this.winner = defender;
					}
					loser.parishArmy();
										
					return this.loser;
			}

			//finds the highest roll of a list of dice rolls
			private int getHighestRoll (ArrayList<Integer> rolls)
			{
				int high = 0;
				int index = 0;
				for (int i = 0; i< rolls.size(); i ++)
				{
						if (rolls.get(i) > high) 
						{
									high = rolls.get(i);
						}
						index = i;
				}
				rolls.remove(index);
				return high;
			}

			//returns the winning Territory
		public Territory getWinner()
		{
			return winner;
		}
  } //end Dice
