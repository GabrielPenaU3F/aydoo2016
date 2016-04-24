package ar.edu.untref.aydoo;


public class AlquilerMensual extends Alquiler {

    public AlquilerMensual(Libro libro, int cantidadDeMeses) {

        String nombre = "Alquiler " + libro.getNombre();
        super.setNombre(nombre);
        super.setLibro(libro);
        this.validarPeriodo(cantidadDeMeses);
        super.setPeriodo(cantidadDeMeses);
        super.setPrecio(this.calcularPrecio());

    }

    @Override
    protected void validarPeriodo(int periodo) {

        if (periodo > 3 || periodo < 1) throw new PeriodoExcedidoException();

    }

    @Override
    protected double calcularPrecio() {

        return super.getPrecioMensual() * this.getPeriodo();

    }
}
