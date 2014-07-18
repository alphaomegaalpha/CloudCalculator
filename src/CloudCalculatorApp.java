import java.io.Console;

public class CloudCalculatorApp {

	public CloudCalculatorApp() {
	}

	public static void main(String[] args) {
		
		/**
		Console c = System.console();

		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		
		String importFolder = c
				.readLine("Please type in the import folder: ");
		String exportFolder = c
				.readLine("Please type in the export folder: ");
		String fileName = c
				.readLine("Please type in the file name: ");
		**/
		
		String path = "/Users/jkuepper/workspace/CloudCalculator/test/testdata/";
		
		CloudCalculator cc = new CloudCalculator();
		cc.scanFolder(path);
		cc.createImages();
		cc.calculateCloudiness();
		

	}

}
