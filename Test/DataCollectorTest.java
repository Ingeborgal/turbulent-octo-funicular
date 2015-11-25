import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
//Krav, datainnsamlingsklassen:


//Når ei linje med måledata leses, skal følgende skje:
// Originale måledata samt resultat av operasjon (bearbeidede måledata) skal lagres, både som bitstrenger og int verdier, og skal kunne gjenfinnes ved hjelp av måledata id
// Vi skal logge data med duplikate måledata-id, samt måledata med feil bitoperasjon (alt annet enn 1 eller 2 er å anse som en feil), dette skjer på enkleste måte ved at hele tekstlinja som er lest lagres unna i en liste (en pasende Java Collection klasse)
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
	public void calculateBitwise_bitwiseOrOperation(){
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
}
