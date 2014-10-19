package com.parnas.kwic.constants;

import java.util.Properties;

public class ConstantsUtil {
	public static String CR;

	/**
	 * 根据当前操作系统设定换行控制字符
	 */
	public static void setCR() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		System.out.println("Your OS is : " + os);
		if (os.startsWith("win") || os.startsWith("Win")) {
			CR = "\r\n";
		} else if (os.startsWith("linux") || os.startsWith("Linux")) {
			CR = "\n";
		} else if (os.startsWith("mac") || os.startsWith("Mac")) {
			CR = "\r";
		}
		CR = "\r\n";
	}

	public static String getCR() {
		return CR;
	}
}
