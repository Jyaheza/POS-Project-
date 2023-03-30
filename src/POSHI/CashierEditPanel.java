package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.AddingExistingElementException;
import posPD.Cashier;
import posPD.Person;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CashierEditPanel(JFrame currentFrame,Store store,Cashier cashier, Boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cashier Edit");
		lblNewLabel.setBounds(180, 48, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setBounds(39, 96, 61, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		//textField.setText(cashier.getNumber());
		textField.setBounds(166, 91, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(39, 149, 61, 16);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		//textField_1.setText(cashier.getName());
		textField_1.setBounds(166, 144, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(39, 196, 61, 16);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		//textField_2.setText(cashier.getPassword());
		textField_2.setBounds(166, 191, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
        if(!isAdd) {
        	textField.setText(cashier.getNumber());
    		textField_1.setText(cashier.getName());
    		textField_2.setText(cashier.getPassword());
        }
		
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(166, 278, 61, 16);
		add(errorLabel);
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd) {
					Person person= new Person(textField_1.getText());
					Cashier cashier = new Cashier(textField.getText(),person,textField_2.getText());
				try {
						store.addCashier(cashier);
					}
				catch(AddingExistingElementException exception) {
					errorLabel.setText(exception.getMessage());
				}
					
				}
				if(!isAdd) {
				cashier.setNumber(textField.getText());
				cashier.getPerson().setName(textField_1.getText());
				}
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();		
			}
		});
		btnNewButton.setBounds(39, 242, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();		
			}
		});
		btnNewButton_1.setBounds(258, 242, 117, 29);
		add(btnNewButton_1);
		
		
		
		
	}
}
