package bibliotheque.mvc.view;

import bibliotheque.metier.Livre;
import bibliotheque.mvc.controller.LivreController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewLivre implements Observer {

    protected LivreController LivreController;
    protected List<Livre> la;

    public void setController(LivreController LivreController) {
        this.LivreController = LivreController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Livre> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
