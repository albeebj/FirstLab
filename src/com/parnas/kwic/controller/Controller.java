package com.parnas.kwic.controller;

import java.io.IOException;

import com.parnas.kwic.data.input.FileInput;
import com.parnas.kwic.data.interfaces.InputInterface;
import com.parnas.kwic.data.interfaces.OutputInterface;
import com.parnas.kwic.data.interfaces.ParserInterface;
import com.parnas.kwic.data.interfaces.ShiftInterface;
import com.parnas.kwic.data.output.FileOutput;
import com.parnas.kwic.data.settler.Shift;
import com.parnas.kwic.data.settler.StringParser;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputInterface ii = new FileInput("files/input.txt");
			ParserInterface pi = new StringParser();
			ShiftInterface si = new Shift();
			OutputInterface oi = new FileOutput();
			
			String temp = ii.getLine();
			
			//if temp is not equals to ""
			while(!temp.equals("")){
				oi.wirteDataToFile(si.shiftParsedStringFromRightToLeft(pi.parseString(temp)));
				temp = ii.getLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
