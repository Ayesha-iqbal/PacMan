/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 * add more to be done
 */

package plague;
import simStation.*;
import mvc.*;

public class PlagueSimulation extends Simulation
{
	private static final long serialVersionUID = 1L;
	public static int VIRULENCE = 50; // % chance of infection
	public static int RESISTANCE = 2; // % chance of resisting infection
	// etc.
	
	public static int getVirulence() 
	{
		return VIRULENCE;
	}
	
	public static void setVIRULENCE(int v) 
	{
		VIRULENCE = v;
	}
	
	public static int getRESISTANCE() 
	{
		return RESISTANCE;
	}
	
	public static void setResistance(int r) 
	{
		RESISTANCE = r;
	}
	
	
}
