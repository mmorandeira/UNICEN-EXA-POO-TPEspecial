package moran.filtros;

import moran.Pista;

public class FNOT extends Filtro{

    private Filtro primero;

    public Boolean compara (Pista cancion){
        return !primero.compara(cancion);
    }
}
