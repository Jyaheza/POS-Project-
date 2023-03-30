package POSHI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.github.lgooddatepicker.components.DatePicker;

import posPD.Cashier;
import posPD.Item;
import posPD.Store;

public class ItemReport extends JPanel {
	JTextArea textArea_1;
	DatePicker datePicker;
	/**
	 * Create the panel.
	 */
	public ItemReport(JFrame currentFrame,Store store) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Item Report");
		lblNewLabel.setBounds(52, 11, 77, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setBounds(134, 11, 33, 16);
		add(lblNewLabel_1);
		
		datePicker = new DatePicker();
		datePicker.setBounds(172, 5, 220, 29);
		add(datePicker);
		
		
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setBounds(74, 228, 99, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(datePicker.getDate().equals(LocalDate.now())){
			
				String reportString="Num           Item                                         Count  "+"\n";
				for(Item item: store.getItems().values() ){
					
						reportString=reportString+item.reportToString()+"\n";
				}
				textArea_1.setText(reportString);
				
			}
				
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setBounds(252, 228, 79, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSMain(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		add(btnNewButton_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(27, 79, 365, 137);
		add(textArea_1);

	

	}

}
