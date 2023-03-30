package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.AddingExistingElementException;
import posPD.Register;
import posPD.Store;
import posPD.TaxCategory;
import posPD.TaxRate;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TaxCategoryEditPanel extends JPanel {
	private JTextField nameTextField;
	private JTextField effectiveDateTextField;
	private JTextField textField;
	private JTextField dateTextField_1;
	private JLabel errorLabel;
	/**
	 * Create the panel.
	 */
	public TaxCategoryEditPanel(JFrame currentFrame, Store store,TaxCategory selectedCategory,boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Category Edit");
		lblNewLabel.setBounds(176, 21, 128, 16);
		add(lblNewLabel);
		
		JLabel nameLable = new JLabel("Name");
		nameLable.setBounds(6, 61, 61, 16);
		add(nameLable);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(176, 212, 252, 16);
		add(errorLabel);
		
		nameTextField = new JTextField(selectedCategory.getCategory());
		nameTextField.setBounds(46, 56, 130, 26);
		if(!isAdd) {
			nameTextField.setText(selectedCategory.getCategory());	
		}
		add(nameTextField);
		nameTextField.setColumns(10);
		
		DefaultListModel<TaxRate> taxRatesList= new DefaultListModel(); 
		for(TaxRate taxRate: selectedCategory.getTaxRates()) {
			taxRatesList.addElement(taxRate);
		}
		JList<TaxRate> list = new JList<TaxRate>(taxRatesList);
		list.setBounds(249, 84, 147, 120);
		add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Tax Rates");
		lblNewLabel_2.setBounds(282, 61, 76, 16);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame,store,new TaxRate(),true,selectedCategory));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton.setBounds(203, 240, 76, 26);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxRate selectedRate= list.getSelectedValue();
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame,store,selectedRate,false,selectedCategory));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(282, 240, 76, 26);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxRate selectedRate= list.getSelectedValue();
				selectedCategory.deleteTaxRate(selectedRate);
				taxRatesList.removeElement(selectedRate);
			}
		});
		btnNewButton_2.setBounds(355, 240, 89, 26);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd) {
					if(list.getSelectedValue()!=null) {
						store.addTaxCategory(new TaxCategory(nameTextField.getText(),LocalDate.parse(dateTextField_1.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd")),list.getSelectedValue()));
					}
					else {
						errorLabel.setText("U have to select altleast one tax rate for the tax Category");
					}
					
				}
				else {
				selectedCategory.setCategory((nameTextField.getText()));
				selectedCategory.setEffectiveDate(dateTextField_1.getText());
				}
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new TaxCategoryPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_3.setBounds(6, 265, 117, 29);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cancel");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new TaxCategoryPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_4.setBounds(135, 265, 117, 29);
		add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("effectiveDate");
		lblNewLabel_1.setBounds(6, 89, 89, 16);
		add(lblNewLabel_1);
		
		
		dateTextField_1 = new JTextField();
		dateTextField_1.setBounds(96, 84, 130, 26);
		if(!isAdd) {
			dateTextField_1.setText(selectedCategory.getEffectiveDate().toString());
		}
		add(dateTextField_1);
		dateTextField_1.setColumns(10);
		
        
		
		

	}
}
