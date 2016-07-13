class Ex {
	
	public static final int ONE = 1;
	private int h; 

	public Ex(int ph) {
		h = ph;
	}

	public int getH() { 
		return h;
	}

	public static int what(int x) {
		return x + ONE; 
	}

	public String toString() {
		return "[Ex instance: h = " + h + "]"; 
	}
}

class Sub extends Ex {

	private int k;

	public Sub(int pk) {
		super(29);
		k = pk;
	}

	public Sub() {
		super(42);
		k = 5;
	}

	public String toString() {
		return "[Sub instance: k = " + k + ", h = " + getH() + "]"; 
	}
}
	
class SubSub1 extends Sub { 

	public SubSub1() {
		super(5); 
	}
	
	public int hPlus1() { 
		return getH() + 1;
	}

}

class SubSub2 extends Sub { 

	private int p;
}

public class Asgn5ExerciseA {

	public static void main(String[] args) {
	   Ex a = new Ex(8);
	   Sub b = new Sub(35);
	   SubSub1 c = new SubSub1();
	   SubSub2 d = new SubSub2();

	   // For Ex. A, draw objects that exist at this point in execution

	   System.out.println("a: " + a);
	   System.out.println("b: " + b);
	   System.out.println("c: " + c);
	   System.out.println("d: " + d);
	}

}
