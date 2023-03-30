package POSHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import posPD.Item;
import posPD.Price;
import posPD.Register;
import posPD.Store;
import posPD.TaxCategory;
import posPD.UPC;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;

public class ItemEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JLabel errorLabel;
	private JComboBox<TaxCategory>comboBox;

	/**
	 * Create the panel.
	 */
	public ItemEditPanel(JFrame currentFrame,Store store,Item selectedItem,boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Item");
		lblNewLabel.setBounds(181, 6, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Number");
		lblNewLabel_1.setBounds(6, 46, 115, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		if(!isAdd) {
			textField.setText(selectedItem.getNumber());
		}
		textField.setBounds(95, 41, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(6, 74, 88, 16);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setText(selectedItem.getDescription());
		textField_1.setBounds(105, 74, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tax Category");
		lblNewLabel_3.setBounds(6, 115, 101, 16);
		add(lblNewLabel_3);
		DefaultComboBoxModel<TaxCategory> tcList= new DefaultComboBoxModel(store.getTaxCategoryList().toArray());

		comboBox = new JComboBox<TaxCategory>(tcList);
		if(!isAdd) {
			comboBox.setSelectedItem(selectedItem.getTaxCategory());
		}
		comboBox.setBounds(95, 112, 162, 16);
		add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("UPCs");
		lblNewLabel_4.setBounds(326, 26, 61, 16);
		add(lblNewLabel_4);
		DefaultListModel<UPC> upcList= new DefaultListModel();
		for(UPC upc: selectedItem.getUPCs().values()) {
			upcList.addElement(upc);
		}
		JList<UPC> list = new JList<UPC>(upcList);
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
		list.setBounds(269, 46, 175, 79);
		add(list);
		
		 btnNewButton = new JButton("Add");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new uPCEditPanel(currentFrame,store,selectedItem,new UPC(),true));
				currentFrame.getContentPane().revalidate();	
		 	}
		 });
		btnNewButton.setBounds(244, 137, 66, 24);
		add(btnNewButton);
		
		 btnNewButton_1 = new JButton("Delete");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		UPC upc= list.getSelectedValue();
		 		if(list.getLastVisibleIndex()>0) {
		 			selectedItem.deleteUPC(upc);
		 			currentFrame.getContentPane().removeAll();		
					currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,selectedItem,false));
					currentFrame.getContentPane().revalidate();	
		 		}
		 		else
		 		{
		 			errorLabel.setText("Item can not have zero UPCs");
		 		}
		 		
		 	}
		 	
		 });
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(367, 137, 77, 24);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UPC selectedUPC = list.getSelectedValue();
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new uPCEditPanel(currentFrame,store,selectedItem,selectedUPC,false));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_2.setBounds(307, 137, 66, 26);
		add(btnNewButton_2);
		DefaultListModel<Price> prices=new DefaultListModel();
		for(Price price: selectedItem.getPrices()) {
			prices.addElement(price);
		}
		JList<Price> list_1 = new JList<Price>(prices);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list_1.isSelectionEmpty()) {
					btnNewButton_4.setEnabled(true);
					btnNewButton_5.setEnabled(true);
					
				}
				else {
					btnNewButton_4.setEnabled(false);
					btnNewButton_5.setEnabled(false);
				}
			}
		});
		list_1.setBounds(254, 178, 190, 79);
		add(list_1);
		
		 btnNewButton_3 = new JButton("Add");
		 btnNewButton_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame,store,selectedItem,new Price(),true));
				currentFrame.getContentPane().revalidate();	
		 	}
		 });
		btnNewButton_3.setBounds(244, 268, 66, 26);
		add(btnNewButton_3);
		
	    btnNewButton_4 = new JButton("Edit");
	    btnNewButton_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Price selectedPrice= list_1.getSelectedValue();
	    		currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame,store,selectedItem,selectedPrice,false));
				currentFrame.getContentPane().revalidate();	
	    	}
	    });
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBounds(312, 268, 71, 26);
		add(btnNewButton_4);
		
	   btnNewButton_5 = new JButton("Delete");
	   btnNewButton_5.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		Price selectedPrice=list_1.getSelectedValue();
	   		if(prices.size()>1) {
	   			selectedItem.removePrice(selectedPrice);
	   			prices.removeElement(selectedPrice);
	   		}
	   	}
	   });
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setBounds(373, 269, 77, 26);
		add(btnNewButton_5);
		
		 btnNewButton_6 = new JButton("Save");
		 btnNewButton_6.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(!isAdd) {
		 			selectedItem.setNumber(textField.getText());
		 			selectedItem.setDescription(textField_1.getText());
		 			selectedItem.setTaxCategory((TaxCategory)comboBox.getSelectedItem());
		 			selectedItem.setUPC(list.getModel().getElementAt(0));
		 			selectedItem.setPrice(selectedItem.getPriceForDate(LocalDate.now()));
		 			currentFrame.getContentPane().removeAll();		
					currentFrame.getContentPane().add(new ItemListPanel(currentFrame,store));
					currentFrame.getContentPane().revalidate();	
		 		}
		 		else {
		 			Item item= new Item(textField.getText(),textField_1.getText(),(TaxCategory)comboBox.getSelectedItem(),list_1.getModel().getElementAt(0),list.getModel().getElementAt(0));
		 			store.addItem(item);
		 			currentFrame.getContentPane().removeAll();		
					currentFrame.getContentPane().add(new ItemListPanel(currentFrame,store));
					currentFrame.getContentPane().revalidate();	
		 			
		 		}
		 	}
		 });
		btnNewButton_6.setBounds(4, 267, 117, 29);
		add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("Cancel");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_7.setBounds(124, 267, 117, 29);
		add(btnNewButton_7);
		
		JLabel lblNewLabel_5 = new JLabel("Prices");
		lblNewLabel_5.setBounds(326, 161, 61, 16);
		add(lblNewLabel_5);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(60, 221, 182, 16);
		add(errorLabel);
		
		

	}

}
