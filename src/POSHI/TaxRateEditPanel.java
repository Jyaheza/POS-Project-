package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Cashier;
import posPD.Store;
import posPD.TaxCategory;
import posPD.TaxRate;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TaxRateEditPanel extends JPanel {
	private JTextField tRateTextField;
	private JTextField eDateTextField;

	/**
	 * Create the panel.
	 */
	public TaxRateEditPanel(JFrame currentFrame,Store store,TaxRate taxRate, Boolean isAdd,TaxCategory currentCategory) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Rate Edit");
		lblNewLabel.setBounds(160, 18, 129, 21);
		add(lblNewLabel);
		
		JLabel tRateLabel = new JLabel("Tax Rate");
		tRateLabel.setBounds(47, 56, 101, 16);
		add(tRateLabel);
		
		tRateTextField = new JTextField();
		tRateTextField.setBounds(195, 51, 130, 26);
		add(tRateTextField);
		tRateTextField.setColumns(10);
		
		JLabel effectiveDateLabel = new JLabel("Effective Date");
		effectiveDateLabel.setBounds(47, 115, 101, 16);
		add(effectiveDateLabel);
		
		eDateTextField = new JTextField();
		eDateTextField.setBounds(195, 110, 130, 26);
		add(eDateTextField);
		eDateTextField.setColumns(10);
		if(!isAdd) {
			eDateTextField.setText(taxRate.getEffectiveDate().toString());
			tRateTextField.setText(taxRate.getRate().toString());
		}
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new TaxCategoryPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();		
			}
		});
		btnNewButton.setBounds(232, 197, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd) {
					TaxRate rate= new TaxRate(LocalDate.parse(eDateTextField.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd")),new BigDecimal(tRateTextField.getText()));
					currentCategory.addTaxRate(rate);
					
				}
				else {

					taxRate.setEffectiveDate(LocalDate.parse(eDateTextField.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
					taxRate.setTaxRate(new BigDecimal(tRateTextField.getText()));
				}
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame,store,currentCategory,true));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(41, 197, 117, 29);
		add(btnNewButton_1);

	}

}
