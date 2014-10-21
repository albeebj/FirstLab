/**
 * 
 */
package com.parnas.kwic.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.parnas.kwic.controller.Controller;

/**
 * @author Administrator
 *
 */
public class MainEntry {
	/**
	 * 程序入口
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
				//没有做安全性检测
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
