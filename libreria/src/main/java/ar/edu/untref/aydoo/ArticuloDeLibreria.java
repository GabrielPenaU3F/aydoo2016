package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {
	
	private int iva; //Se guarda la tasa en porcentaje: por ej. 21

	private double getIva() {
		
		return (this.iva)/100; //Se devuelve la tasa como multiplo: por ej. o.21
		
	}
	
	public double calcularPrecioFinal() {
		
		double precioFinal = this.precio + (this.precio)*(this.getIva());
		return precioFinal;
		
	}

}
