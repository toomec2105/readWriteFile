package com.tomek;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterWriter implements WriteProcessor  {
	@Override
	public void write(String path, String textFromFile) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(textFromFile);
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred when trying to write to a file.");
			e.printStackTrace();	
		}
	}
}
