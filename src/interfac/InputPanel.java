package interfac;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InputPanel extends JPanel implements ActionListener{

	public static final String SORT = "n";
	
	private JTextField numbers;
	private JLabel labelNumbers;
	
	private JButton sort;
	
	private SortingInterface si;
	
	public InputPanel(SortingInterface sin) {
		
		si = sin;
		
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createTitledBorder("Input"));
		
		numbers = new JTextField();
		numbers.setPreferredSize(new Dimension(115,20));
		labelNumbers = new JLabel("Enter numbers to sort: ");
		
		sort = new JButton("Sort");
		sort.addActionListener(this);
		sort.setActionCommand(SORT);
		
		add(labelNumbers);
		add(numbers);
		add(sort);
		
	}
	
	public String[] getData() {
		String[] data = numbers.getText().split(",");
		return data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(SORT)) {
			si.sort(getData(), 1);
		}
	}

}
