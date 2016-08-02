package zcs.asgn9;

import java.awt.Graphics;

import zcs.asgn6.GraphicsApp;

public class ExampleAnimatedApp extends GraphicsApp {

	private static final float GRAVITY = 0.2f;

	/**
	 * A subclass of AnimatedPanel that draws a single spark flying across the
	 * window in a parabolic motion.
	 * 
	 * @author srm
	 */
	@SuppressWarnings("serial")
	class ExamplePanel extends AnimatedPanel {
		
		// The current position of the spark.
		float x = 10, y = 290;
		
		// The velocity of the spark, in the x and y directions.
		// Units of velocity are pixels per frame.
		float vx = 5, vy = -10;

		@Override
		public void drawFrame(Graphics g) {
			// The spark is a little dot, and during the time of the frame it moves
			// from (x, y) to (x + vx, y + vy).  This means it shows up in the image
			// as a streak, which we show by drawing a line.
			g.drawLine(Math.round(x), Math.round(y), Math.round(x+vx), Math.round(y+vy));
		}
		
		@Override
		public void animationTick() {
			// Move the spark according to its velocity.
			x += vx;
			y += vy;
			
			// Update the y velocity to account for gravity.
			vy += GRAVITY;
			
			// When the spark falls out the bottom of the window, reset it back
			// to where it started, just so there is still something to see in this
			// example.
			if (y > getHeight()) {
				x = 10;
				y = 290;
				vy = -10;
			}
		}		
	}

	/**
	 * Create a GUI with the appropriate title and with an instance
	 * of ExamplePanel as its main component.
	 */
	@Override
	public void createAndShowGUI() {
		createAndShowGUI("Example Application", new ExamplePanel());
	}

	/**
	 * Start up the app using an instance of this class.
	 * @param args not used.
	 */
	public static void main(String[] args) {
    	startApp(new ExampleAnimatedApp());
    }

}
