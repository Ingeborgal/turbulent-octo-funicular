import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DataCollectorTest {
	private DataCollector dataCollector;
	private OpenAndReadFile fileHandler;

	@Before
	public void setUp() {
		fileHandler = mock(OpenAndReadFile.class);
		dataCollector = new DataCollector(fileHandler);
	}
	@Test
	public void open_openAndReadFile_assertTrue(){
		when(fileHandler.openFile("file.txt")).thenReturn(true);
		assertTrue(dataCollector.open("file.txt"));
		verify(fileHandler, times(1)).openFile("file.txt");
	}
	@Test
	public void read_readNexLineFromFile_assertEquals(){
		when(fileHandler.nextLine()).thenReturn("a6c4 1 100010000010000100000001 100010000010000100000001");
		assertEquals("a6c4 1 100010000010000100000001 100010000010000100000001", dataCollector.read());
		verify(fileHandler, times(1)).nextLine();
	}
	@Test
	public void readMore_CheckIfThereIsMoreToReadInFile_assertTrue(){
		when(fileHandler.readMore()).thenReturn(true);
		assertTrue(dataCollector.readMore("file.txt"));
		verify(fileHandler, times(1)).readMore();
	}
	@Test
	public void getSavedData_getOperation_assertEquals(){
		String string1 = "100010000010000100000001";
		String string2 = "100010010010000101001001";
		dataCollector.saveData("b86d4a 2 " + string1 + " " + string2);
		assertEquals("2", dataCollector.getSavedData("b86d4a").getOperation());
	}
	@Test
	public void getSavedData_getFirstString_assertEquals(){
		String string1 = "100010000010000100000001";
		String string2 = "100010010010000101001001";
		dataCollector.saveData("b86d4a 2 " + string1 + " " + string2);
		assertEquals(string1, dataCollector.getSavedData("b86d4a").getFirstString());
	}
	@Test
	public void getSavedData_getSecondString_assertEquals(){
		String string1 = "100010000010000100000001";
		String string2 = "100010010010000101001001";
		dataCollector.saveData("b86d4a 2 " + string1 + " " + string2);
		assertEquals(string2, dataCollector.getSavedData("b86d4a").getSecondString());
	}

	@Test (expected = IllegalArgumentException.class)
	public void checkLength_checkThatTheLengthOFSTringIs58_ThrowsIllegalArgumentException(){
		String string1 = "b86d4a 1 1 100010000010000100000001 100010000010000100000001";
		dataCollector.checkLength(string1);
	}
	@Test
	public void calculateBitwise_bitwiseOrOperation_assertEquals(){
		String bitwiseString1 = "111111111111111111111111";
		String bitwiseString2 = "000000000000000000000000";
		assertEquals("111111111111111111111111", dataCollector.calculateBitwise("2", bitwiseString1, bitwiseString2));
	}
	@Test
	public void calculateBitwise_bitwiseAndOperation(){
		String bitwiseString1 = "111111111111111111111111";
		String bitwiseString2 = "000000000000000000000000";
		assertEquals("000000000000000000000000", dataCollector.calculateBitwise("1", bitwiseString1, bitwiseString2));
	}
	@Test
	public void getSavedData_getIntResult_assertEquals(){
		String string1 = "100010000010000100000001";
		String string2 = "100010010010000101001001";
		dataCollector.saveData("b86d4a 2 " + string1 + " " + string2);
		assertEquals(9602193, dataCollector.getSavedData("b86d4a").getIntResult());
	}
	@Test
	public void getSavedData_getBitResult_assertEquals(){
		String string1 = "100010000010000100000001";
		String string2 = "100010010010000101001001";
		dataCollector.saveData("b86d4a 2 " + string1 + " " + string2);
		assertEquals("100100101000010010010001", dataCollector.getSavedData("b86d4a").getBitResult());
	}
	@Test(expected = IllegalArgumentException.class)
	public void getErrorLog_wrongOperator_assertEquals(){
		String string1 = "100010000010000100000001";
		String string2 = "100010010010000101001001";
		dataCollector.saveData("b86d4a 4 " + string1 + " " + string2);
	}
	@Test
	public void saveData_duplicateHexaKeys_assertEquals(){
		String string1 = "b86d4a 1 100010000010000100000001 100010000010000100000001";
		String string2 = "b86d4a 1 100010000010000100000001 100010000010000100000001";
		dataCollector.saveData(string1);
		dataCollector.saveData(string2);
		assertEquals(8422417, dataCollector.getDuplicates().get(0).getIntResult());
	}
}
