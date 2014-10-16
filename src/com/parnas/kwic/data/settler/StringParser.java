package com.parnas.kwic.data.settler;

public class StringParser {

	public StringParser(){
		
	}
	
	public void parseString(String stringToParse){
		String[] parsedString;
		parsedString = stringToParse.split(" ");
		Shift shift = new Shift();
		shift.shiftParsedString(parsedString);
	}
}
