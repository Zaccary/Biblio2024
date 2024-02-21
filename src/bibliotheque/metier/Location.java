package bibliotheque.metier;

import java.time.LocalDate;

public class Location {
    private LocalDate dateLoc;
    private LocalDate dateRestitution;
    private Double Amande;
    private Exemplaire exemplaire;
    private Lecteur lecteur;
    public Location() {
    }

    public Location(LocalDate dateLoc, LocalDate dateRestitution, Lecteur lecteur,Exemplaire exemplaire) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        Amande = null;
        this.exemplaire = exemplaire;
        this.lecteur = lecteur;
    }

    public void calculerAmande() {
    }
    public void enregistrerRetour() {
    }

    public LocalDate getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(LocalDate dateLoc) {
        this.dateLoc = dateLoc;
    }

    public LocalDate getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(LocalDate dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public Double getAmande() {
        return Amande;
    }

    public void setAmande(Double amande) {
        Amande = amande;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }
}
