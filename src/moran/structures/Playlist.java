package moran.structures;

import moran.filters.Filter;

import java.util.Vector;

public class Playlist extends Element {
    Vector<Element> elementVector;

    public Playlist(String name) {
        super(name);
        elementVector = new Vector<Element>();
    }

    public void add(Element element) {
        elementVector.add(element);
    }

    @Override
    public String toString() {
        String aux = "{\n";
        for (int i = 0; i < elementVector.size(); i++) {
            aux += i + ": " + elementVector.elementAt(i).toString() + "\n";
            /*
            if (i + 1 < elementVector.size()) {
                aux += "\n";
            }
            */
        }
        aux += "}";
        return aux;
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
    public Vector<Element> find(Filter filter) {
        Vector<Element> aux = new Vector<Element>();
        for (Element element : elementVector) {
            aux.addAll(element.find(filter));
        }
        return aux;
    }

    @Override
    public boolean remove(Track track) {
        for (Element element : elementVector) {
            if (element.remove(track)) {
                elementVector.remove(element);
            }
        }
        return elementVector.size() == 0;
    }

    /*
    @Override
    public Object clone() throws CloneNotSupportedException {
        Playlist copy = new Playlist(this.getName());
        for(Element element:elementVector){
            copy.add(element.clone());
        }
        return ;
    }
    */

    @Override
    public Playlist copy() {
        Playlist copy = new Playlist("Copia de " + this.getName());
        for (Element element : elementVector) {
            copy.add(element);
        }
        return copy;
    }

    public void test() {
    }
}
