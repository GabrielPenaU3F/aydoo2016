package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {
	
	private final int iva = 21; //Se guarda la tasa en porcentaje: por ej. 21
	
	public ArticuloDeLibreria(String nombre, double precio) {
		
		this.nombre = nombre;
		this.precio = precio;
		
	}

	
	public double calcularPrecioFinal() {
		
		double precioFinal = this.precio + ((this.precio)*(this.iva)/100);
		return precioFinal;
		
	}

}
