package Tournament;

import SimStationpac.Agent;

public class RandomlyCooperate extends Strategy
{
	private String strategyName ; 
	
	public RandomlyCooperate()
	{
		strategyName = "RAND_COOP";
	}
	
	
	public String getStrategyName()
	{
		return strategyName;
	}
	
	public  String getDecision(String lastOpponentDecision)
	{
		int chooser = (int) (Math.random() * 1 + 1) + 1;
        String result = (chooser == 1) ? "CHEAT" : "COOPERATE";
		return result;
	}
}
