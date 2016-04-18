package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Sort extends Opcion {

	public Sort() {
		
		this.parametros = new LinkedList<String>();
		this.opcion = "--sort=";
		
	}

	@Override
	protected void solicitarEjecucionConParametro(String numero, String stringParcial, String parametro) {
		// TODO Auto-generated method stub
		
	}
	
}
