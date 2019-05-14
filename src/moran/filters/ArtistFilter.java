package moran.filters;

import moran.structures.Track;

public class ArtistFilter implements Filter {
    private String artist;

    public ArtistFilter(String artist) {
        this.artist = artist;

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean accept(Track track) {
        return track.getArtist().toLowerCase().contains(this.artist.toLowerCase());
    }
}
