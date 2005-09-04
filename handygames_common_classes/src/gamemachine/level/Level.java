package gamemachine.level;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

import tools.ArrayTools;
import tools.ConfigStorage;

import gamemachine.ResourceLoader;
import games.Settings;

public class Level {
	private ResourceLoader resourceLoader = null;
	
	public int nr = 0;
	
	public String desc = null;	
	public Object [][] imagesToLoad = null;
	public Object [][] soundsToLoad = null;
	
	private ConfigStorage configStorage = null;
	
	public boolean isLoading() {
		return false;
	}
	
	public Object [] getImageSets() {
		return resourceLoader.getImageSets();
	}
	
	public Image[][] getImageSet(int id) {
		return resourceLoader.getLastImageSet(id);
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
	
	public int getNr() {
		return nr;
	}
	
	public Level(int nr, String desc, Object [][] imagesToLoad, Object [][] soundsToLoad) {
		this.nr = nr;
		this.desc = desc;
		this.imagesToLoad = imagesToLoad;
		this.soundsToLoad = soundsToLoad;
	}
	
	public void activateLevel() throws IOException, MediaException {
		resourceLoader = new ResourceLoader();

		resourceLoader.loadImageSets(imagesToLoad);
		resourceLoader.loadSounds(soundsToLoad);
		loadLevelConfig();
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
		resourceLoader = null;
		configStorage = null;
		
		System.gc();
	}
	
	public String getLevelStringValue(String property) {
		return configStorage.getStringValue(property);
	}
	
	public int getLevelIntValue(String property) {
		return configStorage.getIntValue(property);
	}
	
	public int [] getLevelIntArrayDim1(String property) {
		return configStorage.getIntArrayDim1(property);
	}
	
	public int [][] getLevelIntArrayDim2(String property) {
		return configStorage.getIntArrayDim2(property);
	}
	
	private void loadLevelConfig() throws IOException {
		configStorage  = new ConfigStorage(Settings.LEVELPREFIX+getNr()+Settings.LEVELSUFFIX);
	}
}