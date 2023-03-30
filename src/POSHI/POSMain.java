package POSHI;

import javax.swing.JPanel;

import posPD.Store;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class POSMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public POSMain(Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(store.getName());
		lblNewLabel.setBounds(182, 132, 137, 16);
		add(lblNewLabel);

	}
}
