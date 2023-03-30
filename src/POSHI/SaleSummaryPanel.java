package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Sale;
import posPD.Session;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class SaleSummaryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public SaleSummaryPanel(JFrame currentFrame,Store store,Session session,Sale sale) {
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
		
		JLabel lblNewLabel_3 = new JLabel("Number Of Sales");
		lblNewLabel_3.setBounds(6, 79, 116, 16);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setText(Integer.toString(session.getSales().size()));
		textField.setBounds(115, 74, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total Sales");
		lblNewLabel_4.setBounds(6, 120, 96, 16);
		add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setText(session.getTotalSales().toString());
		textField_1.setBounds(81, 115, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Cash");
		lblNewLabel_5.setBounds(6, 159, 77, 16);
		add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 153, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cash Count Difference");
		lblNewLabel_6.setBounds(6, 182, 144, 16);
		add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setText("0.0");
		
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
//					BigDecimal mooney= new BigDecimal("0");
//					mooney=mooney.add(new BigDecimal(textField_2.getText()));
//						textField_3.setText((session.getRegister().getCashDrawer().getCashAmount()/*.subtract(new BigDecimal(textField_2.getText())))*/.toString()));
//					
//				}
				
				
				
				if(textField_2.getText()!=null) {
					BigDecimal mooney= new BigDecimal("0");
				mooney=new BigDecimal(textField_1.getText()).add(session.getRegister().getCashDrawer().getCashAmount().subtract(sale.getCheckAmount()));
					//textField_3.setText((session.getRegister().getCashDrawer().getCashAmount()/*.subtract(new BigDecimal(textField_2.getText())))*/.toString()));
				textField_3.setText((new BigDecimal(textField_2.getText()).subtract(mooney)).toString());
				}
				}	
			}
			});
		textField_3.setBounds(155, 177, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("End Session");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new POSMain(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(128, 233, 117, 29);
		add(btnNewButton);
		

	}

}
