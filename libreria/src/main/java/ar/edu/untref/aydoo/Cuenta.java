package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Cuenta {
	
	//Se asume que las cuentas se renuevan cada mes. Esto lo hace la libreria
	
	private List<Compra> compras;
	
	public Cuenta () {
		
		this.compras = new LinkedList<Compra>();
		
	}
	
	
	public void agregarCompra(Compra compra) {
		
		this.compras.add(compra);
		
	}
	
	
	
	public boolean contiene(Compra compra) {
		
		Iterator<Compra> iteradorCompras = this.compras.iterator();
		while (iteradorCompras.hasNext()) {
			
			Compra actual = iteradorCompras.next();
				
				if (actual.equals(compra)) return true;
			
		}
		
		return false;
			
	}


	
}
