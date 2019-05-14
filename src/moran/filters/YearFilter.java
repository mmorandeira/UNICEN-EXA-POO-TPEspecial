package moran.filters;

import moran.structures.Track;

public class YearFilter implements Filter {
    int year;

    public YearFilter(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean accept(Track track) {
        return track.getYear() == this.year;
    }
}
