package ar.edu.untref.aydoo;

public abstract class Producto implements Comprable {
	
	protected String nombre;
	protected double precio;
	
	public double calcularPrecioFinal() {
		
		return this.precio;
		
	}
	
	public String getNombre() {
		
		return this.nombre;
		
	}

	@Override
	//Dos productos son iguales si tienen el mismo nombre y son del mismo tipo
	public boolean equals(Object obj) {
		
		Producto producto = (Producto) obj;
		if(producto.getNombre() == this.getNombre() && producto.getClass().equals(this.getClass())) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	
	

}
