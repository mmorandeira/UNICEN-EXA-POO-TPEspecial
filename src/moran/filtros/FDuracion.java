package moran.filtros;

import moran.Pista;

public class FDuracion extends Filtro{

    private int tiempo;

    public FAnio(int tiempo)
    {
        this.tiempo=tiempo;
    }

    public Boolean compara (Pista cancion)
    {
        return (cancion.getDuracion()< tiempo);
    }
}

