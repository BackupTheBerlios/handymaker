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
	private Object [][] images = null;
	private Object [][] sounds = null;
	
	private static final String IMAGEROOT = "/images/";
	private static final String SOUNDROOT = "/sound/";
	
	
	/**
	 * 
	 */
	public ResourceLoader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void loadImages(String [] image_desc) {
		images = new Object[image_desc.length][2];
		for (int i=0; i<image_desc.length;i++) {
			images[i][0] = image_desc[i];
			try {
				images[i][1] = Image.createImage(IMAGEROOT+image_desc[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void loadSounds(String [] sound_desc) {
		
		
	}
	
	public Image getImage(String image_desc) {
		for (int i=0; i< images.length;i++) 
			if (image_desc.equals((String) images[i][0]))
				return (Image) images[i][1];

		return null;
	}

	public Object getSound(String name) {
		return null;
	}
	
	public void flushImages() {
		images = null;
		System.gc();
	}

	public void flushSounds() {
		sounds = null;
		System.gc();
	}
	
	public Object[][] getSounds() {
		return sounds;
	}
	
	public Object[][] getImages() {
		return images;
	}
}