/**
 * RandomWalkSimulation extends Simulation
 * This random walk simulation creates 50 drunks who
 * move around in random directions at random steps for
 * the duration of the simulation.s
 * 
 * Edit history:
 * Ayesha 4/4/20
 * Emily 4/7/20
 */

package RandomWalk;
import mvc.*;
import simStation.*;
public class RandomWalkSimulation extends Simulation {

    private final static int AGENT_COUNT = 50;

    @Override
    public String getStats() {
        return "Number of agents: " + this.agents.length +
                "\nClock: " + this.clock;
    }

    @Override
    public Agent getNeighbor(Agent a) 
    {
		return null;
    }

    @Override
    public void populate() {

        this.agents = new Drunk[AGENT_COUNT];
        for (int i = 0; i < this.agents.length; i++) {

            this.agents[i] = new Drunk("RW", "NORTH", (int) (Math.random() * WORLD_WIDTH + 1), (int) (Math.random() * WORLD_HEIGHT + 1), this);

        }

    }

}
