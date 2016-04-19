package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Factorizador {

	private List<Integer> factores;

	public Factorizador () {

		this.factores = new LinkedList<Integer>();

	}

	private void factorizar(int numero) {

		if (!esPrimo(numero)) {

			int menorDivisor = this.buscarMenorDivisor(numero);
			this.factores.add(menorDivisor);
			this.factorizar(numero/menorDivisor);

		} else {

			this.factores.add(numero);

		}

	}


	public boolean esPrimo (int numero) {

		if(numero != 1) {

			int cuenta = 2;
			for(int i=2; i <= numero-1; i++) {

				if (!(numero%i == 0)) {

					cuenta++;

				}

			}
			if (cuenta == numero) {

				return true;

			}	
		} else {

			return true;

		}
		return false;

	}

	public int buscarMenorDivisor (int numero) {

		for (int i=2; i <= numero-1; i++) {

			if (numero%i == 0) {

				return i;

			}

		}
		return -1;

	}

	private  List<Integer> devolverFactores() {

		List<Integer> resultado = new LinkedList<Integer>();
		for(int j=0; j < factores.size(); j++) {

			resultado.add(factores.get(j));

		}
		this.resetearLista(); 
		return resultado;

	}


	private void resetearLista() {
		this.factores = new LinkedList<Integer>();
	}


	public List<Integer> obtenerFactores(int numero) {

		this.factorizar(numero);
		List<Integer> listaFactores = devolverFactores();
		return listaFactores;
	}

}
