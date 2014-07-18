import java.io.Console;


public class CloudCalculatorApp {

	public CloudCalculatorApp() {
	}

	public static void main(String[] args) {
		
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
		
		CloudCalculator cc = new CloudCalculator();
		

	}

}
