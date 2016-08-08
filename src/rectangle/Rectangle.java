package rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Rectangle {
	public int topx;
	public int topy;
	
	public int bottomx;
	public int bottomy;
	
	public int drawtx= topx;
	public int drawty= topy;
	public int drawbx= bottomx;
	public int drawby= bottomy;
	
	public Color colour;
	
	//rectangle constructor
	//for parameters x&y of top left and x&y of bottom right, and a colour
	public Rectangle(int xt, int yt, int xb, int yb, Color c){
		topx= xt;
		topy= yt;
		
		bottomx= xb;
		bottomy= yb;
		
		colour= c;
	}
	
	//square constructor
	//for x&y of center, with a distance from one side through the center 
	//perpindicularaly to the opposite side
	public Rectangle(int cx, int cy, int d){
		topx= cx-(d/2);
		topy= cy-(d/2);
		
		bottomx= cx+(d/2);
		bottomy= cy+(d/2);
	}
	
	public void fix(){
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
	}
	
	public int getLength(){
		return bottomx-topx;
	}
	
	public int getLengthD(){
		return drawbx-drawtx;
	}
	
	public int getHeight(){
		return bottomy-topy;
	}
	
	public int getHeightD(){
		return drawby-drawty;
	}
	
	public boolean isInside(int x, int y){
		return((x>topx&&x<bottomx)&&(y>topy&&y<bottomy));
	}
	
	public void drawHandles(Graphics g){
		g.setColor(new Color(100, 100, 100));
		g.fillRect(topx-3, topy-3, 6, 6);
		g.fillRect(bottomx-3, bottomy-3, 6, 6);
		g.fillRect(topx-3, bottomy-3, 6, 6);
		g.fillRect(bottomx-3, topy-3, 6, 6);
		g.drawRect(drawtx, drawty, getLengthD(), getHeightD());
		g.fillRect((Math.round(getLength()/2.0f))+topx-3, topy-3, 6, 6);
		g.fillRect((Math.round(getLength()/2.0f))+topx-3, bottomy-3, 6, 6);
		g.fillRect(topx-3,(Math.round(getHeight()/2.0f))+topy-3, 6, 6);
		g.fillRect(bottomx-3,(Math.round(getHeight()/2.0f))+topy-3, 6, 6);
	}
	
	//returns which handle has been clicked in an integer ranged 1-8, which
	//corespond to the eight handles labeled from top to bottom and left to right
	//-1 if no handle is selected
	public int resizeHandle(int x, int y){
		ArrayList<Rectangle> handles = new ArrayList<Rectangle>();
		
		handles.add(new Rectangle(topx, topy, 6));//1
		handles.add(new Rectangle(topx+Math.round(getLength()/2.0f), topy, 6));//2
		handles.add(new Rectangle(bottomx, topy, 6));//3
		handles.add(new Rectangle(topx, Math.round(getHeight()/2.0f)+topy, 6));//4
		handles.add(new Rectangle(bottomx, Math.round(getHeight()/2.0f)+topy, 6));//5
		handles.add(new Rectangle(topx, bottomy, 6));//6
		handles.add(new Rectangle(topx+Math.round(getLength()/2.0f), bottomy, 6));//7
		handles.add(new Rectangle(bottomx, bottomy, 6));//8
		
		for(int i= 0; i<handles.size(); i++){
			if(handles.get(i).isInside(x, y)){
				return i+1;
			}
		}
		return -1;
	}
	
	public void resize(int x, int y, int handle){
		if(handle==1){
			topx= x;
			topy = y;
		}
		if(handle==2){topy = y;}
		if(handle==3){
			bottomx= x;
			topy = y;
		}
		if(handle==4){topx = x;}
		if(handle==5){bottomx = x;}
		if(handle==6){
			topx= x;
			bottomy = y;
		}
		if(handle==7){bottomy = y;}
		if(handle==8){
			bottomx= x;
			bottomy = y;
		}
	}

}
