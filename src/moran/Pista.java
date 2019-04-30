package moran;

import java.util.Objects;

public class Pista {
    int id, duracion, anio;

    public int getId() {
        return id;
    }

    public Pista(int id, int duracion, int anio, String titulo, String artista, String tituloAlbum, String genero, String comentarios) {
        this.id = id;
        this.duracion = duracion;
        this.anio = anio;
        this.titulo = titulo;
        this.artista = artista;
        this.tituloAlbum = tituloAlbum;
        this.genero = genero;
        this.comentarios = comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pista pista = (Pista) o;
        return id == pista.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public void setTituloAlbum(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    @Override
    public String toString() {
        return "Pista{" +
                "id=" + id +
                ", duracion=" + duracion +
                ", anio=" + anio +
                ", titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", tituloAlbum='" + tituloAlbum + '\'' +
                ", genero='" + genero + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    String titulo, artista, tituloAlbum, genero, comentarios;
}
