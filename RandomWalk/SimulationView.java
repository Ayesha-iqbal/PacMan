package RandomWalk;
import java.awt.*;

public class SimulationView extends View {

    private final static int AGENT_SIZE = 4;

    public SimulationView(Model model) {

        super(model);

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (Simulation.WORLD_WIDTH != getWidth()) {
            Simulation.WORLD_WIDTH = getWidth();
        }
        if (Simulation.WORLD_HEIGHT != getHeight()) {
            Simulation.WORLD_HEIGHT = getHeight();
        }

        if (((Simulation) this.model).agents != null) {

            for (int i = 0; i < ((Simulation) this.model).agents.length; i++) {

                int agentX = ((Simulation) this.model).agents[i].getX();
                int agentY = ((Simulation) this.model).agents[i].getY();
                g.setColor(((Simulation) this.model).agents[i].getColor());
                g.fillRect(agentX, agentY, AGENT_SIZE, AGENT_SIZE);

            }

        }

    }

}
