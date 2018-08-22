package interfac;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Sorting;

public class SortingInterface extends JFrame{

	private InputPanel inputPanel;
	private GeneratePanel generatePanel;
//	private ResultsPanel resultsPanel;
	
	private Sorting sorting;
	
	public SortingInterface() {
		
		setLayout(new BorderLayout());
		setTitle("Sorting program");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(460,370));
		setResizable(false);
		
		sorting = new Sorting();
		
		inputPanel = new InputPanel(this);
		generatePanel = new GeneratePanel(this);
//		resultsPanel = new ResultsPanel(this);
		
		JPanel aux = new JPanel(new FlowLayout());
		aux.setPreferredSize(new Dimension());
		aux.add(inputPanel);
		aux.add(generatePanel);
		
		add(aux, BorderLayout.CENTER);
//		add(resultsPanel, BorderLayout.EAST);
		
		pack();
	}
	
	public void sortInt(String[] data, int code){
		ArrayList results = sorting.sortInt(data, code);
		String txt = "";
		for (int i = 0; i < results.size(); i++) {
			if(i%2 == 0){
				String d = (String) results.get(i);
				txt += d+"\n";
			}
			else{
				String word = "";
				int[] arr = (int[]) results.get(i);
				for (int j = 0; j < arr.length; j++) {
					word += arr[j]+"    ";
				}
				txt+="Result: "+word+"\n"+"\n";
			}
		}
		JOptionPane.showMessageDialog(this, txt);
	}
	
	public void sortDouble(String[] data, int code){
		ArrayList<Object> results = sorting.sortDouble(data, code);
		String txt = "";
		for (int i = 0; i < results.size(); i++) {
			if(i%2 == 0){
				String d = (String) results.get(i);
				txt += d+"\n";
			}
			else{
				String word = "";
				System.out.println();
				double[] arr = (double[]) results.get(i);
				for (int j = 0; j < arr.length; j++) {
					word += arr[j]+"    ";
				}
				txt+="Result: "+word+"\n"+"\n";
			}
		}
		JOptionPane.showMessageDialog(this, txt);
	}
	
	public static void main(String[] args) {
		SortingInterface i = new SortingInterface();
		i.setVisible(true);
	}
}
