package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectorDeOpciones {

	private List<Opcion> listaDeOpcionesDisponibles;
	private List<Integer> factores;
	private OrdenadorDeArgumentos ordenadorArgs;
	private Factorizador factorizador;
	private String resultadoParcial;
	private int numero;

	public SelectorDeOpciones() {

		this.listaDeOpcionesDisponibles = new LinkedList<Opcion>();
		this.listaDeOpcionesDisponibles.add(new Sort());
		this.listaDeOpcionesDisponibles.add(new Output());
		this.listaDeOpcionesDisponibles.add(new Format());
		this.ordenadorArgs = new OrdenadorDeArgumentos();
		this.factorizador = new Factorizador();
		this.resultadoParcial = new String("");

	}

	public String factorizarConOpciones(String args[]) {

		String argsOrdenado[] = this.ordenadorArgs.ordenar(args);

		this.numero = Integer.parseInt(args[0]);
		this.factores = this.factorizador.obtenerFactores(Integer.parseInt(argsOrdenado[0]));

		int limiteDelFor;
		if(this.verificarSiTieneOutput(argsOrdenado)) {
			
			limiteDelFor = argsOrdenado.length-1;
			
		}
		else {
			
			limiteDelFor = argsOrdenado.length;
			
		}
		/*argsOrdenado[0] es el numero
		 * argsOrdenado[1] es el formato
		 *el for va hasta el final si no hay output
		 *si hay output es la ultima posicion y no la debe tocar
		 */
		for (int i=2; i < limiteDelFor; i++) { 

			Opcion opcionActual = this.seleccionarOpcion(argsOrdenado[i]);
			opcionActual.solicitarEjecucion(this, argsOrdenado[i]);

		}
		this.seleccionarOpcion(argsOrdenado[1]).solicitarEjecucion(this, argsOrdenado[1]); //Pido formatear
		if (this.verificarSiTieneOutput(argsOrdenado)) {
			
			this.seleccionarOpcion(argsOrdenado[argsOrdenado.length-1]).solicitarEjecucion(this, argsOrdenado[argsOrdenado.length-1]);;
			
		}
		
		String resultadoFinal = this.resultadoParcial;
		return resultadoFinal;

	}




	public boolean verificarSiTieneOutput(String[] args) {

		if (args[args.length-1].startsWith("--output-file=")) {

			return true;

		}

		return false;
	}




	private Opcion seleccionarOpcion(String opcion) {

		Iterator<Opcion> iteradorOpcionesDisponibles = this.listaDeOpcionesDisponibles.iterator();
		while (iteradorOpcionesDisponibles.hasNext()) {

			Opcion actual = iteradorOpcionesDisponibles.next();
			if (opcion.startsWith(actual.getOpcion())) {

				return actual;

			}

		}

		throw new OpcionInexistenteException();

	}

	public List<Integer> getFactores() {

		return this.factores;

	}

	public void modificarResultadoParcial(String resultadoNuevo) {

		this.resultadoParcial = resultadoNuevo;

	}

	public void modificarFactores(List<Integer> factores) {

		this.factores = factores;

	}

	public int getNumero() {

		return this.numero;

	}

}
