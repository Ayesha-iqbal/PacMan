/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 */

package plague;

import java.awt.Color;
import java.awt.Graphics;
import mvc.*;
import simStation.*;

public class PlagueView extends View 
{
	private static final long serialVersionUID = 1L;

	public PlagueView(Plague plague) 
	{
		super(plague);
	}
	
	public void paintComponent(Graphics gc)
	{
		Plague p = (Plague)model;
		Color oldColor = gc.getColor();
		
		//test
		gc.setColor(Color.BLACK);
		gc.drawRect(0, 0, Plague.WORLD_SIZE, Plague.WORLD_SIZE);
		
		
		gc.setColor(oldColor);
		
	}
}
