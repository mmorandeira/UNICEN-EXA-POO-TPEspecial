package moran.filters;

public class Comparator {
    ComparatorMode mode;

    public Comparator(ComparatorMode mode) {
        this.mode = mode;
    }

    public boolean compare(Comparable c1, Comparable c2) {
        int res = c1.compareTo(c2);
        if (mode == ComparatorMode.EQUAL && res == 0) return true;
        if (mode == ComparatorMode.GREATER && res > 0) return true;
        if (mode == ComparatorMode.LESS && res < 0) return true;
        return false;
    }
}
