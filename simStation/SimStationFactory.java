/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 */

package simStation;
import mvc.*;

public abstract class SimStationFactory implements SimFactory 
{

	public String[] getEditCommands() 
	{
		return new String[] {"Start","Suspend","Resume","Stop","Stats"};
	}

	public Command makeEditCommand(Model model, String type) 
	{
		if (type == "Start")
			return new StartCommand(model);
		else if(type == "Suspend")
			return new SuspendCommand(model);
		else if(type == "Resume")
			return new ResumeCommand(model);
		else if(type == "Stop")
			return new StopCommand(model);
		else if(type == "Stats")
			return new StatsCommand(model);
		return null;
	}

	public String getTitle() 
	{ 
		return "SimStation";
	}

	public String[] getHelp() 
	{
		return new String[] {"The plague simulator models the spread of a virus through a population."
				+ " Red agents are infected and green ones aren't"};
	}

	public String about() 
	{
		return "SimStation version 1.0. Spring 2020 by PacMan";
	}
}