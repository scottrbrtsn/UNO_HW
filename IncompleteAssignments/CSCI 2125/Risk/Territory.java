	/**
  * Risk Classes
  * Scott Robertson
  * Territory specifies the Territory object
  **/

import java.util.ArrayList;
import java.util.Observable;

public class Territory extends Observable
{

    private String name;
    private Player occupant;
    private int numOfArmies;
    private ArrayList<String> neighbors;
    private boolean isOccupied;
    
    public Territory( String name )
    {
        this.name = name;
        this.occupant = null;
        this.numOfArmies = 0;
        this.neighbors = null;
        this.isOccupied = false;
    }

   public void setNeighbors( ArrayList<String> neighbors )
    {
        this.neighbors = neighbors;
    }

  	public ArrayList<String> getNeighbors()
    {
        return this.neighbors;
    }

    public String getName()
    {
        return this.name;  
    }

		public void setOccupant( Player player )
    {
        this.occupant = player;
        isOccupied = true;
        setChanged();
				notifyObservers();
    }

    public Player getOccupant()
    {
        return this.occupant;
    }

    public boolean isOccupied()
    {
				return this.isOccupied;
    }

 		public void setNumArmies( int number )
    {
        this.numOfArmies = number;
        setChanged();
				notifyObservers();
    }

    public void addArmy ()
    {
				this.numOfArmies ++;
				setChanged();
				notifyObservers();
    }
    public void parishArmy()
    {
				this.numOfArmies --;
				setChanged();
				notifyObservers();
    }
    
    public int getNumArmies()
    {
        return this.numOfArmies;
    }

  
}//end Territory
