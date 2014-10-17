package com.parnas.kwic.data.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.parnas.kwic.data.interfaces.InputInterface;

public class FileInput implements InputInterface{
	
	private String path;
	private BufferedReader br;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public FileInput(String path) throws IOException{
		File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        
        br = new BufferedReader(new FileReader(file));
	}
	

	@Override
	public String getLine() {
		
		String temp=null;
		
		try{
	        
	        temp = br.readLine();
	        
	        //if temp not bull and not equals to "\n"
	        if(temp!=null && !temp.equals(""))
	            return temp;
	        else if(temp == null){
	       		br.close();
	       		return "";
	        }
	       	
		}
		catch(IOException e){
			e.printStackTrace();
			return "Faild";
		}
		return "";
	}

	@Override
	public ArrayList<String> getWholeFile(String path) {
		// TODO Auto-generated method stub
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList<String> shiftedStrings = new ArrayList();
		String temp=null;
		
		try{
	        
	        temp = br.readLine();
	        //if temp not bull and not equals to "\n"
	        while(temp!=null && !temp.equals("")){
	        	shiftedStrings.add(temp);
	        	temp = br.readLine();
	        }
	        
	        return shiftedStrings;
	       	
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return shiftedStrings;
	}
	
}
