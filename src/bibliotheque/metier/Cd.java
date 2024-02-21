package bibliotheque.metier;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cd extends Ouvrage {
    private long code;
    private byte nbrePlages;
    private LocalTime dureeTotale;

    public Cd(String titre, byte ageMin, LocalDate dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, long code, byte nbrePlages, LocalTime dureeTotale) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre);
        this.code = code;
        this.nbrePlages = nbrePlages;
        this.dureeTotale = dureeTotale;
    }

    @Override
    public double amandeRetard(int nbJours) {
        return 0;
    }
}
