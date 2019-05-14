package moran.filters;

import moran.structures.Track;

public class DurationFilter implements Filter {
    private int maxDuration;

    public DurationFilter(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    @Override
    public boolean accept(Track track) {
        return track.getDuration() < this.maxDuration;
    }
}
