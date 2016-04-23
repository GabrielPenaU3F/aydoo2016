package ar.edu.untref.aydoo;

public class Revista extends Producto implements Suscribible {
	
	private Periodicidad periodicidad;

	public Revista(String nombre, int precio, Periodicidad periodicidad) {
		super.setNombre(nombre);
		super.setPrecio(precio);
		this.periodicidad = periodicidad;
	}

	public int getPeriodicidad() {
		return 30/this.periodicidad.getPeriodo();
	}
}
