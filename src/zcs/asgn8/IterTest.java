package zcs.asgn8;

import static org.junit.Assert.*;

import org.junit.Test;

public class IterTest {

	@Test
	public void test() {
		assertEquals(1,Iter.numberc('e', "hello"));
		assertEquals(1,Iter.numberc('h', "hello"));
		assertEquals(4,Iter.numberc('i', "mississippi"));
		
		assertEquals(4,Iter.numberNotc('e', "hello"));
		assertEquals(7,Iter.numberNotc('i', "mississippi"));
		
		assertEquals("h3llo", Iter.replace("hello", 'e', '3'));
		assertEquals("m1ss1ss1pp1", Iter.replace("mississippi", 'i', '1'));
		
		assertEquals("abcd", Iter.rem1("aaaabbbccd"));
		assertEquals("zoe", Iter.rem1("zoooeeeeeee"));
		
		assertEquals("hiiii", Iter.removeFirst("hiiiii", 'i'));
		assertEquals("lama", Iter.removeFirst("llama", 'l'));
		
		assertEquals("eoz", Iter.rev1("zoe"));
		assertEquals("hello", Iter.rev1("olleh"));
		
		assertEquals(46,Iter.sumInts("7:34:1:2:2"));
		assertEquals(34,Iter.sumInts("34"));
		
		assertEquals(120,Iter.fact(5));
		assertEquals(3628800,Iter.fact(10));
		
		assertEquals(3,Iter.numDigits(345));
		assertEquals(4,Iter.numDigits(7593));
		
		assertEquals(12,Iter.sumDigits(345));
		assertEquals(24,Iter.sumDigits(7593));
		
		assertEquals(2,Iter.number2(25432));
		assertEquals(4,Iter.number2(23411222));
		
		assertEquals(4,Iter.into(3*3*3*3*7,3));
		assertEquals(0,Iter.into(5,3));
		
		assertEquals(5,Iter.Fib(5));
		assertEquals(34,Iter.Fib(9));
		assertEquals(1,Iter.Fib(1));
			
		assertEquals(5,Iter.exp(5,1));
		assertEquals(1,Iter.exp(9,0));
		assertEquals(78125,Iter.exp(5,7));
		assertEquals(43046721,Iter.exp(9,8));
//		
	}

}
