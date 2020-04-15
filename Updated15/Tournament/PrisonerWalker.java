/**
 * PrisonerWalker extends Agent and represents a prisoner in the
 * Prisoner's Dilemma Simulation. Each prisoner possesses a fitness
 * score a strategy about how to play. They play with their nearest
 * neighbor depending on the game time. 
 * 
 * Edit history: 
 * Ayesha 4/4/20
 * Emily 4/8/20
 * Adam 4/14/20
 */

package Tournament;
import java.awt.*;
import mvc.*;
import SimStationpac.*;

public class PrisonerWalker extends Agent {

    private Strategy strategy;
    private int fitness;
    private int gameTime;
    private String lastOpponentDecision;
    private int game_timeout;

    private final static int MAX_STEPS = 10;
    private final static String[] headings = {"NORTH", "EAST", "SOUTH", "WEST"};
    private final static int GAME_LENGTH = 2;
    private final static int GLOBAL_GAME_TIMEOUT = 100;

    public static int last_time_printed = 0;
    
    public PrisonerWalker(String name, String heading, int x, int y, Simulation world, Strategy strategy)
    {
    	super(name, heading, x, y, world);
    	this.strategy = strategy;
        this.fitness = 0;
        this.gameTime = 0;
        this.lastOpponentDecision = "COOPERATE";
        this.game_timeout = 0;
        setColor(Color.blue);
    }

    @Override
    public void update() {

        int time = ((Simulation) getWorld()).clock;
        if (time > 0 && (time % 100 == 0 || last_time_printed == time)) 
        {
        	TournamentSimulation.printAverages(this.getName());
            last_time_printed = time;
        }

        if (gameTime == 0) {
            if (this.game_timeout == 0) {
                this.gameTime = GAME_LENGTH;
                Agent neighbor = ((TournamentSimulation) getWorld()).getNeighbor(this);
                String neighborDeci = ((PrisonerWalker)neighbor).strategy.getDecision(((PrisonerWalker)neighbor).lastOpponentDecision);
                setScores(this, this.strategy.getDecision(lastOpponentDecision), neighbor, neighborDeci);
                this.game_timeout = GLOBAL_GAME_TIMEOUT;
            }
            int steps = (int) (Math.random() * MAX_STEPS + 1);
            setHeading(headings[(int) (Math.random() * 4)]);
            move(steps);
            this.game_timeout--;
        } else {

            gameTime--;

        }

    }

 
    
    private String getName() {
		
		return null;
	}

	public int getScores()
    {
    	return fitness;
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
        
        ((PrisonerWalker)a2).lastOpponentDecision = a1decision;
        ((PrisonerWalker)a1).lastOpponentDecision = a2decision;
        
        ((PrisonerWalker) a1).fitness += a1addition;
        ((PrisonerWalker) a2).fitness += a2addition;

  

    }

    

}