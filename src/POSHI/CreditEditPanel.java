package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Cashier;
import posPD.Check;
import posPD.Credit;
import posPD.Sale;
import posPD.Session;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CreditEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public CreditEditPanel(JFrame currentFrame,Store store, Session session,Sale sale) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Credit Card");
		lblNewLabel.setBounds(41, 17, 82, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setBounds(6, 55, 100, 16);
		add(lblNewLabel_1);
		
		
		String[] types= {"MasterCard","VISA"};

		DefaultComboBoxModel<String> cardTypeList= new DefaultComboBoxModel(types);
	
		JComboBox<String> comboBox = new JComboBox<String>(cardTypeList);
		comboBox.setBounds(79, 93, 117, 19);
		add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Card Type");
		lblNewLabel_2.setBounds(6, 96, 61, 16);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(101, 50, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Expiration DAte");
		lblNewLabel_3.setBounds(6, 132, 117, 16);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 127, 111, 31);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PaymentPanel(currentFrame,store,session,sale));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton.setBounds(6, 196, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credit credit = new Credit(sale.calcTotal(),comboBox.getSelectedItem().toString(),textField.getText(),textField_1.getText());
				sale.setAmtTendered(sale.calcTotal());
				sale.addPayment(credit,"credit");
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PaymentPanel(currentFrame,store,session,sale));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(141, 196, 117, 29);
		add(btnNewButton_1);

	}
}
