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
	        	byte[] textAsBytes = text.getBytes();
	            Files.write(pathToTargetFile, textAsBytes);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    
		
	}

}
