package Tournament;
public class StatsCommand extends Command {

    public StatsCommand(Model model) {

        super(model);

    }

    @Override
    public void execute() {

        if (((TournamentSimulation) this.model).isRunning) {
            Utilities.inform(((Simulation) this.model).getStats());
        } else {
            Utilities.inform("Number of agents: 0" +
                    "\nClock: " + ((Simulation) this.model).clock);
        }

    }

}
