package FFSSM;

import java.time.LocalDate;
import java.util.*;
public class Plongeur extends Personne{
	int niveau;
	GroupeSanguin groupe;
	ArrayList<Licence> licences = new ArrayList<>();

	public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone,
			LocalDate naissance, int niveau, GroupeSanguin groupe) {
		super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
			this.niveau = niveau;
			this.groupe = groupe;
	}
	
	public void ajouteLicence( String numero,  LocalDate delivrance , Club c ) {
		licences.add(new Licence(this, numero, delivrance, c));
	}
	public Licence derniereLicence() {
		licences.sort((o1, o2) -> o1.getDelivrance().compareTo(o2.getDelivrance()));
		return licences.get(licences.size()-1);
	}
   

	
}
