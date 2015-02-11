import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.io.File;

public class StartScreen extends JPanel{
	private JPanel startPanel;
	private JButton newGameButton;
	private JButton loadSavedGameButton;
	private RiskFrame mainFrame;
	private JFileChooser chooser;
	private RiskIcon risk;

	public StartScreen(RiskFrame frame){

		mainFrame = frame;

		startPanel = new JPanel();
		startPanel.setLayout( new FlowLayout() ); //set layout
		
		risk = new RiskIcon();
		startPanel.add(risk);
		newGameButton = new JButton("New Game");
		startPanel.add(newGameButton);

		loadSavedGameButton = new JButton("Load Saved Game");
		startPanel.add(loadSavedGameButton);

	  add(startPanel, BorderLayout.NORTH);

		StartHandler handler = new StartHandler();
		newGameButton.addActionListener( handler );
		loadSavedGameButton.addActionListener( handler );

	}
	

	private class StartHandler implements ActionListener{ 
		public StartHandler(){

		}

		public void actionPerformed (ActionEvent event){
			if(event.getActionCommand().equals("New Game")){

						mainFrame.openNewGameScreen();  //, REMOVES START SCREEN; OPENS NEW GAME SCREEN
			}
			if(event.getActionCommand().equals("Load Saved Game")){
						chooser = new JFileChooser();
						int returnVal = chooser.showOpenDialog(StartScreen.this);

						if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = chooser.getSelectedFile();
						
						System.out.println ("Opening: " + file.getName() + ".");
						} else {
						System.out.println ("Load game cancelled.");
						}
			}
			
		}
	}

	
}
