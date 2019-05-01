package moran.filtros;

import moran.Pista;

public class FAND extends Filtro {

    private Filtro primero;
    private Filtro segundo;

    public FAND(Filtro uno,Filtro dos)
    {
        this.segundo=dos;
        this.primero=uno;
    }

    public Boolean compara(Pista cancion)
    {

        return primero.compara(cancion) && segundo.compara(cancion);
    }

}
