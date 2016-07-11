package zcs.test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class Rectangles {
	
	static class MyPanel extends JPanel {
		
		int rectX = 10, rectY = 10;
		
		public MyPanel() {
						
	        addMouseListener(new MouseInputAdapter() {
	    		@Override
	    		public void mouseClicked(MouseEvent e) {
	    			System.err.println("foo!");
	    			rectX = e.getX();
	    			rectY = e.getY();
	    			repaint();
	    		}

	        });
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillRect(rectX, rectY, 20, 20);
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(600, 400);
		}

		
	}

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JPanel panel = new MyPanel();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
