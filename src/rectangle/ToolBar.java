package rectangle;

import java.awt.Color;
import java.awt.Graphics;

public class ToolBar {
	public void draw(Graphics g){
		Colour c= new Colour();
		
		g.setColor(c.grey);
//		g.drawRect(0,0,24,24);
		g.drawRect(8,8,13,13);
		g.setColor(c.colours.get(5));
		g.fillRect(9, 9, 12, 12);
		g.setColor(c.grey);
		g.drawRect(3, 3, 13, 13);
		g.setColor(c.colours.get(0));
		g.fillRect(4, 4, 12, 12);
		
		g.setColor(c.grey);
//		g.drawRect(24,0,24,24);
		g.drawLine(36, 3, 36, 21);// |
		g.drawLine(27, 12, 45, 12);// –
		// <
		g.drawLine(30, 9, 30, 15);
		g.drawLine(29, 10, 29, 14);
		g.drawLine(28, 11, 28, 13);
		// >
		g.drawLine(42, 9, 42, 15);
		g.drawLine(43, 10, 43, 14);
		g.drawLine(44, 11, 44, 13);
		// /\
		g.drawLine(33, 6, 39, 6);
		g.drawLine(34, 5, 38, 5);
		g.drawLine(35, 4, 37, 4);
		// \/
		g.drawLine(33, 18, 39, 18);
		g.drawLine(34, 19, 38, 19);
		g.drawLine(35, 20, 37, 20);
		
//		g.drawRect(48,0,24,24);
		g.drawRect(52, 4, 16, 16);
		//top row
		g.fillRect(51, 3, 3, 3);
		g.fillRect(59, 3, 3, 3);
		g.fillRect(67, 3, 3, 3);
		//middle row
		g.fillRect(51, 11, 3, 3);
		g.fillRect(67, 11, 3, 3);
		//bottom row
		g.fillRect(51, 19, 3, 3);
		g.fillRect(59, 19, 3, 3);
		g.fillRect(67, 19, 3, 3);
	}
	
	//return 1-3, -1 if none
	//1=colour chooser, 2=move, 3=rectangle 
	public int mouseIn(int x, int y){
		if(y<25){
			if(x<24){
				return 1;
			}else{
				if(x<48){
					return 2;
				}else{
					if(x<72){
						return 3;
					}else{return -1;}
				}
			}
		}else{return -1;}
	}
}
