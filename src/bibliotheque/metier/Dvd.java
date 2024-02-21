package bibliotheque.metier;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Dvd extends Ouvrage{

    private long code;
    private LocalTime dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues;
    private List<String> sousTitres;

    public Dvd(String titre, byte ageMin, LocalDate dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, long code, LocalTime dureeTotale, byte nbreBonus) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre);
        this.code = code;
        this.dureeTotale = dureeTotale;
        this.nbreBonus = nbreBonus;
    }

    @Override
    public double amandeRetard(int nbJours) {
        return 0;
    }
}
