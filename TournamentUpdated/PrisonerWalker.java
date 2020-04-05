package Tournament;
import java.awt.*;
import mvc.*;
import SimStationpac.*;

public class PrisonerWalker extends Agent {

    private String strategy;
    private int fitness;
    private int gameTime;
    private String lastOpponentDecision;
    private int game_timeout;

    private final static int MAX_STEPS = 10;
    private final static String[] headings = {"NORTH", "EAST", "SOUTH", "WEST"};
    private final static int GAME_LENGTH = 50;
    private final static int GLOBAL_GAME_TIMEOUT = 100;

    public static int last_time_printed = 0;

    public PrisonerWalker(String name, String heading, int x, int y, Simulation world, String strategy) {
        super(name, heading, x, y, world);
        this.strategy = strategy;
        this.fitness = 0;
        this.gameTime = 0;
        this.lastOpponentDecision = "None";
        this.game_timeout = 0;
        setColor(Color.red);
    }

    @Override
    public void update() {

        int time = ((Simulation) getWorld()).clock;
        if (time > 99) {
            if (time % 100 == 0 || last_time_printed != time) {

                int alwaysCheatAverage = (int) ((float) ((TournamentSimulation) getWorld()).ALWAYS_CHEAT__SCORE / ((TournamentSimulation) getWorld()).ALWAYS_CHEAT__COUNT);
                int alwaysCooperateAverage = (int) ((float) ((TournamentSimulation) getWorld()).ALWAYS_COOPERATE__SCORE / ((TournamentSimulation) getWorld()).ALWAYS_COOPERATE__COUNT);
                int randomCooperateAverage = (int) ((float) ((TournamentSimulation) getWorld()).RAND_COOP_SCORE / ((TournamentSimulation) getWorld()).RAND_COOP_COUNT);
                int cooperateOnlyIf = (int) ((float) ((TournamentSimulation) getWorld()).COOP_ONLY_IF_SCORE / ((TournamentSimulation) getWorld()).COOP_ONLY_IF_COUNT);
                Utilities.inform("Always cheat average: " + alwaysCheatAverage +
                        "\nAlways cooperate average: " + alwaysCooperateAverage +
                        "\nRandom cooperate average: " + randomCooperateAverage +
                        "\nCooperate only if the last one did average :" + cooperateOnlyIf);
                last_time_printed = time;

            }
        }

        if (gameTime == 0) {
            if (this.game_timeout == 0) {
                this.gameTime = GAME_LENGTH;
                Agent neighbor = ((TournamentSimulation) getWorld()).getNeighbor(this);
                setScores(this, getDecision(this), neighbor, getDecision(neighbor));
                this.game_timeout = GLOBAL_GAME_TIMEOUT;
            }
            int steps = (int) (Math.random() * MAX_STEPS + 1);
            setHeading(headings[(int) (Math.random() * 3 + 1)]);
            move(steps);
            this.game_timeout--;
        } else {

            gameTime--;

        }

    }

    private void setScores(Agent a1, String a1decision, Agent a2, String a2decision) {

        int a1addition = 0;
        int a2addition = 0;

        if (a1decision == "CHEAT") {

            if (a2decision == "CHEAT") {

                a1addition = 1;
                a2addition = 1;

            } else if (a2decision == "COOPERATE") {

                a1addition = 5;
                a2addition = 0;

            }

        } else if (a1decision == "COOPERATE") {

            if (a2decision == "CHEAT") {

                a1addition = 0;
                a2addition = 5;

            } else if (a2decision == "COOPERATE") {

                a1addition = 3;
                a2addition = 3;

            }

        }

        ((PrisonerWalker) a1).fitness += a1addition;
        ((PrisonerWalker) a2).fitness += a2addition;

        addToStrategies(a1, a1addition, a2, a2addition);

    }

    public String getDecision(Agent a) {

        if (((PrisonerWalker) a).strategy == "ALWAYS_CHEAT") {

            return "CHEAT";

        } else if (((PrisonerWalker) a).strategy == "ALWAYS_COOPERATE") {

            return "COOPERATE";

        } else if (((PrisonerWalker) a).strategy == "RAND_COOP") {

            int chooser = (int) (Math.random() * 1 + 1) + 1;
            String decision = (chooser == 1) ? "CHEAT" : "COOPERATE";
            return decision;

        } else if (((PrisonerWalker) a).strategy == "COOP_ONLY_IF") {

            if (((PrisonerWalker) a).lastOpponentDecision == "COOPERATE") {

                return "COOPERATE";

            } else if (((PrisonerWalker) a).lastOpponentDecision == "CHEAT") {

                return "CHEAT";

            }

        }

        return "None";

    }

    public void addToStrategies(Agent a1, int a1addition, Agent a2, int a2addition) {

        if (((PrisonerWalker) a1).strategy == "ALWAYS_CHEAT") {

            ((TournamentSimulation) getWorld()).ALWAYS_CHEAT__COUNT++;
            ((TournamentSimulation) getWorld()).ALWAYS_CHEAT__SCORE += a1addition;

        } else if (((PrisonerWalker) a1).strategy == "ALWAYS_COOPERATE") {

            ((TournamentSimulation) getWorld()).ALWAYS_COOPERATE__COUNT++;
            ((TournamentSimulation) getWorld()).ALWAYS_COOPERATE__SCORE += a1addition;

        } else if (((PrisonerWalker) a1).strategy == "RAND_COOP") {

            ((TournamentSimulation) getWorld()).RAND_COOP_COUNT++;
            ((TournamentSimulation) getWorld()).RAND_COOP_SCORE += a1addition;

        } else if (((PrisonerWalker) a1).strategy == "COOP_ONLY_IF") {

            ((TournamentSimulation) getWorld()).COOP_ONLY_IF_COUNT++;
            ((TournamentSimulation) getWorld()).COOP_ONLY_IF_SCORE += a1addition;

        }

        if (((PrisonerWalker) a2).strategy == "ALWAYS_CHEAT") {

            ((TournamentSimulation) getWorld()).ALWAYS_CHEAT__COUNT++;
            ((TournamentSimulation) getWorld()).ALWAYS_CHEAT__SCORE += a1addition;

        } else if (((PrisonerWalker) a2).strategy == "ALWAYS_COOPERATE") {

            ((TournamentSimulation) getWorld()).ALWAYS_COOPERATE__COUNT++;
            ((TournamentSimulation) getWorld()).ALWAYS_COOPERATE__SCORE += a1addition;

        } else if (((PrisonerWalker) a2).strategy == "RAND_COOP") {

            ((TournamentSimulation) getWorld()).RAND_COOP_COUNT++;
            ((TournamentSimulation) getWorld()).RAND_COOP_SCORE += a1addition;

        } else if (((PrisonerWalker) a2).strategy == "COOP_ONLY_IF") {

            ((TournamentSimulation) getWorld()).COOP_ONLY_IF_COUNT++;
            ((TournamentSimulation) getWorld()).COOP_ONLY_IF_SCORE += a1addition;

        }

    }

}
