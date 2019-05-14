package moran.filters;

import moran.structures.Track;

public class OrFilter implements Filter {
    private Filter filter1, filter2;

    public OrFilter(Filter filter1, Filter filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    @Override
    public boolean accept(Track track) {
        return filter1.accept(track) || filter2.accept(track);
    }
}