import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
//Krav, datainnsamlingsklassen:

//Vi skal kunne finne ut om det er mer data å lese
//Når ei linje med måledata leses, skal følgende skje:
// Måledata id skal brukes som nøkkel for lagring og gjenfinning av bearbeidede måledata i en passende Java collection klasse
// Feil antall argumenter skal kaste en exception
// Operasjon (bitwise OR eller AND) skal utføres på måledata (bearbeidingen)
// Originale måledata samt resultat av operasjon (bearbeidede måledata) skal lagres, både som bitstrenger og int verdier, og skal kunne gjenfinnes ved hjelp av måledata id
// Vi skal logge data med duplikate måledata-id, samt måledata med feil bitoperasjon (alt annet enn 1 eller 2 er å anse som en feil), dette skjer på enkleste måte ved at hele tekstlinja som er lest lagres unna i en liste (en pasende Java Collection klasse)
public class DataCollectorTest {
	private Utility util = new Utility();
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
	}
	@Test
	public void read_readFromFile_assertEquals(){
		when(fileHandler.nextLine()).thenReturn("a6c4 1 100010000010000100000001 100010000010000100000001");
		assertEquals("a6c4 1 100010000010000100000001 100010000010000100000001", dataCollector.read());
	}
	@Test
	public void readMoreFromFile(){
		when(fileHandler.readMore()).thenReturn("a6c4 1 100010000010000100000001 100010000010000100000001");
		assertEquals("a6c4 1 100010000010000100000001 100010000010000100000001", dataCollector.readMore);
	}
	


}
