package moran.filters;

public class Comparator {
    ComparatorMode modo;

    public Comparator(ComparatorMode modo) {
        this.modo = modo;
    }

    public boolean comparar(Comparable c1, Comparable c2) {
        int res = c1.compareTo(c2);
        if (modo == ComparatorMode.IGUAL && res == 0) return true;
        if (modo == ComparatorMode.MAYOR && res > 0) return true;
        if (modo == ComparatorMode.MENOR && res < 0) return true;
        return false;
    }
}
