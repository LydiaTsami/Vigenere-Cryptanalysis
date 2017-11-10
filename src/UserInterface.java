import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JTextField;

public class UserInterface {

	private JFrame frmVigenere;
	private JTextPane textPane;
	private static UserInterface window;
	private Vigenere bf;
	private String key;
	private long totalTime;
	private String ciphertext="VIEOEGMOCIGOHHJGBALOTMRJBHUMPXRJKQAMMBZAZKLMROROMQRAAUMNFWUGKXRNGKKUCTXKXJLXGNXAFWQCHLBIAJLJVVQSHLVBVSXQZBUIKSGBBUEUELFZNXPKNXXZLTYEMBVIIGBFRJYKUIFSFGGXUWAUMZFZTKMNYIGNXVZOTKLNSWBQBMZVGNXCEBRXGYK";
	private String plaintext="CONGRATULATIONSYOUSUCEEDINDECRYPTINGTHISMESSAGEITWASNOTTOOHARDAFTERALLKEEPUPTHEGOODWORKANDSPENDMORETIMEWITHCRYPTOOLANDSTUDYCAREFULLYTHEAVAILABLEBOOKSANDDONOTFORGETTHATHEBIGGESTBOOKISINTHEINTERNET";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new UserInterface();
					window.frmVigenere.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVigenere = new JFrame();
		frmVigenere.setTitle("Vigenere - Attack in Progress");
		frmVigenere.setBounds(100, 100, 450, 300);
		frmVigenere.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//frmVigenere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVigenere.getContentPane().setLayout(null);
		
		
		textPane = new JTextPane();
		textPane.setBounds(69, 88, 294, 103);
		frmVigenere.getContentPane().add(textPane);
		
		JLabel lblPleaseWait = new JLabel("Please wait , attack in progress");
		lblPleaseWait.setVisible(false);
		lblPleaseWait.setBounds(131, 37, 188, 14);
		frmVigenere.getContentPane().add(lblPleaseWait);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPleaseWait.setVisible(true);
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						bf = new Vigenere(ciphertext, plaintext);
						long startTime = System.currentTimeMillis();
						bf.Decode(); 
						long endTime = System.currentTimeMillis();
						long totalTime = endTime - startTime;
						updateText(totalTime);
					}
				});
			}
		});
		btnStart.setBounds(171, 203, 89, 23);
		frmVigenere.getContentPane().add(btnStart);
		
	}
	private void updateText(long totalTime) {
		textPane.setText("Number of tries: " +bf.tries + "\n Key: " + bf.key+ "\n Time elapsed: " + TimeUnit.MILLISECONDS.toMinutes(totalTime) + "minutes");
	}
}
