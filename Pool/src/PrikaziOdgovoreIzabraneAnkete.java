import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrikaziOdgovoreIzabraneAnkete {

	private JFrame frmUskoro;

	/**
	 * Launch the application.
	 */
	public void prikaziOdgovore() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikaziOdgovoreIzabraneAnkete window = new PrikaziOdgovoreIzabraneAnkete();
					window.frmUskoro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrikaziOdgovoreIzabraneAnkete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUskoro = new JFrame();
		frmUskoro.setTitle("Uskoro");
		frmUskoro.setResizable(false);
		frmUskoro.setBounds(100, 100, 450, 300);
		frmUskoro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUskoro.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GlasajNaAnketi a = new GlasajNaAnketi();
				int b = a.getId();
				JOptionPane.showMessageDialog(null, "izabran je: "+b);
			}
		});
		btnNewButton.setBounds(110, 113, 89, 23);
		frmUskoro.getContentPane().add(btnNewButton);
		
	}
}
