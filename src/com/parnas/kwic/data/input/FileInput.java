package com.parnas.kwic.data.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.parnas.kwic.data.settler.StringParser;

public class FileInput {
	
	private String path;
	private StringParser parse;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public FileInput(){
		
	}
	
	@SuppressWarnings("resource")
	public boolean getFileLineByPath(){
		
		String temp=null;
		parse = new StringParser();
		
		try{
			File file=new File(path);
	        if(!file.exists()||file.isDirectory())
	            throw new FileNotFoundException();
	        
	        BufferedReader br=new BufferedReader(new FileReader(file));
	        
	        temp=br.readLine();
	        
	        //if temp not bull and not equals to "\n"
	        while(temp!=null && !temp.equals("\n")){
	        	parse.parseString(temp);
	            temp=br.readLine();
	        }
	        br.close();
	        return true;
		}
		catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	
}
