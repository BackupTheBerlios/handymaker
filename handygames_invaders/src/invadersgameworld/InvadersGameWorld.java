package invadersgameworld;

import tools.ArrayTools;
import invadergamemachine.InvaderGameMachine;
import invaders.InvadersSettings;
import gamemachine.level.Level;
import gameworld.*;



public class InvadersGameWorld extends GameWorld
{
	int m_Level;
	long m_LastUpdate;
	TankEntity m_Tank;
	
	public static final int ENTITY_PLAYER=1;
	public static final int ENTITY_SHOT_S=2;
	public static final int ENTITY_INVADER1=3;
	public static final int ENTITY_SHOT_L=4;
	public static final int ENTITY_SHOT_R=5;
	
	public static final int SHOT_WIDTH=8;
	public static final int SHOT_HEIGHT=8;
	public static final int SHOT_STEP=2;
	
	public static final long FRAMEDELAY=50;
	
	public static final int TANK_STEP=2; 
	public static final int BORDER_RIGHT=172;
	
	public InvadersGameWorld(InvaderGameMachine invadersGameMachine)
	{
		super(invadersGameMachine);
		m_Level=0;
	}
	
	public void loadNextLevel()
	{
		/* diesen block hinzugefügt + konstruktor geändert*/
		/* ANFANG */
		Level l = m_GameMachine.getCurrLevel();

		int invaderCount = l.getLevelIntValue(InvadersSettings.INVADERCOUNT);
		
		System.out.println("Level ziel:"+l.getLevelStringValue(InvadersSettings.MISSIONDESCRIPTION));
		System.out.println("Aliens vernichten:"+ArrayTools.getPrintOf(l.getLevelIntArrayDim1(InvadersSettings.MISSIONTERMINATION)));
		
		for (int i=1; i<=invaderCount;i++) {
			
			System.out.println("\ninvader: "+i);
			int [] pos_p = l.getLevelIntArrayDim1(InvadersSettings.INVADERPOSITIONPREFIX+i+InvadersSettings.INVADERPOSITIONSUFFIX);
			System.out.println("- position:"+ArrayTools.getPrintOf(pos_p));
			
			int [][] pos_m = l.getLevelIntArrayDim2(InvadersSettings.INVADERMOVEMENTPREFIX+i+InvadersSettings.INVADERMOVEMENTSUFFIX);
			System.out.println("- movement:"+ArrayTools.getArrayPrint(pos_m));
		}
		/* ENDE */
		
		SimpleEntity se;
		
		m_Level=(++m_Level)%1 +1;
		
		
		se=new SimpleEntity(ENTITY_INVADER1,ENTITY_INVADER1,0,0,30,30);
		
		//player ship
		
		addSimpleEntity(1,new SimpleEntity(ENTITY_PLAYER,ENTITY_PLAYER,100,200,30,30));
	}
	
	public int init()
	{
		m_LastUpdate=System.currentTimeMillis();
		loadNextLevel();
		return 0;
	}
	
	public int update()
	{
		long t=System.currentTimeMillis();
		SimpleEntity se;
		
		while(m_LastUpdate+FRAMEDELAY<t)
		{
			//move invaders
			//move player
			switch(m_Tank.getMovementstatus())
			{
				case TankEntity.MOVE_LEFT:
					if (m_Tank.getX()>=TANK_STEP) m_Tank.move(-TANK_STEP,0);
				break;
				
				case TankEntity.MOVE_RIGHT:
					if (m_Tank.getX()<=BORDER_RIGHT-TANK_STEP) m_Tank.move(TANK_STEP,0);
				break;
			}
			//create shots
			switch(m_Tank.getShotstatus())
			{
				case TankEntity.SHOT_LEFT:
					se=new SimpleEntity(ENTITY_SHOT_L,0,m_Tank.getX(),m_Tank.getY()-SHOT_STEP,SHOT_WIDTH,SHOT_HEIGHT);
					addSimpleEntity(1,se);
				break;
				
				case TankEntity.SHOT_STRAIGHT:
					se=new SimpleEntity(ENTITY_SHOT_S,0,m_Tank.getX(),m_Tank.getY()-SHOT_STEP,SHOT_WIDTH,SHOT_HEIGHT);
					addSimpleEntity(1,se);
				break;
					
				case TankEntity.SHOT_RIGHT:
					se=new SimpleEntity(ENTITY_SHOT_R,0,m_Tank.getX(),m_Tank.getY()-SHOT_STEP,SHOT_WIDTH,SHOT_HEIGHT);
					addSimpleEntity(1,se);
				break;
			}
			m_Tank.setShotstatus(TankEntity.SHOT_NONE);
			//move shots
			se=getFirstEntity();
			int ty=m_Tank.getY();
			int k;
			while(se!=null)
			{
				switch (se.getType())
				{
					case ENTITY_SHOT_L:
						k=(int)(3.5 - 5*(ty-se.getY())/(double)(ty));
						se.move(k,-SHOT_STEP);
					break;
					
					case ENTITY_SHOT_S:
						se.move(0,-SHOT_STEP);
					break;
						
					case ENTITY_SHOT_R:
						k=(int)(3.5 - 5*(ty-se.getY())/(double)(ty));
						se.move(-k,-SHOT_STEP);
					break;
				}
				se=getNextEntity();
			}
			
			m_LastUpdate+=FRAMEDELAY;
		}
		return 0;
	}
	
	public int shutdown()
	{
		return 0;
	}
	
	public int command(int p_Command)
	{
		if (m_Tank==null) return -1;
		switch (p_Command)
		{
			case 1:m_Tank.setShotstatus(TankEntity.SHOT_LEFT);break;
			case 2:m_Tank.setShotstatus(TankEntity.SHOT_STRAIGHT);break;
			case 3:m_Tank.setShotstatus(TankEntity.SHOT_RIGHT);break;
			case 4:m_Tank.setMovementstatus(TankEntity.MOVE_LEFT);break;
			case 5:m_Tank.setMovementstatus(TankEntity.MOVE_NONE);break;
			case 6:m_Tank.setMovementstatus(TankEntity.MOVE_RIGHT);break;
		}
		
		return 0;
	}
}