package xctimes;

import static org.junit.Assert.*;

import org.junit.Test;

public class XCTimesTest {

	@Test
	public void test() {
		Name n1= new Name("Einstein, Albert");
		Name n2= new Name("Locke, John");
		Name n3= new Name("Einstein , Albert ");
		
		System.out.print(n1.equals(n3));
		
	}

}
