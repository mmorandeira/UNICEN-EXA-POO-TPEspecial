package moran.filters;

import moran.structures.Track;

public class TitleFilter implements Filter {
    private String title;

    public TitleFilter(String title) {
        this.title = title.toLowerCase();
    }

    @Override
    public boolean accept(Track track) {
        return track.getName().toLowerCase().contains(this.title);
    }
}