package gamegui.guitemplates;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.game.GameCanvas;

public class GameList extends GameCanvas {
	private Image background = null;

	
	/**
	 * @param arg0
	 */
	public GameList(boolean arg0, Image background) {
		super(arg0);
		this.background = background;
	}
	
	
	
	
	public void paint(Graphics g) {
		if (background != null) {
			g.drawImage(background,0,0,Graphics.TOP | Graphics.LEFT);
			
		}
	}
}
