package invadersound;

import javax.microedition.media.Player;

import sound.SoundMachine;
import gameworld.Entity;
import gamemachine.*;
import gamemachine.level.Level;

public class InvaderSoundMachine extends SoundMachine {
	
	private GameMachine gm = null;
	private Level level =null;
	
    public InvaderSoundMachine (GameMachine g) {
    	gm =g; 
    }
	public void playfromResource (Entity e) {
		int soundSetID = e.getSoundSet();
		int soundID    = e.getSoundNumber();
	    level = gm.getCurrLevel();
		Player [][] player = level.getSounds(e.getSoundSet());
	}
}
