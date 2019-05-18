package moran.filters;

import moran.structures.Track;

public class YearFilter implements Filter {
    private int year;
    private Comparator comp;

    public YearFilter(int year, Comparator comp) {
        this.year = year;
        this.comp = comp;
    }

    @Override
    public boolean accept(Track track) {
        return this.comp.compare(track.getYear(), this.year);
    }
}
