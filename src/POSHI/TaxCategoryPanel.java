package POSHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import posPD.Cashier;
import posPD.Register;
import posPD.Store;
import posPD.TaxCategory;

import javax.swing.event.ListSelectionEvent;
import java.awt.Color;

public class TaxCategoryPanel extends JPanel {
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	private JLabel errorLabel;
	/**
	 * Create the panel.
	 */
	public TaxCategoryPanel(JFrame currentFrame,Store store ) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Category List");
		lblNewLabel.setBounds(186, 16, 163, 16);
		add(lblNewLabel);
		
		DefaultListModel<TaxCategory> taxCategoryList= new DefaultListModel();
		for(TaxCategory  taxCategory : store.getTaxCategories().values()) {
			taxCategoryList.addElement(taxCategory);
		}
			JList<TaxCategory> list = new JList<TaxCategory>(taxCategoryList);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list.isSelectionEmpty()) {
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
				}
				else {
					btnNewButton_1.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}
			}
		});
		list.setBounds(73, 65, 287, 153);
		add(list);
		
		 btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame,store,new TaxCategory(),true));
				currentFrame.getContentPane().revalidate();	
			}
			
		});
		btnNewButton.setBounds(30, 277, 117, 29);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxCategory selectedTaxCategory= list.getSelectedValue();
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame,store,selectedTaxCategory,false));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(163, 277, 117, 29);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxCategory selectedTaxCategory= list.getSelectedValue();
				if(store.isOkeyToDelete(selectedTaxCategory)) {
					store.removeTaxCategory(selectedTaxCategory);
					taxCategoryList.removeElement(selectedTaxCategory);
					System.out.println("deleted");
				}
				else {
					errorLabel.setText("Can't delete taxCategory! it is used in session");
				System.out.println("Used");
				}
				}
		});
		btnNewButton_2.setBounds(292, 277, 117, 29);
		add(btnNewButton_2);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(83, 240, 266, 16);
		add(errorLabel);
		
		

	}

}
