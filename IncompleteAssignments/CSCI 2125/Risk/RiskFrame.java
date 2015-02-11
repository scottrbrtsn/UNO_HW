/**
* Scott Robertson Risk Project
* CSCI 2120
*
* RiskFrame Class
* Main Risk Window
* Holds all methods for Panel transitions
*
* In tabs, displays Player stats e.g. territories in possession
**/
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import java.io.File;
import javax.swing.JFileChooser;
import java.lang.StringBuilder;

public class RiskFrame extends JFrame implements Observer
{
		//Initialize IV's
	private RiskGameModel myModel;
	private RiskFrame window;
	private JFileChooser chooser;
	private JPanel saveGamePanel;
	private JButton saveGameButton;
	private StartScreen startScreen;
	private NewGameScreen newGameScreen;
	private int numPlayers;
	private PlayerCreationScreen playerCreationScreen;
	private WhoGoesFirstScreen whoGoesFirstScreen;
	private TabScreen tabScreen;
	private RiskIcon risk;
	private SaveGameHandler handler;
	private RiskTextPrompt prompt;
	
	public RiskFrame()
		{
				//set up main window for game 
				super("Risk");
				setLayout( new BorderLayout() );	
				openStartScreen();	
				RiskGameModel myModel = new RiskGameModel();  // use game engine to start game, start game after player chooses 'newgame'
				saveGamePanel = new JPanel();
				saveGameButton = new JButton ("Save Game");  //saveGameButton displayed on RiskFrame to always provide the option to save
				saveGamePanel.add(saveGameButton);
				handler = new SaveGameHandler();
				saveGameButton.addActionListener( handler );
				prompt = new RiskTextPrompt();
		}

// returns the instruction prompt
	public RiskTextPrompt getPrompt ()
	{
			return this.prompt;
	}
	public void openStartScreen ()
	{			
			startScreen = new StartScreen(this);
			add(startScreen, BorderLayout.NORTH);
			risk = new RiskIcon();
			add(risk);
	}

	public void openNewGameScreen ()
	{
			prompt.setPrompt("HOW MANY PLAYERS?");
			remove(risk);
			getContentPane().remove(startScreen);
			repaint();
			newGameScreen = new NewGameScreen(this);
			add(prompt);
			add(newGameScreen, BorderLayout.NORTH);
			revalidate();
			repaint();
	}

	public void openPlayerCreationScreen(int numPlayers, RiskGameModel model)
	{
			myModel = model;
			this.numPlayers = numPlayers;
			myModel.setNumPlayers(numPlayers);
			
			prompt.setPrompt("NAME YOURSELF!");
			getContentPane().remove(newGameScreen);
			repaint();
			playerCreationScreen = new PlayerCreationScreen (this, model);
			add(playerCreationScreen, BorderLayout.NORTH);
			revalidate();
			repaint();
	}

	public void openWhoGoesFirstScreen(RiskGameModel model)
	{
			myModel = model;
			prompt.setPrompt("Roll to see who goes first.");
			getContentPane().remove(playerCreationScreen);
			repaint();
			whoGoesFirstScreen = new WhoGoesFirstScreen (myModel, this, this.numPlayers);
			add(whoGoesFirstScreen, BorderLayout.NORTH);
			revalidate();
			repaint();

	}

	public void openTabs()
	{
			remove(prompt);
			add(saveGamePanel, BorderLayout.SOUTH);
			getContentPane().remove(whoGoesFirstScreen);
			repaint();
			tabScreen = new TabScreen(myModel, this);
			add(tabScreen, BorderLayout.PAGE_START);
			revalidate();
			repaint();

}
	//rest of game screens are changed in TabScreens
	public void update  (Observable obs, Object obj)
				{
					//this.setText( String.valueOf ( this.model.getRoll() ) );
					//to update buttons and prompt per the optimization of MVC based on myModel.getState()
				}
//ActionListoner handles the save game button dispayed on the RiskFrame
		private class SaveGameHandler implements ActionListener{   
				public SaveGameHandler(){

				}

				public void actionPerformed (ActionEvent event){
				
					if(event.getActionCommand().equals("Save Game")){
								chooser = new JFileChooser();
								int returnVal = chooser.showOpenDialog(RiskFrame.this);

								if (returnVal == JFileChooser.APPROVE_OPTION) {
								File file = chooser.getSelectedFile();
						
								System.out.println ("Saving: " + file.getName() + ".");
								} else {
								System.out.println ("Save game cancelled.");
								}
					}
			
				}
	}

	
}// End RiskFrame
