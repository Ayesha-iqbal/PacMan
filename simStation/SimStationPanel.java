/**
 * Author: Emily Furuichi
 * Date: 3/31/2020
 */

package simStation;

import mvc.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class SimStationPanel extends AppPanel 
{
	private static final long serialVersionUID = 1L;
	private JButton start, suspend, resume, stop, stats;
	
	public SimStationPanel(SimFactory factory) 
	{
		super(factory);
		View view = factory.getView((Model)model);
		this.setLayout(new GridLayout(1, 2));
		
		start = new JButton("Start");
		start.addActionListener(this);
		suspend = new JButton("Suspend");
		suspend.addActionListener(this);
		resume = new JButton("Resume");
		resume.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		stats = new JButton("Stats");
		stats.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,1));
		
		JPanel startPanel = new JPanel();
		startPanel.add(start);
		buttonPanel.add(startPanel);
		JPanel suspendPanel = new JPanel();
		suspendPanel.add(suspend);
		buttonPanel.add(suspendPanel);
		JPanel resumePanel = new JPanel();
		resumePanel.add(resume);
		buttonPanel.add(resumePanel);
		JPanel stopPanel = new JPanel();
		stopPanel.add(stop);
		buttonPanel.add(stopPanel);
		JPanel statsPanel = new JPanel();
		statsPanel.add(stats);
		buttonPanel.add(statsPanel);
		
		add(buttonPanel,"West");
		add(view,"East");
	}
}

