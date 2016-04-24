package ar.edu.untref.aydoo;


public class AlquilerDiario extends Alquiler {

    @Override
    protected void validarPeriodo(int periodo) {

        if (periodo > 25 || periodo < 3) throw new PeriodoExcedidoException();

    }
}
