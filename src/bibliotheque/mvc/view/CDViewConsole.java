package bibliotheque.mvc.view;

import bibliotheque.metier.CD;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class CDViewConsole extends AbstractViewCD {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(CDController.getAll());
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
        CD a = la.get(nl);
        boolean ok = CDController.remove(a);
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
            System.out.println("nombre de plages");
            byte nbrePlages = sc.nextByte();
            System.out.println("durée totale");
            String[] hms = sc.nextLine().split(":");
            int h = Integer.parseInt(hms[0]);
            int min = Integer.parseInt(hms[1]);
            LocalTime dureeTotale= LocalTime.of(h,min);
            CD rech = new CD(titre, ageMin, dateParution, prixLocation, langue, genre, code, nbrePlages, dureeTotale);
            CD a = CDController.search(rech);
            if(a==null) affMsg("CD inconnu");
            else {
                affMsg(a.toString());
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        CD a = la.get(choix-1);
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
                byte nbrePlages = Byte.parseByte(modifyIfNotBlank("nombre de plages", String.valueOf(a.getNbrePlages())));
                LocalTime dureeTotale = LocalTime.parse(modifyIfNotBlank("durée totale", a.getDureeTotale().toString()));
                a.setTitre(Titre);
                a.setAgeMin(ageMin);
                a.setDateParution(dateParution);
                a.setPrixLocation(prixLocation);
                a.setLangue(langue);
                a.setGenre(genre);
                a.setCode(code);
                a.setNbrePlages(nbrePlages);
                a.setDureeTotale(dureeTotale);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        CDController.update(a);
   }

    public void ajouter() {
        CD a;
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
                System.out.println("nombre de plages");
                byte nbrePlages = sc.nextByte();
                System.out.println("durée totale");
                String[] hms = sc.nextLine().split(":");
                int h = Integer.parseInt(hms[0]);
                int min = Integer.parseInt(hms[1]);
                LocalTime dureeTotale= LocalTime.of(h,min);
                a = new CD(titre, ageMin, dateParution, prixLocation, langue, genre, code, nbrePlages, dureeTotale);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        CDController.add(a);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
