package bibliotheque.mvc.view;

import bibliotheque.metier.DVD;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class DVDViewConsole extends AbstractViewDVD {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(DVDController.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher","modifier","fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void retirer() {
        int nl = choixElt(la)-1;
        DVD a = la.get(nl);
        boolean ok = DVDController.remove(a);
        if(ok) affMsg("client effacé");
        else affMsg("client non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }
    public void rechercher() {
        try {
            System.out.println("Titre");
            String titre = sc.nextLine();
            System.out.println("ageMin");
            int ageMin = sc.nextInt();
            System.out.println("date de parution");
            String[] jma = sc.nextLine().split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int an = Integer.parseInt(jma[2]);
            LocalDate dateParution= LocalDate.of(an,m,j);
            System.out.println("prix de location");
            double prixLocation = sc.nextDouble();
            System.out.println("langue");
            String langue = sc.nextLine();
            System.out.println("genre");
            String genre = sc.nextLine();
            System.out.println("code");
            long code = sc.nextLong();
            System.out.println("durée totale");
            String[] hms = sc.nextLine().split(":");
            int h = Integer.parseInt(hms[0]);
            int min = Integer.parseInt(hms[1]);
            LocalTime dureeTotale= LocalTime.of(h,min);
            System.out.println("nombre bonus");
            byte nbreBonus = sc.nextByte();
            DVD rech = new DVD(titre, ageMin, dateParution, prixLocation, langue, genre, code, dureeTotale,nbreBonus);
            DVD a = DVDController.search(rech);
            if(a==null) affMsg("DVD inconnu");
            else {
                affMsg(a.toString());
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        DVD a = la.get(choix-1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         do {
            try {
                String Titre= modifyIfNotBlank("nom", a.getTitre());
                int ageMin = Integer.parseInt(modifyIfNotBlank("ageMin", String.valueOf(a.getAgeMin())));
                LocalDate dateParution = LocalDate.parse(modifyIfNotBlank("date de parution", a.getDateParution().format(formatter)));
                double prixLocation = Double.parseDouble(modifyIfNotBlank("prix de location", String.valueOf(a.getPrixLocation())));
                String langue = modifyIfNotBlank("langue", a.getLangue());
                String genre = modifyIfNotBlank("genre", a.getGenre());
                long code = Long.parseLong(modifyIfNotBlank("code", String.valueOf(a.getCode())));
                LocalTime dureeTotale = LocalTime.parse(modifyIfNotBlank("durée totale", a.getDureeTotale().toString()));
                byte nbreBonus = Byte.parseByte(modifyIfNotBlank("nombre de plages", String.valueOf(a.getNbreBonus())));
                a.setTitre(Titre);
                a.setAgeMin(ageMin);
                a.setDateParution(dateParution);
                a.setPrixLocation(prixLocation);
                a.setLangue(langue);
                a.setGenre(genre);
                a.setCode(code);
                a.setNbreBonus(nbreBonus);
                a.setDureeTotale(dureeTotale);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        DVDController.update(a);
   }

    public void ajouter() {
        DVD a;
        do {
            try {
                System.out.println("Titre");
                String titre = sc.nextLine();
                System.out.println("ageMin");
                int ageMin = sc.nextInt();
                System.out.println("date de parution");
                String[] jma = sc.nextLine().split(" ");
                int j = Integer.parseInt(jma[0]);
                int m = Integer.parseInt(jma[1]);
                int an = Integer.parseInt(jma[2]);
                LocalDate dateParution= LocalDate.of(an,m,j);
                System.out.println("prix de location");
                double prixLocation = sc.nextDouble();
                System.out.println("langue");
                String langue = sc.nextLine();
                System.out.println("genre");
                String genre = sc.nextLine();
                System.out.println("code");
                long code = sc.nextLong();
                System.out.println("durée totale");
                String[] hms = sc.nextLine().split(":");
                int h = Integer.parseInt(hms[0]);
                int min = Integer.parseInt(hms[1]);
                LocalTime dureeTotale= LocalTime.of(h,min);
                System.out.println("nombre bonus");
                byte nbreBonus = sc.nextByte();
                a = new DVD(titre, ageMin, dateParution, prixLocation, langue, genre, code, dureeTotale,nbreBonus);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        DVDController.add(a);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
