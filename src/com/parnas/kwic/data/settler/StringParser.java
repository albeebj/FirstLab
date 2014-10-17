package com.parnas.kwic.data.settler;

import com.parnas.kwic.data.interfaces.ParserInterface;

public class StringParser implements ParserInterface {

	public StringParser(){
		
	}

	@Override
	public String[] parseString(String stringToParse) {
		// TODO Auto-generated method stub
		String[] parsedString;
		parsedString = stringToParse.split(" ");
		return parsedString;
	}


}
