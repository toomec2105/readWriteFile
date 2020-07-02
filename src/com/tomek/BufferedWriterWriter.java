package com.tomek;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterWriter implements WriteProcessor {

	@Override
	public void write(String path, String textFromFile) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path));) {
			writer.write(textFromFile);
			// writer.close(); try with resources will always call it. The resource must
			// implement Closable interface,
			// which has only one method: close();
		} catch (IOException e) {
			System.out.println("An error occurred when trying to write to a file.");
			e.printStackTrace();
		} finally {
			// writer.close(); before java 8 this was the only way to close IO resources
			// now its better to do it with "try with resources": try(BufferedWriter writer
			// = new BufferedWriter(new FileWriter(path));)
		}
	}
}
