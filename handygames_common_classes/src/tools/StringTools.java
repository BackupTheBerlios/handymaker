/*
 * Created on 22.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tools;

import java.util.Vector;

/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StringTools {

	public static String [] split(String string, String deli) {
		Vector splitted = new Vector();
		int laststart = 0;
		int index = 0;
		boolean cont = true;
		while (cont) {
			index = string.indexOf(deli,laststart);
			if (index == -1) {
				cont = false;
				index = string.length();
			}

			String split = string.substring(laststart,index);
			if (laststart != index)
				splitted.addElement(split);
			laststart = index+deli.length();
		}
		
		if (splitted.size() == 0) {
			String [] st = {string};
			return st;
		}
		return ArrayTools.convertToString(splitted);
	}
	
	public static int getMaxWidthOfString(String [] array) {
		int maxwidth = 0;
		for (int i=0; i<array.length;i++)
			maxwidth = Math.max(maxwidth,array[i].length());
		return maxwidth;
	}
}
