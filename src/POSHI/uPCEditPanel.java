package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Item;
import posPD.Store;
import posPD.UPC;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class uPCEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public uPCEditPanel(JFrame currentFrame,Store store,Item currentItem,UPC selectedUPC,boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPC Edit");
		lblNewLabel.setBounds(163, 16, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UPC number");
		lblNewLabel_1.setBounds(35, 70, 97, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(181, 65, 130, 26);
		if(!isAdd) {
					textField.setText(selectedUPC.getUPCNumber());
				}
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Item");
		lblNewLabel_2.setBounds(35, 136, 61, 16);
		add(lblNewLabel_2);
		
		JLabel itemLabel = new JLabel("");
		itemLabel.setBounds(181, 136, 191, 26);
		itemLabel.setText(currentItem.getDescription());
		add(itemLabel);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd) {
					UPC upc= new UPC(textField.getText());
					upc.addItem(currentItem);
					currentItem.addUPC(upc);
				}
			selectedUPC.setUpcNumber(textField.getText());
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,currentItem,false));
				currentFrame.getContentPane().revalidate();	

			}
		});
		btnNewButton.setBounds(81, 213, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();		
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,currentItem,false));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnNewButton_1.setBounds(261, 213, 117, 29);
		add(btnNewButton_1);

	}

}
