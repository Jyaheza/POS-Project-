package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Sale;
import posPD.SaleLineItem;
import posPD.Session;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.InputMethodListener;
import java.awt.TextArea;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POSsale extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField subTotalField;
	private JTextField taxField;
	private JTextField totalField;
	private JTextField tenderedField;
	private JTextField changeField;
	private JLabel errorLabel;
private JCheckBox taxFreeCheck;
private JTextArea textArea;
private Sale sale= new Sale();
	/**
	 * Create the panel.
	 */
	public POSsale(JFrame currentFrame,Store store, Session session) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POS Sale");
		lblNewLabel.setBounds(166, 17, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier:");
		lblNewLabel_1.setBounds(6, 27, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Register:");
		lblNewLabel_2.setBounds(6, 44, 61, 16);
		add(lblNewLabel_2);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setText(session.getCashierName());
		nameLabel.setBounds(61, 27, 104, 16);
		add(nameLabel);
		
		JLabel registerLabel = new JLabel("");
		registerLabel.setText(session.getRegisterNumber());
		registerLabel.setBounds(61, 44, 89, 16);
		add(registerLabel);
		
		JLabel lblNewLabel_3 = new JLabel(" Item UPC");
		lblNewLabel_3.setBounds(6, 87, 61, 16);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String saleLineItems="";
					boolean addQty=false;
					if(textField.getText().length()>=11) {
						System.out.println("rimwe");
					    if(store.getItemForUPC(textField.getText())!=null) {
					    	System.out.println("kabiri");
					    	sale.setIsTaxIsFree(taxFreeCheck.isSelected());
						SaleLineItem saleLineItem= new SaleLineItem(store.getItemForUPC(textField.getText()),Integer.parseInt(textField_1.getText()));
						store.getItemForUPC(textField.getText()).setItemCount(Integer.parseInt(textField_1.getText()));
						if(sale.getSaleLineItems().isEmpty()) {
							
							sale.addSaleLineItem(saleLineItem);	
							
						}
						else {
							System.out.println("kane");
//							for(SaleLineItem s:sale.getSaleLineItems()) {
//								System.out.println("ahha");
//								if(s.getItem()==saleLineItem.getItem()) {
//									System.out.println("gatanu");
//								s.setQuantity(s.getQuantity()+1);	
//								}
//								else
//									System.out.println("gatandatu");
//									sale.addSaleLineItem(saleLineItem);	
							for(SaleLineItem s: sale.getSaleLineItems()) {
								
								if(s.getItem()==saleLineItem.getItem()) {
									addQty=true;
								}
								if(addQty) {
									s.setQuantity(s.getQuantity()+Integer.parseInt(textField_1.getText()));
								}
							}
							if(!addQty) {
								sale.addSaleLineItem(saleLineItem);	
							}
						}
						for(SaleLineItem s:sale.getSaleLineItems()) {
							saleLineItems+=s.toStringTwo()+"\n";
						}
						textArea.setText(saleLineItems);
						System.out.println(sale);
						subTotalField.setText(sale.calcSubTotal().toString());
						taxField.setText(sale.calcTax().toString());
						totalField.setText(sale.calcTotal().toString());
						
					    }
					    else
					    	errorLabel.setText("No Item for that UPC");
				}
				
				}
			}
		});
