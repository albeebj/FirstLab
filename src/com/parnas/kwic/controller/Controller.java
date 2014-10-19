package com.parnas.kwic.controller;

import java.io.IOException;

import com.parnas.kwic.data.input.FileInput;
import com.parnas.kwic.data.interfaces.InputInterface;
import com.parnas.kwic.data.interfaces.OutputInterface;
import com.parnas.kwic.data.interfaces.ParserInterface;
import com.parnas.kwic.data.interfaces.ShiftInterface;
import com.parnas.kwic.data.interfaces.SortInterface;
import com.parnas.kwic.data.output.FileOutput;
import com.parnas.kwic.data.settler.AlphaSort;
import com.parnas.kwic.data.settler.Shift;
import com.parnas.kwic.data.settler.StringParser;

public class Controller {
	private String inputFilePath;
	private String outputFilePath;
	private String tempFilePath;
	
	private InputInterface ii;
	private ParserInterface pi;
	private ShiftInterface si;
	private OutputInterface oi;
	private SortInterface soi;
	
	public Controller(){
		init();
	}
	
	public Controller(String inFile){
		inputFilePath = inFile;
		init();
	}
	
	public Controller(String inFile, String outFile){
		inputFilePath = inFile;
		outputFilePath = outFile;
		init();
	}
	
	private void init(){
		tempFilePath = "files/test.txt";
		if (inputFilePath == null)
			inputFilePath = "files/input.txt";
		if (outputFilePath == null)
			outputFilePath = "files/output.txt";
		
		try {
			ii = new FileInput(inputFilePath);
			oi = new FileOutput(tempFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pi = new StringParser();
		si = new Shift();
	}
	
	public void execute(){
		String temp = ii.getLine();
		
		//if temp is not equals to ""
		while(!temp.equals("")){
			oi.wirteDataToFile(si.shiftParsedStringFromRightToLeft(pi.parseString(temp)));
			temp = ii.getLine();
		}
		
		try {		
			ii = new FileInput(tempFilePath);
			oi = new FileOutput(outputFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		soi = new AlphaSort(ii.getWholeFile());
		oi.wirteDataToFile(soi.Sort());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 未完成：添加对参数的支持
		Controller controller = new Controller();
		controller.execute();
	}

}
