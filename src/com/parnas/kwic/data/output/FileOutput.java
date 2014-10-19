package com.parnas.kwic.data.output;

import java.io.FileWriter;
import java.io.IOException;

import com.parnas.kwic.data.interfaces.OutputInterface;

public class FileOutput implements OutputInterface{

	private FileWriter writer;
	private String path = "files/test.txt"; //默认的路径

	public FileOutput(String path){
		this.path = path;
	}
	
	public FileOutput() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 将处理过的字符串写入文件
	 * @see com.parnas.kwic.data.interfaces.OutputInterface#wirteDataToFile(java.lang.String)
	 */
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
