package gameworld;

public class SimpleEntity
{
	//vars	
	protected int m_Type;
	protected int m_ImageSet;
	protected int m_PositionX,m_PositionY;
	protected int m_Width,m_Height;
	protected int m_Flag;
	
	//statics
	public static final int FLAG_HIDE=0x00000001;
	public static final int FLAG_ALL=0xFFFFFFFF;
	public static final int TYPE_NONE=-1;
	
	//constructos
	public SimpleEntity()
	{
		setType(TYPE_NONE);
		setImageSet(-1);
		setPosition(0,0);
		setDimension(0,0);
		clearFlag(FLAG_ALL);
	}
	
	public SimpleEntity(int p_Type,int p_X,int p_Y,int p_Width,int p_Height)
	{
		setType(p_Type);
		setImageSet(-1);
		setPosition(p_X,p_Y);
		setDimension(p_Width,p_Height);
		clearFlag(FLAG_ALL);

	}
	
	public SimpleEntity(int p_Type,int p_ImageSet,int p_X,int p_Y,int p_Width,int p_Height)
	{
		setType(p_Type);
		setImageSet(p_ImageSet);
		setPosition(p_X,p_Y);
		setDimension(p_Width,p_Height);
		clearFlag(FLAG_ALL);
	}
	
	public SimpleEntity(SimpleEntity p_SE)
	{
		setType(p_SE.getType());
		setImageSet(p_SE.getImageSet());
		setPosition(p_SE.getX(),p_SE.getY());
		setDimension(p_SE.getWidth(),p_SE.getHeight());
		clearFlag(p_SE.getFlag());
	}
	
	public void setType(int p_Type)
	{
		 m_Type=p_Type;
		 if (m_Type<TYPE_NONE) m_Type=TYPE_NONE;
	}
	
	public void setImageSet(int p_ImageSet)
	{
		m_ImageSet=p_ImageSet;
		if (m_ImageSet<-1) m_ImageSet=-1;
	}
	
	public void setPosition(int p_X,int p_Y)
	{
		m_PositionX=p_X;
		m_PositionY=p_Y;
	}
	
	public void setDimension(int p_Width,int p_Height)
	{
		if (p_Width>=0) m_Width=p_Width;
		if (p_Height>=0) m_Height=p_Height;
	}
	
	public int getType()
	{
		 return m_Type;
	}
	
	public int getImageSet()
	{
		return m_ImageSet;
	}
	
	public int getX()
	{
		return m_PositionX;
	}
	
	public int getY()
	{
		return m_PositionY;
	}
	
	public int getWidth()
	{
		return m_Width;
	}
	
	public int getHeight()
	{
		return m_Height;
	}
	
	public int getFlag()
	{
		return m_Flag;
	}
	
	public int setFlag(int p_Flag)
	{
		return (m_Flag|=p_Flag);
	}
	
	public int clearFlag(int p_Flag)
	{
		return (m_Flag&=~p_Flag);
	}
	
	public boolean isSet(int p_Flag)
	{
		return ((m_Flag&p_Flag)!=0);
	}
	
	public void move(int p_dx,int p_dy)
	{
		m_PositionX+=p_dx;
		m_PositionY+=p_dy;
	}
	
	public boolean isHitBy(int p_X,int p_Y,int p_Width,int p_Height)
	{
		if (m_PositionX>=p_X+p_Width) return false;
		if (p_X>=m_PositionX+m_Width) return false;
		
		if (m_PositionY>=p_Y+p_Height) return false;
		if (p_Y>=m_PositionY+m_Height) return false;
		
		return true;
	}
	
}