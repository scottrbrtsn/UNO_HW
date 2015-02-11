
/**
* Scott Robertson Risk Project
* CSCI 2120
*
*  Paints the RiskMap from the Model
*  Ideally, map will update in response to game activity
*  Currently, stats are shown in tabs
*  Based on terriotory occupants/armies etc...
**/

import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.util.Observer;
import java.util.Observable;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
				
public class RiskMap extends JComponent implements Observer{

		private BufferedImage image;
		private RiskGameModel myModel;
		
		public RiskMap(RiskGameModel model){
			myModel = model;
			image = myModel.getCurrentImage();
			repaint();
		}

		public void paintComponent(Graphics g){
			g.drawImage(image, 125, 0, this); 
		}

		public void update(Observable obs, Object obj){
			System.out.println("Update called.");
			image = myModel.getCurrentImage();
			System.out.println("Repainting current image.");
			repaint();
		}

	}
