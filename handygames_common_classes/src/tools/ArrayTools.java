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
	
}
