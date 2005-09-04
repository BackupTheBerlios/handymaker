package invadersgameworld;

import tools.ArrayTools;
import invadergamemachine.InvaderGameMachine;
import invaders.InvadersSettings;
import gamemachine.level.Level;
import gameworld.*;



public class InvadersGameWorld extends GameWorld
{
	int m_Level;
	
	public static final int ENTITY_PLAYER=1;
	public static final int ENTITY_SHOT1=2;
	public static final int ENTITY_INVADER1=3;
	
	public InvadersGameWorld(InvaderGameMachine invadersGameMachine)
	{
		super(invadersGameMachine);
		m_Level=0;
	}
	
	public void loadNextLevel()
	{
		/* diesen block hinzugefügt + konstruktor geändert*/
		/* ANFANG */
		Level l = gameMachine.getCurrLevel();

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
		switch(m_Level) // level daten aus script oä rauslesen !!!
		{
			case 1:
				for(int i=0;i<6;++i)
				{
					for(int j=0;j<4;++j)
					{
						se.setPosition(40*i+20,40*j+20);
						addSimpleEntity(new SimpleEntity(se));
					}
				}
			break;
		
		}
		
		//player ship
		
		addSimpleEntity(new SimpleEntity(ENTITY_PLAYER,ENTITY_PLAYER,100,200,30,30));
	}
	
	public int init()
	{
		loadNextLevel();
		return 0;
	}
	
	public int update()
	{
		return 0;
	}
	
	public int shutdown()
	{
		return 0;
	}
	
//	public int command(int p_command)
//	{
//	}
}