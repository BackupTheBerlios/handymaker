package src.GameWorld;

public class Entity extends SimpleEntity
{
	private int m_DirectionX,m_DirectionY;
	private int m_ImageOffX,m_ImageOffY;
	private int m_Animation,m_Frame;
	private int m_SoundSet;
	private int m_SoundNumber;
	
	//public static final int FLAG_HIDE=0x00000001;
	//public static final int FLAG_ALL=0xFFFFFFFF;
	//public static final int TYPE_NONE=-1;
	public static final int FLAG_NOIMAGE=0x00000002;
	public static final int FLAG_NOSOUND=0x00000004;
	public static final int FLAG_NOPHYSIC=0x00000008;
	
	

	public Entity()
	{
		super();
		setDirection(0,0);
		setImageOffset(0,0);
		setAnimation(0);
		setFrame(0);
		setSoundSet(-1);
		setSoundNumber(0);
	}
	
	public Entity(Entity p_E)
	{
		super(p_E);
		setDirection(p_E.getDirectionX(),p_E.getDirectionY());
		setImageOffset(p_E.getImageOffsetX(),p_E.getImageOffsetY());
		setAnimation(p_E.getAnimation());
		setFrame(p_E.getFrame());
		setSoundSet(p_E.getSoundSet());
		setSoundNumber(p_E.getSoundNumber());
	}
	
	public void setDirection(int p_dx,int p_dy)
	{
		m_DirectionX=p_dx;
		m_DirectionY=p_dy;
	}

	public int getDirectionX()
	{
		return m_DirectionX;
	}
	
	public int getDirectionY()
	{
		return m_DirectionY;
	}
	
	public void setImageOffset(int p_iox,int p_ioy)
	{
		m_ImageOffX=p_iox;
		m_ImageOffY=p_ioy;
	}
	
	public int getImageOffsetX()
	{
		return m_ImageOffX;
	}
	
	public int getImageOffsetY()
	{
		return m_ImageOffY;
	}
	
	public void setAnimation(int p_Animation)
	{
		m_Animation=p_Animation;
	}
	
	public int getAnimation()
	{
		return m_Animation;
	}
	
	public void setFrame(int p_Frame)
	{
		m_Frame=p_Frame;
	}
	
	public int getFrame()
	{
		return m_Frame;
	}
	
	public void setSoundSet(int p_SoundSet)
	{
		m_SoundSet=p_SoundSet;
	}
	
	public int getSoundSet()
	{
		return m_SoundSet;
	}
	
	public void setSoundNumber(int p_SoundNumber)
	{
		m_SoundNumber=p_SoundNumber;
	}
	
	public int getSoundNumber()
	{
		return m_SoundNumber;
	}
}