package com.parnas.kwic.data.output;

import java.io.FileWriter;
import java.io.IOException;

import com.parnas.kwic.data.interfaces.OutputInterface;

public class FileOutput implements OutputInterface{

	private FileWriter writer;
	@SuppressWarnings("unused")
	private String path = "files/temp.txt"; //默认的路径

	public FileOutput(String path){
		this.path = path;
		try {
			writer = new FileWriter(path, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public FileOutput() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 将处理过的字符串写入文件
	 * @see com.parnas.kwic.data.interfaces.OutputInterface#wirteDataToFile(java.lang.String)
	 */
	@Override
	public void wirteDataToFile(String content, boolean isFinished){
		try{
			 if (isFinished){
				 writer.write(content); 
				 close();
			 }
			 else
				 writer.write(content);  
			
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
	}
	
	public void close(){
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
