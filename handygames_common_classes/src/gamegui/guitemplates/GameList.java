package gamegui.guitemplates;

import gamemachine.GameMachine;
import games.Game;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.game.GameCanvas;

import com.sun.midp.midlet.Scheduler;


import tools.StringTools;

public class GameList extends GameCanvas implements CommandListener, Runnable{
	private GameMachine gameMachine = null;
	
	private Image background = null;
	private String [] options = null;

	private int startPosX = 100;
	private int startPosY = 100;
	private int fontWidth = 7;
	private int spaceBetweenChoice = 20;

	private int norm_r = 0;
	private int norm_g = 0;
	private int norm_b = 0;
	private int chosen_r = 255;
	private int chosen_g = 255;
	private int chosen_b = 255;
	
	
	private Command exit = null;
	
	private int indexOfChosen = 0;
	
	public void setTextColor(int r,int g,int b) {
		this.norm_r = r;
		this.norm_g = g;
		this.norm_b = b;
	}
	
	public void setChoseTextColor(int chosen_r, int chosen_g, int chosen_b) {
		this.chosen_r = chosen_r;
		this.chosen_g = chosen_g;
		this.chosen_b = chosen_b;
	}
	
	/**
	 * @param arg0
	 */
	public GameList(GameMachine gameMachine, boolean arg0, Image background, String [] options) {
		super(arg0);
		this.background = background;
		this.options = options;
		this.gameMachine = gameMachine;
		
		exit = new Command("exit",Command.EXIT,1);
		addCommand(exit);
		setCommandListener(this);
		
		
	}
	
	public void setSpaceBetweenChoice(int spaceBetweenChoice) {
		this.spaceBetweenChoice = spaceBetweenChoice;
	}
	
	public void setStartPosX(int startPosX) {
		this.startPosX = startPosX;
	}
	
	public void setStartPosY(int startPosY) {
		this.startPosY = startPosY;
	}
	
	public void setFontWidth(int fontWidth) {
		this.fontWidth = fontWidth;
	}
	
	/**
	 * Nachdem display.setCurrent aufgerufen wurde, kann centralizeX aufgerufen werden.
	 *
	 */
	public void centralizeX() {
		startPosX = getWidth()/2-StringTools.getMaxWidthOfString(options)*fontWidth/2;
		repaint();
	}
	
	public void paint(Graphics g) {
		if (background != null) {
			g.drawImage(background,0,0,Graphics.TOP | Graphics.LEFT);
			
			
			for (int i=0; i<options.length;i++) {
				if (i == indexOfChosen)
					g.setColor(chosen_r,chosen_g,chosen_b);
				else 
					g.setColor(norm_r,norm_g,norm_b);
				
				g.drawString(options[i],startPosX,startPosY+spaceBetweenChoice*i,Graphics.TOP | Graphics.LEFT);
			}
		}
	}

	/* (non-Javadoc)
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command arg0, Displayable arg1) {
		// TODO Auto-generated method stub
	}
	
	protected void keyReleased(int keyCode) {
		int key = getKeyStates();
		
		if (key == UP_PRESSED)
			up();
		if (key == DOWN_PRESSED)
			down();
		if (key == FIRE_PRESSED)
			fire();
	}
	
	private void up() {
		if (indexOfChosen == 0)
			indexOfChosen = options.length-1;
		else
			indexOfChosen--;
		
		repaint();
	}
	
	private void down() {
		if (indexOfChosen == options.length-1)
			indexOfChosen = 0;
		else
			indexOfChosen++;
		repaint();
	}
	
	private void fire() {
		gameMachine.execute(indexOfChosen);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
		
	}
}