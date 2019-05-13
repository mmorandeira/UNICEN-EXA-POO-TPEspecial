package moran;

public class ArtistFilter implements Filter
{
    private String artist;

    public ArtistFilter(String artist){this.artist=artist;

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    //devuelve true si el artista ingresado aparece  entro de el nombre del artista del track
    @Override
    public boolean accept(Track track) {
        return  track.getArtist().toLowerCase().contains(this.artist.toLowerCase());
        // return track.getArtist()==this.artist;
    }
}
