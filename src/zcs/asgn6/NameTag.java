package zcs.asgn6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import zcs.asgn1.InputReader;

/**
 * the user write name on nametag
 * @author zoë
 */
public class NameTag extends GraphicsApp {
	 
	static String name;//name to be printed on tag should be like 1 capital and 8 normal sized letters max
	static int namelength;//length of name starting with 0 max 8
		
	/**
	  * subclass of jpanel which draws a picture of the name tag
	  * @author zoë
	  */
	static class NamePanel extends JPanel {
		
		/**
		 * overrides the paintComponent function to make it paint a name tag
		 *  @param g The Graphics object that will be used to draw in the component
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(new Color(243, 243, 243));
			g.setColor(new Color(27, 161, 232));
			int w= getWidth();
			int h= getHeight();
			int x= ((w-500)/2);
			int y= ((h-300)/2);
			g.fillRoundRect(x, y, 500, 300, 45, 45);
			g.setColor(new Color(255, 255, 255));
			g.fillRect(x, y+100, 500, 150);		
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
			g.drawString("HELLO", x+170, y+57);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			g.drawString("my name is", x+190, y+77);
			
			g.setColor(new Color(0, 0, 0));
			g.setFont(new Font(Font.SERIF, Font.BOLD, 100));
			g.drawString(name, x+15+((9-namelength)*25), y+205);
		}
	}
	/**
	 * overrides create and show gui
	 */
	@Override
	void createAndShowGUI(){
		createAndShowGUI("Name Tag", new NamePanel());
	}
	
	public static void main(String[] args){
		System.out.print("Name? ");
		InputReader ir= new InputReader();
		name= ir.readLine();
		
		namelength= name.length();
		
		startApp(new NameTag());
	}
}
