/*
 * Created on 04.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gamemachine;

import games.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

import tools.ArrayTools;
import tools.FileReader;

/**
 * Lädt Resourcen wie Images, Sounds etc.
 * 
 * @author Star
 */
public class ResourceLoader {
	private Object [][] soundSets = null;
	
	private Object [][] imageSets = null;
	private Image lastSimpleImage = null;
	private Image[] lastImageArray = null;
	
	public static final String IMAGEROOT = "/media_images/";
	public static final String SOUNDROOT = "/media_sound/";
	public static final String CONFIGS = "/config/";

	
	public Image getLastSimpleImage() {
		return lastSimpleImage;
	}
	
	public Object[] getImageSets() {
		return imageSets;
	}
	
	public Image loadSimpleImage(String image) throws IOException {
		lastSimpleImage = Image.createImage(IMAGEROOT+image);
		return lastSimpleImage;
	}
	
	public Image[] loadImageArray(String [] images) throws IOException {
		lastImageArray = new Image[images.length];
		for (int i=0; i<images.length;i++)
			lastImageArray[i] = Image.createImage(IMAGEROOT+images[i]);
		return lastImageArray;
	}
	
	
	/**
	 * 
	 */
	public ResourceLoader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object[][] loadImageSets(Object [][] imagesets) throws IOException {
		imageSets = new Object[imagesets.length][2];
		for (int i=0; i<imagesets.length; i++) {
			String [][] imageSetDesc = (String [][]) imagesets[i][1];
			int maxlength = ArrayTools.arrayMaxWidth(imageSetDesc);
			Image [][] imageSet = new Image[imageSetDesc.length][maxlength];
			
			for (int animation = 0; animation < imageSetDesc.length;animation++) 
				for (int frame= 0; frame < imageSetDesc[animation].length;frame++) {
					imageSet[animation][frame] = Image.createImage(IMAGEROOT+imageSetDesc[animation][frame]);
				}

			imageSets[i][0] = imagesets[i][0];
			imageSets[i][1] = imageSet;
		}
		return imageSets;
	}
	
	public void loadSounds(Object [][] sound_desc) throws IOException, MediaException {
		soundSets = new Object [sound_desc.length][2];
		for (int i=0; i<sound_desc.length; i++) {
			String [][] sounds = (String [][]) sound_desc[i];
			int maxlength = ArrayTools.arrayMaxWidth(sounds);
			Player [][] soundSet = new Player [sounds.length][maxlength];
			
			for (int j=0; i<sounds.length; j++)
				for (int k=0; k<sounds[i].length; k++) {
					  InputStream is = getClass().getResourceAsStream(SOUNDROOT+ sounds [j][k]);
					  soundSet [j][k] = Manager.createPlayer (is, "audio/x-wav");
				}
			soundSets [i][0] = sound_desc [i][0];
			soundSets [i][1] = soundSet;
			
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
		soundSets = null;
		System.gc();
	}
	
	public void flushResources() {
		flushSounds();
		flushImages();
	}
	
	public Object [] getSounds() {
		return soundSets;
	}

	public Image[][] getLastImageSet(int id) {
		for (int i=0; i<imageSets.length;i++)
			if (((Integer)imageSets[i][0]).intValue() == id)
				return (Image [][]) imageSets[i][1];
		return null;
	}
	
	public Player [][] getSoundSet (int id) {
		for (int i=0; i<soundSets.length; i++)
			if (((Integer)soundSets[i][0]).intValue()==id)
			    return (Player [][]) soundSets [i][1];
		return null;
	}
}