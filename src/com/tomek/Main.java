package com.tomek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	
	// fields
	 private static String path = "/home/darek/eclipse-workspace/Read&WriteFromFile/sourceFile";
	 private static String targetFile = "/home/darek/eclipse-workspace/Read&WriteFromFile/targetFile";
	public static void main(String[] args) {
		
		// creating an array of interface type which will store objects of classes implementing this interface 
		
		WriteProcessor[] writers =  new WriteProcessor[2];  
		writers[0] = new NIOFilesWriter();
		writers[1] = new BufferedWriterWriter();
		
		for (int i = 0; i < writers.length; i++) {
			String pathAsString = "arrayTest" + i ;
			String text = writers[i].getClass().getSimpleName(); 
			try {
				OutputStream out = Files.newOutputStream(Paths.get(pathAsString));
				writers[i].write(pathAsString, text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//WriteProcessor writer1 = new WriteProcessor(); Cannot instantiate the type WriteProcessor = i can't create an object from an interface
				//[new BufferedWriterWriter()];
				
		
		//------------ calls to generic readFromAndWriteToFile_GENERIC ----------------------
		
		/*
		 * readFromAndWriteToFile_GENERIC(path, targetFile, new BufferedReaderReader(),
		 * new NIOFilesWriter()); readFromAndWriteToFile_GENERIC(targetFile, targetFile,
		 * new BufferedReaderReader(), new BufferedWriterWriter());
		 * readFromAndWriteToFile_GENERIC(targetFile, targetFile, new ScannerReader(),
		 * new NIOFilesWriter()); readFromAndWriteToFile_GENERIC(targetFile, targetFile,
		 * new ScannerReader(), new BufferedWriterWriter());
		 * 
		 */
		
	
		
		
		//------------ calls to generic readFromAndWriteToFile_GENERIC using anonymous classes----------------------
		
		ReadProcessor anonymousClassImplementingReadProcessor = new ReadProcessor() {
			@Override
			public String read(String path) {
				String textFromFile = ""; 
				try {
						BufferedReader reader = new BufferedReader(new FileReader(path));
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
		};
		
	
		WriteProcessor anonymousClassImplementingWriteProcessor = new WriteProcessor() {
			
			@Override
			public void write(String targetFile, String text) {
				try {
		        	Path pathToTargetFile = Paths.get(targetFile); // old java.io has similar class File(String pathToFile)	        	
		        	byte[] textAsBytes = text.getBytes();
		            Files.write(pathToTargetFile, textAsBytes);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }				
			}
		};
		
		String textFromFile = anonymousClassImplementingReadProcessor.read(path);
		anonymousClassImplementingWriteProcessor.write(targetFile, textFromFile);
		
		
		//------------ calls to non-generic readFromAndWriteToFile ----------------------
		

		/*
		 * readFromAndWriteToFile(path, targetFile, new BufferedReaderReader(), new
		 * NIOFilesWriter()); readFromAndWriteToFile(targetFile, targetFile, new
		 * BufferedReaderReader(), new BufferedWriterWriter());
		 * readFromAndWriteToFile(targetFile, targetFile, new ScannerReader(), new
		 * NIOFilesWriter()); readFromAndWriteToFile(targetFile, targetFile, new
		 * ScannerReader(), new BufferedWriterWriter());
		 */
	}
	
	
	
	//------------generic readFromAndWriteToFile ----------------------

	
	public static void readFromAndWriteToFile_GENERIC(String sourceFile, String targetFile, ReadProcessor reader, WriteProcessor writer) {
		System.out.println("Calling a generic method");
		String text = reader.read(sourceFile);
		text += " " + reader.getClass().getSimpleName() + " with " + writer.getClass().getSimpleName(); 
		writer.write(targetFile, text);		
	}
	
	//------------ non-generic readFromAndWriteToFile ----------------------
	
	
	public static void readFromAndWriteToFile(String sourceFile, String targetFile, BufferedReaderReader reader, NIOFilesWriter writer) {
		System.out.println("Calling a non-generic method");

		String text = reader.read(sourceFile);
		text += " " + reader.getClass().getSimpleName() + " with " + writer.getClass().getSimpleName(); 
		writer.write(targetFile, text);		
	}
	public static void readFromAndWriteToFile(String sourceFile, String targetFile, ScannerReader reader, BufferedWriterWriter writer) {
		String text = reader.read(sourceFile);
		text += " " + reader.getClass().getSimpleName() + " with " + writer.getClass().getSimpleName(); 
		writer.write(targetFile, text);
	}
	public static void readFromAndWriteToFile(String sourceFile, String targetFile, ScannerReader reader, NIOFilesWriter writer) {
		String text = reader.read(sourceFile);
		text += " " + reader.getClass().getSimpleName() + " with " + writer.getClass().getSimpleName(); 
		writer.write(targetFile, text);
	}
	public static void readFromAndWriteToFile(String sourceFile, String targetFile, BufferedReaderReader reader, BufferedWriterWriter writer) {
		String text = reader.read(sourceFile);
		text += " " + reader.getClass().getSimpleName() + " with " + writer.getClass().getSimpleName(); 
		writer.write(targetFile, text);
	}
}
