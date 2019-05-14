package moran.filters;

import moran.structures.Track;

public interface Filter {
    public boolean accept(Track track);
}
