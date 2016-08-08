package zcs.asgn9;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 * A JPanel subclass that provides a basic mechanism for doing animation.
 * It provides two methods to be overridden: drawFrame for drawing one
 * frame of the animation, and animationTick to update the animation
 * state to the next frame.  Both will be called 60 times per second to
 * keep the animation going.
 * 
 * @author srm
 */
abstract public class AnimatedPanel extends JPanel {
	
	private static final int INIT_DELAY = 100;
	private static final double DEFAULT_FRAME_RATE = 60.0;
		
	Timer timer;
	
	/**
	 * Create an animated panel.  Sets up a timer that will call the methods
	 * anomationTick() and repaint() at every INTERVAL milliseconds.
	 * @param frameRate the frame rate of the animation, in frames per second.
	 */
	public AnimatedPanel(double frameRate) {
		setDoubleBuffered(true);
		
		long interval = Math.round(1000.0 / frameRate);
				
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				animationTick();
				repaint();
			}		
		}, INIT_DELAY, interval);
	}
	
	public AnimatedPanel() {
		this(DEFAULT_FRAME_RATE);
	}
					
	/** 
	 * Repaint the window.  This means drawing the current animation frame,
	 * then calling the sync() method to help us be synchronized to the 
	 * frames of the computer's physical display.
	 * @param g The Graphics object that will be used to draw in the component
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawFrame(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	/**
	 * Draw one frame of the animation, using information about the state of
	 * the animation that is stored in this object.
	 * @param g The Graphics object that will be used to draw in the component
	 */
	public abstract void drawFrame(Graphics g);
	
	/**
	 * Update the state that is stored in this object so that the next frame
	 * will be moved appropriately relative to the current one.
	 */
	public abstract void animationTick();

}
