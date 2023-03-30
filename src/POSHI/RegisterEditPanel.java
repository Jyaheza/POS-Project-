package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.AddingExistingElementException;
import posPD.CashDrawer;
import posPD.Register;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterEditPanel extends JPanel {
	private JTextField textField;
	JLabel errorLabel;
	/**
	 * Create the panel.
	 */
	public RegisterEditPanel(JFrame currentFrame,Store store, Register selectedRegister,Boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Edit ");
		lblNewLabel.setBounds(182, 41, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setBounds(57, 93, 61, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		if(!isAdd) {
			textField.setText(selectedRegister.getNumber());
		}
		textField.setBounds(173, 88, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd) {
					CashDrawer cashDrawer= new CashDrawer();
					try {
						store.addRegister(new Register(textField.getText(),cashDrawer));
					}
					catch(AddingExistingElementException exception) {
						errorLabel.setText(exception.getMessage());
					}
				}
				selectedRegister.setNumber(textField.getText());
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new RegisterListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton.setBounds(71, 189, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new RegisterListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(243, 189, 117, 29);
		add(btnNewButton_1);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(182, 264, 61, 16);
		add(errorLabel);

	}

}
