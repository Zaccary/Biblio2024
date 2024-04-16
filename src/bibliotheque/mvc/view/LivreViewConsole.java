package bibliotheque.mvc.view;

import bibliotheque.metier.Livre;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class LivreViewConsole extends AbstractViewLivre {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(LivreController.getAll());
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
        Livre a = la.get(nl);
        boolean ok = LivreController.remove(a);
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
            System.out.println("Isbn");
            String isbn = sc.nextLine();
            System.out.println("nombre de pages");
            int nbrePages = sc.nextInt();
            System.out.println("type de livre");
            TypeLivre tl = TypeLivre.valueOf(sc.nextLine());
            System.out.println("resume");
            String resume = sc.nextLine();
            Livre rech = new Livre(titre, ageMin, dateParution, prixLocation, langue, genre, isbn, nbrePages, tl, resume);
            Livre a = LivreController.search(rech);
            if(a==null) affMsg("Livre inconnu");
            else {
                affMsg(a.toString());
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        Livre a = la.get(choix-1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         do {
            try {
                String Titre= modifyIfNotBlank("nom", a.getTitre());
                int ageMin = Integer.parseInt(modifyIfNotBlank("ageMin", String.valueOf(a.getAgeMin())));
                LocalDate dateParution = LocalDate.parse(modifyIfNotBlank("date de parution", a.getDateParution().format(formatter)));
                double prixLocation = Double.parseDouble(modifyIfNotBlank("prix de location", String.valueOf(a.getPrixLocation())));
                String langue = modifyIfNotBlank("langue", a.getLangue());
                String genre = modifyIfNotBlank("genre", a.getGenre());
                String isbn = modifyIfNotBlank("isbn", a.getIsbn());
                int nbrePages = Integer.parseInt(modifyIfNotBlank("nombre de pages", String.valueOf(a.getNbrePages())));
                TypeLivre tl = TypeLivre.valueOf(modifyIfNotBlank("type de livre", a.getTl().toString()));
                String resume = modifyIfNotBlank("resume", a.getResume());
                a.setTitre(Titre);
                a.setAgeMin(ageMin);
                a.setDateParution(dateParution);
                a.setPrixLocation(prixLocation);
                a.setLangue(langue);
                a.setGenre(genre);
                a.setIsbn(isbn);
                a.setNbrePages(nbrePages);
                a.setTl(tl);
                a.setResume(resume);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        LivreController.update(a);
   }

    public void ajouter() {
        Livre a;
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
                System.out.println("Isbn");
                String isbn = sc.nextLine();
                System.out.println("nombre de pages");
                int nbrePages = sc.nextInt();
                System.out.println("type de livre");
                TypeLivre tl = TypeLivre.valueOf(sc.nextLine());
                System.out.println("resume");
                String resume = sc.nextLine();
                a = new Livre(titre, ageMin, dateParution, prixLocation, langue, genre, isbn, nbrePages, tl, resume);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        LivreController.add(a);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
