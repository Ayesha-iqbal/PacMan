/**
 * RandomWalker extends Agent
 * These agents represent some population of individuals moving
 * randomly about their simulation spreading some infection. The
 * rate of infection is controlled by the virulence and resistance
 * and the interactions between neighboring agents.
 * 
 * Edit history:
 * Ayesha 4/4/20
 * Emily 4/8/20
 */

package plague;
import java.awt.*;
import mvc.*;
import simStation.*;

public class RandomWalker extends Agent {

    private boolean infected;

    private final static int MAX_STEPS = 10;
    private final static String[] headings = {"NORTH", "EAST", "SOUTH", "WEST"};

    public RandomWalker(String name, String heading, int x, int y, Simulation world, boolean infected) 
    {
        super(name, heading, x, y, world);
        this.infected = infected;
        if (this.infected) 
            setColor(Color.red);
        else
            setColor(Color.green);
    }

    @Override
    public void update() 
    {
        if (this.infected) 
            setColor(Color.red);
        else 
            setColor(Color.green);
        
        int steps = (int) (Math.random() * MAX_STEPS + 1);
        setHeading(headings[(int) (Math.random() * 4)]);
        move(steps);
        Agent neighbor = getWorld().getNeighbor(this);
        
        if (neighbor != null) 
        {
            if (((RandomWalker) neighbor).infected) 
            {
                int resistanceChooser = (int) (Math.random() * 100 + 1);
                this.infected = (resistanceChooser < PlagueSimulation.RESISTANCE) ? false : true;
            }
        }
    }

    public boolean isInfected() 
    {
        return this.infected;
    }

}
