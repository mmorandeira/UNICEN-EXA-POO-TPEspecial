package moran.filters;

import moran.structures.Track;

public class TitleFilter implements Filter {
    private String title;

    public TitleFilter(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean accept(Track track) {
        return track.getName().toLowerCase().contains(this.title.toLowerCase());

    }
}