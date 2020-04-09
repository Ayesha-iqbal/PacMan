/**
 * Drunk extends Agent
 * These agents of the random walk simulation are given
 * a random direction and and steps and so move randomly
 * around their world.
 * 
 * Edit history:
 * Ayesha 4/4/20
 * Emily 4/8/20
 */

package RandomWalk;
import java.awt.*;
import mvc.*;
import simStation.*;

public class Drunk extends Agent 
{
    private final static int MAX_STEPS = 10;
    private final static String[] headings = {"NORTH", "EAST", "SOUTH", "WEST"};

    public Drunk(String name, String heading, int x, int y, Simulation world) 
    {
        super(name, heading, x, y, world);
        setColor(Color.black);
    }

    @Override
    public void update() 
    {

        int steps = (int) (Math.random() * MAX_STEPS + 1);
        setHeading(headings[(int) (Math.random() * 4)]);
        move(steps);

    }

}
