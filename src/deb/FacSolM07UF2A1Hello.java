package deb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FacSolM07UF2A1Hello extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacSolM07UF2A1Hello frame = new FacSolM07UF2A1Hello();
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
	public FacSolM07UF2A1Hello() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblHelloWorld = new JLabel("Hello World");
		lblHelloWorld.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHelloWorld, BorderLayout.NORTH);

		JLabel lblByFacundoSolowinski = new JLabel("by Facundo Solowinski");
		lblByFacundoSolowinski.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblByFacundoSolowinski, BorderLayout.SOUTH);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(FacSolM07UF2A1Hello.class.getResource("/activities/img/FacSolHello.png")));
		contentPane.add(label, BorderLayout.CENTER);
		new ImageIcon(getClass().getResource("/activities/img/FacSolHello.png"));
	}

}
