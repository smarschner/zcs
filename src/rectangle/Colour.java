package rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Colour {
	
	public Color grey= new Color(100, 100, 100);

	public Color colour;
	
	public ArrayList<Color>colours = new ArrayList<Color>();
	public Colour(){
		colours.add(new Color(246, 129, 134));
		colours.add(new Color(255, 181, 130));
		colours.add(new Color(255, 249, 156));
		colours.add(new Color(194, 248, 187));
		colours.add(new Color(187, 231, 248));
		colours.add(new Color(217, 187, 248));
		colour= colours.get(0);
	}
	public void draw(Graphics g){
		for(int i= 0; i<colours.size(); i++){
			g.setColor(colours.get(i));
			g.fillRect(0, i*25+25, 25, 25);
		}
	}

	//picks colour adn changes colour of the current rect
	public void pickColour(int x, int y, Rectangle rectangle, int click){
		for(int i= 0; i<colours.size(); i++){
			if(x<25 && (y>(i*25+25) && y<((i+1)*25+25))){
				colour= colours.get(i);
				if(rectangle!=null&&click>=2){rectangle.colour= colour;}
			}
		}
		

	}
	
	public void highlightColour(Graphics g){
		g.setColor(new Color(100, 100, 100));
		g.drawRect(0, colours.indexOf(colour)*25+25, 24, 24);
	}
}
