package Tournament;
public class TournamentSimulation extends Simulation {

    private final static int AGENT_COUNT = 50;
    public static int ALWAYS_CHEAT__SCORE = 0;
    public static int ALWAYS_CHEAT__COUNT = 0;
    public static int ALWAYS_COOPERATE__SCORE = 0;
    public static int ALWAYS_COOPERATE__COUNT = 0;
    public static int RAND_COOP_SCORE = 0;
    public static int RAND_COOP_COUNT = 0;
    public static int COOP_ONLY_IF_SCORE = 0;
    public static int COOP_ONLY_IF_COUNT = 0;

    @Override
    public String getStats() {
        return "Number of agents: " + this.agents.length +
                "\nClock: " + this.clock;
    }

    @Override
    public Agent getNeighbor(Agent a) {

        double minDistance = -1;
        PrisonerWalker closestAgent = null;
        for (int i = 0; i < this.agents.length; i++) {
            if (this.agents[i] == a) {
                continue;
            }
            double distance = Math.sqrt(Math.pow(a.getX() - this.agents[i].getX(), 2) + Math.pow(a.getY() - this.agents[i].getY(), 2));
            if (distance < minDistance || minDistance == -1) {
                minDistance = distance;
                closestAgent = (PrisonerWalker) this.agents[i];
            }

        }
        return closestAgent;

    }

    @Override
    public void populate() {

        this.agents = new PrisonerWalker[AGENT_COUNT];
        String[] strategies = {"ALWAYS_CHEAT", "ALWAYS_COOPERATE", "RAND_COOP", "COOP_ONLY_IF"};
        for (int i = 0; i < this.agents.length; i++) {

            this.agents[i] = new PrisonerWalker("RW", "NORTH", (int) (Math.random() * WORLD_WIDTH + 1), (int) (Math.random() * WORLD_HEIGHT + 1), this, strategies[(int) (Math.random() * 3 + 1)]);

        }

    }

}
