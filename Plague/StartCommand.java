package Plague;
public class StartCommand extends Command {

    public StartCommand(Model model) {

        super(model);

    }

    @Override
    public void execute() {

        if (!((Simulation) this.model).isRunning) {
            ((Simulation) this.model).start();
        }

    }

}
