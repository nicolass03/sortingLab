package interfac;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Sorting;

public class SortingInterface extends JFrame{

	private InputPanel inputPanel;
	private GeneratePanel generatePanel;
	private ResultsPanel resultsPanel;
	
	private Sorting sorting;
	
	public SortingInterface() {
		
		setLayout(new BorderLayout());
		setTitle("Sorting program");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(660,300));
		
		sorting = new Sorting();
		
		inputPanel = new InputPanel(this);
		generatePanel = new GeneratePanel(this);
		resultsPanel = new ResultsPanel(this);
		
		JPanel aux = new JPanel(new FlowLayout());
		aux.setPreferredSize(new Dimension());
		aux.add(inputPanel);
		aux.add(generatePanel);
		
		add(aux, BorderLayout.CENTER);
		add(resultsPanel, BorderLayout.EAST);
		
		pack();
	}
	
	public void sort(String[] data, int code){
		sorting.sort(data, code);
	}
	
	public static void main(String[] args) {
		SortingInterface i = new SortingInterface();
		i.setVisible(true);
	}
}
