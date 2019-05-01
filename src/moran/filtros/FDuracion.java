package moran.filtros;

import moran.Pista;

public class FDuracion extends Filtro{



    private int anio;

    public FAnio(int anio)
    {
        this.anio=anio;
    }

    public Boolean compara (Pista cancion)
    {
        return (cancion.getAnio()< anio);
    }

}
}