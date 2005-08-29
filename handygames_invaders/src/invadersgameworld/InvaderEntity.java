package invadersgameworld;

import gameworld.*;

public class InvaderEntity extends SimpleEntity
{
	private String m_AIString;
	
	public InvaderEntity()
	{
		super();
		m_AIString="";
	}
	
	public String getAIString()
	{
		return m_AIString;
	}
}