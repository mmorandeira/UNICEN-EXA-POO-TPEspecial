package moran.structures;

import moran.filters.Filter;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Vector;
import java.util.Collections;
import java.util.function.Consumer;

public class Playlist extends Element implements Iterable<Element> {
    Vector<Element> elementVector;

    public Playlist(String name) {
        super(name);
        elementVector = new Vector<Element>();
    }

    public void add(Element element) {
        elementVector.add(element);
    }

    public void addAll(Playlist playlist) {
        for (Element element : playlist) {
            this.add(element);
        }
    }

    public void clear() {
        this.elementVector.clear();
    }

//    public Element elementAt(int index){
//        return elementVector.elementAt(index);
//    }

    public int indexOf(Element element){
        return elementVector.indexOf(element);
    }

    public boolean swap(int index1, int index2) {
        if (inRange(index1) && inRange(index2)) {
            Collections.swap(elementVector, index1, index2);
            return true;
        }
        return false;
    }

    private boolean inRange(int index) {
        return ((index >= 0) && (index < elementVector.size()));
    }

    @Override
    public String toString() {
        return elementVector.toString();
    }

    @Override
    public int totalDuration() {
        int duration = 0;
        for (Element element : elementVector) {
            duration += element.totalDuration();
        }
        return duration;
    }

    @Override
    public int size() {
        int cant = 0;
        for (Element element : elementVector) {
            cant += element.size();
        }
        return cant;
    }

    @Override
    public Playlist find(Filter filter) {
        Playlist aux = new Playlist("Founds");
        for (Element element : elementVector) {
            aux.addAll(element.find(filter));
        }
        return aux;
    }

    @Override
    public Playlist copy() {
        Playlist copy = new Playlist("Copia de " + this.getName());
        for (Element element : elementVector) {
            copy.add(element);
        }
        return copy;
    }


    @Override
    public Iterator iterator() {
        return elementVector.iterator();
    }

    @Override
    public void forEach(Consumer action) {
        elementVector.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return elementVector.spliterator();
    }
}
