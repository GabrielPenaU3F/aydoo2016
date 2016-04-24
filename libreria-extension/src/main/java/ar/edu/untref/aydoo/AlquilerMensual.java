package ar.edu.untref.aydoo;


public class AlquilerMensual extends Alquiler {

    @Override
    protected void validarPeriodo(int periodo) {

        if (periodo > 3 || periodo < 1) throw new PeriodoExcedidoException();

    }
}
