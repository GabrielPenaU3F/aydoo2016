package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Format extends Opcion {

	public Format() {

		this.parametros = new LinkedList<String>();
		this.opcion = "--format=";

	}

	@Override
	protected void solicitarEjecucionConParametro(SelectorDeOpciones selectorDeOpciones, String parametro) {
		// TODO Auto-generated method stub
		
	}

}
