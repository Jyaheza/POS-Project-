package POSHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Sale;
import posPD.Session;
import posPD.Store;
import javax.swing.JLabel;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class SalesReportPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SalesReportPanel(JFrame currentFrame,Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
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
					
					String reportString="Time                     Cash          Check          Credit  "+"\n";
					for(Session session: store.getSessions()) {
						for(Sale sale:session.getSales()) {
							reportString=reportString+sale.reportToString()+"\n";
						}
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
