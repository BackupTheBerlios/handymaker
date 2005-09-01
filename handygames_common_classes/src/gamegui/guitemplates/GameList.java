package gamegui.guitemplates;

import gamemachine.GameMachine;
import gamemachine.ResourceLoader;
import games.Game;
import games.GameException;

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
	
	private String [] options = null;

	private int startPosX = 100;
	private int startPosY = 100;
	private int fontWidth = 7;
	private int fontHeight = 8;
	private int spaceBetweenChoice = 5;

	private int borderWidth = 4;
	
	private int norm_r = 0;
	private int norm_g = 0;
	private int norm_b = 0;
	private int chosen_r = 255;
	private int chosen_g = 255;
	private int chosen_b = 255;
	
	private Command exit = null;
	
	private int indexOfChosen = 0;

	private Image i_background = null;
	
	private Image [] i_chosen_option = null;
	private Image[] i_option = null;

	private int border_b = 0;
	private int border_g = 0;
	private int border_r = 0;
	
	public void setTextColor(int r,int g,int b) {
		this.norm_r = r;
		this.norm_g = g;
		this.norm_b = b;
	}
	
	public void setBorderColor(int r, int g, int b) {
		this.border_r = r;
		this.border_g=  g;
		this.border_b = b;
	}
	
	public void setChoseTextColor(int chosen_r, int chosen_g, int chosen_b) {
		this.chosen_r = chosen_r;
		this.chosen_g = chosen_g;
		this.chosen_b = chosen_b;
	}

	
	/**
	 * @param arg0
	 */
	public GameList(GameMachine gameMachine, boolean arg0, Image i_background, Image[] i_option, String [] options) throws GameException{
		super(arg0);
		
		if (i_option == null || options == null || i_option.length != options.length)
			throw new GameException("options array is null or options length is unequal to i_option length.");
		
		this.i_option = i_option;
		this.i_background = i_background;
		this.options = options;
		this.gameMachine = gameMachine;
		
		exit = new Command("exit",Command.EXIT,1);
		addCommand(exit);
		setCommandListener(this);
	}
	
	public GameList(GameMachine gameMachine,boolean arg0, Image i_background, Image[] i_option, Image[] i_chosen_option, String[] options) throws GameException {
		this(gameMachine, arg0, i_background, i_option, options);
		if (i_chosen_option == null || i_chosen_option.length != i_option.length)
			throw new GameException("options array is null or options length is unequal to i_option length.");
		
		this.i_chosen_option = i_chosen_option;
					
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
	public void centralizeXY() {
		if (i_option == null) {
			startPosX = getWidth()/2-StringTools.getMaxWidthOfString(options)*fontWidth/2;
			startPosY = getHeight()+options.length*(fontHeight+spaceBetweenChoice);
		} else {
			startPosX = getWidth()/2-i_option[0].getWidth()/2;
			startPosY = getHeight()/2-(i_option.length*(spaceBetweenChoice+i_option[1].getHeight())/2);
		}
		repaint();
	}
	
	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}
	
	public void paint(Graphics g) {
		if (i_background != null) {
			g.drawImage(i_background,0,0,Graphics.TOP | Graphics.LEFT);
		}
		
		int curry = startPosY;
		for (int i=0; i<options.length;i++) {
			if (i_option == null) {
				if (i == indexOfChosen)
					g.setColor(chosen_r,chosen_g,chosen_b);
				else 
					g.setColor(norm_r,norm_g,norm_b);
				g.drawString(options[i],startPosX,startPosY+spaceBetweenChoice*i,Graphics.TOP | Graphics.LEFT);
			} else {
				if (i == indexOfChosen) {
					g.setColor(border_r,border_g,border_b);
					g.fillRect(startPosX-borderWidth,curry-borderWidth,i_option[i].getWidth()+(2*borderWidth),i_option[i].getHeight()+(2*borderWidth));
					if (i_chosen_option != null)
						g.drawImage(i_chosen_option[i],startPosX,curry,Graphics.TOP | Graphics.LEFT);
					else
						g.drawImage(i_option[i],startPosX,curry,Graphics.TOP | Graphics.LEFT);
				} else
					g.drawImage(i_option[i],startPosX,curry,Graphics.TOP | Graphics.LEFT);
				curry = curry+spaceBetweenChoice+i_option[i].getHeight();
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