package moran.filters;

public class Comparator {
    ComparatorMode mode;

    public Comparator(ComparatorMode mode) {
        this.mode = mode;
    }

    public boolean compare(Comparable c1, Comparable c2) {
        int res = c1.compareTo(c2);
        if (mode.equals(ComparatorMode.EQUAL) && res == 0) return true;
        if (mode.equals(ComparatorMode.GREATER) && res > 0) return true;
        if (mode.equals(ComparatorMode.LESS) && res < 0) return true;
        return false;
    }
}
