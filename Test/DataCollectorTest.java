import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
//Krav, datainnsamlingsklassen:


//N�r ei linje med m�ledata leses, skal f�lgende skje:
// Feil antall argumenter skal kaste en IllegalArgumentexception
// Operasjon (bitwise OR eller AND) skal utf�res p� m�ledata (bearbeidingen)
// Originale m�ledata samt resultat av operasjon (bearbeidede m�ledata) skal lagres, b�de som bitstrenger og int verdier, og skal kunne gjenfinnes ved hjelp av m�ledata id
// Vi skal logge data med duplikate m�ledata-id, samt m�ledata med feil bitoperasjon (alt annet enn 1 eller 2 er � anse som en feil), dette skjer p� enkleste m�te ved at hele tekstlinja som er lest lagres unna i en liste (en pasende Java Collection klasse)
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
	public void wrongArgument_throwsException(){
		String string1 = "100010000010000100000001";
		String string2 = "100010010010000101001001";
		dataCollector.saveData("b86d4a2 1 " + string1 + " " + string2);
		
	}


}
