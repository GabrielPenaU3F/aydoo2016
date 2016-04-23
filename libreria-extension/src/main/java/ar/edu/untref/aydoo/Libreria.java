package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Libreria {
	
	private LinkedList<Cliente> listaDeClientes;
	
	public Libreria(){	
		listaDeClientes = new LinkedList<Cliente>();
	}

	public void agregarCliente(Cliente cliente) {
		listaDeClientes.add(cliente);
	}
	
	public LinkedList<Cliente> getListaDeClientes(){
		return listaDeClientes;
	}

	public double calcularMontoTotal(Cliente cliente) {
		
		double montoTotal = 0;
		for(Compra compra : cliente.getListaDeCompras()){
			
			for(Producto producto : compra.getListaDeProductos()){
				
				montoTotal += producto.getPrecio();
			}
		}				
		return montoTotal;
	}
}
