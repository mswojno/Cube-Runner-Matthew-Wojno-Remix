import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class boxes {
	 
		int x = 0; 
		
		int y =0; 
		
		int width = 10; 
		
		int height = 10; 
		
		private Rectangle2D box; 
		
		
		public boxes() { 
			
			box = new Rectangle2D.Double(x, y, width, height);
			
			
			
			
			
			
		}
	    
		
		
		public Rectangle2D getRec(double x, double y) { 
			
			box = new Rectangle2D.Double(x, y, width, height); 
			
			
			return box; 
			
			
		}
	  
	    
}
  
	
	
	
	
	
	
	





