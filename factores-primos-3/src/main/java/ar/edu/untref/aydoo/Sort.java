package ar.edu.untref.aydoo;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Sort extends Opcion {

	public Sort() {

		this.parametros = new LinkedList<String>();
		this.opcion = "--sort:";
		this.parametros.add("asc");
		this.parametros.add("des");

	}
	
	@Override
	protected String seleccionarParametro(String argumento) {

		Iterator<String> iteradorParametros = this.parametros.iterator();
		while (iteradorParametros.hasNext()) {

			String parametroActual = iteradorParametros.next();
			if (argumento.endsWith(parametroActual)) {

				return parametroActual;

			}

		}

		throw new ParametroInexistenteException();

	}

	@Override
	protected void solicitarEjecucionConParametro(SelectorDeOpciones selectorDeOpciones, String parametro) {

		if (parametro == "asc") {

			selectorDeOpciones.modificarFactores(this.ordenarAscendente(selectorDeOpciones.getFactores()));

		}
		else if (parametro == "des") {

			selectorDeOpciones.modificarFactores(this.ordenarDescendente(selectorDeOpciones.getFactores()));

		}

	}

	public List<Integer> ordenarDescendente(List<Integer> factores) {

		List<Integer> factoresOrdenados = factores;
		Collections.sort(factoresOrdenados);
		Collections.reverse(factoresOrdenados);
		return factoresOrdenados;

	}


	public List<Integer> ordenarAscendente(List<Integer> factores) {

		List<Integer> factoresOrdenados = factores;
		Collections.sort(factoresOrdenados);
		return factoresOrdenados;

	}

}
