package zcs.asgn12;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import zcs.asgn6.GraphicsApp;


/**
 * An example of how to extend GraphicsApp to do something, by replacing
 * the default JPanel with a subclass that draws something.
 * 
 * @author srm
 */
public class Graphics2DExampleApp extends GraphicsApp {

	/**
	 * A subclass of JPanel that shows a message.
	 * 
	 * @author srm
	 */
	@SuppressWarnings("serial")
	static class Panel extends JPanel {

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
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(4.0f));
			g2.setPaint(new Color(150, 170, 255));
			g2.fill(new Ellipse2D.Double(80., 100., 200., 200.));
			g2.setPaint(new Color(0, 0, 0));
			drawLineFan(g2, 180., 200., 90., 50);		
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setPaint(new Color(150, 170, 255));
			g2.fill(new Ellipse2D.Double(320., 100., 200., 200.));
			g2.setPaint(new Color(0, 0, 0));
			drawLineFan(g2, 420., 200., 90., 50);				
			try {
				BufferedImage img = ImageIO.read(new File("images/heart.png"));
				g2.drawImage(img, 300-32, 70, getBackground(), null);
			} catch (IOException e) {
				System.out.println("Can't read image: " + e.getMessage());
			}
		}

		protected void drawLineFan(Graphics2D g2, double cx, double cy, double r, int N) {
			for (int i = 0; i < N; i++) {
				double angle = 2 * i * Math.PI / N;
				g2.draw(new Line2D.Double(cx, cy, cx + r * Math.sin(angle), cy + r * Math.cos(angle)));
			}
		}
	}


	/**
	 * Create a GUI with the appropriate title and with an instance
	 * of DrawingExamplePanel as its main component.
	 */
	@Override
	public void createAndShowGUI() {
		createAndShowGUI("Example Application", new Panel());
	}

	public static void main(String[] args) {
		startApp(new Graphics2DExampleApp());
	}
}


