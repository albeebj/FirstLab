package com.parnas.kwic.data.settler;

import java.util.ArrayList;
import java.util.Collections;

public class AlphaSort {
	private ArrayList<String> dataString;
	public AlphaSort(ArrayList<String> argString){
		this.dataString = argString;
	}
	
	public String Sort(){
		//调用Java自带的方法进行排序
		Collections.sort(dataString);
		String sortedString = "";
		for (int i = 0; i < dataString.size(); i++) {
			sortedString += dataString.get(i) + "\n";
		}
		return sortedString;
	}
}


