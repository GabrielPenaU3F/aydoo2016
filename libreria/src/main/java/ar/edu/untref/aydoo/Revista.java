package ar.edu.untref.aydoo;

public class Revista extends Producto implements Suscribible{

	private int periodicidad;
	
	public Revista(String nombre, int periodicidad, double precio) {
		
		this.nombre = nombre;
		this.periodicidad = periodicidad;
		this.precio = precio;
		
	}
	
	@Override
	public int getPeriodicidad() {
		
		return this.periodicidad;
		
	}
	
	@Override
	public void aplicarDescuento(int descuento) {
		
		this.precio = (this.precio - (this.precio*descuento/100));
		
	}
}
