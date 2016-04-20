package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Opcion {

	protected String opcion;
	protected List<String> parametros;

	public String getOpcion() {

		return this.opcion;
	}

	protected abstract String seleccionarParametro(String argumento);

	public void solicitarEjecucion(SelectorDeOpciones selectorDeOpciones, String argumento) {

		String parametro = this.seleccionarParametro(argumento);
		this.solicitarEjecucionConParametro(selectorDeOpciones, parametro);

	}

	protected abstract void solicitarEjecucionConParametro(SelectorDeOpciones selectorDeOpciones, String parametro);


}
