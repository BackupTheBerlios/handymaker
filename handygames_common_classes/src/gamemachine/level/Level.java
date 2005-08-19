package gamemachine.level;

import javax.microedition.lcdui.Image;

import gamemachine.ResourceLoader;

public class Level {
	private ResourceLoader resourceLoader = null;
	
	public int nr = 0;
	
	public String desc = null;	
	public String [] imagesToLoad = null;
	public String [] soundsToLoad = null;
	
	
	public String [] getImageDesc() {
		return imagesToLoad;
	}
	
	public String [] getSoundDesc() {
		return soundsToLoad;
	}
	
	/**
	 * Gibt ein zweidimensionales Array vom Typ Object zurück.
	 * <br>object[0][0] = <filename>
	 * <br>object[0][1] = <Image>
	 * @return
	 */
	public Object [][] getImages() {
		return resourceLoader.getImages();
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
	
	public Level(int nr, String desc, String [] imagesToLoad, String [] soundsToLoad, ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		this.nr = nr;
		this.desc = desc;
		this.imagesToLoad = imagesToLoad;
		this.resourceLoader = resourceLoader;
	}
	
	public void activateLevel() {
		resourceLoader.loadImages(imagesToLoad);
		resourceLoader.loadSounds(soundsToLoad);
		
	}

	public Image getImageByName(String name) {
		return resourceLoader.getImage(name);
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
	
	public void passivateLevel() {
		
	}	
}