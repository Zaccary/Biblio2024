package bibliotheque.mvc.model;

import bibliotheque.metier.DVD;

import java.util.ArrayList;
import java.util.List;

public class DVDModel extends DAODVD {

    private List<DVD> ldatas = new ArrayList<>();


    @Override
    public DVD add( DVD elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove( DVD elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public DVD update(DVD elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public DVD read(DVD rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<DVD> getAll() {
        return ldatas;
    }
}
