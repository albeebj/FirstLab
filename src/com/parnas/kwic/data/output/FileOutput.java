package com.parnas.kwic.data.output;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {

	private FileWriter writer;
	private String path = "files/test.txt";
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public FileOutput(){
		
	}
	
	public void wirteDataToFile(String content){
		try{
			writer = new FileWriter(path, true);  
			writer.write(content);  
			writer.close();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
	}
}
