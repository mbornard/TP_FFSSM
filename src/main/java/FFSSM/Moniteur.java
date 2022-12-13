/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.*;
public class Moniteur extends Plongeur {

    public int numeroDiplome;
    LinkedList<Embauche> employeurs = new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, GroupeSanguin groupe,  int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupe);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
    	ArrayList<Embauche> list = new ArrayList<>();
    	for(Embauche e : employeurs) {
    		if(!e.estTerminee()) {
    			list.add(e);
    		}
    	}
    	if(list.size() == 0) {
    		return Optional.empty();
    	}
    	Embauche employeur = list.get(list.size()-1);

    	return Optional.ofNullable(employeur.getEmployeur());
    	
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        Embauche e = new Embauche(debutNouvelle, this, employeur);
        employeurs.add(e);
        
    }

    public List<Embauche> emplois() {
         return this.employeurs;
    }
    
    
    public void ajouterEmployeur(Embauche e) {
    	employeurs.add(e);
    }

}
