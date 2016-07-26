package zcs.asgn7;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibbonacciTest {

	@Test
	public void test() {
		assertEquals(Fibbonacci.F(0), 1);
		assertEquals(Fibbonacci.F(1), 1);
		assertEquals(Fibbonacci.F(2), 2);
		assertEquals(Fibbonacci.F(3), 3);
		assertEquals(Fibbonacci.F(4), 5);
	}

}
