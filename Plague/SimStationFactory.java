package Plague;
public abstract class SimStationFactory {

    public abstract Model makeModel();

    public abstract String[] getEditCommands();

    public abstract Command makeEditCommand(Model model, String type);

    public abstract String getTitle();

    public abstract String getHelp();

    public abstract String about();

}
