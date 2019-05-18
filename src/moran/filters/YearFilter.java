package moran.filters;

import moran.structures.Track;

public class YearFilter implements Filter {
    private int year;
    private Comparator comparator;

    public YearFilter(int year, Comparator comp) {
        this.year = year;
        this.comparator = comp;
    }

    @Override
    public boolean accept(Track track) {
        return this.comparator.compare(track.getYear(), this.year);
    }
}
