/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 * work in progress
 * if someone is more comfortable with multi threading, help would be appreciated
 */

package simStation;

import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String heading;
	private int xc, yc;
	private AgentState state;
	
	public Agent(String name, String heading, int x, int y)
	{
		this.name = name;
		this.heading = heading;
		xc = x;
		yc = y;
		state = AgentState.READY;
	}
	
	public void run()
	{
		switch(state)
		{
			case RUNNING:
				update();
				try
				{
					Thread.sleep(100);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				run();
				
			case SUSPENDED:
				suspend();
				break;
				
			case STOPPED:
				stop();
				break;
				
			default:
				break;
		}
	}
	
	public void start()
	{
		onStart();
		state = AgentState.RUNNING;
		run();
	}
	
	public void suspend()
	{
		onInterrupted();
		state = AgentState.SUSPENDED;
	}
	
	public void resume()
	{
		state = AgentState.RUNNING;
	}
	
	public void stop()
	{
		onExit();
		state = AgentState.STOPPED;
	}
	
	public abstract void update();

	
	public void move(int steps)
	{
		//world.changed();
	}
	
	public void onStart()
	{
		//empty method
		//can be overridden in subclasses if needed.
	}
	
	public void onInterrupted()
	{
		//empty method
		//can be overridden in subclasses if needed.
	}
	
	public void onExit()
	{
		//empty method
		//can be overridden in subclasses if needed.
	}
}
