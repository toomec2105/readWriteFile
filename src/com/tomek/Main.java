package com.tomek;

public class Main {
	
	// fields
	 private static String path = "/home/darek/eclipse-workspace/Read&WriteFromFile/sourceFile";
	 private static String targetFile = "/home/darek/eclipse-workspace/Read&WriteFromFile/targetFile";
	 	 
	public static void main(String[] args) {
				
		readFromAndWriteToFile(path, targetFile, new BufferedReaderReader(), new NIOFilesWriter());
		readFromAndWriteToFile(targetFile, targetFile, new BufferedReaderReader(), new BufferedWriterWriter());
		readFromAndWriteToFile(targetFile, targetFile, new ScannerReader(), new NIOFilesWriter());	
		readFromAndWriteToFile(targetFile, targetFile, new ScannerReader(), new BufferedWriterWriter());
		
	}
	
	public static void readFromAndWriteToFile(String sourceFile, String targetFile, BufferedReaderReader reader, NIOFilesWriter writer) {
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
