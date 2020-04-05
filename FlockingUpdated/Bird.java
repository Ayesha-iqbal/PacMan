package Flocking;
import java.awt.*;
import mvc.*;
import SimStationpac.*;


public class Bird extends Agent {

    private int steps;
    private Agent neighbor;

    public Bird(String name, String heading, int x, int y, Simulation world, int steps) {
        super(name, heading, x, y, world);
        this.steps = steps;
        setColor(Color.red);
    }

    @Override
    public void update() {

        this.neighbor = getWorld().getNeighbor(this);
        this.steps = ((Bird) neighbor).getSteps();
        setHeading(neighbor.getHeading());
        move(steps);

    }

    public int getSteps() {

        return this.steps;

    }

}
