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

	public void agregarTodosLosProductosAdquiridosPorSuscripcion(Mes mes) {

		
		Compra compraDeTodosLosArticulosSuscriptos = new Compra(mes);
		List<Suscribible> listaDeArticulosSuscriptos = this.obtenerListaDeArticulosSuscriptosEnLaCuenta(mes);
		Iterator<Suscribible> iteradorDeArticulosSuscriptos = listaDeArticulosSuscriptos.iterator();
		while (iteradorDeArticulosSuscriptos.hasNext()) {

			Suscribible actual = iteradorDeArticulosSuscriptos.next();
			for(int i=0; i < actual.getPeriodicidad(); i++) { //Lo agrego tantas veces como se haya comprado por la suscripcion
				
				actual.aplicarDescuento(20);
				compraDeTodosLosArticulosSuscriptos.agregarArticulo((Comprable)actual); //Podria evitar este casteo haciendo que Suscribible herede de COmprable pero es una relacion que queda como innecesaria
			
			}
			
		}
		this.compras.add(compraDeTodosLosArticulosSuscriptos);
		
	}


	private List<Suscribible> obtenerListaDeArticulosSuscriptosEnLaCuenta(Mes mes) {

		List<Suscribible> articulosSuscriptos = new LinkedList<Suscribible>();
		Iterator<Compra> iteradorCompras = this.compras.iterator();
		while (iteradorCompras.hasNext()) {

			Compra actual = iteradorCompras.next();
			//Filtro por mes
			if (actual.getMes().equals(mes)) {
				
				//Pido la lista de articulos suscriptos a cada compra y las concateno en una sola lista
				articulosSuscriptos.addAll(actual.obtenerListaDeArticulosSuscribibles());
			
			}
		}

		return articulosSuscriptos;

	}


	public double sumarElMontoTotalDeTodosLosProductos() {
		
		double montoAcumulado=0;
		
		Iterator<Compra> iteradorCompras = this.compras.iterator();
		while(iteradorCompras.hasNext()) {
			
			Compra actual = iteradorCompras.next();
			montoAcumulado += actual.obtenerMontoTotal();
			
		}
		return montoAcumulado;
		
	}

}
