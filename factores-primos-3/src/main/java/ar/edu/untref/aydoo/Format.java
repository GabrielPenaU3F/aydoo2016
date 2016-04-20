package ar.edu.untref.aydoo;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class Format extends Opcion {

	public Format() {

		this.parametros = new LinkedList<String>();
		this.opcion = "--format=";
		this.parametros.add("pretty");
		this.parametros.add("quiet");

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

		int numero = selectorDeOpciones.getNumero();
		List<Integer> factores = selectorDeOpciones.getFactores();

		if(parametro == "pretty") {

			String mensajeFormateado = this.formatearPretty(numero, factores);
			selectorDeOpciones.modificarResultadoParcial(mensajeFormateado);

		}
		else if (parametro == "quiet") {

			String mensajeFormateado = this.formatearQuiet(numero, factores);
			selectorDeOpciones.modificarResultadoParcial(mensajeFormateado);

		}

	}

	public String formatearQuiet(int numero, List<Integer> factores) {

		String mensaje = "";
		for(int i=0; i < factores.size(); i++) {

			mensaje = mensaje.concat(factores.get(i) + "\n");

		}
		String mensajeFormateado = String.format(mensaje);
		return mensajeFormateado;
	}




	public String formatearPretty(int numero, List<Integer> factores) {

		String mensaje = numero + ":";
		for(int i=0; i < factores.size(); i++) {

			mensaje = mensaje.concat(" " + factores.get(i));

		}
		return mensaje;

	}

}
