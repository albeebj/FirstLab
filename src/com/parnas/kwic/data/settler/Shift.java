package com.parnas.kwic.data.settler;

import com.parnas.kwic.data.output.FileOutput;

public class Shift {

	public Shift(){
		
	}
	
	public void shiftParsedString(String[] parsedString){
		
		String tmp;
		String stringToWrite = "";
		int length = parsedString.length;
		
		for(int i = 0; i<length; i++){
			if(i == length -1)
				stringToWrite += parsedString[i] + "\n";
			else
				stringToWrite += parsedString[i] + " ";
		}
		
		FileOutput fop = new FileOutput();
		System.out.println(stringToWrite);
		fop.wirteDataToFile(stringToWrite);
		
		for(int i = 0; i<length-1; i++){
			stringToWrite = "";
			tmp = parsedString[0];
			for(int j = 0; j<length-1; j++){
				parsedString[j] = parsedString[j+1];
				stringToWrite += parsedString[j] + " ";
			}
			parsedString[length-1] = tmp;
			stringToWrite += parsedString[i] + "\n";
			System.out.println(stringToWrite);
			fop.wirteDataToFile(stringToWrite);
		}
	}
}
