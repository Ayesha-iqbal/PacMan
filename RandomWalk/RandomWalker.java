package RandomWalk;
import java.awt.*;

public class RandomWalker extends Agent {

    private final static int MAX_STEPS = 10;
    private final static String[] headings = {"NORTH", "EAST", "SOUTH", "WEST"};

    public RandomWalker(String name, String heading, int x, int y, Simulation world) {
        super(name, heading, x, y, world);
        setColor(Color.red);
    }

    @Override
    public void update() {

        int steps = (int) (Math.random() * MAX_STEPS + 1);
        setHeading(headings[(int) (Math.random() * 3 + 1)]);
        move(steps);

    }

}
