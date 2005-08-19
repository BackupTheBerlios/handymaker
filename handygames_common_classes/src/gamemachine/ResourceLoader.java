/*
 * Created on 04.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gamemachine;

import java.io.IOException;
import java.util.Vector;

import javax.microedition.lcdui.Image;

/**
 * Lädt Resourcen wie Images, Sounds etc.
 * 
 * @author Star
 */
public class ResourceLoader {
	private Object [][] sounds = null;
	
	private Object [] imageSets = null;
	
	private static final String IMAGEROOT = "/images/";
	private static final String SOUNDROOT = "/sound/";
	
	
	public Object[] getImageSets() {
		return imageSets;
	}
	
	/**
	 * 
	 */
	public ResourceLoader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object [] loadImageSets(Object [] imagesets) throws IOException {
		Object [] result = new Object[imagesets.length];
		for (int i=0; i<imagesets.length; i++) {
			Image [][] imageSet = null;
			if (imagesets[i] != null) {
				String [][] imageSetDesc = (String [][]) imagesets[i];
				
				imageSet = new Image[imageSetDesc.length][imageSetDesc[1].length]; 
				for (int animation = 0; animation < imageSetDesc.length;animation++) 
					for (int frame = 0; frame < imageSetDesc[1].length;frame++) {
						System.out.println(IMAGEROOT+imageSetDesc[animation][frame]);
						imageSet[animation][frame] = Image.createImage(IMAGEROOT+imageSetDesc[animation][frame]);
					}
			}
			result[i] = imageSet;
		}
		
		return result;
	}
	
	public void loadSounds(String [] sound_desc) {
		
		
	}
	
	public Object getSound(String name) {
		return null;
	}
	
	public void flushImages() {
		imageSets = null;
		System.gc();
	}

	public void flushSounds() {
		sounds = null;
		System.gc();
	}
	
	public void flushResources() {
		flushSounds();
		flushImages();
	}
	
	public Object[][] getSounds() {
		return sounds;
	}

}