/*
 * Created on 03.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package invadergamemachine;

import java.io.IOException;

import gamemachine.GameMachine;
import gamemachine.ResourceLoader;
import gamemachine.level.Level;
import invadergamegui.InvaderGameGUI;
import invaders.Invaders;
import invaders.InvadersSettings;


/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvaderGameMachine extends GameMachine {
	public static final int INVADER = 1;
	public static final int TANK = 2;
	
	private InvaderGameGUI igui = null;

	private Level [] levels = null;
	private int currLevelIndex = 0;

	private static int gameState = GAMEON;
	
	/**
	 * 
	 */
	public InvaderGameMachine(Invaders invaders) {
		super(invaders);
		
		igui = new InvaderGameGUI(this);
		
		display.setCurrent(igui);

		screen_width = igui.getWidth();
		screen_height = igui.getHeight();

		igui.setHeight(screen_height);
		igui.setWidth(screen_width);

		defineLevel();
		setSpeed(100);
		
		nextLevel();
	}

	public void nextLevel() {
		setCurrLevel(levels[currLevelIndex++]);

		try {
			currLevel.activateLevel();
			igui.loadNewLevel();
			
			// SOUND AKTIVIEREN
			// soundEngine.loadResources();
			
			currLevel.flushResources();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private void defineLevel() {
		ResourceLoader r = new ResourceLoader();
		
		levels = new Level[3];
		
		levels[0] = new Level(1,"",InvadersSettings.IMAGESETS_L1,InvadersSettings.DESC_SOUNDSET_L1,r);
		levels[1] = new Level(2,"",InvadersSettings.IMAGESETS_L2,InvadersSettings.DESC_SOUNDSET_L2, r);
		levels[2] = new Level(3,"",InvadersSettings.IMAGESETS_L3,InvadersSettings.DESC_SOUNDSET_L3,r);
		
	}

	public void startGame() {
		showStartScreen();
		
		startGameprocess();
	}

	private synchronized void startGameprocess() {
		while (gameState == GAMEON) {

			igui.repaint();
			freeze();
		}
	}
	


	public void action(int keyCode) {
		if (LEFT == keyCode)
			;
		
		if (RIGHT == keyCode)
			;
		
		if (FIRE == keyCode)
			;
	}

	/**
	 * 
	 */
	public void exit() {
		game.exit();
		
	}


	public void showStartScreen() {
		display.setCurrent(igui);		
	}
}