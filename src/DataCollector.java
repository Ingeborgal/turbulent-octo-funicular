
public class DataCollector {

	OpenAndReadFile openAndReadFile;

	public DataCollector(OpenAndReadFile fileHandler) {
		this.openAndReadFile = fileHandler;
	}

	public boolean open(String fileName) {
		return openAndReadFile.openFile(fileName);
	}

	public String read() {
		return openAndReadFile.nextLine();
	}

}
