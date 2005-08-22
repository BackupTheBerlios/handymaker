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
	
	
	protected int screen_width;
	protected int screen_height;
	
	/**
	 * @param arg0
	 */
	public GameGUI(GameMachine gm, boolean arg0) {
		super(arg0);
		this.gm = gm;
		// TODO Auto-generated constructor stub
	}

	public void loadNewLevel() {
		currLevel = gm.getCurrLevel();
	}
	
	/* (non-Javadoc)
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public abstract void commandAction(Command arg0, Displayable arg1);

	/**
	 * @param screen_height
	 */
	public void setHeight(int screen_height) {
		this.screen_height = screen_height;
		
	}

	/**
	 * @param screen_width2
	 */
	public void setWidth(int screen_width2) {
		this.screen_width = screen_width2;
		
	}
}