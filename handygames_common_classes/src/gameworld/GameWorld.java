package gameworld;

import gamemachine.GameMachine;

public class GameWorld
{
	protected SimpleEntity m_Entity[][];
	protected int m_Slot,m_LoopSlot,m_LoopLayer;
	protected int m_Status;
	protected GameMachine m_GameMachine;
		
	public static final int ENTITYCOUNT=256;
	public static final int LAYERCOUNT=4;
	
	public static final int STATUS_END=-1;
	public static final int STATUS_IDLE=0;
	public static final int STATUS_RUNNING=1;
	
	public GameWorld()
	{
	
		m_Entity=new SimpleEntity[LAYERCOUNT][ENTITYCOUNT];
		m_Slot=0;
		m_Status=STATUS_IDLE;
		
	}
		
	public GameWorld(GameMachine p_GameMachine)
	{
		setGameMachine(p_GameMachine);

		m_Entity=new SimpleEntity[LAYERCOUNT][ENTITYCOUNT];
		m_Slot=0;
		m_Status=STATUS_IDLE;
	}
	
	public GameWorld(int p_Layercount,int p_Entitycount)
	{
		int c=p_Entitycount;
		int l=p_Layercount;
		
		if (c<1) c=ENTITYCOUNT;
		if (l<1) l=LAYERCOUNT;
		
		m_Entity=new SimpleEntity[l][c];
		m_Slot=0;
		m_Status=STATUS_IDLE;
	}

	public void setGameMachine(GameMachine p_GameMachine)
	{
		m_GameMachine=p_GameMachine;
	}
 
	public int createSimpleEntity()
	{
		return createSimpleEntity(0,new SimpleEntity());
	}
	
	public int createSimpleEntity(int p_Layer,SimpleEntity p_SE)
	{
		int startSlot=m_Slot;
		
		if ((p_Layer<0) || (p_Layer>=m_Entity.length)) return -1;
		do
		{
			if (m_Entity[p_Layer][m_Slot]==null)
			{
				m_Entity[p_Layer][m_Slot]=new SimpleEntity(p_SE);
				return m_Slot+p_Layer*m_Entity.length;
			}
			
			m_Slot=(m_Slot+1)%m_Entity.length;

		} while(m_Slot!=startSlot);
		
		return -1;
	}
	
	public int createEntity()
	{
		return createEntity(0,new Entity());
	}
	
	public int createEntity(int p_Layer,Entity p_E)
	{
		int startSlot=m_Slot;
		
		if ((p_Layer<0) || (p_Layer>=m_Entity.length)) return -1;
		do
		{
			if (m_Entity[p_Layer][m_Slot]==null)
			{
				m_Entity[p_Layer][m_Slot]=new Entity(p_E);
				return m_Slot+p_Layer*m_Entity.length;
			}
			
			m_Slot=(m_Slot+1)%m_Entity.length;

		} while(m_Slot!=startSlot);
		
		return -1;
	}
	
	public int addSimpleEntity(int p_Layer,SimpleEntity p_Entity)
	{
		int startSlot=m_Slot;
		
		if ((p_Layer<0) || (p_Layer>=m_Entity.length)) return -1;
		
		do
		{
			if (m_Entity[p_Layer][m_Slot]==null)
			{
				m_Entity[p_Layer][m_Slot]=p_Entity;
				return m_Slot+p_Layer*m_Entity.length;
			}
			
			m_Slot=(m_Slot+1)%m_Entity.length;

		} while(m_Slot!=startSlot);
		
		return -1;
	}
	
	public void moveAllEntitysofType(int p_Type,int dx,int dy)
	{
		SimpleEntity se;
		
		se=getFirstEntity();
		
		while(se!=null)
		{
			if (se.getType()==p_Type)
			{
				se.move(dx,dy);
			}
			se=getNextEntity();
		}
		
	}
	
	public SimpleEntity getNextEntity()
	{
		while(m_Entity[m_LoopLayer][m_LoopSlot]==null)
		{
			++m_LoopSlot;
			
			if (m_LoopSlot>=m_Entity[m_LoopLayer].length)
			{
				m_LoopSlot=0;
				++m_LoopLayer;
			}
			if (m_LoopLayer>=m_Entity.length) return null;
		}
		
		return m_Entity[m_LoopLayer][m_LoopSlot];
	}
	
	public SimpleEntity getFirstEntity()
	{
		m_LoopSlot=0;
		m_LoopLayer=0;
		return getNextEntity();
	}
	
	public int getLayerCount()
	{
		return m_Entity.length;
	}
	
	public int getStatus()
	{
		return m_Status;
	}
	
	public int init()
	{
		m_Status=STATUS_RUNNING;
		return 0;
	}
	
	public int update()
	{
		return 0;
	}
	
	public int shutdown()
	{
		m_Status=STATUS_END;
		return 0;
	}
	
	public int command(int p_command)
	{
		return 0;
	}
}