import javax.swing.JFrame;
/**
How do I get a model variable to update across all viewers?
pass original model in declaration of opening new window.

How do I get a text box to input from user, i.e. player name, select territory, etc...?


* Start Screen
	-  new game
	-  load saved game
	New Game Screen
	- game name
	- number of players (3-6)
	Player creation Screen
	- player names
	Game Init Screen
	-  in turns, player will select unoccupied countries and place armies on them
*
*
**/
public class DisplayGUI {
	public static void main(String[] args){
		RiskFrame mainFrame = new RiskFrame();
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainFrame.setSize(1200, 2000);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setVisible(true);
	}
}
