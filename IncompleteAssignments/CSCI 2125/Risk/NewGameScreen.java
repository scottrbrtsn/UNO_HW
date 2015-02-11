import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NewGameScreen extends JPanel{
	private JPanel newGamePanel;
	private JButton threeButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private RiskGameModel myModel;
	private RiskFrame mainFrame;



	public NewGameScreen(RiskFrame frame){

		mainFrame = frame;

		newGamePanel = new JPanel();
		newGamePanel.setLayout( new FlowLayout() ); //set layout


		threeButton = new JButton("3");
		newGamePanel.add(threeButton);

		fourButton = new JButton("4");
		newGamePanel.add(fourButton);

		fiveButton = new JButton("5");
		newGamePanel.add(fiveButton);

		sixButton = new JButton("6");
		newGamePanel.add(sixButton);

		add(newGamePanel, BorderLayout.NORTH);

		NewGameHandler handler = new NewGameHandler();
		threeButton.addActionListener( handler );
		fourButton.addActionListener( handler );
		fiveButton.addActionListener( handler );
		sixButton.addActionListener( handler );

	}


	private class NewGameHandler implements ActionListener{
		public NewGameHandler(){

		}

		public void actionPerformed (ActionEvent event){
				myModel = new RiskGameModel();
				
			if(event.getActionCommand().equals("3")){
						System.out.println("number of players set to 3");
						mainFrame.openPlayerCreationScreen(3, myModel);
			}
			
			if(event.getActionCommand().equals("4")){
						System.out.println("number of players set to 4");
						mainFrame.openPlayerCreationScreen(4, myModel);
			}

			if(event.getActionCommand().equals("5")){
						System.out.println("number of players set to 5");
						mainFrame.openPlayerCreationScreen(5, myModel);
			}
			
			if(event.getActionCommand().equals("6")){
						System.out.println("number of players set to 6");
						mainFrame.openPlayerCreationScreen(6, myModel);
			}
			
		}
	}


}

