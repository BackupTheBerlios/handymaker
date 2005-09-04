package sound;

import gamemachine.GameMachine;
import gamemachine.level.Level;
import gameworld.Entity;

import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

public abstract class  SoundMachine {

	private GameMachine gm = null;
	private Level level =null;
	
    public SoundMachine (GameMachine g) {
    	gm =g; 
    }

	public void playfromResource (Entity e) {
	    level = gm.getCurrLevel();
		Player [][] player = level.getSounds(e.getSoundSet());
		try {
			player [e.getSoundNumber()][0].start();
		} catch (MediaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
