package bibliotheque.mvc.model;

import bibliotheque.metier.CD;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOCD extends Subject {


    public abstract CD add( CD elt) ;

    public abstract boolean remove( CD elt) ;

    public abstract CD update(CD elt) ;

    public abstract CD read(CD rech) ;

    public abstract List<CD> getAll() ;
    public List<CD> getNotification(){
        return getAll();
    }
}