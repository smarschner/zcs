package fireworks;

import java.awt.Color;
import java.awt.Graphics;

public class Particle {
	//position of particle
	public float x, y;
	//velocity of particle
	public float vx, vy;
	//drag
	public float k;
	//colour, and which colour should be used if applicaple
	public int intcolour; //either 0 or 1
	public Color colour;
	//a sparks destination
	public int sparkx;
	public int sparky;
	
	public int age= (int)Math.round(30+Math.random()*10);

	public Particle(){
	}
	
	//x= x value of click
	//y= y value of where the spark should show up (bottom of screen)
	//desty= y value of destination (where the firework should go off)
	public void setSpark(int x, int y, int desty){
		vx= 0;
		vy= -7;
		this.x= x;
		this.y= y;
		sparkx= x;
		sparky= desty;
		colour= new Color(255, 255, 255);
	}
	
	public void updateSpark(){
		x += vx;
		y += vy;
		double speed= Math.sqrt(vx*vx + vy*vy);
		double drag= (1- (1/12)*(speed*speed));
		vx*=drag;
		vy*=drag;
	}
	public void setDome(float x, float y){
		float r= (float)(Math.sqrt(1-(Math.pow(Math.random(),2)))*2);
		float a= (float)(Math.PI*(Math.random()*2));
		vx= (float)(Math.sin(a)*r);
		vy= (float)(Math.cos(a)*r);
		this.x= x;
		this.y= y;
		colour= new Color(255, 255, 255-age);
	}
	
	public void updateDome(){
		Dome d= new Dome();
		x += vx;
		y += vy;
		vy += d.gravity;
		colour= new Color(255, 255, 255-age);
		double speed= Math.sqrt(vx*vx + vy*vy);
		double drag= (1- d.drag*(speed*speed));
		vx*=drag;
		vy*=drag;
	}
	
	public void setSphere(float x, float y, FireworksRandomizer random){
		float r= (float)(Math.sqrt(1-(Math.pow(Math.random(),2)))*3);
		float a= (float)(Math.PI*(Math.random()*2));
		vx= (float)(Math.sin(a)*r);
		vy= (float)(Math.cos(a)*r);
		this.x= x;
		this.y= y;
		int n= (int)(Math.round(Math.random()));
		if(n==0){
			intcolour= 0;
			colour= random.sphere.getColour(age, 0);
		}
		if(n==1){
			intcolour= 1;
			colour= random.sphere.getColour(age, 1);
		}
	}
	
	public void updateSphere(FireworksRandomizer random){
		Sphere s= new Sphere();
		x += vx;
		y += vy;
		vy += s.gravity;
		if(intcolour==0){
			colour= random.sphere.getColour(age, 0);
		}
		if(intcolour==1){
			colour= random.sphere.getColour(age, 1);
		}
		double speed= Math.sqrt(vx*vx + vy*vy);
		double drag= (1- s.drag*(speed*speed));
		vx*=drag;
		vy*=drag;
	}
	
	public void draw(Graphics g){
		age-=1;
		g.setColor(colour);
		g.drawLine(Math.round(x), Math.round(y), Math.round(x+vx), Math.round(y+vy));
	}
}
