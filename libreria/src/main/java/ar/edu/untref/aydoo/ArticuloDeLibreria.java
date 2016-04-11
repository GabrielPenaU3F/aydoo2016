package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {
	
	private final int iva = 21; //Se guarda la tasa en porcentaje: por ej. 21
	
	public ArticuloDeLibreria(String nombre, double precio) {
		
		this.nombre = nombre;
		this.precio = precio;
		
	}

	private double getIva() {
		
		return (this.iva)/100; //Se devuelve la tasa como multiplo: por ej. o.21
		
	}
	
	public double calcularPrecioFinal() {
		
		double precioFinal = this.precio + (this.precio)*(this.getIva());
		return precioFinal;
		
	}

}
