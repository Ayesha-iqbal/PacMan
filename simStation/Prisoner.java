/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 * to be done
 */

package simStation;

public class Prisoner extends Agent
{
	private int fitness;
	
	public Prisoner(String name, String heading, int x, int y) 
	{
		super(name, heading, x, y);
		fitness = 0;
	}
	
	public boolean cooperate()
	{
		return false;
		//to do
	}
	
	public boolean cheat()
	{
		return false;
		//to do
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
