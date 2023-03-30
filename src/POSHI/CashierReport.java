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

import posPD.Sale;
import posPD.Cashier;
import posPD.Session;
import posPD.Store;

public class CashierReport extends JPanel {

	/**
	 * Create the panel.
	 */
	public CashierReport(JFrame currentFrame, Store store) {

setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cashier Report");
		lblNewLabel.setBounds(185, 6, 117, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setBounds(109, 50, 33, 16);
		add(lblNewLabel_1);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(154, 44, 220, 29);
		add(datePicker);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(43, 88, 375, 172);
		add(textArea);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(datePicker.getDate().equals(LocalDate.now())) {
					
					
					String reportString="Number          Name          Count  "+"\n";
					for(Cashier cashier : store.getCashiers().values()) {
						
							reportString=reportString+cashier.reportToString()+"\n";
						}
					textArea.setText(reportString);
					
				}
				
				}
				
			
		});
		btnNewButton.setBounds(75, 265, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSMain(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(257, 265, 117, 29);
		add(btnNewButton_1);

	}

	}


