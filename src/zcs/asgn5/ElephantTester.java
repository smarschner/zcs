package zcs.asgn5;

import static org.junit.Assert.*;

import org.junit.Test;

public class ElephantTester {

	@Test
	public void testConstructor1() {
		Elephant e= new Elephant("Ellie", 2000, 1, 'G');
		
		assertEquals("Ellie", e.getName());
		assertEquals(2000, e.getYear());
		assertEquals(1, e.getMonth());
		assertEquals(false, e.isMale());
		assertEquals(-1, e.getTag());
		assertEquals(null, e.getMother());
		assertEquals(null, e.getFather());
		assertEquals(0, e.getNumChildren());
	}
	
	@Test
	public void testSetter(){
		Elephant e= new Elephant("EllieJR", 2000, 1, 'G');
		Elephant f= new Elephant("EllieSR2", 1950, 1, 'B');
		Elephant m= new Elephant("EllieSR1", 1950, 1, 'G');
		
		//tests addMother
		e.addMother(m);
		assertEquals(e.getMother(), m);
		assertEquals(m.getNumChildren(), 1);
		
		//tests addFather
		e.addFather(f);
		assertEquals(e.getFather(), f);
		assertEquals(f.getNumChildren(), 1);
		
		//tests setTag
		e.setTag(1);
		assertEquals(1, e.getTag());
		
	}
		
	@Test
	public void testConstructor2(){
		Elephant f= new Elephant("EllieSR2", 1950, 1, 'B');
		Elephant m= new Elephant("EllieSR1", 1950, 1, 'G');
		Elephant e= new Elephant("EllieJR", 2000, 1, 'G', 1, m, f);
		
		assertEquals("EllieJR", e.getName());
		assertEquals(2000, e.getYear());
		assertEquals(1, e.getMonth());
		assertEquals(false, e.isMale());
		assertEquals(1, e.getTag());
		assertEquals(m, e.getMother());
		assertEquals(f, e.getFather());
		
		assertEquals(1, m.getNumChildren());
		assertEquals(1, f.getNumChildren());
	}

}
