package interfac;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultsPanel extends JPanel{

	private JLabel results;
	
	private SortingInterface si;
	
	public ResultsPanel(SortingInterface i) {
		
		setLayout(new GridLayout());
		setBorder(BorderFactory.createTitledBorder("Results"));
		setPreferredSize(new Dimension(300,10));
	}
}
