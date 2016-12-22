import java.awt.EventQueue;

import javax.swing.JFrame;


public class LogovanKorisnik {

	private JFrame frmUserPanel;

	/**
	 * Launch the application.
	 */
	public void LogovanProfil() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogovanKorisnik window = new LogovanKorisnik();
					window.frmUserPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogovanKorisnik() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserPanel = new JFrame();
		frmUserPanel.setTitle("User Panel");
		frmUserPanel.setBounds(100, 100, 450, 176);
		frmUserPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
