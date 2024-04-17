package bibliotheque.mvcold.controller;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvcold.model.DAO;
import bibliotheque.mvcold.view.AbstractView;

public class LecteurController extends Controller<Lecteur> {

    public LecteurController(DAO<Lecteur> model, AbstractView<Lecteur> view) {
        super(model, view);
    }
}
