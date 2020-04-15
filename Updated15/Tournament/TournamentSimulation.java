/**
 * TournamentSimulation extends Simulation and simulates the Prisoner's Dilemma Tournament.
 * Prisoners may cooperate or cheat depending on their strategy and will maintain personal 
 * fitness scores. Average scores for each strategy type will be printed every 100 clock ticks.
 * The Averages can also be viewed in stats.
 * 
 * Edit history:
 * Ayesha 4/4/20
 * Emily 4/8/20
 * Adam/ 4/14/20
 */
package Tournament;
import java.text.DecimalFormat;
import java.util.ArrayList;

import mvc.*;
import SimStationpac.*;
public class TournamentSimulation extends Simulation 
{
    private final static int AGENT_COUNT = 50;
    private static DecimalFormat df = new DecimalFormat("#.##");
    private static ArrayList<Agent> cheater = new ArrayList<Agent>();
    private static ArrayList<Agent> cooperators = new ArrayList<Agent>();
    private static ArrayList<Agent> Reciproicator = new ArrayList<Agent>();
    private static ArrayList<Agent> randomer = new ArrayList<Agent>();
    private static ArrayList list[] = {cheater, cooperators, Reciproicator, randomer};

    @Override
    public String getStats()
    {    	
    	double alwaysCheatAverage = 0;
		double alwaysCooperateAverage = 0;
		double randomCooperateAverage = 0;
		double cooperateOnlyIfAverage = 0;
		double sum = 0;
		
		for(int i = 0; i < list[0].size(); i++)
		{
			sum += ((PrisonerWalker)list[0].get(i)).getScores();
		}
		alwaysCheatAverage = sum/list[0].size();
		sum = 0;
		
		for(int i = 0; i < list[1].size(); i++)
		{
			sum += ((PrisonerWalker)list[1].get(i)).getScores();
		}
		alwaysCooperateAverage = sum/list[1].size();
		sum = 0;
		
		for(int i = 0; i < list[2].size(); i++)
		{
			sum += ((PrisonerWalker)list[2].get(i)).getScores();
		}
		cooperateOnlyIfAverage = sum/list[2].size();
		sum = 0;
		
		for(int i = 0; i < list[3].size(); i++)
		{
			sum += ((PrisonerWalker)list[3].get(i)).getScores();
		}
		randomCooperateAverage = sum/list[3].size();
		sum = 0;
		
		
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
        Strategy strategy[] = new Strategy[4];
        strategy[0] = new AlwaysCheat();
        strategy[1] = new AlwaysCooperate();
        strategy[2] = new CooperateIfOtherCoop();
        strategy[3] = new RandomlyCooperate();
        
        
        for (int i = 0; i < this.agents.length; i++) 
        {
        	int ran = (int) (Math.random() * 4);
        	this.agents[i] = new PrisonerWalker("RW"+i, "NORTH", (int) (Math.random() * WORLD_WIDTH + 1), 
        			(int) (Math.random() * WORLD_HEIGHT + 1), this, strategy[ran]);
        	list[ran].add(this.agents[i]);
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
			double sum = 0;
			
			for(int i = 0; i < list[0].size(); i++)
			{
				sum += ((PrisonerWalker)list[0].get(i)).getScores();
			}
			alwaysCheatAverage = sum/list[0].size();
			sum = 0;
			
			for(int i = 0; i < list[1].size(); i++)
			{
				sum += ((PrisonerWalker)list[1].get(i)).getScores();
			}
			alwaysCooperateAverage = sum/list[1].size();
			sum = 0;
			
			for(int i = 0; i < list[2].size(); i++)
			{
				sum += ((PrisonerWalker)list[2].get(i)).getScores();
			}
			cooperateOnlyIfAverage = sum/list[2].size();
			sum = 0;
			
			for(int i = 0; i < list[3].size(); i++)
			{
				sum += ((PrisonerWalker)list[3].get(i)).getScores();
			}
			randomCooperateAverage = sum/list[3].size();
			sum = 0;
	        
	       Utilities.inform("Always cheat average: " + df.format(alwaysCheatAverage) +
	        		"\nAlways cooperate average: " + df.format(alwaysCooperateAverage) +
	        		"\nRandom cooperate average: "+ df.format(randomCooperateAverage) +
	        		"\nCooperate only if the last one did average: " + df.format(cooperateOnlyIfAverage));
	        		
    	
		}

	}
}