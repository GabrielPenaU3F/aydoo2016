package ar.edu.untref.aydoo;

import java.util.List;

public class Formateador {
	
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
