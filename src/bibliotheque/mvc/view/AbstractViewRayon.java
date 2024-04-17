package bibliotheque.mvc.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvc.controller.RayonController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewRayon implements Observer {

    protected RayonController RayonController;
    protected List<Rayon> la;

    public void setController(RayonController RayonController) {
        this.RayonController = RayonController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Rayon> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
