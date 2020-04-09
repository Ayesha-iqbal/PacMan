/**
 * PlaguePanel extends SimStationPanel
 * It sets up the panel and placement of buttons
 * and graphical view of the simulation.
 * 
 * Edit history:
 * Ayesha 4/4/20
 */

package plague;
import javax.swing.*;
import mvc.*;
import simStation.*;

import java.awt.*;

public class PlaguePanel extends SimStationPanel {

    private JButton startButton;
    private JButton suspendButton;
    private JButton resumeButton;
    private JButton stopButton;
    private JButton statsButton;

    public PlaguePanel(SimStationFactory simStationFactory) {

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
        buttonsPanel.setLayout(new GridLayout(5,1));
        
        JPanel startP = new JPanel();
  		startP.add(startButton);
  		buttonsPanel.add(startP);
  		JPanel suspendP = new JPanel();
  		suspendP.add(suspendButton);
  		buttonsPanel.add(suspendP);
  		JPanel resumeP = new JPanel();
  		resumeP.add(resumeButton);
  		buttonsPanel.add(resumeP);
  		JPanel stopP = new JPanel();
  		stopP.add(stopButton);
  		buttonsPanel.add(stopP);
  		JPanel statsP = new JPanel();
  		statsP.add(statsButton);
  		buttonsPanel.add(statsP);

        
        /*buttonsPanel.add(startButton);
        buttonsPanel.add(suspendButton);
        buttonsPanel.add(resumeButton);
        buttonsPanel.add(stopButton);
        buttonsPanel.add(statsButton);*/
        
        add(buttonsPanel);
        add(simulationView);
    }

    public static void main(String[] args) 
    {
        SimStationFactory simStationFactory = new PlagueFactory();
        SimStationPanel appPanel = new PlaguePanel(simStationFactory);
        appPanel.display();
    }

}
