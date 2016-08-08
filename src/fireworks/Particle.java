package fireworks;

import java.awt.Color;
import java.awt.Graphics;

public class Particle {
	//id number: each particle has unique id which is it's index on the list
	//position of particle
	public float x, y;
	//velocity of particle
	public float vx, vy;
	//drag
	public float k;
	//colour
	public Color colour;
	
	public int age= (int)Math.round(60+Math.random()*5);

	public Particle(){
	}
	
	public void setSphere(float x, float y){
		float r= (float)(Math.sqrt(1-(Math.pow(Math.random(),2)))*5);
		float a= (float)(Math.PI*(Math.random()*2));
		vx= (float)(Math.sin(a)*r);
		vy= (float)(Math.cos(a)*r);
		this.x= x;
		this.y= y;
		colour= new Color(255, 255, 255);
	}
	
	public void draw(Graphics g){
		age-=1;
		g.setColor(colour);
		g.drawLine(Math.round(x), Math.round(y), Math.round(x+vx), Math.round(y+vy));
	}
}
