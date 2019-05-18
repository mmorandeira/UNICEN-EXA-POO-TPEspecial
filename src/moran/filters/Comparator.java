package moran.filters;

public class Comparator {
    ComparatorMode modo;

    public Comparator(ComparatorMode modo) {
        this.modo = modo;
    }

    public boolean comparar(Comparable c1, Comparable c2) {
        int res = c1.compareTo(c2);
        if (modo == ComparatorMode.EQUAL && res == 0) return true;
        if (modo == ComparatorMode.GREATER && res > 0) return true;
        if (modo == ComparatorMode.LESS && res < 0) return true;
        return false;
    }
}
