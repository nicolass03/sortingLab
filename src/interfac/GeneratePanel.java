package interfac;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GeneratePanel extends JPanel implements ItemListener, ActionListener{

	public static final String[] DATA_OPTIONS = {"Ordered", "Ordered backwards","Random","Percentually order"};
	public static final String SORT = "n";
	
	private JTextField range;
	private JTextField size;
	private JLabel rangeLabel;
	private JLabel sizeLabel;
	private JLabel optionsLabel;
	private JLabel percentageLabel;
	private JTextField percentage;
	
	private JCheckBox canRepeat;
	
	private JComboBox options;
	
	private JRadioButton integ;
	private JRadioButton doub;	
	
	private SortingInterface si;
	
	private JButton sort;
	
	public GeneratePanel(SortingInterface i) {
		si = i;
		
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createTitledBorder("Generate"));
		setPreferredSize(new Dimension(333,190));
		
		rangeLabel = new JLabel("Range:");
		sizeLabel = new JLabel("Size:");
		range = new JTextField();
		range.setPreferredSize(new Dimension(115,20));
		size = new JTextField();
		size.setPreferredSize(new Dimension(115,20));
		percentage = new JTextField();
		percentage.setEnabled(false);
		percentage.setPreferredSize(new Dimension(115,20));
		percentageLabel = new JLabel("Percentage");
		canRepeat = new JCheckBox("Repeat numbers");
		
		options = new JComboBox(DATA_OPTIONS);
		options.addItemListener(this);
		optionsLabel = new JLabel("Options");
		
		doub = new JRadioButton("Double");
		integ = new JRadioButton("Integer");
		ButtonGroup bg = new ButtonGroup();
		bg.add(integ);
		bg.add(doub);
		
		JPanel au = new JPanel(new FlowLayout());
		au.add(integ);
		au.add(doub);
		
		JPanel aux = new JPanel(new FlowLayout());
		aux.setPreferredSize(new Dimension(325,25));
		aux.add(rangeLabel);
		aux.add(range);
		
		JPanel aux1 = new JPanel(new FlowLayout());
		aux1.setPreferredSize(new Dimension(325,25));
		aux1.add(sizeLabel);
		aux1.add(size);
		
		JPanel aux2 = new JPanel(new FlowLayout());
		aux2.setPreferredSize(new Dimension(325,35));
		aux2.add(optionsLabel);
		aux2.add(options);
		
		JPanel aux3 = new JPanel(new FlowLayout());
		aux3.setPreferredSize(new Dimension(325,25));
		aux3.add(canRepeat);
		
		JPanel aux4 = new JPanel(new FlowLayout());
		aux4.add(percentageLabel);
		aux4.add(percentage);
		
		sort = new JButton("Sort");
		sort.addActionListener(this);
		sort.setActionCommand(SORT);
		
		add(au);
		add(aux);
		add(aux1);
		add(aux3);
		add(aux2);
		add(aux4);
		add(sort);
	}
	
	public String[] getData() {
		String rang = range.getText();
		String size = this.size.getText();
		String option = (String) options.getSelectedItem();
		String repeat = (canRepeat.isSelected())?"true":"false";
		String percentag = percentage.getText();
		
		String[] data = {rang,size,option,repeat,percentag};
		return data;
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		
		if(options.getSelectedIndex() == 3) {
			percentageOption(true);
		}
		else {
			percentageOption(false);
		}
	}

	public void percentageOption(boolean added) {
		if(added) {	
			percentage.setEnabled(true);
			validate();
		}
		else {
			percentage.setEnabled(false);
			validate();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(SORT)) {
			if(doub.isSelected()) {
				si.sortDouble(getData(), 2);				
			}
			else {
				si.sortInt(getData(), 2);
			}
		}
	}
}
