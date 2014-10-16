package com.parnas.kwic.controller;

import com.parnas.kwic.data.input.FileInput;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInput fi = new FileInput();
		fi.setPath("files/input.txt");
		System.out.println(fi.getFileLineByPath());
	}

}
