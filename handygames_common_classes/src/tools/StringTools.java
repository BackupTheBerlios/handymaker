/*
 * Created on 22.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tools;

/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StringTools {

	
	
	public static int getMaxWidthOfString(String [] array) {
		int maxwidth = 0;
		for (int i=0; i<array.length;i++)
			maxwidth = Math.max(maxwidth,array[i].length());
		return maxwidth;
	}
}
