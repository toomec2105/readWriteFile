package com.tomek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class NIOFilesReader implements ReadProcessor {

	@Override
	public String read(String path) {
		List<String> list = null;
		String output = "";
		
		try {
			list = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < list.size(); i++) {
			output += list.get(i) + "\n";
		}
		
		return output;
	}

}
