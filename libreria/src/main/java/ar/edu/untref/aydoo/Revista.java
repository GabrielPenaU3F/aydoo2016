package ar.edu.untref.aydoo;

public class Revista extends Producto implements Suscribible{

	private int periodicidad;
	
	public Revista(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public int getPeriodicidad() {
		
		return this.periodicidad;
		
	}
}
