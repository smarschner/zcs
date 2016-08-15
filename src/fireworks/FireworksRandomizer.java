package fireworks;

import java.awt.Color;

public class FireworksRandomizer {
	//0= dome, 1=sphere
	public int r;
	public Sphere sphere;
	
	public FireworksRandomizer(){
		int n= (int) Math.round(Math.random());
		if(n==0){r= 0;}
		if(n==1){
			r= 1;
			sphere= new Sphere();
		}
	}
}

class Dome extends FireworksRandomizer{
	public static float gravity= .1f;
	public static float drag= 1/12;
}

class Sphere extends FireworksRandomizer{
	public static float gravity= .02f;
	public static float drag= 1/12;
	//colour scheme to be assigned to fireworks,
	//0=purple and green
	//1= blue and red
	//2=red and green
	int colour0;
	int colour1;
	
	public Sphere(){
		int n= (int) Math.round(Math.random()*2);
		if(n==0){
			colour0= 0;
			colour1= 0;
		}
		
		if(n==1){
			colour0= 1;
			colour1= 1;
		}
		
		if(n==2){
			colour0= 2;
			colour1= 2;
		}
	}
	
	//returns the colour the particle should be, getting whiter as it ages
	//n1 says whether it should use colour1 or 2
	public Color getColour(int age, int n1){
		if(n1==0){
			if(colour0==0) return new Color(255, 255-age*2, 255);
			if(colour0==1) return new Color(255-age*2, 255-age*2, 255);
			if(colour0==2) return new Color(255, 255-age*2, 255-age*2);
		}
		if(n1==1){
			if(colour1==0)return new Color(255-age*2, 255, 255-age*2);
			if(colour1==1)return new Color(255, 255-age*2, 255-age*2);
			if(colour1==2)return new Color(255-age*2, 255, 255-age*2);
		}
		
		return Color.white;
	}
}
 