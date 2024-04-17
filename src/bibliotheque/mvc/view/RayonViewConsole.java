package bibliotheque.mvc.view;

import bibliotheque.metier.Rayon;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class RayonViewConsole extends AbstractViewRayon {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(RayonController.getAll());
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
        Rayon a = la.get(nl);
        boolean ok = RayonController.remove(a);
        if(ok) affMsg("client effacé");
        else affMsg("client non effacé");
    }
    private void affMsg(String msg) {
        System.out.println(msg);
    }
    public void rechercher() {
        try {
            System.out.println("codeRayon");
            String codeRayon = sc.nextLine();
            System.out.println("genre");
            String genre = sc.nextLine();
            Rayon rech = new Rayon(codeRayon, genre);
            Rayon a = RayonController.search(rech);
            if(a==null) affMsg("Rayon inconnu");
            else {
                affMsg(a.toString());
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        Rayon a = la.get(choix-1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         do {
            try {
                String codeRayon = modifyIfNotBlank("codeRayon", a.getCodeRayon());
                String genre = modifyIfNotBlank("genre", a.getGenre());
                a.setCodeRayon(codeRayon);
                a.setGenre(genre);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        RayonController.update(a);
   }

    public void ajouter() {
        Rayon a;
        do {
            try {
                System.out.println("codeRayon");
                String codeRayon = sc.nextLine();
                System.out.println("genre");
                String genre = sc.nextLine();
                a = new Rayon(codeRayon, genre);
                break;

            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        RayonController.add(a);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
