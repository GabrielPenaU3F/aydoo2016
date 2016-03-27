package ar.edu.untref.aydoo;

import java.util.List;

public class Formateador {
	
	public static String formatear(String[] args) {
		final String pretty = "--format=pretty";
        final String quiet = "--format=quiet";
        final String numero = args[0];
		if(args.length == 1) {
			return formatearPretty(numero);
		} else if (args.length == 2) {
			final String formato = args[1];
	        if ((formato.compareToIgnoreCase(pretty) == 0)) {
	        	return formatearPretty(numero);
	        } else if (formato.compareToIgnoreCase(quiet) == 0) {
	        	return formatearQuiet(numero);
	        } else {
	        	return "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
	        }
		}
		return "";
	}
	
	public static String formatearPretty(String numero) {
		int number = Integer.parseInt(numero);
		String mensaje = numero + ":";
		Factorizador.factorizar(number);
		List<Integer> factores = Factorizador.getFactores();
		for(int i=0; i < factores.size(); i++) {
			mensaje = mensaje.concat(" " + factores.get(i));
		}
		return mensaje;
	}
	
	public static String formatearQuiet(String numero) {
		int number = Integer.parseInt(numero);
		String mensaje = "";
		Factorizador.factorizar(number);
		List<Integer> factores = Factorizador.getFactores();
		for(int i=0; i < factores.size(); i++) {
			mensaje = mensaje.concat(factores.get(i) + "/n");
		}
		String mensajeFormateado = String.format(mensaje);
		return mensajeFormateado;
	}

}
