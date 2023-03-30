package POSHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import posPD.Sale;
import posPD.Session;
import posPD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentPanel extends JPanel {
	private JTextField paymentField;
	private JTextField amtTenderedField;
	private JPanel cashPanel;
	private JPanel checkPanel;
	private JPanel creditPanel;  

	/**
	 * Create the panel.
	 */
	public PaymentPanel(JFrame currentFrame,Store store,Session session,Sale sale ) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payments");
		lblNewLabel.setBounds(183, 6, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Due");
		lblNewLabel_1.setBounds(16, 34, 120, 16);
		add(lblNewLabel_1);
		
		paymentField = new JTextField();
		paymentField.setText(sale.calcTotal().toString());
		paymentField.setBounds(6, 62, 130, 26);
		add(paymentField);
		paymentField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Amount Tendered ");
		lblNewLabel_2.setBounds(16, 100, 120, 13);
		add(lblNewLabel_2);
		
		amtTenderedField = new JTextField();
		if(sale.getPayment()!=null) {
			amtTenderedField.setText(sale.getAmtTendered().toString());
		}
		else
		amtTenderedField.setText("0.0");
		amtTenderedField.setBounds(6, 125, 130, 26);
		add(amtTenderedField);
		amtTenderedField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cash");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashPanel= new CashEditPanel(currentFrame,store,session,sale);
				cashPanel.setBounds(148, 34, 296, 219);
				if(checkPanel!=null) {
					remove(checkPanel);
					checkPanel=null;
				}
				if(creditPanel!=null) {
					remove(creditPanel);
					creditPanel=null;
				}
				add(cashPanel);
				revalidate();
				repaint();
			}
		});
		btnNewButton.setBounds(6, 168, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPanel= new CheckEditPanel(currentFrame,store,session,sale);
				checkPanel.setBounds(148, 34, 296, 219);
				if(cashPanel!=null) {
					remove(cashPanel);
					cashPanel=null;
				}
				if(creditPanel!=null) {
					remove(creditPanel);
					creditPanel=null;
				}
				add(checkPanel);
				revalidate();
				repaint();
			}
		});
		btnNewButton_1.setBounds(6, 209, 117, 29);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Credit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creditPanel= new CreditEditPanel(currentFrame,store,session,sale);
				creditPanel.setBounds(148, 34, 296, 219);
				if(checkPanel!=null) {
					remove(checkPanel);
					checkPanel=null;
				}
				if(cashPanel!=null) {
					remove(cashPanel);
					cashPanel=null;
				}
				add(creditPanel);
				revalidate();
				repaint();
			}
		});
		btnNewButton_2.setBounds(6, 248, 117, 29);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Complete Payment");
		if(sale.getAmtTendered()!=null) {
		if(sale.calcTotal().compareTo(sale.getAmtTendered())!=1) {
			btnNewButton_3.setEnabled(true);
		}
		}
		else
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					System.out.println(sale.reportToString());
				
				
				session.setIsPaid(true);
				session.getCashier().setCashCount(sale.calcTotal());
				session.adddSale(sale);
				session.getRegister().getCashDrawer().addCash(sale.calcTotal().subtract(sale.getCheckAmount()));
				
				
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new POSsale(currentFrame,store,session));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_3.setBounds(172, 265, 161, 29);
		add(btnNewButton_3);
		
		
		//panel.setBounds(148, 34, 296, 219);
		

	}
}
