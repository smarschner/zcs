package zcs.asgn7;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecTest {

	@Test
	public void test() {
		assertEquals(1,Rec.numberc('e', "hello"));
		assertEquals(4,Rec.numberc('i', "mississippi"));
		
		assertEquals(4,Rec.numberNotc('e', "hello"));
		assertEquals(7,Rec.numberNotc('i', "mississippi"));
		
		assertEquals("h3llo", Rec.replace("hello", 'e', '3'));
		assertEquals("m1ss1ss1pp1", Rec.replace("mississippi", 'i', '1'));
		
		assertEquals("abcd", Rec.rem1("aaaabbbccd"));
		assertEquals("zoe", Rec.rem1("zoooeeeeeee"));
		
		assertEquals("hiiii", Rec.removeFirst("hiiiii", 'i'));
		assertEquals("lama", Rec.removeFirst("llama", 'l'));
		
		assertEquals("eoz", Rec.rev1("zoe"));
		assertEquals("hello", Rec.rev1("olleh"));
		
		assertEquals("eoz", Rec.rev2("zoe"));
		assertEquals("hello", Rec.rev2("olleh"));
		
		assertEquals(46,Rec.sumInts("7:34:1:2:2"));
		assertEquals(34,Rec.sumInts("34"));
		
		assertEquals(120,Rec.fact(5));
		assertEquals(3628800,Rec.fact(10));
		
		assertEquals(12,Rec.sumDigits(345));
		assertEquals(24,Rec.sumDigits(7593));
		
		assertEquals(2,Rec.number2(25432));
		assertEquals(4,Rec.number2(23411222));
		
		assertEquals(4,Rec.into(3*3*3*3*7,3));
		assertEquals(0,Rec.into(5,3));
		
		assertEquals(78125,Rec.exp(5,7));
		assertEquals(43046721,Rec.exp(9,8));
		
	}

}
