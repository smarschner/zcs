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
		
		//the top left corner of rect
		int cornerx;
		int cornery;
		//x and y positions of the mouse
		int mousex;
		int mousey;
		//true when mouse has been released
		boolean released;
		
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
			setBackground(new Color(255, 184, 184));
			g.setColor(new Color(255, 255, 255));
			g.drawRect(cornerx, cornery, mousex-cornerx, mousey-cornery);
			if(released==true){
				g.fillRect(cornerx, cornery, mousex-cornerx, mousey-cornery);
			}

		}

		/**
		 * mouse commands
		 */
		
		@Override
		public void mouseClicked(MouseEvent e) {
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
