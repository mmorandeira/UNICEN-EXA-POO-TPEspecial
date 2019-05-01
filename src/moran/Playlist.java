package moran;

import java.util.ArrayList;

public class Playlist
    {
    private String nombre;
    private ArrayList<Pista> listaCanciones;
    private int tamaño;

    public Playlist(String nombre,ArrayList<Pista> listita)
    {
        this.nombre=nombre;
        this.listaCanciones=listita;
    }
    public  Playlist(ArrayList<Pista> listita)
    {
        this.nombre="Nuesva playlist";
        this.listaCanciones=listita;
    }
    public void setNombre(String nombre) {
            this.nombre = nombre;
        }

    public String getNombre()
    {
            return nombre;
    }

    public int getTamaño()
    {
        int tam=0;
        for(Pista a: listaCanciones)
            {
            tam++;
            }
        return tam
    }

    }
