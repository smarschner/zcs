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
		assertEquals("12:00 AM", Methods.toAMPM("0:00"));
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
	@Test
	public void timeToCorrect() {
		assertEquals("1 hour and 5 minutes", 
				Methods.timeToCorrect("1 hours and 5 minutes"));
		assertEquals("12 hours and 1 minute", 
				Methods.timeToCorrect("12 hours and 1 minutes"));
	}
	@Test
	public void eliminateAMPM(){
		assertEquals("21:37",
				Methods.eliminateAMPM("9:37 PM"));
		assertEquals("9:37",
				Methods.eliminateAMPM("9:37 AM"));
	}
	
	@Test
	public void removeAMPM(){
		assertEquals("21:37",
				Methods.removeAMPM("9:37 PM"));
		assertEquals("9:37",
				Methods.removeAMPM("9:37 AM"));
		assertEquals("22:10",
				Methods.removeAMPM("22:10"));
	}
	@Test
	public void timeinMinutes(){
		assertEquals(1294,
				Methods.timeInMinutes("21:34"));
	}
	@Test
	public void AMPMtimeinMinutes(){
		assertEquals(1294,
				Methods.AMPMtimeInMinutes("9:34 PM"));
	}
	
	@Test
	public void comesbefore(){
		assertEquals(true,
				Methods.comesBefore("7:19", "22:30"));
		assertEquals(true,
				Methods.comesBefore("7:19", "3:24 PM"));
		assertEquals(false,
				Methods.comesBefore("11:20", "11:01 AM"));
	}
}
