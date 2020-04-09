/**
 * PlagueSimulation extends Simulation
 * This simulates the spread of an infection in a population of set size
 * It spreads over time as the agents move randomly and interact with
 * one another. 
 * 
 * Edit history:
 * Ayesha 4/4/20
 * Emily 4/8/20
 */

package plague;
import mvc.*;
import simStation.*;
public class PlagueSimulation extends Simulation {

    private final static int AGENT_COUNT = 50;
    public final static int VIRULENCE = 50;
    public final static int RESISTANCE = 12;

    @Override
    public String getStats() {

        int infectedCounter = 0;
        for (Agent agent : this.agents) {
            if (((RandomWalker) agent).isInfected()) {
                infectedCounter++;
            }
        }
        double infectedPercentage = ((float) infectedCounter / this.agents.length) * 100;

        return "Number of agents: " + this.agents.length +
                "\nClock: " + this.clock +
                "\n% Infected: " + infectedPercentage;

    }

    @Override
    public Agent getNeighbor(Agent a) {

        for (int i = 0; i < this.agents.length; i++) {
            if (this.agents[i] == a) {
                continue;
            }
            double distance = Math.sqrt(Math.pow(a.getX() - this.agents[i].getX(), 2) + Math.pow(a.getY() - this.agents[i].getY(), 2));
            if (distance <= 4) {
                return this.agents[i];
            }
        }
        return null;

    }

    @Override
    public void populate() {

        this.agents = new RandomWalker[AGENT_COUNT];
        for (int i = 0; i < this.agents.length; i++) {

            int infectedChooser = (int) (Math.random() * 100);
            boolean infected = (infectedChooser < VIRULENCE) ? true : false;
            this.agents[i] = new RandomWalker("RW", "NORTH", (int) (Math.random() * WORLD_WIDTH + 1), (int) (Math.random() * WORLD_HEIGHT + 1), this, infected);

        }

    }

}
