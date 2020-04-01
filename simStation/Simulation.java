/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 * work in progress
 */

package simStation;

import mvc.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Simulation extends Model
{
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private int clock;
	private List<Agent> agentList;
	
	public Simulation()
	{
		clock = 0;
		agentList = new LinkedList<Agent>();
	}
	
	private void startTimer()
	{
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}
	
	private void stopTimer()
	{
		timer.cancel();
		timer.purge();
	}
	
	private class ClockUpdater extends TimerTask
	{
		public void run()
		{
			clock++;
			changed();
		}
	}
	public void start()
	{
		startTimer();
		for(Agent a : agentList)
		{
			Thread thread = new Thread(a);
			thread.start();
			//a.start();
		}
	}
	
	public void suspend()
	{
		for(Agent a : agentList)
		{
			a.suspend();
		}
	}
	
	public void resume()
	{
		for(Agent a : agentList)
		{
			a.resume();
		}
	}
	
	public void stop()
	{
		for(Agent a : agentList)
		{
			a.stop();
		}
		stopTimer();
	}
	
	/**
	 * Gets the following agent
	 * if the agent is not in the list or the last agent
	 * it will return null
	 * @param a agent to use
	 * @return next agent
	 */
	public Agent getNeighbor(Agent a)
	{
		for(int i = 0; i < agentList.size()-1; i++)
		{
			if(agentList.get(i).equals(a))
			{
				return agentList.get(i+1);
			}
		}
		return null;
	}
	
	public void populate()
	{
		//empty method that will be specified in subclasses.
		//It's called by start and populates the simulation.
	}
	
	public String[] getStats() 
	{
		String[] stats = new String[3];
		stats[0] = "#agents = " + agentList.size();
		stats[1] = "clock = " + clock;
		//stats[3] = "% infected" = (double)numInfected/((double)agentList.size());
		return stats;
	}
}
