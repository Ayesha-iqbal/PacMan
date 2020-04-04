package RandomWalk;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Simulation extends Model {

    private Timer timer;
    protected int clock = 0;
    protected Agent[] agents = null;
    public boolean isRunning = false;

    protected static int WORLD_WIDTH = -1;
    protected static int WORLD_HEIGHT = -1;

    private void startTimer() {

        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);

    }

    private void stopTimer() {

        timer.cancel();
        timer.purge();

    }

    private class ClockUpdater extends TimerTask {

        public void run() {

            clock++;

        }

    }

    public void start() {

        this.isRunning = true;
        if (agents == null) {
            populate();
        }
        startTimer();
        for (int i = 0; i < this.agents.length; i++) {

            this.agents[i].start();
            this.agents[i].thread.start();

        }

    }

    public void suspend() {

        stopTimer();
        for (int i = 0; i < this.agents.length; i++) {
            this.agents[i].suspend();
        }

    }

    public void resume() {

        for (int i = 0; i < this.agents.length; i++) {

            this.agents[i].resume();

        }
        startTimer();

    }

    public void stop() {

        this.isRunning = false;
        stopTimer();
        for (int i = 0; i < this.agents.length; i++) {
            this.agents[i].stop();
        }
        this.agents = null;
        this.clock = 0;
        firePropertyChange(null, null, null);

    }

    public void changed() {
        firePropertyChange(null, null, null);
    }

    public abstract String getStats();

    public abstract Agent getNeighbor(Agent a);

    public abstract void populate();

}