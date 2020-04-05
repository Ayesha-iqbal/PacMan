package SimStationpac;

import mvc.*;

public class SuspendCommand extends Command {

    public SuspendCommand(Model model) {

        super(model);

    }

    @Override
    public void execute() {

        if (((Simulation) this.model).isRunning) {
            ((Simulation) this.model).suspend();
        }

    }

}
