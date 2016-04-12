package ar.edu.untref.aydoo;

import java.util.List;

public class Cuenta {
	
	//Se asume que las cuentas se renuevan cada mes. Esto lo hace la libreria
	
	private List<Compra> compras;
	private Mes mes;
	
	
	public void agregarCompra(Compra compra) {
		
		this.compras.add(compra);
		
	}
	
	public Mes getMes(Mes mes) {
		
		return this.mes;
		
	}
	
	public void setMes(Mes mes) {
		
		this.mes = mes;
		
	}

}
