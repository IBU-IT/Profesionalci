import java.util.ArrayList;

public class Anketa {
	public String pitanje;
	public ArrayList<String> odgovori;
	
	public Anketa(){
		odgovori = new ArrayList<String>();
	}
	
	public String toString(){
		String rezultat = pitanje+"\n\n";

		for(int i=0; i<odgovori.size(); i++){
			rezultat += odgovori.get(i)+"\n";
		}
		
		return rezultat;
	}
 }
