package invadersgameworld;

import gameworld.*;

public class InvaderEntity extends SimpleEntity
{
	private int m_AIBuffer[][];
	private int m_AICount;
	private int m_AIPos;
	
	public InvaderEntity()
	{
		super();
		m_AIBuffer=new int[1][1];
		m_AICount=0;
		m_AIPos=0;
	}
	
	public void setAIBuffer(int p[][])
	{
		m_AIBuffer=p;
	}
	
	public int getNextStep()
	{
		//to be done
		return 0;
	}
}