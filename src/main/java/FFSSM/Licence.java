/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.*;
public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club emetteur;
    public ArrayList<Plongee> plongees = new ArrayList<>();

    
    //public ArrayList<Plongee> lesPlongees = new ArrayList<>();

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club emetteur) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.emetteur = emetteur;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return emetteur;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
    	return (d.isAfter(this.getDelivrance()) &&(d.isBefore(this.getDelivrance().plusYears(1))));
    }
    public void ajouterPlongees(Plongee p) {
    	plongees.add(p);
    }

}
