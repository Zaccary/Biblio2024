package bibliotheque.metier;

import java.util.ArrayList;
import java.util.List;

public class Exemplaire {
    private String Matricule;
    private String descriptionEtat;
    private Ouvrage ouvrage;
    private List<Location> locations =new ArrayList<>();
    private Rayon rayon;
    public Exemplaire() {
    }

    public Exemplaire(String matricule, String descriptionEtat, Ouvrage ouvrage) {
        Matricule = matricule;
        this.descriptionEtat = descriptionEtat;
        this.ouvrage = ouvrage;
    }

    public void modifierEtat(String etat) {
    }
    public void lecteurActuel() {
    }
    public void lecteur() {
    }
    public void envoiMailLecteurActuel(Mail mail) {
    }
    public void envoiMailLecteur(Mail mail) {
    }
    public Boolean enRetard() {
        return null;
    }
    public int joursRetard() {
        return 0;
    }
    public Boolean enLocation() {
        return null;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }
}
