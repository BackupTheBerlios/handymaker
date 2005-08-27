package gameworld;

public class GameWorld
{
	private SimpleEntity m_Entity[];
	private int m_Slot,m_LoopSlot;
	private int m_Status;
	
	public static final int ENTITYCOUNT=1024;
	
	public static final int STATUS_END=-1;
	public static final int STATUS_IDLE=0;
	public static final int STATUS_RUNNING=1;
	
	public GameWorld()
	{
		m_Entity=new SimpleEntity[ENTITYCOUNT];
		m_Slot=0;
		m_Status=STATUS_IDLE;
	}
	
	public GameWorld(int p_Entitycount)
	{
		int c=p_Entitycount;
		
		if (c<1) c=ENTITYCOUNT;
		
		m_Entity=new SimpleEntity[c];
		m_Slot=0;
		m_Status=STATUS_IDLE;
	}
	
	public int createSimpleEntity()
	{
		return createSimpleEntity(new SimpleEntity());
	}
	
	public int createSimpleEntity(SimpleEntity p_SE)
	{
		int startSlot=m_Slot;
		do
		{
			if (m_Entity[m_Slot]==null)
			{
				m_Entity[m_Slot]=new SimpleEntity(p_SE);
				return m_Slot;
			}
			
			m_Slot=(m_Slot+1)%m_Entity.length;

		} while(m_Slot!=startSlot);
		
		return -1;
	}
	
	public int createEntity()
	{
		return createEntity(new Entity());
	}
	
	public int createEntity(Entity p_E)
	{
		int startSlot=m_Slot;
		do
		{
			if (m_Entity[m_Slot]==null)
			{
				m_Entity[m_Slot]=new Entity(p_E);
				return m_Slot;
			}
			
			m_Slot=(m_Slot+1)%m_Entity.length;

		} while(m_Slot!=startSlot);
		
		return -1;
	}
	
	public int addSimpleEntity(SimpleEntity p_Entity)
	{
		int startSlot=m_Slot;
		do
		{
			if (m_Entity[m_Slot]==null)
			{
				m_Entity[m_Slot]=p_Entity;
				return m_Slot;
			}
			
			m_Slot=(m_Slot+1)%m_Entity.length;

		} while(m_Slot!=startSlot);
		
		return -1;
	}
	
	public void moveAllEntitysofType(int p_Type,int dx,int dy)
	{
		for(int slot=0;slot<m_Entity.length;++slot)
		{
			if (m_Entity[slot]!=null)
			{
				if (m_Entity[slot].getType()==p_Type)
				{
					m_Entity[slot].move(dx,dy);
				}
			}
		}
	}
	
	public SimpleEntity getNextEntity()
	{
		while(m_Entity[m_LoopSlot]==null)
		{
			if (++m_LoopSlot>=m_Entity.length) return null;
		}
		
		return m_Entity[m_LoopSlot];
	}
	
	public SimpleEntity getFirstEntity()
	{
		m_LoopSlot=0;
		return getNextEntity();
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

	public void command(int command) {
		// TODO Auto-generated method stub
		System.out.println(command);
		
	}
	
}