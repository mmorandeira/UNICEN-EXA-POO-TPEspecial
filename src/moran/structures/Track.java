package moran.structures;

import moran.filters.Filter;
import java.util.Objects;

public class Track extends Element {
    int id, duration, year;
    public final int size = 1;

    public int getId() {
        return id;
    }

    public Track(int id, int duration, int year, String name, String artist, String albumTitle, String genre, String comments) {
        super(name);
        this.id = id;
        this.duration = duration;
        this.year = year;
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.comments = comments;
    }

    public Track(Track trackToCopy) {
        super(trackToCopy.getName());
        this.id = trackToCopy.getId();
        this.duration = trackToCopy.getDuration();
        this.year = trackToCopy.getYear();
        this.artist = trackToCopy.getArtist();
        this.albumTitle = trackToCopy.getAlbumTitle();
        this.genre = trackToCopy.getGenre();
        this.comments = trackToCopy.getComments();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    @Override
    public String toString() {
        return "Pista{ " + this.getId() +
                " - " + this.getName() +
                " - " + this.getArtist() +
                " - " + this.getAlbumTitle() +
                " - (" + this.getGenre() +
                "," + this.getYear() +
                ") }";
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    String artist, albumTitle, genre, comments;

    @Override
    public int totalDuration() {
        return duration;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Playlist find(Filter filter) {
        Playlist aux = new Playlist("Founds");
        if (filter.accept(this)) {
            aux.add(this);
        }
        return aux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return id == track.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Track copy() {
        Track aux = new Track(this);
        return aux;
    }

}
