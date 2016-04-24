package ar.edu.untref.aydoo;


public class AlquilerCuatrimestral extends Alquiler {

    public AlquilerCuatrimestral(Libro libro, int cantidadDeCuatrimestres) {

        String nombre = "Alquiler " + libro.getNombre();
        super.setNombre(nombre);
        super.setLibro(libro);
        this.validarPeriodo(cantidadDeCuatrimestres);
        super.setPeriodo(cantidadDeCuatrimestres);
        super.setPrecio(this.calcularPrecio());

    }

    @Override
    protected double calcularPrecio() {

        return ((this.getPeriodo() * super.getPrecioCuatrimestral()) - this.calcularDescuento());

    }


    private double calcularDescuento() {

        double montoADescontarPorCuatrimestre =  super.getPrecioCuatrimestral() * 0.10;
        return montoADescontarPorCuatrimestre * this.getPeriodo();

    }

    protected void validarPeriodo(int periodo) {

        if (periodo > 2 || periodo < 1) throw new PeriodoExcedidoException();

    }
}
