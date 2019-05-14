package moran.structures;

import moran.filters.Filter;

import java.util.Vector;

public abstract class Element { //implements Cloneable {
    private String name;

    public abstract int totalDuration();

    public abstract int size();

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Vector<Element> find(Filter filter);

    public abstract boolean remove(Track track);

    public abstract Element copy(); //nose como implementar cloneable

}
