package moran;

import java.util.Objects;

public class Track {
    int id, duration, year;

    public int getId() {
        return id;
    }

    public Track(int id, int duration, int year, String title, String artist, String albumTitle, String genre, String comments) {
        this.id = id;
        this.duration = duration;
        this.year = year;
        this.title = title;
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.comments = comments;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                ", titulo='" + title + '\'' +
                ", artista='" + artist + '\'' +
                ", tituloAlbum='" + title + '\'' +
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

    String title, artist, albumTitle, genre, comments;
}
