package com.parnas.kwic.data.settler;

import com.parnas.kwic.data.interfaces.ParserInterface;

public class StringParser implements ParserInterface {

	public StringParser(){
		
	}

	/**
	 * 对句子进行分词
	 * @see com.parnas.kwic.data.interfaces.ParserInterface#parseString(java.lang.String)
	 */
	@Override
	public String[] parseString(String stringToParse) {
		// TODO Auto-generated method stub
		String[] parsedString;
		parsedString = stringToParse.split(" ");
		return parsedString;
	}


}
