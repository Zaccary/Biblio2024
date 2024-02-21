package bibliotheque.metier;

import java.time.LocalDate;
import java.util.List;

public class Livre extends Ouvrage {
    private String ISBN;
    private int nbPages;
    private TypeLivre typeLivre;
    private String resume;

    public Livre(String titre, byte ageMin, LocalDate dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, String ISBN, int nbPages, TypeLivre typeLivre, String resume) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre);
        this.ISBN = ISBN;
        this.nbPages = nbPages;
        this.typeLivre = typeLivre;
        this.resume = resume;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public TypeLivre getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(TypeLivre typeLivre) {
        this.typeLivre = typeLivre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
    public List<Exemplaire> getListeExemplaires() {
        return  super.getExemplaires();
    }

    @Override
    public double amandeRetard(int nbJours) {
        return 0;
    }
}
