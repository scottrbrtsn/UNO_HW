/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  Paints the RiskMap from the Model
**/
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.util.Observer;
import java.util.Observable;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
				
public class RiskTextPrompt extends JComponent implements Observer{


		private String prompt;
		
		public RiskTextPrompt(){

			this.prompt = "";
			repaint();
		}
		public void setPrompt (String prompt)
		{
			this.prompt = prompt;
		}
		public String getPrompt(){
		return prompt;
		}
		public void paintComponent(Graphics g){
			g.setColor(Color.RED);
			g.setFont( new Font ("Serif", Font.BOLD, 36) );
			g.drawString(prompt,150,150);
			//g.setColor(Color.BLUE);
			//g.drawString("FOUR TROOPS", 450, 150);
		}

		public void update(Observable obs, Object obj){
			
			System.out.println("Update called.");
			System.out.println("Repainting current text.");
			repaint();
		}

	}
