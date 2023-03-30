package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Cashier;
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
import javax.swing.JTextField;
import java.awt.Color;

public class RegisterListPanel extends JPanel {
	JButton btnNewButton ;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	private JLabel errorLabel;
	
	/**
	 * Create the panel.
	 */
	public RegisterListPanel(JFrame currentFrame,Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register List");
		lblNewLabel.setBounds(171, 38, 99, 16);
		add(lblNewLabel);
		DefaultListModel<Register> registersList= new DefaultListModel();
		for(Register register: store.getRegisters().values()) {
			registersList.addElement(register);
		}
		
		JList<Register> list = new JList<Register>(registersList);
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
		list.setBounds(92, 66, 211, 156);
		add(list);
		
        btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame,store,new Register(),true));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton.setBounds(6, 265, 99, 29);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register selectedRegister= list.getSelectedValue();
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame,store,selectedRegister,false));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(117, 265, 115, 29);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register selectedRegister= list.getSelectedValue();
				if(store.isOkayToDelete(selectedRegister)) {
				store.removeRegister(selectedRegister);
				registersList.removeElement(selectedRegister);
				}
				else 
					errorLabel.setText("Register is used in session! Can't be deleted");
			}
		});
		btnNewButton_2.setBounds(247, 265, 117, 29);
		add(btnNewButton_2);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(72, 237, 276, 16);
		add(errorLabel);
		

	}

}
