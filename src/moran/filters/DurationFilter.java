package moran.filters;

import moran.structures.Track;

public class DurationFilter implements Filter {
    private int duration;
    private Comparator comparator;

    public DurationFilter(int maxDuration, Comparator comparator) {
        this.duration = maxDuration;
        this.comparator = comparator;
    }

    @Override
    public boolean accept(Track track) {
        return this.comparator.compare(track.getDuration(), this.duration);
    }
}
