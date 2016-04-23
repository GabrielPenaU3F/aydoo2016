package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Compra {
	
	private Mes mes;
	private LinkedList<Producto> listaDeProductos;

	public Compra(Mes mes) {
		this.mes = mes;
		this.listaDeProductos = new LinkedList<Producto>();
	}

	public Mes getMes() {
		return mes;
	}

	public LinkedList<Producto> getListaDeProductos() {
		return this.listaDeProductos;
	}

	public void agregarProducto(Producto producto) {
		this.listaDeProductos.add(producto);		
	}

	public void agregarProductoSuscribible(Suscribible productoSuscribible, boolean suscripcionAnual) {
				
		Producto productoParaAgregar = (Producto) productoSuscribible;
		
		if(suscripcionAnual){
			productoParaAgregar.setPrecio(productoParaAgregar.getPrecio()-(productoParaAgregar.getPrecio()*0.2));
		}
		
		for(int i = 0; i < productoSuscribible.getPeriodicidad(); i++){
			this.listaDeProductos.add(productoParaAgregar);
		}
	}
}
