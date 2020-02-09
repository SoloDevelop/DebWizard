package deb;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import deb.ManManager.SECTION;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ManPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3057052545581875448L;
	private JTextField nameTF;
	private JTextField synopsisTF;
	private JTextField descTF;
	private JTextField optTitleTF;
	private JTextField optDescTF;
	private JTextPane manTP;

	File man;
	public ManManager manManager = ManManager.getSingletonInstance();

	/**
	 * Create the panel.
	 */
	public ManPanel() {
		setPreferredSize(new Dimension(600, 500));
		setLayout(null);
		//setLayout(null);

		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(32, 7, 48, 15);
		add(lblName);

		JLabel lblSynopsis = new JLabel("Synopsis: ");
		lblSynopsis.setBounds(32, 34, 70, 15);
		add(lblSynopsis);

		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(32, 61, 87, 15);
		add(lblDescription);

		JLabel lblOptions = new JLabel("Options:");
		lblOptions.setBounds(32, 115, 58, 15);
		add(lblOptions);

		nameTF = new JTextField();
		nameTF.setBounds(135, 5, 124, 19);
		add(nameTF);
		nameTF.setColumns(10);

		synopsisTF = new JTextField();
		synopsisTF.setBounds(135, 32, 124, 19);
		add(synopsisTF);
		synopsisTF.setColumns(10);

		descTF = new JTextField();
		descTF.setBounds(135, 59, 124, 19);
		add(descTF);
		descTF.setColumns(10);

		JTextPane optionsTP = new JTextPane();
		optionsTP.setBounds(135, 123, 329, 146);
		optionsTP.setBorder(new LineBorder(Color.GRAY));
		add(optionsTP);

		JPanel optPanel = new JPanel();
		optPanel.setBounds(71, 301, 393, 133);
		optPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(optPanel);
		optPanel.setLayout(null);

		JLabel lblOptionTitle = new JLabel("Option title:");
		lblOptionTitle.setBounds(12, 12, 92, 15);
		optPanel.add(lblOptionTitle);

		optTitleTF = new JTextField();
		optTitleTF.setToolTipText("-h, --help");
		optTitleTF.setBounds(122, 10, 124, 19);
		optPanel.add(optTitleTF);
		optTitleTF.setColumns(10);

		optDescTF = new JTextField();
		optDescTF.setToolTipText("Opens the help panel");
		optDescTF.setBounds(122, 51, 124, 19);
		optPanel.add(optDescTF);
		optDescTF.setColumns(10);
		
				JLabel lblOptionDesc = new JLabel("Option desc :");
				lblOptionDesc.setBounds(12, 53, 92, 15);
				optPanel.add(lblOptionDesc);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(271, 91, 114, 25);
		optPanel.add(btnClear);

		JComboBox<SECTION> sectionCB = new JComboBox<SECTION>();
		sectionCB.setBounds(135, 83, 127, 24);
		sectionCB.setModel(new DefaultComboBoxModel<SECTION>((ManManager.SECTION.values())));
		add(sectionCB);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManEntry man = new ManEntry(nameTF.getText(), synopsisTF.getText(), descTF.getText());
				man.setOptions(optTitleTF.getText(), optDescTF.getText());
				manManager.setSection((SECTION) sectionCB.getSelectedItem());
				manManager.mkMan();
				manManager.add(man);
			}
		});
		btnAdd.setBounds(145, 91, 114, 25);
		optPanel.add(btnAdd);

		manTP = new JTextPane();
		manTP.setBounds(456, 33, -95, 123);
		manTP.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(manTP);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(32, 157, 86, 25);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (man != null)
					manTP.setText(manManager.getText());
				else
					System.out.println("Nothing selected.");
			}
		});
		add(btnRefresh);

		JLabel lblSection = new JLabel("Section: ");
		lblSection.setBounds(32, 88, 60, 15);
		add(lblSection);

	}
}
