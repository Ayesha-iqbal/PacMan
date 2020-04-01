/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 */

package simStation;
import mvc.*;

public interface SimFactory extends AppFactory
{
	public View getView(Model m);
}
