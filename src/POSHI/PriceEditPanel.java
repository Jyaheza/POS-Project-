package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Item;
import posPD.Price;
import posPD.PromoPrice;
import posPD.Store;
import posPD.UPC;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class PriceEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JCheckBox chckbxNewCheckBox;

	/**
	 * Create the panel.
	 */
	public PriceEditPanel(JFrame currentFrame, Store store,Item selectedItem,Price price,boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Price Edit ");
		lblNewLabel.setBounds(174, 6, 101, 16);
		add(lblNewLabel);
		
		chckbxNewCheckBox = new JCheckBox("promo Price");
		
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(isAdd) {
					if(chckbxNewCheckBox.isSelected()) {
						textField_2.setVisible(true);
						lblNewLabel_3.setVisible(true);
					}
					else {
						textField_2.setVisible(false);
						lblNewLabel_3.setVisible(false);
					}
				}
				
			}
		});
		chckbxNewCheckBox.setBounds(126, 34, 128, 23);
		add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(21, 74, 61, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(124, 69, 130, 26);
		if(!isAdd) {
			textField.setText(price.getPriceValue().toString());
		}
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Effective Date");
		lblNewLabel_2.setBounds(21, 129, 101, 16);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 124, 130, 26);
		if(!isAdd) {
			textField_1.setText(price.getEffectiveDate().toString());
		}
		add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("End Date");
		
		lblNewLabel_3.setBounds(21, 176, 73, 16);
		
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 171, 130, 26);
		textField_2.setVisible(false);
		if(!isAdd) {
			   textField_2.setVisible(false);
			}
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd) {
					if(chckbxNewCheckBox.isSelected()) {
						PromoPrice promo= new PromoPrice(new BigDecimal(textField.getText()),LocalDate.parse(textField_1.getText(),DateTimeFormatter.
								ofPattern("yyyy-dd-MM")),LocalDate.parse(textField_2.getText(),DateTimeFormatter.ofPattern("yyyy-dd-MM")));
						selectedItem.addPromoPrice(promo);
						selectedItem.addPrice((Price)promo);
					}
					else {
						Price price = new Price(textField.getText(),LocalDate.parse(textField_1.getText(),DateTimeFormatter.ofPattern("yyyy-dd-MM")));
						selectedItem.addPrice(price);
						
					}
				}
				else {
					price.setPrice(new BigDecimal(textField.getText()));
					price.setEffectiveDate(LocalDate.parse(textField_1.getText(),DateTimeFormatter.ofPattern("yyyy-dd-MM")));
				}
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,selectedItem,true));
				currentFrame.getContentPane().revalidate();	
				
			}
		});
		btnNewButton.setBounds(57, 233, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,selectedItem,true));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(239, 233, 117, 29);
		add(btnNewButton_1);

	}
}
