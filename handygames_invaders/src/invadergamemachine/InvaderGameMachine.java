/*
 * Created on 03.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package invadergamemachine;

import gamemachine.GameMachine;
import gamemachine.ResourceLoader;
import invadergamegui.InvaderGameGUI;
import invaders.Invaders;


/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvaderGameMachine extends GameMachine {
	public static final int INVADER = 1;
	public static final int TANK = 2;
	
	public static final int H_SPACE = 20; 
	public static final int V_SPACE = 7;

	public static final int RIGHT_OFFSET = 5;
	public static final int BOTTOM_OFFSET = 5;
	public static final int LEFT_OFFSET = 5;
	public static final int TOP_OFFSET = 5;
	
	public static final int INVADERWIDTH = 14;
	public static final int INVADERHEIGHT = 14;
	
	public static final int TANKWIDTH = 23;
	public static final int TANKHEIGHT = 12;
	
	
	
	
	
	private static int gameState = GAMEON;

	private static final String INVADERPIC = "invader1.png";
	private static final String TANKPIC = "tank.png";
	private static final String [] IMAGES_DESC = {INVADERPIC,TANKPIC};
	private static final String [] SOUNDS_DESC = null;
	
	private InvaderGameGUI igui = null;
	

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

		loadRecoures();
		speed = 100;
	}
	
	/**
	 * 
	 */
	private void loadRecoures() {
		ResourceLoader r = new ResourceLoader();
		r.loadImages(IMAGES_DESC);
		igui.setInvaderpic(r.getImage(INVADERPIC));
		igui.setTankpic(r.getImage(TANKPIC));
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
