package moran.filters;

import moran.structures.Track;

public class ArtistFilter implements Filter {
    private String artist;

    public ArtistFilter(String artist) {
        this.artist = artist.toLowerCase();
    }

    @Override
    public boolean accept(Track track) {
        return track.getArtist().toLowerCase().contains(this.artist);
    }
}
