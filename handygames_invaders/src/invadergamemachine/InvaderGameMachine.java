/*
 * Created on 03.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package invadergamemachine;

import gamegui.level.Level;
import gamemachine.GameMachine;
import gamemachine.ResourceLoader;
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
	
	private static int gameState = GAMEON;

	private static final String INVADERPIC = "invader1.png";
	private static final String TANKPIC = "tank.png";
	private static final String [] IMAGES_DESC = {INVADERPIC,TANKPIC};
	private static final String [] SOUNDS_DESC = null;
	
	private InvaderGameGUI igui = null;
	
	private Level [] levels = null;
	/**
	 * 
	 */
	public InvaderGameMachine(Invaders invaders) {
		super(invaders);
		
		//igui = new InvaderGameGUI(this,igc);
		
		display.setCurrent(igui);

		screen_width = igui.getWidth();
		screen_height = igui.getHeight();

		igui.setHeight(screen_height);
		igui.setWidth(screen_width);

		defineLevel();
		setSpeed(100);
	}
	
	/**
	 * 
	 */
	private void defineLevel() {
		ResourceLoader r = new ResourceLoader();
		
		levels = new Level[3];
		
		levels[0] = new Level(1,"TÖTEN SIE ALLE INVADERS",InvadersSettings.imageDescLevel1,InvadersSettings.soundDescLevel1,r);
		levels[1] = new Level(2,"TÖTEN SIE ALLE!", InvadersSettings.imageDescLevel2, InvadersSettings.soundDescLevel2, r);
		
		
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
