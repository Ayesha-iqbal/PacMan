/**
 * PlagueFactory extends SimStationFactory
 * It contains all the menu commands and can 
 * create a new plague simulation.
 * 
 * Edit history:
 * Ayesha 4/4/20
 * Emily 4/8/20
 */

package plague;
import mvc.*;
import simStation.*;
public class PlagueFactory extends SimStationFactory 
{

    @Override
    public Model makeModel() {

        return new PlagueSimulation();

    }

    @Override
    public String[] getEditCommands() {

        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};

    }

    @Override
    public Command makeEditCommand(Model model, String type) {

        if (type == "Start") {
            return new StartCommand(model);
        } else if (type == "Suspend") {
            return new SuspendCommand(model);
        } else if (type == "Resume") {
            return new ResumeCommand(model);
        } else if (type == "Stop") {
            return new StopCommand(model);
        } else if (type == "Stats") {
            return new StatsCommand(model);
        }
        return null;

    }

    @Override
    public String getTitle() {

        return "SimStation: Plague";

    }


    @Override
    public String getHelp() {

        return "Click:\n " +
                "1. Start - start the simulation.\n " +
                "2. Suspend - pause the simulation.\n " +
                "3. Resume - resume the simulation.\n " +
                "4. Stop - stop the simulation.\n " +
                "5. Stats - show stats.\n";

    }

    @Override
    public String about() {

        return "SimStation version 1.0 Plague.";

    }

}
