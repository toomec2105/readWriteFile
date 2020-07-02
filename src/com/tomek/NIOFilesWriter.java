package com.tomek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOFilesWriter implements WriteProcessor{

	@Override
	public void write(String targetFile, String text) {

	        try {
	        	Path pathToTargetFile = Paths.get(targetFile); // old java.io has similar class File(String pathToFile)	            
	        	
	        	
	        	// 1
	        	// The method ensures that the file is closed when all lines have been written (or an I/O error or other runtime exception is thrown).
	            // Files.write(pathToTargetFile, text);  will not work: it needs Iterable<CharSequence> so for example String[] or ArrayList<String>
	           
	            // 2
	            byte[] textAsBytes = text.getBytes(); //more complicated
	            Files.write(pathToTargetFile, textAsBytes);
	            
	        	//3
	            // Files.writeString(pathToTargetFile, text); java 11
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    
		
	}

}
