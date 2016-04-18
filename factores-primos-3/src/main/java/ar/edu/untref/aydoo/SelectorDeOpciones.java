package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectorDeOpciones {

	private static List<Opcion> listaDeOpcionesDisponibles = new LinkedList<Opcion>();

	public static String factorizarConOpciones(String args[]) {

		String argsOrdenado[] = OrdenadorDeArgumentos.ordenar(args);
		String resultadoParcial = "";

		for (int i=1; i < argsOrdenado.length; i++) { //argsOrdenado[0] es el numero

			Opcion opcionActual = seleccionarOpcion(argsOrdenado[i]);
			opcionActual.solicitarEjecucion(argsOrdenado[0], resultadoParcial, argsOrdenado[i]);

		}

		return resultadoParcial;

	}




	private static Opcion seleccionarOpcion(String opcion) {

		Iterator<Opcion> iteradorOpcionesDisponibles = listaDeOpcionesDisponibles.iterator();
		while (iteradorOpcionesDisponibles.hasNext()) {

			Opcion actual = iteradorOpcionesDisponibles.next();
			if (opcion.startsWith(actual.getOpcion())) {

				return actual;

			}

		}

		throw new OpcionInexistenteException();

	}

}
