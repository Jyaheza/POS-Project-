package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Cashier;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class CashierListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JList<Cashier> list= new JList<Cashier>();
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
    JLabel errorLabel;
	public CashierListPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Cashier List");
		lblNewLabel.setBounds(192, 13, 61, 16);
		add(lblNewLabel);
		
		DefaultListModel<Cashier> cashiersList= new DefaultListModel();
		for(Cashier cashier: store.getCashiers().values()) {
			cashiersList.addElement(cashier);
		}
			
		
		 list = new JList<Cashier>(cashiersList);
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
		list.setBounds(114, 51, 203, 147);
		add(list);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame,store,new Cashier(),true));
				currentFrame.getContentPane().revalidate();				
				}
		});
		btnNewButton.setBounds(6, 265, 117, 29);
		add(btnNewButton);
		
		 btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier selectedCashier = list.getSelectedValue();
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame,store,selectedCashier,false));
				currentFrame.getContentPane().revalidate();		
			}
		});
		btnNewButton_1.setBounds(150, 265, 117, 29);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
	    btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier selectedCashier= list.getSelectedValue();
				if(store.isOkayToDelete(selectedCashier)) {
					store.removeCashier(selectedCashier);
					cashiersList.removeElement(selectedCashier);
				}
				else {
				errorLabel.setText("Cashier is used in a session! Can not be deleted");
				}
				
			}
		});
		btnNewButton_2.setBounds(297, 265, 117, 29);
		add(btnNewButton_2);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(69, 222, 326, 16);
		add(errorLabel);

	}
}
