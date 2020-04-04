package RandomWalk;
public class ResumeCommand extends Command {

    public ResumeCommand(Model model) {

        super(model);

    }

    @Override
    public void execute() {

        if (((Simulation) this.model).isRunning) {
            ((Simulation) this.model).resume();
        }

    }

}
