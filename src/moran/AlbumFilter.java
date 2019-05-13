package moran;

public class AlbumFilter implements Filter {
    private String album;

    public AlbumFilter(String album) {
        this.album = album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }
    @Override
    public boolean accept(Track track) {
        return track.getAlbumTitle().toLowerCase().contains(this.album.toLowerCase());

    }
}