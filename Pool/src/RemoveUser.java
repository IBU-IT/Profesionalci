import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class RemoveUser {

	public void TestnoBrisanje() {
		//Jos nije povezano s bazom pa za primjer koristimo arraylist
		ArrayList<String> users = new ArrayList<String>();
		users.add("Kiso");
		users.add("Muhamed");
		users.add("Veno");
		
		String izbor = JOptionPane.showInputDialog(null, "1. Izlistaj sve korisnike\n2.Obrisi korisnika");
		int meni = Integer.parseInt(izbor);
		
		switch(meni){
		case 1:
			//IZLISTAJ
			JOptionPane.showMessageDialog(null, Arrays.toString(users.toArray()));
			break;
		case 2:
			String ime = JOptionPane.showInputDialog(null, "Unesi ime korisnika kojeg zelis obrisati: ");			
			if (users.contains(ime)) {
			    //Korinik postoji
				users.remove(ime);
				JOptionPane.showMessageDialog(null, "Korinisk: "+ime+" je obrisan iz baze");
			} else {
				JOptionPane.showMessageDialog(null, "Korinisk ne postoji u bazi.");
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error");
		}

	}

}