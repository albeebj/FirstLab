package com.parnas.kwic.data.settler;

import com.parnas.kwic.constants.ConstantsUtil;
import com.parnas.kwic.data.interfaces.ShiftInterface;

public class Shift implements ShiftInterface{

	public Shift(){
		
	}
	
	/**
	 * 以字为单位进行循环移位 
	 * @see com.parnas.kwic.data.interfaces.ShiftInterface#shiftParsedStringFromRightToLeft(java.lang.String[])
	 */
	@Override
	public String shiftParsedStringFromRightToLeft(String[] parsedString){
		
		String tmp;
		String stringToWrite = "";
		int length = parsedString.length;
		
		for(int i = 0; i<length; i++){
			if(i == length -1)
				stringToWrite += parsedString[i] + ConstantsUtil.getCR();
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
			stringToWrite += parsedString[length-1] + ConstantsUtil.getCR();
		}
		
		return stringToWrite;
	}
}
