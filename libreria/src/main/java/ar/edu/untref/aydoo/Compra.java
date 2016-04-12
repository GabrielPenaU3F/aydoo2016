package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Compra {

	private List<Comprable> articulosComprados;
	private Mes mes;
	
	public Compra(Mes mes) {
		
		this.articulosComprados = new LinkedList<Comprable>();
		this.mes = mes;
		
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

	@Override
	public boolean equals(Object obj) {
		
		Compra otraCompra = (Compra) obj;
		if (!this.mes.equals(otraCompra.getMes())) return false; //Si los meses son distintos las compras son distintas
		
		Iterator<Comprable> iteradorArticulosComprados = this.articulosComprados.iterator();
		while (iteradorArticulosComprados.hasNext()) {
			
			Comprable actual = iteradorArticulosComprados.next();
			if (!otraCompra.contiene(actual)) { //Si aparece algun articulo que no esta en la otra compra
				
				return false;
				
			}
			
		}
		
		//Si termino de recorrer y no falto ninguno
		return true;
		
	}

	public Mes getMes() {
		
		return this.mes;
		
	}
	
	public List<Suscribible> obtenerListaDeArticulosSuscribibles() {
		
		List<Suscribible> articulosSuscribibles = new LinkedList<Suscribible>();
		
		Iterator<Comprable> iteradorArticulos = this.articulosComprados.iterator();
		while (iteradorArticulos.hasNext()) {
			
			Comprable actual = iteradorArticulos.next();
			if(actual.getClass().equals(Suscripcion.class)) {
				
				articulosSuscribibles.add(((Suscripcion)actual).getArticulo());
				
			}
			
		}
		
		return articulosSuscribibles;
	}
	
	
	
}
