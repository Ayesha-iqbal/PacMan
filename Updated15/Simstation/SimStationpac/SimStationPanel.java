package SimStationpac;
import javax.swing.*;
import mvc.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

public class SimStationPanel extends JPanel implements PropertyChangeListener, ActionListener {

    protected Model model;
    private JFrame frame;
    private Set<View> views;
    private SimStationFactory appFactory;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 300;

    public SimStationPanel(SimStationFactory appFactory) {

        super();

        this.appFactory = appFactory;
        model = appFactory.makeModel();
        views = new HashSet<View>();
        if (model != null) {

            model.addPropertyChangeListener(this);

        }
        frame = new JFrame();
        Container container = frame.getContentPane();
        container.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(appFactory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String commandString = actionEvent.getActionCommand();

        if (commandString == "Save") {

            Utilities.save(model, false);

        } else if (commandString == "SaveAs") {

            Utilities.save(model, true);

        } else if (commandString == "Open") {

            Model newModel = Utilities.open(model);
            if (newModel != null) {

                setModel(newModel);

            }

        } else if (commandString == "New") {

            Utilities.saveChanges(model);
            setModel(appFactory.makeModel());
            // needed cuz setModel sets to true:
            model.setUnsavedChanges(false);

        } else if (commandString == "Quit") {

            Utilities.saveChanges(model);
            System.exit(1);

        } else if (commandString == "About") {

            Utilities.inform(appFactory.about());

        } else if (commandString == "Help") {

            Utilities.inform(appFactory.getHelp());

        } else {

            Command command = appFactory.makeEditCommand(model, commandString);
            CommandProcessor.execute(command);

        }

    }

    
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

        this.model.removePropertyChangeListener(this);
        this.model = model;
        this.model.addPropertyChangeListener(this);
        for (View view : views) {

            view.setModel(this.model);

        }
        //this.model.copy(model);

    }
	
    protected JMenuBar createMenuBar() {

        JMenuBar result = new JMenuBar();
        // add file, edit, and help menus
        JMenu fileMenu =
                Utilities.makeMenu("File", new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);

        JMenu editMenu =
                Utilities.makeMenu("Edit", appFactory.getEditCommands(), this);
        result.add(editMenu);

        JMenu helpMenu =
                Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);

        return result;

    }

    @Override
    public Component add(Component component) {

        if (component instanceof View) {

            views.add((View) component);

        }
        return super.add(component);
    }

    public void display() {

        frame.setVisible(true);

    }

    public Model getModel() {

        return this.model;

    }

    public void setModel(Model model) {

        this.model = model;

    }

}
