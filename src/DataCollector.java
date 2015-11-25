import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class DataCollector {

	OpenAndReadFile openAndReadFile;
	private Map<String, SavedData> saves;
	private Utility util = new Utility();

	public DataCollector(OpenAndReadFile fileHandler) {
		this.openAndReadFile = fileHandler;
		saves = new HashMap<>();
	}

	public boolean open(String fileName) {
		return openAndReadFile.openFile(fileName);
	}

	public String read() {
		return openAndReadFile.nextLine();
	}

	public boolean readMore(String string) {
		return openAndReadFile.readMore();
	}

	public void saveData(String string) {

		String[] token = splitString(string);
		saves.put(token[0], new SavedData(token[1], token[2], token[3]));

	}

	private String[] splitString(String string) {
		StringTokenizer tokenizer = new StringTokenizer(string);

		String[] token = new String[4];

		for ( int i = 0; tokenizer.hasMoreElements(); i++ )
			token[ i ] = tokenizer.nextToken();
		if(token.length != 4)
			throw new IllegalArgumentException();
		else
			return token;
	}


	public SavedData getSavedData(String key) {
		return saves.get(key);
	}

}
class SavedData{

	private String operation, firstString, secondString;

	public SavedData(String operation, String firstString, String secondString) {
		this.operation = operation;
		this.firstString = firstString;
		this.secondString = secondString;
	}

	public String getOperation() {
		return operation;
	}

	public Object getFirstString() {
		return firstString;
	}

	public Object getSecondString() {
		return secondString;
	}

}
