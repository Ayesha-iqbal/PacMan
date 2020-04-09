/**
 * FlockingSimulation extends Simulation
 * This flocking simulation simulates birds moving randomly 
 * initially and how they interact and influence one another 
 * over time. Birds copy the direction and heading of their 
 * neighbor and eventually move in the same direction.
 * 
 * Edit history:
 * Ayesha 4/4/20
 * Emily 4/8/20
 */

package Flocking;

import mvc.*;
import simStation.*;

public class FlockingSimulation extends Simulation {

    private final static int AGENT_COUNT = 50;
    private final static int MAX_STEPS = 10;

    @Override
    public String getStats() {
        return "Number of agents: " + this.agents.length +
                "\nClock: " + this.clock;
    }

    @Override
    public Agent getNeighbor(Agent a) {

        double minDistance = -1;
        Bird closestAgent = null;
        for (int i = 0; i < this.agents.length; i++) {

            if (this.agents[i] == a) {
                continue;
            }

            double distance = Math.sqrt(Math.pow(a.getX() - this.agents[i].getX(), 2) + Math.pow(a.getY() - this.agents[i].getY(), 2));
            if (distance < minDistance || minDistance == -1) {
                minDistance = distance;
                closestAgent = (Bird) this.agents[i];
            }

        }
        return closestAgent;

    }

    @Override
    public void populate() 
    {

        this.agents = new Bird[AGENT_COUNT];

        String[] headings = {"NORTH", "EAST", "SOUTH", "WEST"};

        for (int i = 0; i < this.agents.length; i++) 
        {

            this.agents[i] = new Bird("BIRD", headings[(int) (Math.random() * 4)], (int) (Math.random() * WORLD_WIDTH + 1), (int) (Math.random() * WORLD_HEIGHT + 1), this,
                    (int) (Math.random() * MAX_STEPS + 1));

        }

    }

}
