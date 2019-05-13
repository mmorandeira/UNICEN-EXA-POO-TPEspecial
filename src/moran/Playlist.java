package moran;

import java.util.ArrayList;


//implementacion con lista de playlisto o listas de canciones.
public class Playlist
    {
    private String nombre;
    private ArrayList<Pista> ;
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

   //tamaño mal echo
   /*
    public int getTamaño()

    {
        int tam=0;
        for(Pista a: listaCanciones)
            {
            tam++;
            }
        return tam;
    }
    */

    public int getTamaño(){return listaCanciones.size()}
    public int getDuracion(){
        int tam=0;
        for(Pista a: listaCanciones)
        {
            tam+=a.getDuracion();
        }
        return tam;
    }

    public void agregarCancion(Pista cancion)
    {
        listaCanciones.add(cancion)
    }
    public boolean estaVacia()
    {
        return listaCanciones.isEmpty();
    }

    }
