package bibliotheque.mvc.model;

import bibliotheque.metier.CD;

import java.util.ArrayList;
import java.util.List;

public class CDModel extends DAOCD {

    private List<CD> ldatas = new ArrayList<>();


    @Override
    public CD add( CD elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove( CD elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public CD update(CD elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public CD read(CD rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<CD> getAll() {
        return ldatas;
    }
}
