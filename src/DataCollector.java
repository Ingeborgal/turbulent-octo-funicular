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
		
		checkLength(string);

		String[] token = splitString(string);
		String bitResult = calculateBitwise(token[1], token[2], token[3]);
		int intResult = util.convertFromBinaryToDecimal(bitResult);
		saves.put(token[0], new SavedData(token[1], token[2], token[3], bitResult, intResult));

	}

	private String[] splitString(String string) {
		StringTokenizer tokenizer = new StringTokenizer(string);

		String[] token = new String[4];

		for (int i = 0; tokenizer.hasMoreElements(); i++ )
			token[i] = tokenizer.nextToken();
		
			return token;
	}
	

	public SavedData getSavedData(String key) {
		return saves.get(key);
	}

	public void checkLength(String string) {
		
		if(string.length() != 58)
			throw new IllegalArgumentException();
	}

	public String calculateBitwise(String operaton, String firstString, String secondString) {
		String result = "";
		if(operaton.equals("1"))
			result = util.bitwiseAndOperation(firstString, secondString);
			else if (operaton.equals("2"))
				result = util.bitwiseOrOperation(firstString, secondString);
		
		return result;
	}
}
class SavedData{

	private String operation, firstString, secondString, bitResult;
	private int intResult;

	public SavedData(String operation, String firstString, String secondString, String bitResult, int intResult) {
		this.operation = operation;
		this.firstString = firstString;
		this.secondString = secondString;
		this.bitResult = bitResult;
		this.intResult = intResult;
	}

	public String getOperation() {
		return operation;
	}

	public String getFirstString() {
		return firstString;
	}

	public String getSecondString() {
		return secondString;
	}

	public String getBitResult() {
		return bitResult;
	}
	public int getIntResult(){
		return intResult;
	}
}
