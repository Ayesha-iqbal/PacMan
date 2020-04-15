package SimStationpac;
import java.awt.*;
import java.io.Serializable;
import mvc.*;
public abstract class Agent implements Serializable, Runnable {

    private String name;
    private String heading;
    private int x;
    private int y;
    private Color color;
    private AgentState state;
    private Simulation world;
    protected transient Thread thread;

    public Agent(String name, String heading, int x, int y, Simulation world) {

        this.thread = null;
        this.name = name;
        this.heading = heading;
        this.x = x;
        this.y = y;
        this.world = world;
        this.state = AgentState.STOPPED;

    }

    @Override
    public void run() {
        if (this.state == AgentState.READY) {
            this.state = AgentState.RUNNING;
            while (this.state == AgentState.RUNNING) {
                update();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void start() {
        if (this.state == AgentState.STOPPED) {
            this.state = AgentState.READY;
        }
        this.thread = new Thread(this, "Agent");
    }

    public void suspend() {
        if (this.state == AgentState.RUNNING) {
            this.state = AgentState.SUSPENDED;
        }
    }

    public void resume() {
        if (this.state == AgentState.SUSPENDED) {
            this.state = AgentState.READY;
        }
        this.thread = new Thread(this, "Agent");
        this.thread.start();
    }

    public void stop() {
        this.state = AgentState.STOPPED;
    }

    public void move(int steps) {
        if (this.heading == "NORTH") {
            this.y -= steps;
            if (this.y < 0) {
                this.y = this.world.WORLD_HEIGHT;
            }
        } else if (this.heading == "EAST") {
            this.x += steps;
            if (this.x > this.world.WORLD_WIDTH) {
                this.x = 0;
            }
        } else if (this.heading == "SOUTH") {
            this.y += steps;
            if (this.y > this.world.WORLD_HEIGHT) {
                this.y = 0;
            }
        } else if (this.heading == "WEST") {
            this.x -= steps;
            if (this.x < 0) {
                this.x = this.world.WORLD_WIDTH;
            }
        }
        this.world.changed();
    }

    public String getHeading() {

        return this.heading;

    }

    public int getX() {

        return this.x;

    }

    public int getY() {

        return this.y;

    }

    public Color getColor() {

        return this.color;

    }

    public Simulation getWorld() {

        return this.world;

    }

    public void setHeading(String heading) {

        this.heading = heading;

    }

    public void setColor(Color color) {

        this.color = color;

    }
    
    public String getName()
    {
    	return this.name;
    }

    public abstract void update();

}
