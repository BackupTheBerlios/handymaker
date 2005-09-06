package invadersgameworld;

import gamemachine.GameMachine;
import gameworld.SimpleEntity;

public class TankEntity extends SimpleEntity {

	private int shot = 0;
	private int shield = 0;
	private int speed = 0;
	private int live = 3;
	private int points = 0;
    private GameMachine gm = null;
	
	private int shot_price;
	private int shield_price;
	private int speed_price;
	private int live_price;

	private final int LIVE_P = 0;
    
	public TankEntity(int p_Type, int p_ImageSet, int p_X, int p_Y,
			int p_Width, int p_Height,GameMachine gm) {
		super(p_Type, p_ImageSet, p_X, p_Y, p_Width, p_Height);
		this.gm=gm;
		calculatePrices ();	
	}

	public void raisePoints (int points) {
		this.points += points;
	}
	
	public void lostLive () {
		live--;
	}
	
	/* preise könnten je nach updatetype und abhängig von z.b. current level
	 * im späteren spielverlauf neu berechnet werden */
	public void calculatePrices () {
		int level = gm.getCurrLevel().nr;
		live_price = 1000*level/2;
		shot_price = 300;
		shield_price = 500;
		speed_price = 300;
	}
	
	public void incrementLive () {
		points-=live_price;
		live++;
	}
	
	public void incrementShot () {
		points-=shot_price;
		shot++;
	}
	
	public void incrementShield () {
		points-=shield_price;
		shield++;
	}
	
	public void invrementSpeed () {
		points-=speed_price;
		speed++;
	}
			
    public boolean [] isIncrementable () {
    	boolean incrementable [] = {false,false,false,false};
    	if (live<3 && points>=live_price) incrementable[0]= true;
    	if (shot<3 && points>=shot_price) incrementable[1]= true;
    	if (shield<3 && points>=shield_price) incrementable[2]= true;
    	if (speed<3 && points>=speed_price) incrementable[3]= true;
    	return incrementable;	
    }
    
    public boolean isIncrementableLive() {
    	return isIncrementable()[LIVE_P];
    }
    
    public int getLive () {
    	return live;
    }
    
    public int getShot () {
    	return shot;
    }
    
    public int getShield () {
    	return shield;
    }
    
    public int getSpeed () {
    	return speed;
    }
    
    public int getPoints () {
    	return points;
    }
 }


