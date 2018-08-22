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
	
	private JRadioButton integ;
	private JRadioButton doub;	
	
	private SortingInterface si;
	
	public InputPanel(SortingInterface sin) {
		
		si = sin;
		
		setLayout(new GridLayout(2,1));
		setBorder(BorderFactory.createTitledBorder("Input"));
		
		numbers = new JTextField();
		numbers.setPreferredSize(new Dimension(115,20));
		labelNumbers = new JLabel("Enter numbers to sort (separated by -): ");
		
		sort = new JButton("Sort");
		sort.addActionListener(this);
		sort.setActionCommand(SORT);
		
		doub = new JRadioButton("Double");
		integ = new JRadioButton("Integer");
		ButtonGroup bg = new ButtonGroup();
		bg.add(integ);
		bg.add(doub);
		
		JPanel au = new JPanel(new FlowLayout());
		au.setPreferredSize(new Dimension(115,10));
		au.add(integ);
		au.add(doub);
		
		JPanel aux = new JPanel(new FlowLayout());
		aux.add(labelNumbers);
		aux.add(numbers);
		aux.add(sort);
		
		add(au);
		add(aux);
		
	}
	
	public String[] getData() {
		String[] data = numbers.getText().split("-");
		return data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(SORT)) {
			if(doub.isSelected()) {
				si.sortDouble(getData(), 0);				
			}
			else {
				si.sortInt(getData(), 0);
			}
		}
	}

}
