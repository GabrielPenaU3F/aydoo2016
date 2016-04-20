package ar.edu.untref.aydoo;

import java.util.List;
import java.util.LinkedList;

public class Format extends Opcion {

	public Format() {

		this.parametros = new LinkedList<String>();
		this.opcion = "--format=";
		this.parametros.add("pretty");
		this.parametros.add("quiet");

	}

	@Override
	protected void solicitarEjecucionConParametro(SelectorDeOpciones selectorDeOpciones, String parametro) {

		int numero = selectorDeOpciones.getNumero();
		String mensaje = (numero + ":");
		List<Integer> factores = selectorDeOpciones.getFactores();

		if(parametro == "pretty") {

			String mensajeFormateado = this.formatearPretty(mensaje, factores);
			selectorDeOpciones.modificarResultadoParcial(mensajeFormateado);

		}
		else if (parametro == "quiet") {

			String mensajeFormateado = this.formatearQuiet(mensaje, factores);
			selectorDeOpciones.modificarResultadoParcial(mensajeFormateado);

		}

	}

	public String formatearQuiet(String mensaje, List<Integer> factores) {

		for(int i=0; i < factores.size(); i++) {

			mensaje = mensaje.concat(factores.get(i) + "\n");

		}
		String mensajeFormateado = String.format(mensaje);
		return mensajeFormateado;
	}




	public String formatearPretty(String mensaje, List<Integer> factores) {

		for(int i=0; i < factores.size(); i++) {

			mensaje = mensaje.concat(" " + factores.get(i));

		}
		return mensaje;

	}

}
