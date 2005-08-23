package src.GameWorld;

public class SimpleMap
{
	private int m_ImageSet;
	private int m_PositionX,m_PositionY;
	private int m_Map[][];
	private int m_Flag;
	
	public static final int FLAG_HIDE=1;
	public static final int FLAG_ALL=0xFFFFFFFF;
	
	
	public SimpleMap(int p_Width,int p_Height)
	{
		int w=p_Width,h=p_Height;
		
		if (w<=0) w=1;
		if (h<=0) h=1;
		
		m_Map=new int[w][h];
		
		setImageSet(-1);
		setPosition(0,0);
		clearFlag(FLAG_ALL);
	}
	
	public void setImageSet(int p_IS)
	{
	}
	
	public void setPosition(int p_x,int p_y)
	{
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
		return m_Map.length;
	}
	
	public int getHeight()
	{
		return m_Map[0].length;
	}
	
	public void setTile(int p_X,int p_Y,int p_Num)
	{
		try
		{
			m_Map[p_X][p_Y]=p_Num;
		}
		catch(Exception e){}
	}
	
	public int getTile(int p_X,int p_Y)
	{
		try
		{
			return m_Map[p_X][p_Y];
		}
		catch(Exception e){}
		return 0;
	}
}