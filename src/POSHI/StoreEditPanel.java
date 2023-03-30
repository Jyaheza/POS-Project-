package POSHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import posPD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public StoreEditPanel(JFrame currentFrame,Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Store Edit");
		lblNewLabel.setBounds(176, 22, 83, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(39, 130, 61, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText(store.getName());
		textField.setBounds(92, 127, 338, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.setName(textField.getText());
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSMain(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(45, 199, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSMain(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		
		btnNewButton_1.setBounds(216, 199, 117, 29);
		add(btnNewButton_1);

	}

}
