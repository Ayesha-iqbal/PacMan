package RandomWalk;
import mvc.*;
import SimStationpac.*;
public class RandomWalkSimulation extends Simulation {

    private final static int AGENT_COUNT = 50;

    @Override
    public String getStats() {
        return "Number of agents: " + this.agents.length +
                "\nClock: " + this.clock;
    }

    @Override
    public Agent getNeighbor(Agent a) {

        double minDistance = -1;
        RandomWalker closestAgent = null;
        for (int i = 0; i < this.agents.length; i++) {
            if (this.agents[i] == a) {
                continue;
            }
            double distance = Math.sqrt(Math.pow(a.getX() - this.agents[i].getX(), 2) + Math.pow(a.getY() - this.agents[i].getY(), 2));
            if (distance < minDistance || minDistance == -1) {
                minDistance = distance;
                closestAgent = (RandomWalker) this.agents[i];
            }

        }
        return closestAgent;

    }

    @Override
    public void populate() {

        this.agents = new RandomWalker[AGENT_COUNT];
        for (int i = 0; i < this.agents.length; i++) {

            this.agents[i] = new RandomWalker("RW", "NORTH", (int) (Math.random() * WORLD_WIDTH + 1), (int) (Math.random() * WORLD_HEIGHT + 1), this);

        }

    }

}
