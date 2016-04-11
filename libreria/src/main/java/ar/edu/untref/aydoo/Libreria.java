package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {

	private List<Cliente> clientes;
	private List<Comprable> stock;
	
	public Libreria() {
		
		this.clientes = new LinkedList<Cliente>();
		this.stock = new LinkedList<Comprable>();
		
	}

	public void agregarProducto(Producto producto) {

		//Si me viene una revista o un diario
		if (producto.getClass().equals(Revista.class) || producto.getClass().equals(Diario.class)) {

			stock.add(producto); //Agrego el producto
			Suscripcion suscripcion = new Suscripcion((Suscribible)producto);
			stock.add(suscripcion); //Agrego la suscripcion al diario o revista

		}
		else {

			stock.add(producto);

		}

	}

	public boolean tieneEnStock(Producto producto) {
		
		Iterator<Comprable> iteradorStock = stock.iterator();
		while(iteradorStock.hasNext()) {
			
			Comprable actual = iteradorStock.next();
			if(actual.getClass() != Suscripcion.class) { //Me aseguro que sea un producto
				
				if(((Producto)actual).equals(producto)) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	//Sobrecargo el metodo para poder comparar suscripciones
	public boolean tieneEnStock(Suscripcion suscripcion) {
		

		Iterator<Comprable> iteradorStock = stock.iterator();
		while(iteradorStock.hasNext()) {
			
			Comprable actual = iteradorStock.next();
			if(actual.getClass() == Suscripcion.class) {
				
				if(suscripcion.equals(actual)) {
					
					return true;
					
				}
				
			}
			
			
		}
		
		return false;
		
	}


}
