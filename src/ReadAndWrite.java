
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ReadAndWrite {

	public static void main(String[] args) {
		// some comment

		String path = "/home/darek/eclipse-workspace/Read&WriteFromFile/sourceFile";

		
// How to add new line to a string---- done
// Extract the first part into method readFileWithScanner----done
// Replace the method with BufferedReader and FileReader----done
		
		 String textFromFile = "";
		textFromFile = readFileWithBufferedReader();
		//textFromFile = readFileWithScanner(path);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("targetFile"));
			writer.write("This is written text" + textFromFile);
			writer.close();

		} catch (IOException e) {
			System.out.println("An error occurred when trying to write to a file.");
			e.printStackTrace();
			
		}
	}
	public static String readFileWithBufferedReader() {
		String textFromFile = ""; 
		try {
				BufferedReader reader = new BufferedReader(new FileReader("sourceFile"));
				String line;

				while( (line = reader.readLine() ) != null) {
				textFromFile += line + "\n";
				}
				reader.close();

			} catch (IOException e) {
				System.out.println("An error occurred when trying to write to a file.");
				e.printStackTrace();
				
			}
		return textFromFile;
	}
	
	public static String readFileWithScanner(String path) {
		String textFromFile = "";
		try {
			
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				textFromFile += scanner.nextLine() + "\n";
				// System.out.println(textFromFile);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred when trying to read a file.");
			e.printStackTrace();
		}
		return textFromFile;
		
	}
}
