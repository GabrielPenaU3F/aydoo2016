package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Sort extends Opcion {

	public Sort() {
		
		this.parametros = new LinkedList<String>();
		this.opcion = "--sort=";
		
	}

	@Override
	protected void solicitarEjecucionConParametro(SelectorDeOpciones selectorDeOpciones, String parametro) {
		// TODO Auto-generated method stub
		
	}
	
}
