package zcs.asgn5; 

public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x= x;
		this.y= y;
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	
	public void setPoint(int x, int y){
		this.x= x;
		this.y= y;
	}
		
}

//1. String s, Employee e
//2. create instance, do constructor, value= id
//3. id of instance
//4. needs x,y and r
//5. (5, 6)
//6. false, false, true, true