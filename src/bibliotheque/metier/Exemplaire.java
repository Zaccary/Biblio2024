package bibliotheque.metier;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import bibliotheque.gestion.Gestion;

public class Exemplaire {

    private String matricule;
    private String descriptionEtat;

    private Ouvrage ouvrage;
    private Rayon rayon;

    private String etat;


    public Exemplaire(String matricule, String descriptionEtat,Ouvrage ouvrage){
        this.matricule = matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage = ouvrage;

        this.ouvrage.getLex().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(matricule, that.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
        if(this.ouvrage!=null) this.ouvrage.getLex().remove(this);
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        if(this.rayon!=null) this.rayon.getLex().remove(this);
        this.rayon=rayon;
        this.rayon.getLex().add(this);
    }


    @Override
    public String toString() {
        return "Exemplaire{" +
                "matricule='" + matricule + '\'' +
                ", descriptionEtat='" + descriptionEtat + '\'' +
                ", ouvrage=" + ouvrage +
                ", rayon=" + rayon +
                '}';
    }

    public void modifierEtat(String etat){
       setDescriptionEtat(etat);
    }

    public Lecteur lecteurActuel(){
        if(enLocation()) return Gestion.haloc.get(this);
        return null;
    }

    public void envoiMailLecteurActuel(Mail mail){
        if(lecteurActuel()!=null) System.out.println("envoi de "+mail+ " à "+lecteurActuel().getMail());
        else System.out.println("aucune location en cours");
    }
    /*
    impossible à utiliser car la méthode lecteurs() n'existe plus ??
    public void envoiMailLecteurs(Mail mail){
        List<Lecteur>ll=lecteurs();
        if(ll.isEmpty()){
            System.out.println("aucun lecteur enregistré");
        }
        else{
            for(Lecteur l: ll){
                System.out.println("envoi de "+mail+ " à "+l.getMail());
            }
        }
    }*/


    public boolean enLocation(){
        if(Gestion.haloc.get(this)==null)
            return false;
        else
            return true;
    }



}
