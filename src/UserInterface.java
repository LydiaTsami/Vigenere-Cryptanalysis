import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class UserInterface {

	private JFrame frmVigenere;
	private static UserInterface window;
	private Vigenere bf;
	private String key;
	private long totalTime;
	private String ciphertext="VIEOEGMOCIGOHHJGBALOTMRJBHUMPXRJKQAMMBZAZKLMROROMQRAAUMNFWUGKXRNGKKUCTXKXJLXGNXAFWQCHLBIAJLJVVQSHLVBVSXQZBUIKSGBBUEUELFZNXPKNXXZLTYEMBVIIGBFRJYKUIFSFGGXUWAUMZFZTKMNYIGNXVZOTKLNSWBQBMZVGNXCEBRXGYK";
	private String plaintext="CONGRATULATIONSYOUSUCEEDINDECRYPTINGTHISMESSAGEITWASNOTTOOHARDAFTERALLKEEPUPTHEGOODWORKANDSPENDMORETIMEWITHCRYPTOOLANDSTUDYCAREFULLYTHEAVAILABLEBOOKSANDDONOTFORGETTHATHEBIGGESTBOOKISINTHEINTERNET";
	private JTextField textField;

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
		frmVigenere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVigenere.getContentPane().setLayout(null);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(69, 88, 294, 103);
		frmVigenere.getContentPane().add(textPane);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();
				bf = new Vigenere(ciphertext, plaintext,window);
				bf.Decode();
				long endTime   = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				
				textPane.setText("Number of tries: " +bf.tries + "\n Key: " + bf.key+ "\n Time elapsed: " + TimeUnit.MILLISECONDS.toMinutes(totalTime) + "minutes");
			}
		});
		btnStart.setBounds(171, 203, 89, 23);
		frmVigenere.getContentPane().add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(69, 35, 294, 30);
		frmVigenere.getContentPane().add(textField);
		textField.setColumns(10);
	
		
	}
	
	public void updateTextField() {
		textField.setText("Progress: "+bf.tries+ "/308915776 \n"+ (308915776-bf.tries)+ " Remaining.");
	}
}
