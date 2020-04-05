package mvc;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JComponent implements PropertyChangeListener {

    protected Model model;

    public View(Model model){

        this.model = model;
        model.addPropertyChangeListener(this);
        setBorder(LineBorder.createBlackLineBorder());

    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

        repaint();

    }

    public Model getModel(){

        return this.model;

    }

    public void setModel(Model model){

        if (this.model != null) {

            this.model.removePropertyChangeListener(this);
        }

        this.model = model;

        if (model != null) {

            this.model.addPropertyChangeListener(this);
            repaint();

        }

    }

}
