/*
 * Created on 05.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gamegui;

import gamemachine.GameMachine;
import gamemachine.level.Level;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.game.GameCanvas;

/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class GameGUI extends GameCanvas implements CommandListener{
	private GameMachine gm = null;
	protected Level currLevel = null;
	
	private int speed = 3000;
	
	/**
	 * @param arg0
	 */
	public GameGUI(GameMachine gm, boolean arg0) {
		super(arg0);
		this.gm = gm;
		// TODO Auto-generated constructor stub
	}


	public synchronized void freeze() {
		try {
			wait(speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void loadNewLevel() {
		currLevel = gm.getCurrLevel();
	}
	
	/* (non-Javadoc)
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public abstract void commandAction(Command arg0, Displayable arg1);
}