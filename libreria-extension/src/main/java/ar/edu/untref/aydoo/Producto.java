package ar.edu.untref.aydoo;

public class Producto {

	private double precio;
	private String nombre;

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;		
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
