/*
 * Created on 03.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gamemachine;

import gamemachine.level.Level;
import games.Game;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;


/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class GameMachine {
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	public static final int FIRE = 5;
	public static final int NOCMD = 6;
	public static final int UPLEFT = 7;
	public static final int UPRIGHT = 8;
	
	public static final int STARTGAME = 0;
	
	public static final int GAMEON = 1;
	public static final int GAMEOFF = 2;
	
	protected Level currLevel = null;
	
	
	protected Game game = null;
	
	protected int speed = 0;
	
	protected Display display = null;

	/**
	 * 
	 */
	protected synchronized void freeze() {
		try {
			wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public GameMachine(Game game) {
		super();
		
		this.game = game;
		this.display = game.getCurrentDisplay();
	}

	
	public Display getCurrentDisplay() {
		return game.getCurrentDisplay();
	}
	
	public Level getCurrLevel() {
		return currLevel;
	}
	
	protected void setCurrLevel(Level currLevel) {
		this.currLevel = currLevel;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
		
	}
	
	
	public abstract void action(int keyCode);

	public abstract void exit();
	
	public abstract void showStartScreen();
	
	public abstract void execute(int command);
	
	public void getGameWorld() {
		// TODO Auto-generated method stub
		
	}
	

}
