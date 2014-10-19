package com.parnas.kwic.data.settler;

import java.util.ArrayList;
import java.util.Collections;

import com.parnas.kwic.constants.ConstantsUtil;
import com.parnas.kwic.data.interfaces.SortInterface;

public class AlphaSort implements SortInterface{
	private ArrayList<String> dataString;
	public AlphaSort(ArrayList<String> argString){
		this.dataString = argString;
	}
	
	/**
	 * ���ַ�����������
	 * @see com.parnas.kwic.data.interfaces.SortInterface#Sort()
	 */
	@Override
	public String Sort(){
		//����Java�Դ��ķ�����������
		Collections.sort(dataString);
		String sortedString = "";
		for (int i = 0; i < dataString.size(); i++) {
			sortedString += dataString.get(i) + ConstantsUtil.getCR();
		}
		return sortedString;
	}
}


