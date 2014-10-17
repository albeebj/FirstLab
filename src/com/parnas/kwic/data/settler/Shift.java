package com.parnas.kwic.data.settler;

import com.parnas.kwic.data.interfaces.ShiftInterface;

public class Shift implements ShiftInterface{

	public Shift(){
		
	}
	
	@Override
	public String shiftParsedStringFromRightToLeft(String[] parsedString){
		
		String tmp;
		String stringToWrite = "";
		int length = parsedString.length;
		
		for(int i = 0; i<length; i++){
			if(i == length -1)
				stringToWrite += parsedString[i] + "\n";
			else
				stringToWrite += parsedString[i] + " ";
		}
		
		
		
		for(int i = 0; i<length-1; i++){
			tmp = parsedString[0];
			for(int j = 0; j<length-1; j++){
				parsedString[j] = parsedString[j+1];
				stringToWrite += parsedString[j] + " ";
			}
			parsedString[length-1] = tmp;
			stringToWrite += parsedString[length-1] + "\n";
		}
		
		return stringToWrite;
	}
}
