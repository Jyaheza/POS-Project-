package POSHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import posPD.Cash;
import posPD.Sale;
import posPD.Session;
import posPD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CashEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CashEditPanel(JFrame currentFrame,Store store, Session session,Sale sale) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Cash  Payment");
		lblNewLabel.setBounds(55, 6, 216, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount Tendered");
		lblNewLabel_1.setBounds(6, 46, 130, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(129, 41, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cash cash= new Cash("Cash",sale.calcTotal(),new BigDecimal(textField.getText()));
			sale.addPayment(cash,"cash");
			sale.setAmtTendered(new BigDecimal(textField.getText()));
			currentFrame.getContentPane().removeAll();		
			currentFrame.getContentPane().add(new PaymentPanel(currentFrame,store,session,sale));
			currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton.setBounds(6, 74, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel"); 
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PaymentPanel(currentFrame,store,session,sale));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(129, 74, 117, 29);
		add(btnNewButton_1);

	}

}
