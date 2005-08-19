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
import invaders.InvadersSettings;

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
	
	private Image [][] i_invaders_a = null;
	private Image [][] i_invaders_b = null;
	private Image [][] i_tank = null;
	
	private boolean fireswitch = true;
	private Command exit = null;
	
	private InvaderGameMachine igm = null;
	
	

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
	
	public void loadNewLevel() {
		super.loadNewLevel();
		
		
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
		g.drawImage(i_invaders_a[InvadersSettings.I_INVADER_A_EXPL][0],10,20,Graphics.TOP | Graphics.LEFT);
		
	}

	public void activateGUI() {
		Level currLevel = igm.getCurrLevel();
		System.out.println(currLevel);
		i_invaders_a = currLevel.getImageSet(InvadersSettings.I_INVADER_A_IMAGESET);
		i_invaders_b = currLevel.getImageSet(InvadersSettings.I_INVADER_B_IMAGESET);
		i_tank = currLevel.getImageSet(InvadersSettings.I_TANKIMAGESET);
	}
}