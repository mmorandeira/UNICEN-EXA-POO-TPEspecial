package moran;

import java.util.Vector;

public abstract class Element {
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

}
