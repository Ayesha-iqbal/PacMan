package Tournament;

import java.io.Serializable;

import SimStationpac.Agent;

public abstract class Strategy implements Serializable
{
	private String strategyName;
	
	public abstract String getStrategyName();
	
	public abstract String getDecision(String lastOpponentDecision);
	
}
