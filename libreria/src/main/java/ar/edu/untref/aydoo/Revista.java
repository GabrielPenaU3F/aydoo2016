package ar.edu.untref.aydoo;

public class Revista extends Producto implements Suscribible{

	private int periodicidad;
	
	public Revista(String nombre, int periodicidad, double precio) {
		
		this.nombre = nombre;
		this.periodicidad = periodicidad;
		this.precio = precio;
		
	}
	
	public int getPeriodicidad() {
		
		return this.periodicidad;
		
	}
}
