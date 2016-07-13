
class A {

	static int x;

	A(int y) {
		x = y;
	}

	int f(int x) {
		A.x = A.x + x;
		return A.x;
	}

}

class B {

	int x;

	B(int y) {
		x = y;
	}

	int g(int x) {
		this.x = this.x + x;
		// For Exercise B draw the frames and objects that exist each time this point in execution is reached.
		return this.x;
	}

}

class C extends B {

	C(int y) {
		super(y + 1);
		y = y - 1;
		x = x + 1;
	}

	int g() {
		int x = 42;
		x = x + 1;
		x = g(x) + 3;
		return this.x;
	}

}

class D extends A {

	D(int y) {
		super(y + 1);
		y = y - 1;
		x = x + 1;
	}

	int f(int x) {
		x = 42;
		this.x = 29;
		return x;
	}

}


class Asgn5ExerciseB {
	public static void main(String[] args) {
		int y = 4;
		A a = new A(y);
		B b = new B(y);
		C c = new C(y);
		D d = new D(y);
		System.out.println(a.f(y));
		System.out.println(b.g(y));
		System.out.println(c.g(y));
		System.out.println(d.f(y));
	}
}