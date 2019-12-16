package deb;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import deb.Control.ARCHITECTURE;
import deb.Control.PRIORITY;
import deb.Control.SECTION;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Dimension;

public class DebianPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1424338093312621692L;
	private JTextField packageTF;
	private JTextField versionTF;
	private JTextField homepageTF;
	private JTextField dependsTF;
	private JTextField maintainterTF;
	private JTextArea descTA;
	private JTextPane controlTP;

	ControlManager controlManager;
	protected File control;

	/**
	 * Create the panel.
	 */

	public DebianPanel() {

		controlManager = ControlManager.getSingletonInstance();

		setPreferredSize(new Dimension(625, 355));
		setLayout(null);

		JLabel lblPackage = new JLabel("Package: ");
		lblPackage.setBounds(12, 12, 66, 15);
		add(lblPackage);

		JLabel lblVersion = new JLabel("Version: ");
		lblVersion.setBounds(12, 39, 66, 15);
		add(lblVersion);

		JLabel lblSection = new JLabel("Section: ");
		lblSection.setBounds(12, 66, 66, 15);
		add(lblSection);

		JLabel lblPriority = new JLabel("Priority: ");
		lblPriority.setBounds(12, 93, 66, 15);
		add(lblPriority);

		JLabel lblHomepage = new JLabel("Homepage: ");
		lblHomepage.setBounds(12, 120, 88, 15);
		add(lblHomepage);

		JLabel lblArchitecture = new JLabel("Architecture: ");
		lblArchitecture.setBounds(12, 147, 110, 15);
		add(lblArchitecture);

		JLabel lblDepends = new JLabel("Depends: ");
		lblDepends.setBounds(12, 174, 88, 15);
		add(lblDepends);

		JLabel lblMaintainer = new JLabel("Maintainer <mail>: ");
		lblMaintainer.setBounds(12, 201, 110, 15);
		add(lblMaintainer);

		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(12, 228, 88, 15);
		add(lblDescription);

		packageTF = new JTextField();
		packageTF.setBounds(140, 10, 124, 19);
		add(packageTF);
		packageTF.setColumns(10);

		versionTF = new JTextField();
		versionTF.setBounds(140, 37, 124, 19);
		add(versionTF);
		versionTF.setColumns(10);

		homepageTF = new JTextField();
		homepageTF.setBounds(140, 116, 124, 19);
		add(homepageTF);
		homepageTF.setColumns(10);

		dependsTF = new JTextField();
		dependsTF.setBounds(140, 172, 124, 19);
		add(dependsTF);
		dependsTF.setColumns(10);

		maintainterTF = new JTextField();
		maintainterTF.setBounds(140, 199, 124, 19);
		add(maintainterTF);
		maintainterTF.setColumns(10);

		descTA = new JTextArea();
		descTA.setAlignmentY(Component.TOP_ALIGNMENT);
		descTA.setAlignmentX(Component.LEFT_ALIGNMENT);
		descTA.setBorder(new LineBorder(Color.GRAY));
		descTA.setBounds(140, 228, 124, 60);
		add(descTA);

		JComboBox<SECTION> sectionCB = new JComboBox<SECTION>();
		sectionCB.setModel(new DefaultComboBoxModel<SECTION>(SECTION.values()));
		sectionCB.setBounds(140, 62, 124, 22);
		add(sectionCB);

		JComboBox<PRIORITY> priorityCB = new JComboBox<PRIORITY>();
		priorityCB.setModel(new DefaultComboBoxModel<PRIORITY>(PRIORITY.values()));
		priorityCB.setBounds(140, 89, 124, 22);
		add(priorityCB);

		JComboBox<ARCHITECTURE> architectureCB = new JComboBox<ARCHITECTURE>();
		architectureCB.setModel(new DefaultComboBoxModel<ARCHITECTURE>(ARCHITECTURE.values()));
		architectureCB.setBounds(140, 140, 124, 22);
		add(architectureCB);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control ctrl = new Control(packageTF.getText(), versionTF.getText(),
						(SECTION) sectionCB.getSelectedItem(), (PRIORITY) priorityCB.getSelectedItem(),
						homepageTF.getText(), (ARCHITECTURE) architectureCB.getSelectedItem(), dependsTF.getText(),
						maintainterTF.getText(), descTA.getText());

				controlManager.mkControl();
				control = controlManager.setControl(ctrl);

			}
		});
		btnSend.setBounds(162, 320, 89, 23);
		add(btnSend);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to wipe the data?", "",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					if (control != null) {
						controlManager.clear();
					} else
						System.out.println("Nothing to clear.");
				}
			}
		});
		btnClear.setBounds(12, 320, 89, 23);
		add(btnClear);

		controlTP = new JTextPane();
		controlTP.setEditable(false);
		controlTP.setBounds(306, 12, 309, 276);
		add(controlTP);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(controlManager.getText());
				controlTP.setText(controlManager.getText());
			}
		});
		btnRefresh.setBounds(407, 320, 89, 23);
		add(btnRefresh);

	}
}
