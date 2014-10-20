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
	 * ɾ���ļ�
	 * @param sPath
	 */
	public void deleteFile(String sPath) {
		File file = new File(sPath);
		// ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

	
	/**
	 * ��ʼ���������趨�ļ�·��������ļ�����������
	 */
	private void init(String type) {
		
		if(type.equals("fileInput")){
			tempFilePath = "files/temp.txt";
			if (inputFilePath == null)
				inputFilePath = "files/input.txt";
			if (outputFilePath == null)
				outputFilePath = "files/output.txt";
			
			// ���������ͬ���ļ����Ƚ���ɾ��
			deleteFile(outputFilePath);
			deleteFile(tempFilePath);
			
			//��ȡϵͳ���ͣ����û��п����ַ�
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
			
			// ���������ͬ���ļ����Ƚ���ɾ��
			deleteFile(outputFilePath);
			deleteFile(tempFilePath);
			
			//��ȡϵͳ���ͣ����û��п����ַ�
			ConstantsUtil.setCR();
	
			ii = new SocketInput(8000);
			oi = new FileOutput(tempFilePath);
			pi = new StringParser();
			si = new Shift();
		}
	}


	/**
	 * ��ִ�к���
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

	
	/**
	 * �������
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String choice = "";
		Controller controller = new Controller();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(choice != "3"){
			System.out.println("Choose your input: 1)file 2)socket 3)exit");
			System.out.print(">");
			choice =  br.readLine();  //System.in.read();
//			System.out.println(choice);
			if (choice.equals("1")) {
				controller.init("fileInput");
				System.out.println("Your input file path(return for a default file)");
				System.out.print(">");
				br = new BufferedReader(new InputStreamReader(System.in));
				String inPath = br.readLine();
				//û������ȫ�Լ��
				if (inPath == null || inPath.equals("")) {
					System.out.println("Using default files. ./file/input.txt for input; ./file/temp.txt for shifted result; ./file/output.txt for sorted result.");
				} else {
					System.out.println("Your file path and name is: " + inPath);
				}
				controller.execute();
				break;
			} else if (choice.equals("2")) {
				controller.init("socketInput");
				controller.execute();
				break;
			} else if (choice.equals("3")){
				System.out.println("Quited...");
				System.exit(-1);
			} else {
				System.out.println("Bad choice. Abort. Please try again.");
			}
		}
	}

}
