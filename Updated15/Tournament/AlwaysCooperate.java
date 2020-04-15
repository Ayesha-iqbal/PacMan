package Tournament;

import SimStationpac.Agent;

public class AlwaysCooperate extends Strategy
{
	private String strategyName;
	
	public AlwaysCooperate()
	{
		strategyName = "ALWAYS_COOPERATE";
	}
	
	public  String getStrategyName()
	{
		return strategyName;
	}
	
	public  String getDecision(String lastOpponentDecision)
	{
		return "COOPERATE";
	}
	
}
