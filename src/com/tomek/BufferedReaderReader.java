package com.tomek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderReader implements ReadProcessor {

	@Override
	public String read(String path) {
		String textFromFile = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(path));) { // reader.close() will always be
																					// called
			String line;

			while ((line = reader.readLine()) != null) {
				textFromFile += line + "\n";
			}

		} catch (IOException e) {
			System.out.println("An error occurred when trying to write to a file.");
			e.printStackTrace();
		}

		return textFromFile;
	}

}
