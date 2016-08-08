package fireworks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.event.MouseInputListener;

import zcs.asgn6.GraphicsApp;
import zcs.asgn9.AnimatedPanel;

public class Fireworks extends GraphicsApp{

	private static final float GRAVITY = 0f;
	HashSet<Particle> particles= new HashSet<Particle>();

	/**
	 * A subclass of AnimatedPanel that draws a single spark flying across the
	 * window in a parabolic motion.
	 * 
	 * @author srm
	 */
	@SuppressWarnings("serial")
	class FireworkPanel extends AnimatedPanel  implements MouseInputListener{
		
		//coords of mouse and last coords of mouse
		public int x1, x2, y1, y2;
		//true first time it is ran
		public boolean initialize=true;
		//velocity to be given to partcile
		public float vx, vy;
				
		public FireworkPanel(){
			setBackground(new Color(45,45,45));
			//adds 100 particles
			for(int x= 0; x<10000; x++){
				particles.add(new Particle());
			}
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		@Override
		public void drawFrame(Graphics g) {
			g.setColor(new Color(255, 255, 250));
			//draws the particle
			for(int x= 0; x<particles.size(); x++){
				particles.get(x).draw(g);
			}
		}
		
		@Override
		public void animationTick() {
			for(int x= 0; x<particles.size(); x++){
				Particle p= particles.get(x);
				// Move the spark according to its velocity.
				p.x += p.vx;
				p.y += p.vy;
				// Update the y velocity to account for gravity.
				p.vy += GRAVITY;
				// When the spark falls out the bottom of the window, reset it back
				// to where it started
				if (p.y > getHeight()||p.y<0||p.x<0||p.x>getWidth()||p.age==Math.round(50+(Math.random()*10))){
					float r= (float)(Math.sqrt(1-(Math.pow(Math.random(),2)))*5);
					float a= (float)(Math.PI*(Math.random()*2));
					vx= (float)(Math.sin(a)*r);
					vy= (float)(Math.cos(a)*r);
					p.set(x2, y2, vx, vy);
					p.age= 0;
				}
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(initialize){
				for(Particle p: particles){
					float r= (float)(Math.sqrt(1-(Math.pow(Math.random(),2)))*5);
					float a= (float)(Math.PI*(Math.random()*2));
					vx= (float)(Math.sin(a)*r);
					vy= (float)(Math.cos(a)*r);
					p.set(x2, y2, vx, vy);
				}
				initialize= false;
			}
			
			for(int x= 0; x<particles.size(); x++){
				Particle p= particles.get(x);
				float r= (float)(Math.sqrt(1-(Math.pow(Math.random(),2)))*(5+Math.random()));
				float a= (float)(Math.PI*(Math.random()*2));
				vx= (float)(Math.sin(a)*r);
				vy= (float)(Math.cos(a)*r);
				p.set(x2, y2, vx, vy);		
				p.age= 0;
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			x1= x2;
			y1= y2;
			x2= e.getX();
			y2= e.getY();
		}		
	}

	/**
	 * Create a GUI with the appropriate title and with an instance
	 * of ExamplePanel as its main component.
	 */
	@Override
	public void createAndShowGUI() {
		createAndShowGUI("Fireworks", new FireworkPanel());
	}

	/**
	 * Start up the app using an instance of this class.
	 * @param args not used.
	 */
	public static void main(String[] args) {
    	startApp(new Fireworks());
	}

}
