package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Compra {

	private List<Comprable> productosComprados;
	
	public Compra() {
		
		this.productosComprados = new LinkedList<Comprable>();
		
	}
	
	public void agregarProducto(Comprable producto) {
		
		this.productosComprados.add(producto);
		
	}
	
}
