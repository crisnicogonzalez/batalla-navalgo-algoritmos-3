package disparos;

import java.util.ArrayList;

import partes.Parte;
import partes.ParteDanioDisparo;
import partes.ParteDanioTotal;
import barcos.Vector;
import casillero.Casillero;
import escenario.Tablero;
import excepciones.PosicionInvalida;

public class DisparoConvencional extends Disparo {
    protected Casillero casilleroAfectado;

    public DisparoConvencional() {
        costo = 200;
        nombre = "disparoconvencional";
    }

    @Override
    public void cambiarCasillerosAfectados(Vector posicion) throws PosicionInvalida {
        if (Tablero.getTablero().fueraDeRango(posicion)) {
            throw new PosicionInvalida("El disparo queda fuera de rango. Imposible colocar.");
        }
        Tablero tablero = Tablero.getTablero();
        casilleroAfectado = tablero.obtenerCasillero(posicion);
    }

    @Override
    public boolean debeExplotar() {
        return true;
    }

    @Override
    public void explotar() {
        ArrayList<Parte> partesAfectadas = casilleroAfectado.obtenerPartes();
        for (int i = 0; i < partesAfectadas.size(); i++) {
            (partesAfectadas.get(i)).explosion(this);
        }
    }

    @Override
    public void afectar(ParteDanioTotal parte) {
        parte.recibirDanio(1);
    }

    @Override
    public void afectar(ParteDanioDisparo parte) {
        parte.recibirDanio(1);
    }

}
