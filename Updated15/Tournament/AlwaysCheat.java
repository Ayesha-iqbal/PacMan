package Tournament;

import SimStationpac.Agent;

public class AlwaysCheat extends Strategy
{
	private String strategyName ; 
	
	public AlwaysCheat()
	{
		strategyName = "ALWAYS_CHEAT";
	}
	
	
	public String getStrategyName()
	{
		return strategyName;
	}
	
	public  String getDecision(String lastOpponentDecision)
	{
		return "CHEAT";
	}
}
