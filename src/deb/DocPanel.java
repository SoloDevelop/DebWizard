package deb;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import deb.ChangelogEntry.Stability;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import deb.ChangelogEntry.Urgency;
import java.awt.Dimension;

public class DocPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1299255677558244178L;
	private JTextField pckgTF;
	private JTextField verTF;
	private JTextField descTF;
	private JTextField customLicenseTF;
	private JTextField customChgLogTF;
	public JTextPane changelogTP;

	public static File changelog;
	public static File license;
	private JTextField publisherTF;
	private JTextField mailTF;

	private ChangelogManager changelogManager;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public DocPanel() {
		setPreferredSize(new Dimension(500, 600));

		final JFileChooser licenseFC = new JFileChooser();
		final JFileChooser changelogFC = new JFileChooser();
		changelogManager = ChangelogManager.getSingletonInstance();

		setLayout(null);

		JLabel lblLicense = new JLabel("License: ");
		lblLicense.setBounds(12, 12, 66, 15);
		add(lblLicense);

		ButtonGroup licenseBtnGrp = new ButtonGroup();

		JRadioButton rdbtnGpl = new JRadioButton("GPL");
		rdbtnGpl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customLicenseTF.setEnabled(false);
			}
		});
		rdbtnGpl.setBounds(22, 35, 56, 23);
		licenseBtnGrp.add(rdbtnGpl);
		add(rdbtnGpl);

		JRadioButton rdbtnLgpl = new JRadioButton("LGPL");
		rdbtnLgpl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customLicenseTF.setEnabled(false);
			}
		});
		rdbtnLgpl.setBounds(22, 60, 56, 23);
		licenseBtnGrp.add(rdbtnLgpl);
		add(rdbtnLgpl);

		customLicenseTF = new JTextField();
		customLicenseTF.setEnabled(false);
		customLicenseTF.setEditable(false);
		customLicenseTF.setBounds(12, 117, 96, 20);
		add(customLicenseTF);
		customLicenseTF.setColumns(10);

		JRadioButton rdbtnLCustom = new JRadioButton("Custom");
		rdbtnLCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Handle open button action.
				if (e.getSource() == rdbtnLCustom) {
					int returnVal = licenseFC.showOpenDialog(DocPanel.this); // Parent = Panel

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						license = licenseFC.getSelectedFile();
						// TODO: Handle Open File
						customLicenseTF.setText(license.getName());
						customLicenseTF.setEnabled(true);
					} else {
						// TODO: Handle cancel
						System.out.println("Open command cancelled by user.");
					}
				}
			}
		});
		rdbtnLCustom.setBounds(22, 87, 73, 23);
		licenseBtnGrp.add(rdbtnLCustom);
		add(rdbtnLCustom);

		JLabel lblChangelog = new JLabel("Changelog: ");
		lblChangelog.setBounds(238, 12, 96, 15);
		add(lblChangelog);

		changelogTP = new JTextPane();
		changelogTP.setEditable(false);
		changelogTP.setBorder(new LineBorder(Color.GRAY));
		changelogTP.setBounds(122, 37, 368, 251);
		add(changelogTP);

		JPanel newChgLogEntryPanel = new JPanel();
		newChgLogEntryPanel.setVisible(false);
		newChgLogEntryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		newChgLogEntryPanel.setBounds(22, 300, 468, 289);
		add(newChgLogEntryPanel);
		newChgLogEntryPanel.setLayout(null);

		JLabel lblPackage = new JLabel("Package: ");
		lblPackage.setBounds(12, 12, 66, 15);
		newChgLogEntryPanel.add(lblPackage);

		JLabel lblVersion = new JLabel("Version: ");
		lblVersion.setBounds(12, 39, 66, 15);
		newChgLogEntryPanel.add(lblVersion);

		JLabel lblDesc = new JLabel("Desc: ");
		lblDesc.setBounds(12, 65, 66, 15);
		newChgLogEntryPanel.add(lblDesc);

		pckgTF = new JTextField();
		pckgTF.setBounds(88, 9, 283, 20);
		newChgLogEntryPanel.add(pckgTF);
		pckgTF.setColumns(10);

		verTF = new JTextField();
		verTF.setBounds(88, 36, 283, 20);
		newChgLogEntryPanel.add(verTF);
		verTF.setColumns(10);

		descTF = new JTextField();
		descTF.setBounds(88, 63, 283, 70);
		newChgLogEntryPanel.add(descTF);
		descTF.setColumns(10);

		JComboBox<Stability> stability = new JComboBox<Stability>();
		stability.setBackground(Color.WHITE);
		stability.setForeground(Color.BLACK);
		stability.setModel(new DefaultComboBoxModel<Stability>(Stability.values())); // TODO: Mayb need to cast from raw
																						// type.
		stability.setBounds(88, 144, 89, 22);
		newChgLogEntryPanel.add(stability);

		JLabel lblStability = new JLabel("Stability: ");
		lblStability.setBounds(12, 148, 48, 14);
		newChgLogEntryPanel.add(lblStability);

		JLabel lblPublisher = new JLabel("Publisher: ");
		lblPublisher.setBounds(12, 182, 66, 14);
		newChgLogEntryPanel.add(lblPublisher);

		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(12, 207, 68, 14);
		newChgLogEntryPanel.add(lblMail);

		publisherTF = new JTextField();
		publisherTF.setBounds(88, 179, 283, 20);
		newChgLogEntryPanel.add(publisherTF);
		publisherTF.setColumns(10);

		mailTF = new JTextField();
		mailTF.setBounds(88, 204, 283, 20);
		newChgLogEntryPanel.add(mailTF);
		mailTF.setColumns(10);

		JLabel lblUrgency = new JLabel("Urgency: ");
		lblUrgency.setBounds(198, 148, 48, 14);
		newChgLogEntryPanel.add(lblUrgency);

		JComboBox<Urgency> urgency = new JComboBox<Urgency>();
		urgency.setModel(new DefaultComboBoxModel<Urgency>(Urgency.values()));
		urgency.setBounds(256, 144, 89, 22);
		newChgLogEntryPanel.add(urgency);

		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String time = new Timestamp(System.currentTimeMillis()).toString();

				ChangelogEntry changelogEntry = new ChangelogEntry(pckgTF.getText(), verTF.getText(), descTF.getText(),
						publisherTF.getText(), mailTF.getText(), time, (Stability) stability.getSelectedItem(),
						(Urgency) urgency.getSelectedItem());
				changelogManager.add(changelogEntry);
			}
		});
		btnAddEntry.setBounds(317, 255, 89, 23);
		newChgLogEntryPanel.add(btnAddEntry);

		JButton btnClear = new JButton("Clear"); // TODO: clear button
		btnClear.setBounds(217, 255, 89, 23);
		newChgLogEntryPanel.add(btnClear);

		JLabel lblChangelog_1 = new JLabel("Changelog:");
		lblChangelog_1.setBounds(10, 163, 66, 14);
		add(lblChangelog_1);

		JRadioButton rdbtnNew = new JRadioButton("New");
		buttonGroup.add(rdbtnNew);
		rdbtnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changelogManager.createChangelog();
				newChgLogEntryPanel.setVisible(true);
			}
		});
		rdbtnNew.setBounds(22, 184, 96, 23);
		add(rdbtnNew);

		JRadioButton rdbtnCLCustom = new JRadioButton("Custom");
		buttonGroup.add(rdbtnCLCustom);
		rdbtnCLCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newChgLogEntryPanel.setVisible(false);
				if (e.getSource() == rdbtnLCustom) {
					int returnVal = changelogFC.showOpenDialog(DocPanel.this); // Parent = Panel

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						changelogManager.setChangeLog(changelogFC.getSelectedFile());
						// changelog = changelogFC.getSelectedFile();
						// changelogManager = ChangelogManager.getSingletonInstance();
						// TODO: Handle Open File
						customLicenseTF.setText(changelog.getName());
						customLicenseTF.setEnabled(true);
					} else {
						// TODO: Handle cancel
						System.out.println("Open command cancelled by user.");
					}
				}
			}
		});
		rdbtnCLCustom.setBounds(22, 210, 96, 23);
		add(rdbtnCLCustom);

		customChgLogTF = new JTextField();
		customChgLogTF.setEnabled(false);
		customChgLogTF.setEditable(false);
		customChgLogTF.setColumns(10);
		customChgLogTF.setBounds(12, 240, 96, 20);
		add(customChgLogTF);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changelogTP.setText(changelogManager.getText());
			}
		});
		btnRefresh.setBounds(417, 8, 73, 23);
		add(btnRefresh);

		JButton btnClearChgl = new JButton("Clear");
		btnClearChgl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				changelogManager.clear();
				changelogManager.getText();
			}
		});
		btnClearChgl.setBounds(334, 8, 73, 23);
		add(btnClearChgl);

	}

}
