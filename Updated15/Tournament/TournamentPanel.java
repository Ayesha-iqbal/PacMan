/**
 * Tournament panel extends SimStationPanel
 * It sets up the panel and placement of buttons
 * and graphical view of the game.
 * 
 * Edit history:
 * Ayesha 4/4/20
 */
package Tournament;
import javax.swing.*;
import java.awt.*;
import mvc.*;
import SimStationpac.*;

public class TournamentPanel extends SimStationPanel 
{
    private JButton startButton;
    private JButton suspendButton;
    private JButton resumeButton;
    private JButton stopButton;
    private JButton statsButton;

    public TournamentPanel(SimStationFactory simStationFactory) 
    {
        super(simStationFactory);
        SimulationView simulationView = new SimulationView(this.model);
        this.setLayout(new GridLayout(1, 2));

        startButton = new JButton("Start");
        suspendButton = new JButton("Suspend");
        resumeButton = new JButton("Resume");
        stopButton = new JButton("Stop");
        statsButton = new JButton("Stats");

        startButton.addActionListener(this);
        suspendButton.addActionListener(this);
        resumeButton.addActionListener(this);
        stopButton.addActionListener(this);
        statsButton.addActionListener(this);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(startButton);
        buttonsPanel.add(suspendButton);
        buttonsPanel.add(resumeButton);
        buttonsPanel.add(stopButton);
        buttonsPanel.add(statsButton);
        add(buttonsPanel,"East");
        add(simulationView,"West");
    }

    public static void main(String[] args) 
    {
        SimStationFactory simStationFactory = new TournamentFactory();
        SimStationPanel appPanel = new TournamentPanel(simStationFactory);
        appPanel.display();
    }

}