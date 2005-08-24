package gamemachine.level;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

import gamemachine.ResourceLoader;

public class Level {
	private ResourceLoader resourceLoader = null;
	
	public int nr = 0;
	
	public String desc = null;	
	public Object [][] imagesToLoad = null;
	public Object [][] soundsToLoad = null;
	
	public boolean isLoading() {
		return false;
	}
	
	public Object [] getImageSets() {
		return resourceLoader.getImageSets();
	}
	
	public Image[][] getImageSet(int id) {
		return resourceLoader.getImageSet(id);
	}
	
	public Object [] getImageDesc() {
		return imagesToLoad;
	}
	
	public Object [][] getSoundDesc() {
		return soundsToLoad;
	}
	
	/**
	 * Gibt ein zweidimensionales Array vom Typ Object zurück.
	 * <br>object[0][0] = <filename>
	 * <br>object[0][1] = <Sound>
	 * @return
	 */
	public Player [][] getSounds(int id) {
		return resourceLoader.getSoundSet(id);
	}
	
	public Level(int nr, String desc, Object [][] imagesToLoad, Object [][] soundsToLoad, ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		this.nr = nr;
		this.desc = desc;
		this.imagesToLoad = imagesToLoad;
		this.resourceLoader = resourceLoader;
		this.soundsToLoad = soundsToLoad;
	}
	
	public void activateLevel() throws IOException, MediaException {
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