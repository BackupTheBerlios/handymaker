/*
 * Created on 02.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package invaders;

import gamegui.guitemplates.GameList;
import games.Game;
import invadergamemachine.InvaderGameMachine;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Invaders extends MIDlet implements Game {
	private InvaderGameMachine igm = null;
	
	public Invaders() {
		super();
		igm = new InvaderGameMachine(this);
	}

	protected void startApp() throws MIDletStateChangeException {
		igm.startGame();
	}

	protected void pauseApp() {
	}

	public Display getCurrentDisplay() {
		return Display.getDisplay(this);
	}
	
	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
	}

	public void exit() {
		try {
			destroyApp(false);
		} catch (MIDletStateChangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    notifyDestroyed();
	}
}