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


	public void registrarCliente(Cliente cliente) {

		this.clientes.add(cliente);

	}

	public boolean verificarSiEstaEnStock(Comprable articulo) {

		Iterator<Comprable> iteradorStock = this.stock.iterator();
		while (iteradorStock.hasNext()) {

			Comprable actual = iteradorStock.next();
			if (actual.getClass().equals(articulo.getClass())) { //Si los dos tienen la misma clase
				
				if (actual.getClass().equals(Suscripcion.class)) { //Si los dos son suscripciones los comparo con el equals de suscripciones
					
					if (((Suscripcion)actual).equals(articulo)) return true;

				}
				else { //Si los dos son iguales pero no son suscripciones, entonces son productos los dos
					
					if(((Producto)actual).equals(articulo)) return true;
					
				}
			}
		}

		return false;

	}

	public double calcularMontoACobrar(Mes mes, Cliente cliente) {

		this.validarCliente(cliente);
		cliente.getCuenta().agregarTodosLosProductosAdquiridosPorSuscripcion(mes);
		double montoACobrar = cliente.getCuenta().sumarElMontoTotalDeTodosLosProductos();
		return montoACobrar;

	}

	private void validarCliente(Cliente cliente) {

		boolean estaEnLaLista = false;
		Iterator<Cliente> iteradorClientes = this.clientes.iterator();
		while (iteradorClientes.hasNext()) {

			Cliente actual = iteradorClientes.next();
			if(actual.equals(cliente)) {

				estaEnLaLista = true;

			}

		}
		if (estaEnLaLista == false) throw new RuntimeException ("El cliente no esta registrado");

	}


}
