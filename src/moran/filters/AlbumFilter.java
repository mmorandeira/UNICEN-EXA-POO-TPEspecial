package moran.filters;

import moran.structures.Track;

public class AlbumFilter implements Filter {
    private String album;

    public AlbumFilter(String album) {
        this.album = album.toLowerCase();
    }

    @Override
    public boolean accept(Track track) {
        return track.getAlbumTitle().toLowerCase().contains(this.album);
    }
}