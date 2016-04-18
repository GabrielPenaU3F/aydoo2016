package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Factorizador {
	
	private static List<Integer> factores = new LinkedList<Integer>();
	
	private static void factorizar(int numero) {
		
		if (!esPrimo(numero)) {
			
			int menorDivisor = buscarMenorDivisor(numero);
			factores.add(menorDivisor);
			factorizar(numero/menorDivisor);
			
		} else {
			
			factores.add(numero);
			
		}
		
	}


	static boolean esPrimo (int numero) {
		
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
	
	static int buscarMenorDivisor (int numero) {
		
		for (int i=2; i <= numero-1; i++) {
			
			if (numero%i == 0) {
				
				return i;
				
			}
			
		}
		return -1;
		
	}
	
	private static List<Integer> devolverFactores() {
		
		List<Integer> resultado = new LinkedList<Integer>();
		for(int j=0; j < factores.size(); j++) {
			
			resultado.add(factores.get(j));
			
		}
		resetearLista(); 
		return resultado;
		
	}


	private static void resetearLista() {
		factores = new LinkedList<Integer>();
	}


	public static List<Integer> obtenerFactores(int numero) {
		
		factorizar(numero);
		List<Integer> listaFactores = devolverFactores();
		return listaFactores;
	}

}
