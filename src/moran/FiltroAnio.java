package moran;

public class FiltroAnio implements Filtro {
    int anio;

    public FiltroAnio(int anio){
        this.anio = anio;
    }

    public int getAnio(){
        return anio;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }

    @Override
    public boolean aceptado(Pista pista) {
        return pista.getAnio()==this.anio;
    }
}
