package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Output extends Opcion {
	
	public Output () {
		
		this.parametros = new LinkedList<String>();
		this.opcion = "--output=";
		
	}

	@Override
	protected void solicitarEjecucionConParametro(SelectorDeOpciones selectorDeOpciones, String parametro) {
		// TODO Auto-generated method stub
		
	}




}
