/*
 * Created on 03.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package invadergamemachine;

import java.io.IOException;

import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.MediaException;

import tools.ArrayTools;

import gamegui.GameGUI;
import gamegui.guitemplates.GameList;
import gamemachine.GameMachine;
import gamemachine.ResourceLoader;
import gamemachine.level.Level;
import games.GameException;
import invadergamegui.InvaderGameGUI;
import invaders.Invaders;
import invaders.InvadersSettings;
import invadersgameworld.InvadersGameWorld;
import invadersound.InvaderSoundMachine;


/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvaderGameMachine extends GameMachine implements Runnable {
	public static final int INVADER = 1;
	public static final int TANK = 2;
	
	private Thread iguiThread = null;
	private InvaderGameGUI igui = null;
	private InvadersGameWorld igw = null;
	private InvaderSoundMachine ism = null;
	
	private GameList startScreen = null;
	private GameList shopScreen = null;
	
	private Level [] levels = null;
	private int currLevelIndex = 0;

	public static int gameState = GAMEON;
	

	/**
	 * 
	 */
	public InvaderGameMachine(Invaders invaders) {
		super(invaders);


		defineLevel();
		setSpeed(1000);
		
		
		//showStartScreen();


		//startPlay();
	}


	
	private void nextLevel()  {
		setCurrLevel(levels[currLevelIndex++]);

		try {
			currLevel.activateLevel();
			igui.loadNewLevel();
			igw.loadNextLevel();
			ism.nextLevel();
			
			// SOUND AKTIVIEREN
			// soundEngine.loadResources();
			
			currLevel.flushResources();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private void defineLevel() {
		levels = new Level[3];
		
		levels[0] = new Level(1,"",InvadersSettings.IMAGESETS_L1,InvadersSettings.DESC_SOUNDSET_L1);
		levels[1] = new Level(2,"",InvadersSettings.IMAGESETS_L2,InvadersSettings.DESC_SOUNDSET_L2);
		levels[2] = new Level(3,"",InvadersSettings.IMAGESETS_L3,InvadersSettings.DESC_SOUNDSET_L3);
		
	}

	public void startGame() {
		showStartScreen();
	}

	private void initPlay()  {
		igui = new InvaderGameGUI(this);
		igw = new InvadersGameWorld(this);
		ism = new InvaderSoundMachine(this);
		
		iguiThread = new Thread(igui);
		iguiThread.start();		
		
		nextLevel();
		getCurrentDisplay().setCurrent(igui);
		System.out.println("init play.");
	}
	
	private synchronized void startPlay() {
		igui.go();
		System.out.println("start play.");	
	}

	private synchronized void pausePlay() {
		igui.dontGo();
	}
	
	private synchronized void destroyPlay() {
		try {
			iguiThread.join();
			igui = null;
			iguiThread = null;
			System.gc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		ResourceLoader rl = new ResourceLoader();
		
		shopScreen = null;
		
		try {
			Image background = background = rl.loadSimpleImage(InvadersSettings.DESC_BACKGROUND);
			Image [] options = rl.loadImageArray(InvadersSettings.DESC_INVADER_STARTSCREEN_OPTIONS);
			Image [] chosen_options = rl.loadImageArray(InvadersSettings.DESC_INVADERSTARTSCREEN_CHOSENOPTIONS);
			startScreen = new GameList(this,false,background,options,chosen_options,InvadersSettings.OPTIONS);
			
			startScreen .setBorderWidth(0);
			startScreen .setBorderColor(255,255,255);
			startScreen .centralizeXY();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GameException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		getCurrentDisplay().setCurrent(startScreen);
	}
	
	public void showShop() {
		ResourceLoader rl = new ResourceLoader();
		
		startScreen = null;
		
		try {
			Image background = background = rl.loadSimpleImage(InvadersSettings.SHOP_BACKGROUND);
			Image [] options = rl.loadImageArray(InvadersSettings.SHOP_INVADER_STARTSCREEN_OPTIONS);
			shopScreen = new GameList(this,false,background,options,InvadersSettings.SHOP_OPTIONS);
			
			shopScreen.setBorderWidth(3);
			shopScreen.setBorderColor(0,255,255);
			shopScreen.centralizeXY();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GameException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		getCurrentDisplay().setCurrent(shopScreen);
	}
	
	/* (non-Javadoc)
	 * @see gamemachine.GameMachine#execute(int)
	 */
	public void execute(int command) {
		if (startScreen != null) {
			if (command == InvadersSettings.START) {
				initPlay();
				startPlay();
			}
			
			if (command == InvadersSettings.HIGHSCORE) {
				showShop();
			}
		}
		
		if (shopScreen != null) {
			if (command == InvadersSettings.EXITSHOP) {
				showStartScreen();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
		
	}
}