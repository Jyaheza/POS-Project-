package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Item;
import posPD.Register;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ItemListPanel extends JPanel {
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JLabel errorLabel;
	/**
	 * Create the panel.
	 */
	public ItemListPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Items LIst");
		lblNewLabel.setBounds(189, 17, 149, 16);
		add(lblNewLabel);
		DefaultListModel<Item> itemsList= new DefaultListModel<Item>();
		for(Item item: store.getItems().values()) {
		itemsList.addElement(item);	
		}
		JList<Item> list = new JList<Item>(itemsList);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list.isSelectionEmpty()) {
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
				}
			}
		});
		list.setBounds(51, 56, 365, 160);
		add(list);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,new Item(),false));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton.setBounds(16, 241, 117, 29);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item selectedItem= list.getSelectedValue();
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,selectedItem,false));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(160, 241, 117, 29);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item selectedItem= list.getSelectedValue();
				if(store.isOkeyToDelete(selectedItem)) {
					store.removeItem(selectedItem);
					itemsList.removeElement(selectedItem);
				}
				
				else 
					errorLabel.setText("Item is used in session can't be deleted");
			}
		});
		btnNewButton_2.setBounds(304, 241, 117, 29);
		add(btnNewButton_2);
		
		 errorLabel = new JLabel("");
		errorLabel.setBounds(61, 228, 336, 16);
		add(errorLabel);

	}
}
