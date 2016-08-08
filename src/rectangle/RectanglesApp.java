package rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import zcs.asgn6.GraphicsApp;

/**
 * the user can draw a rectangle in the window and move it around
 * @author zoë
 */
public class RectanglesApp extends GraphicsApp {
	 
	/**
	  * subclass of jpanel which draws a rectangle
	  * @author zoë
	  */
	@SuppressWarnings("serial")
	static class RectanglePanel extends JPanel implements MouseInputListener, KeyListener{
		
		//mouse clicked coordinates
			int clickx;
			int clicky;
		//the top left corner of rect
			int topx;
			int topy;
		//x and y positions of the mouse
			int bottomx;
			int bottomy;
		//draw x&y
			int drawtx= topx;
			int drawty= topy;
			int drawbx= bottomx;
			int drawby= bottomy;
		//true when you are drawing
			boolean drawing;
		//handle(1-8) you are resizing, none if not resizing
			int resizing= -1;
		//color to be used next
			Colour c= new Colour();
		//rectangle selected
			Rectangle rectangle;
		//coords of mouse (when its hovered over something but not clicked)
			int hoverx;
			int hovery;
		//colour pallate open
			boolean openPallate= false;
		//which tools are selected
			boolean move= false;
			boolean rect= true;
		//two coords stored so rectangles can be moved, -1 by default
			int movex1= -1;
			int movey1= -1;
			int movex2;
			int movey2;
		ArrayList<Rectangle> list = new ArrayList<Rectangle>();
		
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
			setBackground(Color.white);
			
			//changes which values are in which variable, so that topx&y hold the top left and
			//bottomx&y hold the bottom right corner
				if(bottomx<topx){
					drawtx= bottomx;
					drawbx= topx; 
				}else{
					drawtx= topx;
					drawbx= bottomx;
				}
				
				if(bottomy<topy){
					drawty= bottomy;
					drawby= topy; 
				}else{
					drawty= topy;
					drawby= bottomy;
				}
				
			//draws filled rectangles
				for (int i = 0; i < list.size(); i++) {
					list.get(i).fix();
					g.setColor(list.get(i).colour);
					g.fillRect(list.get(i).drawtx, list.get(i).drawty, 
							list.get(i).getLengthD(), list.get(i).getHeightD());
					if(list.get(i)==rectangle){rectangle.drawHandles(g);}
				}	
				
			//draws shadowy rectangle
				if(drawing){
					g.setColor(new Color(100, 100, 100));
					g.drawRect(drawtx, drawty, drawbx-drawtx, drawby-drawty);
				}
			
			//draws toolbar
				ToolBar t= new ToolBar();
				t.draw(g);
				
				if(move==true){g.drawRect(24, 0, 24, 24);}
				if(rect==true){g.drawRect(48, 0, 24, 24);}
				
			//calls drawing of colour palette and highlights selected colour
				if(t.mouseIn(hoverx, hovery)==1||openPallate==true){
					c.draw(g);
					c.highlightColour(g);
				}
				if(t.mouseIn(hoverx, hovery)==1){openPallate= true;}
				if(!(new Rectangle(0, 0, 25, 200, null).isInside(hoverx, hovery))){
					openPallate= false;
				}
		}

		/**
		 * mouse commands8
		 */
 		
		@Override
		public void mouseClicked(MouseEvent e) {
			clickx= e.getX();
			clicky= e.getY();
				
			//detects which tool is selected
				ToolBar t= new ToolBar();
				if(t.mouseIn(clickx, clicky)==2){
					move= true;
					rect= false;
				}
				if(t.mouseIn(clickx, clicky)==3){
					move= false;
					rect= true;
				}
			//detects which rectangle is clicked
				if(!(new Rectangle(0,25,25,200, null).isInside(e.getX(), e.getY()))&&
						!(new Rectangle(0,0,72,25, null).isInside(e.getX(), e.getY()))){
					rectangle= null;
					for(int i= 0; i<list.size(); i++){
						if(list.get(i).isInside(e.getX(), e.getY())){rectangle=list.get(i);}
					}
				}
			//calls method to select colour
				if(openPallate){
					c.pickColour(e.getX(), e.getY(), rectangle, e.getClickCount());
				}
				
			repaint();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
				if(rectangle!=null){
					resizing= rectangle.resizeHandle(e.getX(), e.getY());
				}
				topx= e.getX();
				topy= e.getY();
				bottomx= e.getX();
				bottomy= e.getY();
				repaint();
				
				if(resizing==-1&&rectangle!=null&&move==true){
					if(rectangle.isInside(e.getX(), e.getY())){
						movex1= e.getX();
						movey1= e.getY();
					}
				}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			resizing= -1;
			if(drawing){
				drawing= false;
				bottomx=e.getX();
				bottomy=e.getY();
				list.add(new Rectangle(drawtx, drawty, drawbx, drawby, c.colour));
				rectangle= list.get(list.size()-1);
			}
			if(movex1!=-1){movex1= -1;}
			
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
			if(resizing!=-1){
				rectangle.resize(e.getX(), e.getY(), resizing);
			}else{
				if(rect){
					drawing = true;
					bottomx= e.getX();
					bottomy= e.getY();
					rectangle= null;
				}
			if(movex1!=-1){
				movex2= e.getX();
				movey2= e.getY();
				Move.moveRect(rectangle, movex1, movey1, movex2, movey2);
				movex1= movex2;
				movey1= movey2;
			}
			}
			
			
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {	
			hoverx= e.getX();
			hovery= e.getY();
			repaint();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
				list.remove(rectangle);
				rectangle= null;
			}
			if(e.getKeyChar()=='v'){
				move= true;
				rect= false;
			}
			if(e.getKeyChar()=='r'){
				move= false;
				rect= true;
			}
			if(e.getKeyChar()=='b'){
				if(rectangle!=null&&list.indexOf(rectangle)!=0){
					int index= list.indexOf(rectangle);
					list.add(index-1, rectangle);
					list.remove(index+1);
				}
			}
			if(e.getKeyChar()=='f'){
				if(rectangle!=null&&list.indexOf(rectangle)!=list.size()-1){
					int index= list.indexOf(rectangle);
					list.add(index+2, rectangle);
					list.remove(index);
				}
			}
			if(e.getKeyChar()=='B'){
				if(rectangle!=null&&list.indexOf(rectangle)!=0){
					int index= list.indexOf(rectangle);
					list.add(0, rectangle);
					list.remove(index+1);
				}
			}
			if(e.getKeyChar()=='F'){
				if(rectangle!=null&&list.indexOf(rectangle)!=list.size()-1){
					int index= list.indexOf(rectangle);
					list.add(list.size(), rectangle);
					list.remove(index);
				}
			}
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
	/**
	 * overrides create and show gui
	 */
	@Override
	public void createAndShowGUI(){
		RectanglePanel panel = new RectanglePanel();
		createAndShowGUI("Rectangle", panel);
		frame.addKeyListener(panel);
	}
	
	public static void main(String[] args){
		startApp(new RectanglesApp());
	}
}
