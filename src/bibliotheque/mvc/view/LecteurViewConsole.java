package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class LecteurViewConsole extends AbstractView<Lecteur> {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(controller.getAll());
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

    @Override
    public void affList(List la) {
        affListe(la);
    }

    private void retirer() {
        int nl = choixElt(la)-1;
        Lecteur l = la.get(nl);
        boolean ok = controller.remove(l);
        if(ok) affMsg("lecteur effacé");
        else affMsg("lecteur non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println("numéro de lecteur :");
            int id = lireInt();
            Lecteur rech = new Lecteur(id,"","",null,"","","");
            Lecteur l = controller.search(rech);
            if(l==null) affMsg("lecteur inconnu");
            else {
                affMsg(l.toString());
             }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        Lecteur a  = la.get(choix-1);
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
        controller.update(a);
   }


    public void ajouter() {
       Lecteur l;
        do {
            try {
                System.out.println("nom ");
                String nom = sc.nextLine();
                System.out.println("prénom ");
                String prenom = sc.nextLine();
                System.out.println("date de naissance :");
                LocalDate dn = lecDate();
                System.out.println("mail :");
                String mail = sc.nextLine();
                System.out.println("adresse :");
                String adr = sc.nextLine();
                System.out.println("tel :");
                String tel = sc.nextLine();
                l = new Lecteur(nom,prenom,dn,adr,mail,tel);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        l=controller.add(l);
        affMsg("création du lecteur : "+l);
    }

}