//		textField.addInputMethodListener(new InputMethodListener() {
//			public void caretPositionChanged(InputMethodEvent event) {
//			}
//			public void inputMethodTextChanged(InputMethodEvent event) {
//				if(textField.getText().length()>=11) {
//					Sale sale= new Sale(taxFreeCheck.isSelected());
//					SaleLineItem saleLineItem= new SaleLineItem(store.getItemForUPC(textField.getText()),Integer.parseInt(textField_1.getText()));
//					textArea.setText(saleLineItem.toString());
//					System.out.println(sale);
//					sale.addSaleLineItem(saleLineItem);
//					
//					
//				}
//			}
//		});
//		textField.getDocument().addDocumentListener(new DocumentListener() {
//
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				warn();
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				warn();
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				warn();
//			}
//			
//			public void warn() {
//				String saleLineItems="";
//				if(textField.getText().length()>=11) {
//				    sale= new Sale(taxFreeCheck.isSelected());
//					SaleLineItem saleLineItem= new SaleLineItem(store.getItemForUPC(textField.getText()),Integer.parseInt(textField_1.getText()));
//					
//					sale.addSaleLineItem(saleLineItem);
//					for(SaleLineItem s:sale.getSaleLineItems()) {
//						saleLineItems+=s.toStringTwo()+"\n";
//					}
//					textArea.setText(saleLineItems);
//					System.out.println(sale);
//					subTotalField.setText(sale.calcSubTotal().toString());
//					taxField.setText(sale.calcTax().toString());
//					totalField.setText(sale.calcTotal().toString());
//					textField.setText(" ");
//			}
//			}
//		});
		textField.setBounds(74, 84, 122, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setBounds(206, 87, 61, 16);
		add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(279, 85, 89, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(6, 115, 383, 94);
		add(textArea);
		
		JButton btnNewButton = new JButton("Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PaymentPanel(currentFrame,store,session,sale));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton.setBounds(6, 240, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Complete Payment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(session.getSale().reportToString());
				subTotalField.setText("");
				taxField.setText("");
				changeField.setText("");
				totalField.setText("");
				tenderedField.setText("");
			}
		});
		btnNewButton_1.setBounds(135, 240, 145, 29);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel Sale");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new PosLoginPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_2.setBounds(6, 265, 117, 29);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("End Session");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.out.println("session"+sale.getCheckAmount().toString());
				session.getRegister().getCashDrawer().addCash(sale.calcTotal());
				store.addSession(session);
				System.out.println(session.getSale().reportToString());
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new SaleSummaryPanel(currentFrame,store,session,sale));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_3.setBounds(135, 265, 117, 29);
		add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("SubTotal");
		lblNewLabel_5.setBounds(409, 113, 61, 16);
		add(lblNewLabel_5);
		
		subTotalField = new JTextField();
		subTotalField.setBounds(469, 111, 68, 19);
		add(subTotalField);
		subTotalField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tax");
		lblNewLabel_6.setBounds(409, 130, 61, 16);
		add(lblNewLabel_6);
		
		taxField = new JTextField();
		taxField.setBounds(476, 130, 61, 16);
		add(taxField);
		taxField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Total");
		lblNewLabel_7.setBounds(409, 146, 61, 16);
		add(lblNewLabel_7);
		
		totalField = new JTextField();
		totalField.setBounds(469, 146, 61, 16);
		add(totalField);
		totalField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Amt Tendered");
		lblNewLabel_8.setBounds(394, 169, 90, 16);
		add(lblNewLabel_8);
		
		tenderedField = new JTextField();
		tenderedField.setBounds(486, 169, 62, 16);
		add(tenderedField);
		tenderedField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Change");
		lblNewLabel_9.setBounds(394, 191, 61, 16);
		add(lblNewLabel_9);
		
		changeField = new JTextField();
		changeField.setBounds(456, 189, 93, 19);
		add(changeField);
		changeField.setColumns(10);
		
		taxFreeCheck= new JCheckBox("TaxFree");
		taxFreeCheck.setBounds(355, 44, 89, 29);
		add(taxFreeCheck);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(6, 221, 393, 16);
		add(errorLabel);
		if(session.getIsPaid()) {
			String saleLineItems="";
			for(SaleLineItem s:sale.getSaleLineItems()) {
				saleLineItems+=s.toStringTwo()+"\n";
		}
			textArea.setText(saleLineItems);
			subTotalField.setText(session.getSale().calcSubTotal().toString());
			taxField.setText(session.getSale().calcTax().toString());
			totalField.setText(session.getSale().calcTotal().toString());
			tenderedField.setText(session.getSale().getAmtTendered().toString());
			changeField.setText((session.getSale().getAmtTendered().subtract(session.getSale().calcTotal())).toString());
			
			
		}
	}
}
