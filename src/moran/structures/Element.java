package moran.structures;

import moran.filters.Filter;

import java.util.Objects;

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

    public abstract Playlist find(Filter filter);

    public abstract Element copy(); //nose como implementar cloneable

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(name, element.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
