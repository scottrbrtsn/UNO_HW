/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  Supplies text boxes for each player 
*  And check boxes for choosing player attributes?  e.g. color, 
**/
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PlayerCreationScreen extends JPanel
{
	private JPanel playerCreationPanel;
	private JPanel buttonPanel;
	private JButton enterButton;
	private JTextField gameName;
	private JTextField[] textFieldList;
	private JTextField player1;
	private JTextField player2;
	private JTextField player3;
	private JTextField player4;
	private JTextField player5;
	private JTextField player6;
	private String gameNameStr;
	private String player1Str;
	private String player2Str;
	private String player3Str;
	private String player4Str;
	private String player5Str;
	private String player6Str;
	private Player[] players;
	private RiskGameModel myModel;
	private RiskFrame mainFrame;
	private int numPlayers;

	
	

	public PlayerCreationScreen(RiskFrame frame, RiskGameModel model)
	{

		myModel = model;
		mainFrame = frame;
		this.numPlayers = myModel.getNumPlayers();
		playerCreationPanel = new JPanel();
		playerCreationPanel.setLayout ( new FlowLayout() );

				//add textfield to store game name
		gameName = new JTextField("Game", 15);
		playerCreationPanel.add(gameName);

			//add textfields to store player's names
							int playerCounter = 0;
							JTextField[] textFields = {player1, player2, player3, player4, player5, player6};

							String playerPrompt = "";
							for (int i = 0; i < numPlayers; i++)
							{
							playerCounter ++;
							playerPrompt = String.format("Player %s", playerCounter);
							textFields[i] = new JTextField(playerPrompt, 15);
							playerCreationPanel.add(textFields[i]);
							}
							
							textFieldList = textFields;

		add(playerCreationPanel, BorderLayout.NORTH);

		//add buttons
		buttonPanel = new JPanel();
		buttonPanel.setLayout( new FlowLayout() ); //set layout

		enterButton = new JButton("Enter");
		buttonPanel.add(enterButton);

		add(buttonPanel, BorderLayout.EAST);

		PlayerCreationHandler handler = new PlayerCreationHandler();
		enterButton.addActionListener( handler );


	}

	
	
	private class PlayerCreationHandler implements ActionListener{
		public PlayerCreationHandler(){

		}

		public void actionPerformed (ActionEvent event){

					if(event.getActionCommand().equals("Enter")){
									myModel.setGameName(gameName.getText() );
									System.out.println( myModel.getGameName() );
									Player [] players = new Player[myModel.getNumPlayers()];
									int playerCounter = 0;
									for (int i = 0; i < myModel.getNumPlayers(); i++)
										{
											players[i] = new Player ( textFieldList[i].getText() );
										}

								//add armies to players based on number of players 3 = 35, 4 = 30, 5 = 25, 6 = 20;
											int armies = 0;
											if (numPlayers == 3)
											{			
													for (int i = 0; i < numPlayers; i++)  //sets number of armies for each player
													{
															//players[i].addArmies(35);
															players[i].addArmies(10);  //for debugging
													}
											}
											if (numPlayers == 4)
											{			
													for (int i = 0; i < numPlayers; i++)  //sets number of armies for each player
													{
															players[i].addArmies(30);					
													}
											}
											if (numPlayers == 5)
											{			
													for (int i = 0; i < numPlayers; i++)  //sets number of armies for each player
													{
															players[i].addArmies(25);					
													}
											}
											if (numPlayers == 6)
											{			
													for (int i = 0; i < numPlayers; i++)  //sets number of armies for each player
													{
															players[i].addArmies(20);					
													}
											}

											myModel.addPlayers(players);   
											System.out.println ( myModel.getPlayerRotation().getFirst().getTotalArmies() ); 
											for (int i = 0; i < myModel.getNumPlayers(); i++) //for debugging, prints out player names
										{

											Player player =  myModel.getPlayerRotation().removeFirst();
											System.out.println( player.getName() );  
											myModel.getPlayerRotation().add(player);
										}	
							mainFrame.openWhoGoesFirstScreen(myModel);			   //for MVC optimization, set gamestate to 2

					}
			} 

		} //end handler class
					
												//how to create and add players to place into model for game use

}//end player creation screen class
