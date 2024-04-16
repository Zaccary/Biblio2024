package bibliotheque.mvc.controller;

import bibliotheque.metier.CD;
import bibliotheque.mvc.model.DAOCD;
import bibliotheque.mvc.view.AbstractViewCD;

import java.util.List;


public class CDController {

    protected  DAOCD model;
    protected  AbstractViewCD view;

    public CDController(DAOCD model, AbstractViewCD view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<CD> getAll(){
        List<CD> l = model.getAll();
        return l;
    }

    public CD add( CD elt) {
        CD nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(CD elt) {
        return model.remove(elt);
    }
    public CD update(CD elt) {
        return model.update(elt);
    }

    public CD search(CD rech) {
        return  model.read(rech);
    }
}
