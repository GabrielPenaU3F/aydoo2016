package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Cliente {
	
	private String nombre;
	private String direccion;
	private LinkedList<Compra> listaDeCompras;

	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaDeCompras = new LinkedList<Compra>();
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public void agregarCompra(Compra compra) {
		this.listaDeCompras.add(compra);		
	}
	
	public LinkedList<Compra> getListaDeCompras(){
		return this.listaDeCompras;
	}
}
