package ar.edu.untref.aydoo;

public class Periodico extends Producto implements Suscribible {
	
	private Periodicidad periodicidad;

	public Periodico(String nombre, int precio, Periodicidad periodicidad) {
		super.setNombre(nombre);
		super.setPrecio(precio);
		this.periodicidad = periodicidad;
	}
	
	public int getPeriodicidad(){
		return 30/this.periodicidad.getPeriodo();
	}
}
