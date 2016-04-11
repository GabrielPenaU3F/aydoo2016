package ar.edu.untref.aydoo;

public class Diario extends Producto implements Suscribible {
	
	private int periodicidad;
	
	public Diario (String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public int getPeriodicidad() {
		
		return this.periodicidad;
		
	}

}
