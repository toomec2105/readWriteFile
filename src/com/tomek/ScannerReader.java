package com.tomek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReader implements ReadProcessor {

	
	public String read(String path) {
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
