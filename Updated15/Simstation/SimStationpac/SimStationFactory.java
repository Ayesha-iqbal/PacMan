package SimStationpac;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;

public interface  SimStationFactory extends AppFactory{

    public  Model makeModel();

    public  String[] getEditCommands();

    public  Command makeEditCommand(Model model, String type);

    public  String getTitle();

    public  String[] getHelp();

    public  String about();

}
