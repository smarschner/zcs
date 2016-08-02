package zcs.asgn6;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 * An example of how to extend GraphicsApp to do something, by replacing
 * the default JPanel with a subclass that draws something.
 * 
 * @author srm
 */
public class ExampleApp extends GraphicsApp {

	/**
	 * A subclass of JPanel that shows a message.
	 * 
	 * @author srm
	 */
	@SuppressWarnings("serial")
	static class ExamplePanel extends JPanel {
						
		/** 
		 * This method is called whenever Swing wants this component to draw
		 * its contents.  This happens when the window first becomes visible,
		 * when it is uncovered or made larger, or after someone calls the
		 * repaint() method to report that the contents have changed and need
		 * to be redrawn.
		 * @param g The Graphics object that will be used to draw in the component
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("Hi Zoë!", 260, 200);
		}
	}
	

	/**
	 * Create a GUI with the appropriate title and with an instance
	 * of DrawingExamplePanel as its main component.
	 */
	@Override
	public void createAndShowGUI() {
		createAndShowGUI("Example Application", new ExamplePanel());
	}
		
	public static void main(String[] args) {
    	startApp(new ExampleApp());
    }
}
