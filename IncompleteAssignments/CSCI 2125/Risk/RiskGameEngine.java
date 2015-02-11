/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  RiskGameEngine Class
*  Starts, Loads, and Saves the GameModel
*  
**/

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public class RiskGameEngine
{

		private RiskGameModel myModel;
		
		public RiskGameEngine()
		{
				myModel = new RiskGameModel();

		}

		public void startNewGame()
		{
				
		}

		public RiskGameModel loadSavedGame(String gameName)
		{
			ObjectInputStream input = null;
 		
 			try{
 					input = new ObjectInputStream(new FileInputStream(gameName + ".ser"));
 					} catch (IOException e) {
							e.printStackTrace();
 					}

			myModel = null;


 			try {
					myModel = (RiskGameModel)input.readObject();

					} catch (IOException e){
							e.printStackTrace();
 					} catch (ClassNotFoundException e){
							e.printStackTrace();
 				}

 				return myModel;
		}

		public void saveGame(String gameName)
		{
			        ObjectOutputStream writer = null;
			try {
   							writer = new ObjectOutputStream( new FileOutputStream(gameName+ ".ser") );
   		
   		} catch (IOException e) {
   				System.out.println("Could open file");
   		} 

     try {
   							writer.writeObject(myModel);
   		
   		} catch (IOException e) {
   				System.out.println("Couldn't write to file");
   		}

   		try{
   							writer.flush();
   							writer.close();
   				}
   		catch (IOException e){
   				System.out.println ("Unable to flush and close file.");
 					}
		}













}
