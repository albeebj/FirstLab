package com.parnas.kwic.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.parnas.kwic.constants.ConstantsUtil;
import com.parnas.kwic.data.input.FileInput;
import com.parnas.kwic.data.input.SocketInput;
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

	public Controller() {
		
	}

//	public Controller(String inFile) {
//		inputFilePath = inFile;
//		init();
//	}
//
//	public Controller(String inFile, String outFile) {
//		inputFilePath = inFile;
//		outputFilePath = outFile;
//		init();
//	}

	/**
	 * 删除文件
	 * @param sPath
	 */
	public void deleteFile(String sPath) {
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

	
	/**
	 * 初始化，包括设定文件路径，清除文件，构建对象
	 */
	public void init(String type) {
		
		if(type.equals("fileInput")){
			tempFilePath = "files/temp.txt";
			if (inputFilePath == null)
				inputFilePath = "files/input.txt";
			if (outputFilePath == null)
				outputFilePath = "files/output.txt";
			
			// 如果存在相同的文件，先进行删除
			deleteFile(outputFilePath);
			deleteFile(tempFilePath);
			
			//获取系统类型，设置换行控制字符
			ConstantsUtil.setCR();
	
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
		else if (type.equals("socketInput")){
			tempFilePath = "files/temp.txt";
			if (outputFilePath == null)
				outputFilePath = "files/output.txt";
			
			// 如果存在相同的文件，先进行删除
			deleteFile(outputFilePath);
			deleteFile(tempFilePath);
			
			//获取系统类型，设置换行控制字符
			ConstantsUtil.setCR();
	
			ii = new SocketInput(8000);
			oi = new FileOutput(tempFilePath);
			pi = new StringParser();
			si = new Shift();
		}
	}


	/**
	 * 主执行函数
	 */
	public void execute() {
		String temp = ii.getLine();

		// if temp is not equals to ""
		while (!temp.equals("")) {
			if(temp.equals("nullString"))
				temp = ii.getLine();
			else {
				oi.wirteDataToFile(si.shiftParsedStringFromRightToLeft(pi
						.parseString(temp)), false);
				temp = ii.getLine();
			}
		}
		oi.wirteDataToFile(temp, true);

		try {
			ii = new FileInput(tempFilePath);
			oi = new FileOutput(outputFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		soi = new AlphaSort(ii.getWholeFile());
		oi.wirteDataToFile(soi.Sort(), true);
		System.out.println("Program finished...");
	}

	

}
