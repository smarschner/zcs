package zcs.asgn6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 * the user can draw a rectangle in the window and move it around
 * @author zoë
 */
public class RectanglesApp extends GraphicsApp {
	 
	/**
	  * subclass of jpanel which draws a rectangle
	  * @author zoë
	  */
	static class RectanglePanel extends JPanel  implements MouseInputListener {
		
		//mouse clicked coordinates
		int clickx;
		int clicky;
		//the top left corner of rect
		int cornerx;
		int cornery;
		//x and y positions of the mouse
		int mousex;
		int mousey;
		//true when mouse has been released
		boolean released;
		
		//color to be used next
		Color colour;
		
		/**
		 * constructor
		 */
		public RectanglePanel(){
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		
		/**
		 * overrides the paintComponent function to make it paint a rectangle
		 *  @param g The Graphics object that will be used to draw in the component
		 */
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.white);
			
			//draw color chooser
			g.setColor(new Color(231, 143, 143));//red
			g.fillRect(0, 0, 25, 25);
			g.setColor(new Color(251, 176, 115));//orange
			g.fillRect(0, 25, 25, 25);
			g.setColor(new Color(255, 249, 156));//yellow
			g.fillRect(0, 50, 25, 25);
			g.setColor(new Color(139, 240, 149));//green
			g.fillRect(0, 75, 25, 25);
			g.setColor(new Color(167, 214, 244));//blue
			g.fillRect(0, 100, 25, 25);
			g.setColor(new Color(183, 167, 244));//purple
			g.fillRect(0, 125, 25, 25);
			//choose color
			if(0 <= clickx && clickx <= 25){
				if(0<= clicky && clicky <=25){colour= new Color(231, 143, 143);}
				if(25< clicky && clicky <=50){colour= new Color(251, 176, 115);}
				if(50< clicky && clicky <=75){colour= new Color(255, 249, 156);}
				if(75< clicky && clicky <=100){colour= new Color(139, 240, 149);}
				if(100< clicky && clicky <=125){colour= new Color(167, 214, 244);}
				if(125< clicky && clicky <=150){colour= new Color(183, 167, 244);}
			}
			
			
			g.setColor(new Color(248, 248, 248));
			g.drawRect(cornerx, cornery, mousex-cornerx, mousey-cornery);
			if(released==true){
				g.setColor(colour);
				g.fillRect(cornerx, cornery, mousex-cornerx, mousey-cornery);
			}

		}

		/**
		 * mouse commands
		 */
		
		@Override
		public void mouseClicked(MouseEvent e) {
			clickx= e.getX();
			clicky= e.getY();
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			released= false;
			cornerx= e.getX();
			cornery= e.getY();
			mousex= 0;
			mousey= 0;
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			released= true;
			mousex=e.getX();
			mousey=e.getY();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {			
		}

		@Override
		public void mouseExited(MouseEvent e) {			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			mousex= e.getX();
			mousey= e.getY();
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {	
		}
	}
	/**
	 * overrides create and show gui
	 */
	@Override
	void createAndShowGUI(){
		createAndShowGUI("Rectangle", new RectanglePanel());
	}
	
	public static void main(String[] args){
		startApp(new RectanglesApp());
	}
}
