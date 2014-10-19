package com.parnas.kwic.data.output;

import java.io.FileWriter;
import java.io.IOException;

import com.parnas.kwic.data.interfaces.OutputInterface;

public class FileOutput implements OutputInterface{

	private FileWriter writer;
	private String path = "files/test.txt"; //Ä¬ÈÏµÄÂ·¾¶

	public FileOutput(String path){
		this.path = path;
	}
	
	public FileOutput() {
		// TODO Auto-generated constructor stub
	}

	@Override
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
