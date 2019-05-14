package moran.structures;

import moran.filters.Filter;

import java.util.Objects;
import java.util.Vector;

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
        this.id = trackToCopy.id;
        this.duration = trackToCopy.duration;
        this.year = trackToCopy.year;
        this.artist = trackToCopy.artist;
        this.albumTitle = trackToCopy.albumTitle;
        this.genre = trackToCopy.genre;
        this.comments = trackToCopy.comments;
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
        return "Pista{" +
                "id=" + id +
                ", duracion=" + duration +
                ", anio=" + year +
                ", titulo='" + this.getName() + '\'' +
                ", artista='" + artist + '\'' +
                ", tituloAlbum='" + albumTitle + '\'' +
                ", genero='" + genre + '\'' +
                ", comentarios='" + comments + '\'' +
                '}';
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
    public Vector<Element> find(Filter filter) {
        if (filter.accept(this)) {
            Vector<Element> aux = new Vector<Element>();
            aux.add(this);
            return aux;
        }
        return null;
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
    public Object clone() throws CloneNotSupportedException {
        return (Track) super.clone();
    }
}
