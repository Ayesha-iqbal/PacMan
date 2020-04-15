package Tournament;

import SimStationpac.Agent;

public class CooperateIfOtherCoop extends Strategy
{
	private String strategyName ; 
	
	public CooperateIfOtherCoop()
	{
		strategyName = "COOP_ONLY_IF";
	}
	
	
	public String getStrategyName()
	{
		return strategyName;
	}
		
	public String getDecision(String lastOpponentDecision)
	{
		return lastOpponentDecision;
	}
}
