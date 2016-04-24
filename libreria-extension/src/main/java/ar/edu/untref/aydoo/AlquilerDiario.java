package ar.edu.untref.aydoo;


public class AlquilerDiario extends Alquiler {

    public AlquilerDiario(Libro libro, int cantidadDeDias) {

        String nombre = "Alquiler " + libro.getNombre();
        super.setNombre(nombre);
        super.setLibro(libro);
        this.validarPeriodo(cantidadDeDias);
        super.setPeriodo(cantidadDeDias);
        super.setPrecio(this.calcularPrecio());

    }

    @Override
    protected double calcularPrecio() {

        return super.getPrecioDiario() * this.getPeriodo();

    }

    @Override
    protected void validarPeriodo(int periodo) {

        if (periodo > 25 || periodo < 3) throw new PeriodoExcedidoException();

    }
}
