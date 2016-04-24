package ar.edu.untref.aydoo;


public abstract class Alquiler extends Producto {

    protected int periodoEnUnidadesDeTiempo;
    protected Libro libro;
    protected int precioMensual = 200;
    protected int precioDiario = 10;
    protected int precioCuatrimestral = 4 * this.precioMensual;
    /*El periodo en unidades de tiempo solo se utiliza
    para calcular el precio final del alquiler. Cada alquiler
    maneja su propia unidad de tiempo (dias, meses, cuatrimestres).
     */

    public int getPeriodo() {

        return this.periodoEnUnidadesDeTiempo;

    }

    public double calcularPrecio() {

        return this.getPeriodo() * this.getPrecio();

    }

    public Libro getLibro() {

        return this.libro;

    }

    protected void setLibro(Libro libro) {

        this.libro = libro;

    }

    protected void setPeriodo(int periodo) {

        this.periodoEnUnidadesDeTiempo = periodo;

    }

    protected double getPrecioMensual() {

        return this.precioMensual;

    }

    protected double getPrecioDiario() {

        return this.precioDiario;

    }

    protected double getPrecioCuatrimestral() {

        return this.precioCuatrimestral;

    }
    
}
