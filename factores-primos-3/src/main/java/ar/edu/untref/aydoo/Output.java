package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Output extends Opcion {
	
	public Output () {
		
		this.parametros = new LinkedList<String>();
		this.opcion = "--output=";
		
	}

	@Override
	protected void solicitarEjecucionConParametro(String numero, String stringParcial, String parametro) {
		// TODO Auto-generated method stub
		
	}

}
