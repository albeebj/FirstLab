package com.parnas.kwic.data.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.parnas.kwic.data.interfaces.InputInterface;

public class FileInput implements InputInterface{
	
	private File file;
	private BufferedReader br;

	public FileInput(String path) throws IOException{
		file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        
        br = new BufferedReader(new FileReader(file));
	}
	

	/**
	 * 从文件中读取一行
	 * @see com.parnas.kwic.data.interfaces.InputInterface#getLine()
	 */
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
		return "nullString";
	}

	/**
	 * 读取整个文件
	 * @see com.parnas.kwic.data.interfaces.InputInterface#getWholeFile()
	 */
	@Override
	public ArrayList<String> getWholeFile() {
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
	        br.close();
	        return shiftedStrings;
	       	
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return shiftedStrings;
	}
	
}
