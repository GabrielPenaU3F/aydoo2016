package ar.edu.untref.aydoo;

public abstract class Producto implements Comprable {
	
	protected String nombre;
	protected double precio;
	
	public double calcularPrecioFinal() {
		
		return precio;
		
	}
	

}
