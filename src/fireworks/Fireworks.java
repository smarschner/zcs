package fireworks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.HashSet;

import javax.swing.event.MouseInputListener;

import zcs.asgn6.GraphicsApp;
import zcs.asgn9.AnimatedPanel;

public class Fireworks extends GraphicsApp{

	HashSet<Particle> particles= new HashSet<Particle>();
	FireworksRandomizer r;
	HashSet<Particle> sparks= new HashSet<Particle>();
	/**
	 * A subclass of AnimatedPanel that draws a single spark flying across the
	 * window in a parabolic motion.
	 * 
	 * @author srm
	 */
	@SuppressWarnings("serial")
	class FireworkPanel extends AnimatedPanel  implements MouseInputListener{
		
		//coords of mouse click
				
		public FireworkPanel(){
			setBackground(new Color(45,45,45));
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		@Override
		public void drawFrame(Graphics g) {
			//draws the particle
			if(!sparks.isEmpty()){
				for(Particle s : sparks){
					s.draw(g);
				}
			}
			for(Particle p : particles){
					p.draw(g);
				}
		}
		
		@Override
		public void animationTick() {
			if(!sparks.isEmpty()){
				HashSet<Particle> remove= new HashSet<Particle>();
					for(Particle s : sparks){
						if(Math.round(s.y)<s.sparky){
							remove.add(s);
							for(int x= 0; x<100; x++){
								Particle p= new Particle();
								if(r.r==0){p.setDome(s.sparkx, s.sparky);}
								else{p.setSphere(s.sparkx, s.sparky, r);}
								particles.add(p);	
							}
						}else{
							s.updateSpark();
						}
					}
				sparks.removeAll(remove);
			}
			
			HashSet<Particle> remove= new HashSet<Particle>();
			for(Particle p : particles){
				if(p.age==0){
					remove.add(p);
				}
				if(r.r==0){p.updateDome();;}
				else{p.updateSphere(r);;}
			}
			particles.removeAll(remove);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			r=new FireworksRandomizer();
			Particle spark= new Particle();
			spark.setSpark(e.getX(), getHeight(), e.getY());
			sparks.add(spark);
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
