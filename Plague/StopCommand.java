package Plague;
public class StopCommand extends Command {

    public StopCommand(Model model) {

        super(model);

    }

    @Override
    public void execute() {

        if (((Simulation) this.model).isRunning) {
            ((Simulation) this.model).stop();
        }

    }

}
