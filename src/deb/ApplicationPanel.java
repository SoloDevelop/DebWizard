package deb;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import org.apache.commons.io.FilenameUtils;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import deb.Desktop.TYPE;
import deb.Desktop.CATEGORIES;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JTextPane;

public class ApplicationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6188819110608949517L;
	private JTextField nameTF;
	private JTextField execTF;
	private JTextField commentTF;
	private File icon;
	protected ApplicationManager applicationManager;
	final JFileChooser iconFC = new JFileChooser();

	public static File desktop;

	/**
	 * Create the panel.
	 */
	public ApplicationPanel() {
		setPreferredSize(new Dimension(600, 500));

		applicationManager = ApplicationManager.getSingletonInstance();
		setLayout(null);

		JLabel iconDisplay = new JLabel("");
		iconDisplay.setBounds(93, 310, 64, 64);
		iconDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(iconDisplay);

		JButton btnUpload = new JButton("Upload icon");
		btnUpload.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnUpload) {
					int returnVal = iconFC.showOpenDialog(ApplicationPanel.this); // Parent = Panel

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						icon = iconFC.getSelectedFile();

						Path iconPath = Paths.get(ApplicationManager.WORKSPACE_PATH + File.separator
								+ FieldManager.packageName + "." + FilenameUtils.getExtension(icon.toString()));
						try {
							Files.copy(icon.toPath(), iconPath, StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						// TODO: Handle cancel
						System.out.println("Open command cancelled by user.");
					}
				}
			}
		});
		btnUpload.setBounds(81, 385, 89, 23);
		add(btnUpload);

		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(10, 11, 48, 14);
		add(lblName);

		JLabel lblExec = new JLabel("Exec: ");
		lblExec.setBounds(10, 44, 48, 14);
		add(lblExec);

		JLabel lblType = new JLabel("Type: ");
		lblType.setBounds(10, 87, 48, 14);
		add(lblType);

		JLabel lblCategories = new JLabel("Categories: ");
		lblCategories.setBounds(10, 131, 62, 14);
		add(lblCategories);

		JLabel lblComment = new JLabel("Comment: ");
		lblComment.setBounds(10, 175, 62, 14);
		add(lblComment);

		nameTF = new JTextField();
		nameTF.setBounds(93, 11, 142, 20);
		add(nameTF);
		nameTF.setColumns(10);

		execTF = new JTextField();
		execTF.setBounds(93, 41, 142, 20);
		add(execTF);
		execTF.setColumns(10);

		commentTF = new JTextField();
		commentTF.setBounds(93, 172, 142, 100);
		commentTF.setAlignmentY(Component.TOP_ALIGNMENT);
		commentTF.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(commentTF);
		commentTF.setColumns(10);

		JComboBox<TYPE> typeCB = new JComboBox<TYPE>();
		typeCB.setModel(new DefaultComboBoxModel<TYPE>(TYPE.values()));
		typeCB.setBounds(93, 83, 142, 22);
		add(typeCB);

		JComboBox<CATEGORIES> categoriesCB = new JComboBox<CATEGORIES>();
		categoriesCB.setModel(new DefaultComboBoxModel<CATEGORIES>(CATEGORIES.values()));
		categoriesCB.setBounds(93, 127, 142, 22);
		add(categoriesCB);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Desktop desk = new Desktop(nameTF.getText(), execTF.getText(), icon.toPath(),
						(TYPE) typeCB.getSelectedItem(), (CATEGORIES) categoriesCB.getSelectedItem(),
						commentTF.getText());
				desktop = applicationManager.mkDesktop(desk);
			}
		});
		btnSend.setBounds(468, 466, 89, 23);
		add(btnSend);

		JLabel lblIcon = new JLabel("Icon: ");
		lblIcon.setBounds(10, 310, 48, 14);
		add(lblIcon);

		JTextPane desktopTP = new JTextPane();
		desktopTP.setBounds(305, 33, 252, 355);
		add(desktopTP);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (applicationManager.desktopFile != null)
					desktopTP.setText(applicationManager.getText());
				else
					System.out.println("Nothing to show.");
			}
		});
		btnRefresh.setBounds(305, 399, 89, 23);
		add(btnRefresh);

	}
}
