package gamegui.guitemplates;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.List;

public class GameList extends List {

	public GameList(String arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	
	public void paint(Graphics g) {
		g.setColor(0,0,0);
		g.fillRect(0,0,100,100);
	}
}
