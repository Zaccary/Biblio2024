package bibliotheque.mvc.view;

import bibliotheque.metier.Mail;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class MailViewConsole extends AbstractViewMail {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(MailController.getAll());
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
        Mail a = la.get(nl);
        boolean ok = MailController.remove(a);
        if(ok) affMsg("client effacé");
        else affMsg("client non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }
    public void rechercher() {
        try {
            System.out.println("objet");
            String objet = sc.nextLine();
            System.out.println("message");
            String message = sc.nextLine();
            System.out.println("date d'envoi");
            String dateEnvoi = sc.nextLine();
            Mail rech = new Mail(objet, message, dateEnvoi);
            Mail a = MailController.search(rech);
            if(a==null) affMsg("Mail inconnu");
            else {
                affMsg(a.toString());
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        Mail a = la.get(choix-1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         do {
            try {
                String objet = modifyIfNotBlank("objet", a.getObjet());
                String message = modifyIfNotBlank("message", a.getMessage());
                String dateEnvoie = modifyIfNotBlank("date d'envoi", a.getDateEnvoi());
                a.setObjet(objet);
                a.setMessage(message);
                a.setDateEnvoi(dateEnvoie
                );
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        MailController.update(a);
   }

    public void ajouter() {
        Mail a;
        do {
            try {
                System.out.println("objet");
                String objet = sc.nextLine();
                System.out.println("message");
                String message = sc.nextLine();
                System.out.println("date d'envoi");
                String dateEnvoi = sc.nextLine();
                a = new Mail(objet, message, dateEnvoi);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        MailController.add(a);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
