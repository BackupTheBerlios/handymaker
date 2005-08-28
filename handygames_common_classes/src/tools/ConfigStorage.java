package tools;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

public class ConfigStorage {
	private String config;
	private String [][] properties = null;
	
	public ConfigStorage(String configFile) throws IOException {
		super();
		
		FileReader fr = new FileReader(configFile);
		config = fr.readFile();
		parseFile();
	}
	
	private void parseFile() {
		String lines [] = StringTools.split(config,";");
		
		properties = new String[lines.length][2];
		
		for (int i=0; i<lines.length;i++) {
			String line [] = StringTools.split(lines[i].trim(),"=");
			properties[i][0] = line[0].trim();
			properties[i][1] = line[1].trim();
		}
	}
	
	public String getStringValue(String property) {
		for (int i=0; i<properties.length;i++) 
			if (properties[i][0].equals(property))
				return properties[i][1];
		return "";
	}
	
	public int getIntValue(String property) {
		return Integer.parseInt(getStringValue(property));
	}
	
	/**
	 * Gibt die Properties für ein indimensionales Array zurück.
	 * @param property
	 * @return
	 */
	public String [] getStringArrayDim1(String property) {
		return StringTools.split(getStringValue(property)," ");
	}
	
	public int [] getIntArrayDim1(String property) {
		return ArrayTools.convertToInt(getStringArrayDim1(property));
	}

	/**
	 * Ist für eine n*n matrix geeignet.
	 * <br>wird die matrix in der datei mit 2,-1,1 3,2,1 2,4 definiert, dann
	 * wird die letzte spalte der letzten zeile mit null aufgefüllt
	 * @param property
	 * @return
	 */
	public String [][] getStringArrayDim2(String property) {
		String prop [] = getStringArrayDim1(property);
		Vector buff = new Vector();
		int max = 0;
		for (int i=0; i<prop.length;i++) {
			String elements[] = StringTools.split(prop[i],",");
			buff.addElement(elements);
			max = Math.max(max,elements.length);
		}
		String res [][] = new String[prop.length][max];
		for (int i=0; i<res.length; i++) {
			String [] elements= (String[]) buff.elementAt(i);
			for (int j=0; j<max;j++) {
				if (j<elements.length) 
					res[i][j] = elements[j];
				else
					res[i][j] = null;
			}
		}
		
		return res;
	}
	
	public int [][] getIntArrayDim2(String property) {
		String [][] prop = getStringArrayDim2(property);
		return ArrayTools.convertToIntDim2(prop);
	}
}