package deb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JTextField;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pckNameTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setPreferredSize(new Dimension(464, 585));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnSetDebian = new JButton("Set DEBIAN");
		btnSetDebian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame("DEBIAN");
				f.getContentPane().add(new DebianPanel());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnSetDebian.setBounds(10, 11, 114, 23);
		panel.add(btnSetDebian);

		JButton btnSetBin = new JButton("Set bin");
		btnSetBin.setBounds(153, 11, 89, 23);
		panel.add(btnSetBin);

		JButton btnSetApp = new JButton("Set app");
		btnSetApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame("Application");
				f.getContentPane().add(new ApplicationPanel());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnSetApp.setBounds(278, 11, 89, 23);
		panel.add(btnSetApp);

		JButton btnSetChangelog = new JButton("Set changelog and license");
		btnSetChangelog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame("Doc");
				f.getContentPane().add(new DocPanel());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnSetChangelog.setBounds(246, 46, 184, 23);
		panel.add(btnSetChangelog);

		JButton btnSetManual = new JButton("Set manual");
		btnSetManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame f = new JFrame("Manual");
				f.getContentPane().add(new ManPanel());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
	

		btnSetManual.setBounds(10, 45, 114, 23);
		panel.add(btnSetManual);

		JButton btnSetJar = new JButton("Set jar");
		btnSetJar.setBounds(128, 45, 89, 23);
		panel.add(btnSetJar);

		pckNameTF = new JTextField();
		pckNameTF.setText("solfac");
		pckNameTF.setBounds(10, 117, 124, 19);
		panel.add(pckNameTF);
		pckNameTF.setColumns(10);

		JButton btnSetPckgName = new JButton("Set pckg name");
		btnSetPckgName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FieldManager.packageName = pckNameTF.getText();
			}
		});
		btnSetPckgName.setBounds(12, 148, 114, 25);
		panel.add(btnSetPckgName);
	}
}
