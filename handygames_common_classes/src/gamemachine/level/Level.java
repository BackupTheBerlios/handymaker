package gamemachine.level;

import java.io.IOException;

import javax.microedition.lcdui.Image;

import gamemachine.ResourceLoader;

public class Level {
	private ResourceLoader resourceLoader = null;
	
	public int nr = 0;
	
	public String desc = null;	
	public Object [] imagesToLoad = null;
	public String [] soundsToLoad = null;
	
	public Object [] getImageSets() {
		return resourceLoader.getImageSets();
	}
	
	public Image[][] getImageSet(int id) {
		return resourceLoader.getImageSet(id);
	}
	
	public Object [] getImageDesc() {
		return imagesToLoad;
	}
	
	public String [] getSoundDesc() {
		return soundsToLoad;
	}
	
	/**
	 * Gibt ein zweidimensionales Array vom Typ Object zurück.
	 * <br>object[0][0] = <filename>
	 * <br>object[0][1] = <Sound>
	 * @return
	 */
	public Object [][] getSounds() {
		return resourceLoader.getSounds();
	}
	
	public Level(int nr, String desc, Object [] imagesToLoad, String [] soundsToLoad, ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		this.nr = nr;
		this.desc = desc;
		this.imagesToLoad = imagesToLoad;
		this.resourceLoader = resourceLoader;
	}
	
	public void activateLevel() throws IOException {
		resourceLoader.loadImageSets(imagesToLoad);
		
		resourceLoader.loadSounds(soundsToLoad);
	}
		
	public Object getSoundByName(String name) {
		return resourceLoader.getSound(name);
	}
	
	public void flushSounds() {
		resourceLoader.flushSounds();
	}
	
	public void flushImages() {
		resourceLoader.flushImages();
	}
	
	public void flushResources() {
		resourceLoader.flushResources();
	}	
}