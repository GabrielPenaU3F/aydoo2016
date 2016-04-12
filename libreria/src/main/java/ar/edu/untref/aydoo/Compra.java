package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Compra {

	private List<Comprable> articulosComprados;
	
	public Compra() {
		
		this.articulosComprados = new LinkedList<Comprable>();
		
	}

	public void agregarArticulo(Comprable articulo) {
		
		this.articulosComprados.add(articulo);
		
	}
	
	public boolean contiene(Comprable articulo) {
		
		Iterator<Comprable> iteradorArticulosComprados = articulosComprados.iterator();
		while(iteradorArticulosComprados.hasNext()) {
		
			Comprable actual = iteradorArticulosComprados.next();
			if(actual.getClass().equals(articulo.getClass())) {
				
				if ((actual.getClass().equals(Suscripcion.class)) && (articulo.getClass().equals(Suscripcion.class))) { 
					
					//Si los dos son suscripciones y son iguales (utiliza el equals de la suscripcion)
					if( ((Suscripcion)actual).equals((Suscripcion)articulo)) return true;
					
				} 
				else {
					
					//Si los dos son productos y son iguales
					if( ((Producto)actual).equals((Producto)articulo)) return true;
					
				}
				
			}
		
		}
		
		//Si se termino de recorrer y no se encontraron coincidencias
		return false;
		
	}
	
}
