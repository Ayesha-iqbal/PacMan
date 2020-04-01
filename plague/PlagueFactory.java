/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 */

package plague;
import mvc.*;
import simStation.*;

public class PlagueFactory extends SimStationFactory
{
	private Plague plague;
	
	@Override
	public Model makeModel() 
	{
		plague = new Plague();
		return plague;
	}
	
	@Override
	public View getView(Model m) 
	{
		return new PlagueView(plague);
	}
}
