package ar.edu.untref.aydoo;

public class Diario extends Producto implements Suscribible {
	
	private int periodicidad;
	
	public Diario (String nombre, int periodicidad, double precio) {
		
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
