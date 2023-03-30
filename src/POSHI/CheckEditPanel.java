package POSHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import posPD.Check;
import posPD.Sale;
import posPD.Session;
import posPD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CheckEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public CheckEditPanel(JFrame currentFrame, Store store, Session session,Sale sale) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Check");
		lblNewLabel.setBounds(39, 24, 103, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setBounds(6, 52, 61, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(83, 52, 130, 16);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Routing Num");
		lblNewLabel_2.setBounds(6, 80, 103, 16);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 75, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Account Num");
		lblNewLabel_3.setBounds(6, 108, 86, 16);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 103, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Check Num");
		lblNewLabel_4.setBounds(6, 142, 86, 16);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(83, 136, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PaymentPanel(currentFrame,store,session,sale));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton.setBounds(6, 172, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Check check = new Check(sale.calcTotal(),textField_2.getText(),textField_3.getText());
				sale.setAmtTendered(new BigDecimal(textField.getText()));
				sale.addPayment(check,"check");
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PaymentPanel(currentFrame,store,session,sale));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(134, 172, 117, 29);
		add(btnNewButton_1);
		

	}

}
