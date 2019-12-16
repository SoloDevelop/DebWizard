package deb;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class ManPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3057052545581875448L;
	private JTextField nameTF;
	private JTextField synopsisTF;
	private JTextField descTF;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ManPanel() {
		setLayout(null);

		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(12, 12, 66, 15);
		add(lblName);

		JLabel lblSynopsis = new JLabel("Synopsis: ");
		lblSynopsis.setBounds(12, 39, 82, 15);
		add(lblSynopsis);

		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(12, 66, 98, 15);
		add(lblDescription);

		JLabel lblOptions = new JLabel("Options:");
		lblOptions.setBounds(12, 93, 66, 15);
		add(lblOptions);

		nameTF = new JTextField();
		nameTF.setBounds(145, 10, 124, 19);
		add(nameTF);
		nameTF.setColumns(10);

		synopsisTF = new JTextField();
		synopsisTF.setBounds(145, 37, 124, 19);
		add(synopsisTF);
		synopsisTF.setColumns(10);

		descTF = new JTextField();
		descTF.setBounds(145, 64, 124, 19);
		add(descTF);
		descTF.setColumns(10);

		JTextPane optionsTP = new JTextPane();
		optionsTP.setBorder(new LineBorder(Color.GRAY));
		optionsTP.setBounds(145, 93, 249, 138);
		add(optionsTP);

		JPanel optPanel = new JPanel();
		optPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		optPanel.setBounds(12, 261, 397, 128);
		add(optPanel);
		optPanel.setLayout(null);

		JLabel lblOptionTitle = new JLabel("Option title:");
		lblOptionTitle.setBounds(12, 12, 92, 15);
		optPanel.add(lblOptionTitle);

		textField = new JTextField();
		textField.setBounds(122, 10, 124, 19);
		optPanel.add(textField);
		textField.setColumns(10);

		JLabel lblOptionDesc = new JLabel("Option desc :");
		lblOptionDesc.setBounds(12, 53, 92, 15);
		optPanel.add(lblOptionDesc);

		textField_1 = new JTextField();
		textField_1.setBounds(122, 51, 124, 19);
		optPanel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(271, 91, 114, 25);
		optPanel.add(btnClear);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(145, 91, 114, 25);
		optPanel.add(btnAdd);

	}
}
