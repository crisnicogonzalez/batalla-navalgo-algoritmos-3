package disparos;

import partes.ParteDanioDisparo;
import partes.ParteDanioTotal;
import barcos.Vector;

public abstract class Disparo {
    protected int costo;
    protected String nombre;

    public int costo() {
        return costo;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public abstract void cambiarCasillerosAfectados(Vector posicion);

    public abstract boolean debeExplotar();

    public abstract void explotar();

    public void pasarTurno() {

    }

    public abstract void afectar(ParteDanioTotal parte);

    public abstract void afectar(ParteDanioDisparo parte);

}