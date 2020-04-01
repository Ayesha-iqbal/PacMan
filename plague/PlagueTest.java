/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 */

package plague;

import mvc.*;
import simStation.*;

public class PlagueTest 
{
	public static void main(String[] args) {
		PlagueFactory factory = new PlagueFactory();
		AppPanel panel = new SimStationPanel(factory);
		panel.display();
	}
}
