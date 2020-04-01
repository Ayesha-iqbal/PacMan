/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 */

package simStation;

import java.awt.Color;
import java.awt.Graphics;
import mvc.*;


public class SimStationView extends View
{
	private static final long serialVersionUID = 1L;

	public SimStationView(Model model) 
	{
		super(model);
	}
	
	public void paintComponent(Graphics gc) 
	{
		Color oldColor = gc.getColor();
		
		//what to put here?
		
		gc.setColor(oldColor);
	}
}
