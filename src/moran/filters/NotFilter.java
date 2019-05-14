package moran.filters;

import moran.structures.Track;

public class NotFilter implements Filter {
    private Filter filter1;

    public NotFilter(Filter filter) {
        this.filter1 = filter;
    }

    @Override
    public boolean accept(Track track) {
        return !filter1.accept(track);
    }
}
