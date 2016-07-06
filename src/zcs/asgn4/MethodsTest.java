package zcs.asgn4;

import static org.junit.Assert.*;

import org.junit.Test;

public class MethodsTest {

	@Test
	public void testToVerbose() {
		assertEquals("4 hours and 13 minutes", 
				Methods.toVerbose("4:13"));
		assertEquals("4 hours and 13 minutes",
				Methods.toVerbose("04:13"));
		assertEquals("23 hours and 59 minutes",
				Methods.toVerbose("23:59"));
	}
	
	@Test
	public void testToAMPM() {
		assertEquals("4:13 AM",
				Methods.toAMPM("4:13"));
		assertTrue("4:13 AM".equals(Methods.toAMPM("4:13")));
		assertEquals("4:13 AM",
				Methods.toAMPM("04:13"));
		assertEquals("11:59 PM",
				Methods.toAMPM("23:59"));
		assertEquals("11:59 AM",
				Methods.toAMPM("11:59"));
		assertFalse("12:00 AM".equals(Methods.toAMPM("12:00")));
		assertEquals("12:00 PM",
				Methods.toAMPM("12:00"));
		assertEquals("12:01 PM",
				Methods.toAMPM("12:01"));
	}
	
}
