/*
 * Created on 02.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package invadergamegui;

import gamegui.GameGUI;
import gamemachine.level.Level;
import invadergamemachine.InvaderGameMachine;

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 * @author Star
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvaderGameGUI extends GameGUI {
	
	private boolean fireswitch = true;
	private Command exit = null;
	
	private InvaderGameMachine igm = null;
	
	private Image invaderpic = null;
	private Image tankpic = null;

	/**
	 * @param igc
	 * 
	 */
	public InvaderGameGUI(InvaderGameMachine igm) {
		super(igm, false);
		this.igm = igm;
		
		exit = new Command("exit",Command.EXIT,1);
		addCommand(exit);
		setCommandListener(this);
	}
	
	protected void keyReleased(int keyCode) {
		int command = InvaderGameMachine.NOCMD;
		int key = getKeyStates();

		
		switch (key) {
			case LEFT_PRESSED : command = InvaderGameMachine.LEFT; break;
			case RIGHT_PRESSED : command = InvaderGameMachine.RIGHT; break;
			case FIRE_PRESSED : command = InvaderGameMachine.FIRE; break;
		}

		igm.action(command);

	}
	
	public void paint(Graphics g) {
		Image i_buff = Image.createImage(screen_width,screen_height);
		Graphics g_buff = i_buff.getGraphics();
		
		g_buff.setColor(0,0,0);
		g_buff.fillRect(0,0,screen_width,screen_height);
		g_buff.setColor(255,255,255);

		if (g_buff != null) {
			// INVADERS
			printObjects(g_buff);
			
			// FIRE
		}
		
		 g.drawImage(i_buff, 0, 0, Graphics.TOP | Graphics.LEFT);
	}
	
	public void commandAction(Command cmd, Displayable arg1) {
        if (cmd == exit) {
        	igm.exit();
        }
	}

	/**
	 * 
	 */
	private void printObjects(Graphics g) {
		//g.drawImage(invaderpic,s.getX(),s.getY(),Graphics.TOP | Graphics.LEFT);
	}
}