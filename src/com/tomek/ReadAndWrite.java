package com.tomek;

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
		// variables
		 String textFromFile = "";
		 String path = "/home/darek/eclipse-workspace/Read&WriteFromFile/sourceFile";
		 
		 ScannerReader scannerReader = new ScannerReader();
		 //textFromFile = scannerReader.read(path);
		 BufferedReaderReader bufferedReaderReader = new BufferedReaderReader();
		 textFromFile = bufferedReaderReader.read("");
	
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
