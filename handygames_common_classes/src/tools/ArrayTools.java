package tools;

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
	
	public static String getArrayPrint(Object [] array) {
		if (array == null)
			return null;
		String result = "";
		for (int i=0; i<array.length;i++)
			result += " - "+array[i];
		
		return result;
	}
	
	
}
