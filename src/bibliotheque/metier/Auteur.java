package bibliotheque.metier;

import java.util.ArrayList;
import java.util.List;

public class Auteur {
    private String nom;
    private String prenom;
    private String Nationalite;
    private List<Ouvrage> ouvrages=new ArrayList<>();
    public Auteur() {
    }

    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        Nationalite = nationalite;
    }

    public void listerOuvrages() {
    }
    public void listerOuvrages(TypeOuvrage type, TypeLivre livre) {
    }
    public void listerOuvrages(String genre) {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return Nationalite;
    }

    public void setNationalite(String nationalite) {
        Nationalite = nationalite;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void setOuvrages(List<Ouvrage> ouvrages) {
        this.ouvrages = ouvrages;
    }
}
