package tools;

import gamemachine.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {
	private String filename = "";
	
	public FileReader(String filename) {
		this.filename = filename;
	}

	public String readFile() throws IOException {
		InputStream file = getClass().getResourceAsStream(filename);
		StringBuffer result = new StringBuffer();
		int read = 0;
		
		do {
			read = file.read();
			if (read != -1)
				result.append((char)read);
		} while (read != -1);
		
		file.close();
		
		return result.toString();
	}
}
