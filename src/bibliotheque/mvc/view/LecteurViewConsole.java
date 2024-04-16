package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class LecteurViewConsole extends AbstractViewLecteur {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(LecteurController.getAll());
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
        Lecteur a = la.get(nl);
        boolean ok = LecteurController.remove(a);
        if(ok) affMsg("client effacé");
        else affMsg("client non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println("numlecteur");
            int numlecteur = sc.nextInt();
            System.out.println("nom ");
            String nom = sc.nextLine();
            System.out.println("prénom ");
            String prenom = sc.nextLine();
            System.out.println("date de naissance");
            String[] jma = sc.nextLine().split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int an = Integer.parseInt(jma[2]);
            LocalDate dn= LocalDate.of(an,m,j);
            System.out.println("adresse");
            String adresse = sc.nextLine();
            System.out.println("mail");
            String mail = sc.nextLine();
            System.out.println("tel");
            String tel = sc.nextLine();
            Lecteur rech = new Lecteur(numlecteur,nom, prenom, dn, adresse, mail, tel);
            Lecteur a = LecteurController.search(rech);
            if(a==null) affMsg("Lecteur inconnu");
            else {
                affMsg(a.toString());
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        Lecteur a = la.get(choix-1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         do {
            try {
                int numlecteur = Integer.parseInt(modifyIfNotBlank("numéro", String.valueOf(a.getNumlecteur())));
                String nom= modifyIfNotBlank("nom", a.getNom());
                String prenom= modifyIfNotBlank("prénom", a.getPrenom());
                LocalDate dn= LocalDate.parse(modifyIfNotBlank("date de naissance", a.getDn().format(formatter)));
                String adresse=modifyIfNotBlank("adresse", a.getAdresse());
                String mail= modifyIfNotBlank("mail", a.getMail());
                String tel= modifyIfNotBlank("tel", a.getTel());
                a.setNumlecteur(numlecteur);
                a.setNom(nom);
                a.setPrenom(prenom);
                a.setDn(dn);
                a.setAdresse(adresse);
                a.setMail(mail);
                a.setTel(tel);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        LecteurController.update(a);
   }

/*
                int numlecteur;
                String nom;
                String prenom;
                LocalDate dn;
                String adresse;
                String mail;
                String tel;
 */
    public void ajouter() {
        Lecteur a;
        do {
            try {
                System.out.println("numlecteur");
                int numlecteur = sc.nextInt();
                System.out.println("nom ");
                String nom = sc.nextLine();
                System.out.println("prénom ");
                String prenom = sc.nextLine();
                System.out.println("date de naissance");
                String[] jma = sc.nextLine().split(" ");
                int j = Integer.parseInt(jma[0]);
                int m = Integer.parseInt(jma[1]);
                int an = Integer.parseInt(jma[2]);
                LocalDate dn= LocalDate.of(an,m,j);
                System.out.println("adresse");
                String adresse = sc.nextLine();
                System.out.println("mail");
                String mail = sc.nextLine();
                System.out.println("tel");
                String tel = sc.nextLine();
                a = new Lecteur(numlecteur,nom, prenom, dn, adresse, mail, tel);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        LecteurController.add(a);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
