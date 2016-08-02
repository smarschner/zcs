package zcs.asgn6;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is an application that consists of a single JPanel in a
 * single window.  It doesn't do much on its own, but subclasses can
 * provide new subclasses of JPanel that do more interesting things.
 * 
 * @author srm
 *
 */

public class GraphicsApp {
	
	// The application's top level frame
	JFrame frame;
		
	/**
	 * Create the components of the GUI, and configure them so that
	 * they are ready to go.
	 *  
	 * @param title The title of the application's window
	 * @param panel The component that will go in the window
	 */
	public void createAndShowGUI(String title, JPanel panel){
		
    	// Create and set up the window
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));

        // Create an instance of our custom JPanel and put it in the window
        frame.getContentPane().add(panel);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }
	
	/**
	 * Configure the GUI as appropriate.  This method is meant to be
	 * overridden in a subclass to do something more interesting, either
	 * using a subclass of JPanel that has more interesting behavior
	 * than JPanel, or by adding children to the JPanel before creating
	 * the GUI.
	 */
	public void createAndShowGUI() {
		createAndShowGUI("Graphics Application", new JPanel());
	}
		
	/**
	 * This method is needed to get the application started.  This method
	 * asks swing to call createAndShowGUI, then returns, and Swing will
	 * actually start the application a moment later.
	 * 
	 * @param app The instance representing the app to be run.
	 */
	public static void startApp(GraphicsApp app) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                app.createAndShowGUI();
            }
        });
	}

	/**
	 * The standard Java entry point.  A subclass will want to provide
	 * its own main function that instantiates an instance of that subclass
	 * rather than of GraphicsApp.
	 * 
	 * @param args Arguments are ignored
	 */
    public static void main(String[] args) {
    	startApp(new GraphicsApp());
    }

}
