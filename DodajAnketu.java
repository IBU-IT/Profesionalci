import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class DodajAnketu {

	public Anketa get() {
		//Jos nije povezano s bazom pa za primjer koristimo arraylist
		Anketa anketa = new Anketa();
		
		anketa.pitanje = JOptionPane.showInputDialog(null, "Unesite pitanje ya anketu?");
		
		int brojOdgovora = Integer.parseInt(JOptionPane.showInputDialog(null, "Koliko ima odgovora?"));
		
		for(int i=0; i<brojOdgovora; i++){
			anketa.odgovori.add(JOptionPane.showInputDialog(null, "Unesite"+(i+1)+".odgovor za anketu?"));
		}

		JOptionPane.showMessageDialog(null, anketa.toString());
		
		return anketa;
	}
}