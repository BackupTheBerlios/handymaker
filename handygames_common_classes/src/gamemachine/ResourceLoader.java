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
import javax.microedition.media.Player;

import tools.ArrayTools;

/**
 * Lädt Resourcen wie Images, Sounds etc.
 * 
 * @author Star
 */
public class ResourceLoader {
	private Player [] sounds = null;
	
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

	public void loadImageSets(Object [] imagesets) throws IOException {
		imageSets = new Object[imagesets.length];
		for (int i=0; i<imagesets.length; i++) {
			Image [][] imageSet = null;
			if (imagesets[i] != null) {
				String [][] imageSetDesc = (String [][]) imagesets[i];
				int maxlength = ArrayTools.arrayMaxWidth(imageSetDesc);

				imageSet = new Image[imageSetDesc.length][maxlength]; 
				for (int animation = 0; animation < imageSetDesc.length;animation++) 
					for (int frame= 0; frame < imageSetDesc[animation].length;frame++) {
						imageSet[animation][frame] = Image.createImage(IMAGEROOT+imageSetDesc[animation][frame]);
					}
			}
			imageSets[i] = imageSet;
		}
	}
	
	public void loadSounds(Object [] sound_desc) {
		for (int i=0; i<sound_desc.length; i++) {
			String [] sounds = (String []) sound_desc[i];
			System.out.println(ArrayTools.getArrayPrint(sounds));
			
		}
		
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
	
	public Player [] getSounds() {
		return sounds;
	}

	public Image[][] getImageSet(int id) {
		return (Image [][] )imageSets[id];
	}
}