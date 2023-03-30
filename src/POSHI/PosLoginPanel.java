package POSHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import posPD.Cashier;
import posPD.Register;
import posPD.Sale;
import posPD.Session;
import posPD.Store;
import posPD.TaxCategory;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PosLoginPanel extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel errorLabel;

	/**
	 * Create the panel.
	 */
	public PosLoginPanel( JFrame currentFrame,Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(198, 6, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier");
		lblNewLabel_1.setBounds(28, 62, 61, 16);
		add(lblNewLabel_1);
		
		DefaultComboBoxModel<Cashier> cashierList= new DefaultComboBoxModel(store.getCashiers().values().toArray());
	
		JComboBox<Cashier> comboBox = new JComboBox<Cashier>(cashierList);
		
		comboBox.setBounds(159, 58, 163, 20);
		add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setBounds(28, 110, 61, 16);
		add(lblNewLabel_2);
		
		DefaultComboBoxModel<Register> registerList= new DefaultComboBoxModel(store.getRegisterList().toArray());
		JComboBox<Register> comboBox_1 = new JComboBox<Register>(registerList);
		comboBox_1.setBounds(170, 110, 163, 16);
		add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Starting Cash");
		lblNewLabel_3.setBounds(28, 165, 61, 16);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(171, 160, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(28, 213, 61, 16);
		add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 208, 134, 20);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 Cashier cashier= (Cashier) comboBox.getSelectedItem();				
			 if(cashier.isAuthorized(passwordField.getText())) {
				 Register register= (Register) comboBox_1.getSelectedItem();//gettimg register from combo box
				 Session session= new Session(cashier,register,new Sale());//creating a session
				 register.getCashDrawer().setCashAmount(new BigDecimal(textField.getText()));//these methods need creating
 				 currentFrame.getContentPane().removeAll();		
					currentFrame.getContentPane().add(new POSsale(currentFrame,store,session));
					currentFrame.getContentPane().revalidate();	
			 }
			 else {
				 errorLabel.setText("Incorrect Login");
			 }
			}
		});
		btnNewButton.setBounds(6, 251, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSMain(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(159, 251, 117, 29);
		add(btnNewButton_1);
		
	 errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(28, 234, 344, 16);
		add(errorLabel);
		

	}
}
