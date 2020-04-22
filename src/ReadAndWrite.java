
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ReadAndWrite {

	public static void main(String[] args) {

		String path = "/home/darek/eclipse-workspace/Read&WriteFromFile/sourceFile";

		String textFromFile = "";
// How to add new line to a string
// Extract the first pat into method readFileWithScanner
// Replace the method with BufferedReader and FileReader
		
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				textFromFile += scanner.nextLine();
				// System.out.println(textFromFile);
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred when trying to read a file.");
			e.printStackTrace();
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("targetFile"));
			writer.write("This is written text" + textFromFile);
			writer.close();

		} catch (IOException e) {
			System.out.println("An error occurred when trying to write to a file.");
			e.printStackTrace();
			
		}
	}
}
