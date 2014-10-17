/**
 * 
 */
package com.parnas.kwic.data.interfaces;

import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public interface InputInterface {
	
	public String getLine();
	
	public ArrayList<String> getWholeFile(String path);
}
