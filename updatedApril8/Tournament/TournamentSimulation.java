/**
 * TournamentSimulation extends Simulation and simulates the Prisoner's Dilemma Tournament.
 * Prisoners may cooperate or cheat depending on their strategy and will maintain personal 
 * fitness scores. Average scores for each strategy type will be printed every 100 clock ticks.
 * The Averages can also be viewed in stats.
 * 
 * Edit history:
 * Ayesha 4/4/20
 * Emily 4/8/20
 */
package Tournament;
import java.text.DecimalFormat;

import mvc.*;
import simStation.*;
public class TournamentSimulation extends Simulation 
{

    private final static int AGENT_COUNT = 50;
    public static int ALWAYS_CHEAT_SCORE = 0;
    public static int ALWAYS_CHEAT_COUNT = 0;
    public static int ALWAYS_COOPERATE_SCORE = 0;
    public static int ALWAYS_COOPERATE_COUNT = 0;
    public static int RAND_COOP_SCORE = 0;
    public static int RAND_COOP_COUNT = 0;
    public static int COOP_ONLY_IF_SCORE = 0;
    public static int COOP_ONLY_IF_COUNT = 0;
    private static DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public String getStats()
    {    	
    	double alwaysCheatAverage = 0;
		double alwaysCooperateAverage = 0;
		double randomCooperateAverage = 0;
		double cooperateOnlyIfAverage = 0;
		
    	if(ALWAYS_CHEAT_COUNT > 0)
    		alwaysCheatAverage = (double)ALWAYS_CHEAT_SCORE / ALWAYS_CHEAT_COUNT;
		if(ALWAYS_COOPERATE_COUNT > 0)
			alwaysCooperateAverage = (double)ALWAYS_COOPERATE_SCORE / ALWAYS_COOPERATE_COUNT;
       if (RAND_COOP_COUNT > 0)
    	   randomCooperateAverage = (double)RAND_COOP_SCORE / RAND_COOP_COUNT;
       if(COOP_ONLY_IF_COUNT > 0)
    	   cooperateOnlyIfAverage = (double)COOP_ONLY_IF_SCORE / COOP_ONLY_IF_COUNT;
    	
    	return "Number of agents: " + AGENT_COUNT + 
        		"\nAlways cheat average: " + df.format(alwaysCheatAverage) +
        		"\nAlways cooperate average: " + df.format(alwaysCooperateAverage) +
        		"\nRandom cooperate average: "+ df.format(randomCooperateAverage) +
        		"\nCooperate only if the last one did average: " + df.format(cooperateOnlyIfAverage) +
                "\nClock: " + this.clock;
    }

    @Override
    public Agent getNeighbor(Agent a) {

        double minDistance = -1;
        PrisonerWalker closestAgent = null;
        for (int i = 0; i < this.agents.length; i++) {
            if (this.agents[i] == a) {
                continue;
            }
            double distance = Math.sqrt(Math.pow(a.getX() - this.agents[i].getX(), 2) + 
            		Math.pow(a.getY() - this.agents[i].getY(), 2));
            if (distance < minDistance || minDistance == -1) {
                minDistance = distance;
                closestAgent = (PrisonerWalker) this.agents[i];
            }

        }
        return closestAgent;

    }

    @Override
    public void populate() 
    {
        this.agents = new PrisonerWalker[AGENT_COUNT];
        String[] strategies = {"ALWAYS_CHEAT", "ALWAYS_COOPERATE", "RAND_COOP", "COOP_ONLY_IF"};
        
        for (int i = 0; i < this.agents.length; i++) 
        {
            this.agents[i] = new PrisonerWalker("RW"+i, "NORTH", (int) (Math.random() * WORLD_WIDTH + 1), 
            		(int) (Math.random() * WORLD_HEIGHT + 1), this, strategies[(int) (Math.random() * 4)]);
        }
    }
    
    public static void printAverages(String name) 
	{				
		if(name.equals("RW0"))
		{
			double alwaysCheatAverage = 0;
			double alwaysCooperateAverage = 0;
			double randomCooperateAverage = 0;
			double cooperateOnlyIfAverage = 0;
			
			if(ALWAYS_CHEAT_COUNT > 0)
	    		alwaysCheatAverage = (double)ALWAYS_CHEAT_SCORE / ALWAYS_CHEAT_COUNT;
			if(ALWAYS_COOPERATE_COUNT > 0)
				alwaysCooperateAverage = (double)ALWAYS_COOPERATE_SCORE / ALWAYS_COOPERATE_COUNT;
	       if (RAND_COOP_COUNT > 0)
	    	   randomCooperateAverage = (double)RAND_COOP_SCORE / RAND_COOP_COUNT;
	       if(COOP_ONLY_IF_COUNT > 0)
	    	   cooperateOnlyIfAverage = (double)COOP_ONLY_IF_SCORE / COOP_ONLY_IF_COUNT;
	        
	       Utilities.inform("Always cheat average: " + df.format(alwaysCheatAverage) +
	        		"\nAlways cooperate average: " + df.format(alwaysCooperateAverage) +
	        		"\nRandom cooperate average: "+ df.format(randomCooperateAverage) +
	        		"\nCooperate only if the last one did average: " + df.format(cooperateOnlyIfAverage));
		}
	}

}
