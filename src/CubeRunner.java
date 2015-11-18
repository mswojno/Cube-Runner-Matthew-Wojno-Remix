

	import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.geom.*;
import java.util.Random;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class CubeRunner extends JPanel implements ActionListener, KeyListener {
	
		
		java.awt.Font font = new java.awt.Font("Dialog",Font.BOLD,14);
		
		private  Timer t = new Timer(70, this);
		 private Timer set60 = new Timer(60, this);
		 private Timer set50 = new Timer(50, this);
		 private Timer set40 = new Timer(40, this);
		 private Timer set30 = new Timer(30, this); 
		 private Timer set20 = new Timer(20, this); 
		 private Timer set15 = new Timer(15, this);
		 private Timer set10 = new Timer(10,this);
		 private Timer set5 = new Timer(5 ,this);
		 
		
		
		int counter = 0;
		
		private static int condensed = 0;
		

		
		
		Rectangle2D boxes[] = new Rectangle2D[30]; 
		
			boxes object = new boxes(); 
		
		
		double x = 0; 
		
		double y =0; 
		
		double x1 = 0; 
		
		int pointx = 220;
	    
		int pointx1 = 230; 
	   
	    int pointx2 = 210; 
	    
	    int velX = 0;
	    
	  int currentscore = 0;
	  
		static CubeRunner a = new CubeRunner(); 
		
		static JFrame frame = new JFrame("CubeRunner"); 
		
	  
	    
	    int ypoints1 = 200;
	    
	    int ypoints2 = 250;
	    
	    String play = "n";

		private ActionListener taskPerformer;
	   
		
		
		public CubeRunner() { 
			
			
		
			
			
		
			t.start(); 
			set50.stop();
			
			
			
			 addKeyListener(this);  //Add this key listener
		       setFocusable(true);     // Sets the focus to this so I can use KeyListener
		        setFocusTraversalKeysEnabled(false); //Allows keys to act normal
		        
		        
		       
				
				
			for(int k = 0; k < 30; k++) { 
				x = Math.random() * 500; 
				
				y = Math.random() * -500;
				
				boxes[k] = object.getRec(x, y);
				
				
				
				
				
				
				
			}
			
			
			
				
				
				
				
				
			
		}
			
			public void paintComponent (Graphics g) { 
				
				super.paintComponent(g);
				

				int[] xpoints = {pointx, pointx1 , pointx2};
				
				int[] ypoints = {ypoints1, ypoints2, ypoints2};
				
				
			    Graphics2D g2 = (Graphics2D) g;  //cast to a graphics object
		        
		        
			    
		        g2.setFont(font);
		        g2.setColor(Color.blue);
		        
		        g2.drawString("Score: " + condensed, 440, 400);
		        
		       
		       
			    Polygon myTri = new Polygon(xpoints, ypoints, xpoints.length );  // a triangle

			    g2.setColor(Color.red);

			    g2.fill(myTri);
		        
			    
		        for(int i = 0; i < 30; i++) { 
		        	g2.setColor(Color.black);
		        	
		        	g2.fill(boxes[i]);
		        	  
		        	if(myTri.intersects(boxes[i])){ 
		          		
		          		t.stop();
		          		set50.stop();
		          		set40.stop();
		          		set30.stop();
		          		set20.stop();
		          		set15.stop();
		          		set5.stop();
		          		
		          		 x = 0; 
		          		
		          		 y =0; 
		          		
		          		 x1 = 0; 
		          		
		          		 pointx = 220;
		          	    
		          		pointx1 = 230; 
		          	   
		          	    pointx2 = 210; 
		          	    
		          	     velX = 0;
		          	    
		          	  
		          	     ypoints1 = 200;
		          	    
		          	     ypoints2 = 250;
		          		
		          		JOptionPane.showMessageDialog(null,"You lose!" +" " +  "Your Score was: " + " "+ condensed );
		          		
		          		
		          		 String play = JOptionPane.showInputDialog(null, "If you wish to play again type 'y' !!!");
		          		 
		          		if(play.charAt(0) == 'y'){
		          			restart();
		          		}
		          		
		          		
		          		condensed = 0;
		          		
		          		
		          	}
		  			
		        	
		        	
		        	
		        }
		        
		       
			}
			
			
			
			public void actionPerformed (ActionEvent e ) { 
				
				
				
				
				
				if(e.getSource() == t || e.getSource() == set50 ||e.getSource() == set40 || e.getSource() == set30||e.getSource() == set20||e.getSource() == set15||e.getSource() == set5) { 
					counter++;
					
					 condensed = counter / 10;
					
					if(condensed >= 30) { 
						
						 t.stop();
						set50.start();
						set40.stop();
						set30.stop();
						set20.stop();
						set15.stop();
						set10.stop();
						set5.stop();
					
						
						
					}
					
					if(condensed >= 80) { 
						t.stop();
						set50.stop();
						set40.start();
						set30.stop();
						set20.stop();
						set15.stop();
						set10.stop();
						set5.stop();
					}
					
					if(condensed >= 120) { 
						
						t.stop();
						set50.stop();
						set40.stop();
						set30.start();
						set20.stop();
						set15.stop();
						set10.stop();
						set5.stop();
						
						
					}
					
					if(condensed >= 150) { 
						
						t.stop();
						set50.stop();
						set40.stop();
						set30.stop();
						set20.start();
						set15.stop();
						set10.stop();
						set5.stop();
						
					}
					
					if(condensed >= 250) {
						t.stop();
						set50.stop();
						set40.stop();
						set30.stop();
						set20.stop();
						set15.start();
						set10.stop();
						set5.stop();
					}
					
					if(condensed >= 350){
						t.stop();
						set50.stop();
						set40.stop();
						set30.stop();
						set20.stop();
						set15.stop();
						set10.start();
						set5.stop();
						
						
					}
					
					if(condensed >= 450) { 
						t.stop();
						set50.stop();
						set40.stop();
						set30.stop();
						set20.stop();
						set15.stop();
						set10.stop();
						set5.start();
						
						
						
						
					}
				
					
					
					pointx += velX;
		    		pointx1 += velX; 
		       	 	pointx2 += velX;
					
		       	 	
		       	 	x1 += 2; 
					
					for(int j= 0; j< 30; j++) { 
						
						boxes[j] = new Rectangle2D.Double(boxes[j].getX(), boxes[j].getY() + 2, 15,15);
						
						if(boxes[j].getY() > 400) { 
							
							double x = Math.random() * 500; 
							double y = 0; 
							
							boxes[j] = new Rectangle2D.Double(x, y, 15, 15); 
							
							
						}
					
							
						if(pointx >= 520 || pointx1 >= 520 || pointx2 >= 520 ) { 
							
							 
						   
								
						     
						     pointx = 510;
							    
							 pointx1 = 520; 
						   
						     pointx2 = 500; 
						    
						     ypoints1 = 200; 
						     
						     ypoints2 = 250;
						     
						     
						     
							
							
							
							
						}
						
						if(pointx <= 0|| pointx1 <= 0 || pointx2 <=0) { 
							
							
							pointx = 10;
							
							 pointx1 = 20; 
						   
						     pointx2 = 0; 
						    
						     ypoints1 = 200; 
						     
						     ypoints2 = 250;
							
							
							
							
							
						}
						
						
						
						
					}
						
				repaint(); 
					
				}
				
			}	
						
			
			
			public void restart(){
				
				frame.dispose();
				
				CubeRunner a = new CubeRunner(); 
				
				JFrame frame = new JFrame("CubeRunner"); 
				
				frame.getContentPane().add(a);
				
				frame.setVisible(true);
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				frame.setSize(700,700);
				
			}
			
			
			 public void left(){  //sets up key to move the object up
		         velX = -7;
		        
		     }
		     
		     public void right(){
		         velX = 7;
		         
		     }
		     
		     
		     public void stop(){  //This stops the movement when the key is released
		         velX = 0;
		       
		     }
		    
		     public void keyPressed(KeyEvent e){   //This is to determine what key is pressed
		         
		    	 int code = e.getKeyCode();
		        
		         if(code == KeyEvent.VK_RIGHT){
		             right();
		         }
		          if(code == KeyEvent.VK_LEFT){
		             left();
		         }
		       
		     }
		     public void keyTyped(KeyEvent e){}
		     public void keyReleased(KeyEvent e){
		          stop();
		     }
			
			public static void main(String [] args) { 
				
				
			
				frame.getContentPane().add(a);
				
				frame.setVisible(true);
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				frame.setSize(700,700);
				
				
				
				
				
				
			}
			
			
			
			
		}
		
		