package moran.filters;

import moran.structures.Track;

public class GenreFilter implements Filter {
    private String genre;

    public GenreFilter(String genre) {
        this.genre = genre.toLowerCase();
    }

    @Override
    public boolean accept(Track track) {
        return track.getGenre().toLowerCase().contains(this.genre);
    }
}

