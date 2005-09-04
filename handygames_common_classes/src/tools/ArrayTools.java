package tools;

import games.Settings;

import java.util.Vector;

public class ArrayTools {

	/**
	 * Ermittelt die maximale Breite eines Arrays aus dem zweidimensionalen Arrays.
	 * @param array
	 * @return
	 */
	public static int arrayMaxWidth(Object [][] array) {
		int val = 0;
		if (array == null)
			return val;
		for (int i=0; i<array.length;i++) 
			val = Math.max(array[i].length,val);
		return val;
	}
	
	
	public static String getArrayPrint(Object [][] array) {
		String print = "";
		if (array == null)
			return null;
		for (int i=0;i<array.length;i++) {
			print += "\n";
			for (int j = 0; j<array[i].length;j++)
				print += " - "+array[i][j];
		}
		return print;
	}
	
	public static String getArrayPrint(int [][] array) {
		if (array == null)
			return null;
		String res = "";
		for (int i=0; i<array.length;i++) {
			res += "\n";
			for (int j=0;j<array[i].length;j++)
				res += " - "+array[i][j];
		}
		return res;
	}
	
	public static String getArrayPrint(Object [] array) {
		if (array == null)
			return null;
		String result = "";
		for (int i=0; i<array.length;i++)
			result += " - "+array[i];
		
		return result;
	}
	
	public static int [] convertToInt(String [] string) {
		if (string == null)
			return null;
		
		int [] result = new int[string.length];
		for (int i=0; i<result.length;i++)
			result[i] = Integer.parseInt(string[i]);
		
		return result;
	}
	
	public static String [] convertToString(Vector vector) {
		if (vector == null || vector.size() == 0)
			return null;
		String [] string = new String[vector.size()];
		
		for (int i=0; i<string.length;i++) 
			string[i] = (String) vector.elementAt(i);
		
		return string;
	}
	
	public static int [][] convertToIntDim2(String [][] string) {
		if (string == null)
			return null;
		int [][] result = new int[string.length][string[1].length];
		for (int i=0; i<result.length;i++) {
			for (int j=0; j<result[i].length;j++) {
				if (string[i][j] == null)
					result[i][j] = Settings.NOVALUE;
				else
					result[i][j] = Integer.parseInt(string[i][j].trim());
				
			}
		}
		
		return result;
	}
	
	public static String getPrintOf(int [] array) {
		if (array == null)
			return null;
		
		String result = "";
		
		for (int i=0; i<array.length;i++)
			result += " - "+array[i];
		
		return result;
	}
}