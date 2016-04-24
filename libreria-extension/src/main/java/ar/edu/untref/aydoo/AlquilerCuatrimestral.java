package ar.edu.untref.aydoo;


public class AlquilerCuatrimestral extends Alquiler {

    public AlquilerCuatrimestral(Libro libro, int cantidadDeCuatrimestres) {

        String nombre = "Alquiler " + libro.getNombre();
        super.setNombre(nombre);
        super.setLibro(libro);
        super.setPrecio(this.calcularPrecio());
        super.setPeriodo(cantidadDeCuatrimestres);

    }

    @Override
    public double calcularPrecio() {

        int periodo = this.getPeriodo();
        return (( periodo * super.getPrecioCuatrimestral()) - this.calcularDescuento());

    }


    private double calcularDescuento() {

        double montoADescontarPorCuatrimestre =  super.getPrecioCuatrimestral() * 0.10;
        return montoADescontarPorCuatrimestre * this.getPeriodo();

    }
}
