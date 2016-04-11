package ar.edu.untref.aydoo;

import java.util.List;

public class Cuenta {
	
	//Se asume que las cuentas se renuevan cada mes
	
	private Cliente cliente;
	private List<Compra> compras;
	private Mes mes;
	
	public Cuenta (Cliente cliente) {
		
		this.cliente = cliente;
	
	}
	
	public Cliente getCliente() {
		
		return this.cliente;
		
	}
	
	public void agregarCompra(Compra compra) {
		
		this.compras.add(compra);
		
	}
	
	public Mes getMes(Mes mes) {
		
		return this.mes;
		
	}

}
