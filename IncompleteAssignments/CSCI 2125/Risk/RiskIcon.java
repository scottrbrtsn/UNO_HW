/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  RiskIcon Class
*  Loads @ StartScreen
*	 
**/

import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import java.awt.Graphics;

public class RiskIcon extends JComponent{

		private BufferedImage risk;
		private BufferedImage testImage;
		public RiskIcon(){
		try{
			risk = ImageIO.read(new File("RISK.jpg"));

		} catch (IOException e){
			System.out.println("Image not loaded!: " + e);
		}
		testImage = risk;
		}

		public void paintComponent(Graphics g){
			g.drawImage(risk, 275, 100, this); 
		}
	
}

