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
	
	@Test
	public void testElephantCount(){
		Elephant f= new Elephant("EllieSR2", 1950, 1, 'B');
		assertEquals(Elephant.getPopulation(), 1);
		
		Elephant m= new Elephant("EllieSR1", 1950, 1, 'G');
		assertEquals(Elephant.getPopulation(), 2);
		
		Elephant e= new Elephant("EllieJR", 2000, 1, 'G', 1, m, f);
		assertEquals(Elephant.getPopulation(), 3);
	}

	@Test
	public void testToString(){
		Elephant f= new Elephant("EllieSR2", 1950, 1, 'B');
		Elephant m= new Elephant("EllieSR1", 1950, 1, 'G');
		Elephant e= new Elephant("EllieJR", 2000, 1, 'G', 1, m, f);
		
		assertEquals("Male elephant EllieSR2. Born 1/1950. 1 child.", f.toString());
		assertEquals( "Female elephant EllieSR1. Born 1/1950. 1 child.", m.toString());
		assertEquals( "Female elephant EllieJR. Tag 1. Born 1/2000. Mother EllieSR1. "
				+ "Father EllieSR2. 0 children.", e.toString());
	}

	@Test
	public void testRelativeMethods(){
		Elephant f= new Elephant("Dad", 1950, 1, 'B');
		Elephant m= new Elephant("Mom", 1950, 1, 'G');
		Elephant e= new Elephant("EllieJR", 2000, 1, 'G', 1, m, f);
		Elephant s= new Elephant("EllieSis", 2000, 1, 'G', 1, m, f);
		Elephant b= new Elephant("EllieBro", 2000, 1, 'B', 1, m, f);
		
		assertEquals(e.isMother(m), true);
		assertEquals(e.isFather(f), true);
		
		assertEquals(e.isFather(null), false);
		
		assertEquals(e.isParent(f), true);
		assertEquals(e.isParent(m), true);
		
		assertEquals(e.isSister(s), true);
		assertEquals(e.isSister(e), false);
		assertEquals(e.isSister(b), false);
		
		assertEquals(Elephant.isSister(e,s), true);
		
		assertEquals(Elephant.isYounger(e, m), true);
		assertEquals(Elephant.isYounger(m, e), false);
	}
}
