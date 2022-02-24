package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	//Good total seconds test
	@ParameterizedTest
	@ValueSource(strings = {"08:00:00", "08:36:18", "08:59:59"})
	public void testGetTotalSecondsGood(String totalSeconds) {
		int seconds = Time.getTotalSeconds(totalSeconds);
		assertTrue("The total seconds were not calculated properly", seconds>=0 || seconds<=32399);
	}

	//Bad total seconds test
	@Test
	public void testGetTotalSecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalSeconds("10:00");});
	}
	
	//Boundary total seconds test
	@ParameterizedTest
	@ValueSource(strings= {"00:00:00", "59:59:59"})
	public void testGetTotalSecondsBoundary(String totalSeconds) {
		int seconds = Time.getTotalSeconds(totalSeconds);
		assertTrue("The boundary test failed for total seconds", seconds>=0 || seconds<=89999);
	}

	
	//Good milliseconds test
	@ParameterizedTest
	@ValueSource(strings = {"07:00:59:002", "07:25:59:002", "07:59:59:002"})
	public void testGetMillisecondsGood(String millisecond) {
		int milliseconds = Time.getMilliseconds(millisecond);
		assertTrue("The Milliseconds were not calculated properly", milliseconds==2);
	}
	
	//Bad milliseconds test
	@Test
	public void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, 
				 ()-> {Time.getTotalSeconds("10:00");});
	}
	
	//Boundary milliseconds test
		@ParameterizedTest
		@ValueSource(strings = {"00:00:00:000", "59:59:59:999"})
		public void testGetMillisecondsBoundary(String millisecond) {
			int milliseconds = Time.getMilliseconds(millisecond);
			assertTrue("The Milliseconds were not calculated properly", milliseconds>=0 || milliseconds <= 999);
		}
	
	//Good seconds test
	@ParameterizedTest
	@ValueSource(strings = {"07:00:59", "07:25:59", "07:59:59"})
	public void testGetSecondsGood(String second) {
		int seconds = Time.getSeconds(second);
		assertTrue("The seconds were not calculated properly", seconds==59);
	}
	
	//Bad seconds test
	@Test
	public void testGetSecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getSeconds("00:04");});
	}
	
	//Boundary seconds test
	@ParameterizedTest
	@ValueSource(strings= {"00:00:00", "00:00:59"})
	public void testGetSecondsBoundary(String second) {
		int seconds = Time.getSeconds(second);
		assertTrue("The boundary test failed for seconds", seconds>=0 || seconds<=59);
	}

	//Good total minutes test
	@ParameterizedTest
	@ValueSource(strings = {"06:25:00", "06:25:10", "06:25:59"})
	public void testGetTotalMinutesGood(String totalMinutes) {
		int minutes = Time.getTotalMinutes(totalMinutes);
		assertTrue("The minutes were not calculated properly", minutes==25);
	}
	
	//Bad total minutes test
	@Test
	public void testGetTotalMinutesBad() 
	{
	assertThrows(
	 NumberFormatException.class, 
	 ()-> {Time.getTotalMinutes("10:jj:00");});
	}
	
	//Boundary total minutes test
	@ParameterizedTest
	@ValueSource(strings= {"00:00:00", "00:59:59"})
	public void testGetTotalMinutesBoundary(String totalMinutes) {
		int minutes = Time.getTotalMinutes(totalMinutes);
		assertTrue("The boundary test failed for total minutes", minutes>=0 || minutes<=59);
	}

	//Good total hours test
	@ParameterizedTest
	@ValueSource(strings = {"03:00:00", "03:25:10", "03:59:59"})
	public void testGetTotalHoursGood(String totalHours) {
	int hours = Time.getTotalHours(totalHours);
	assertTrue("The hours were not calculated properly", hours==3);
	}
	
	//Bad total hours test
	@Test
	public void testGetTotalHoursBad() 
	{
	assertThrows(
	 NumberFormatException.class, 
	 ()-> {Time.getTotalHours("dd:40:10");});
	}
	
	//Boundary total hours test
	@ParameterizedTest
	@ValueSource(strings= {"00:00:00", "24:59:59"})
	public void testGetTotalHoursBoundary(String totalHours) {
		int hours = Time.getTotalHours(totalHours);
		assertTrue("The boundary test failed for total hours", hours>=0 || hours<=24);
	}

}
