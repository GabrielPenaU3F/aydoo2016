package ar.edu.untref.aydoo;

public class OrdenadorDeArgumentos {

	public String[] ordenar(String[] args) {


		/*Esto funciona de la siguiente manera:
		 * Si en el argumento especifico el format, el array nuevo tendra
		 * la misma longitud. 
		 * Si en el argumento no especifico el format, el array nuevo
		 * tendra un elemento mas, se le colocara un --format=pretty
		 * para eliminar ese problema de la logica del formateador
		 * El format quedara siempre en la posicion 1 del array nuevo
		 * El output quedara siempre en la posicion final del array nuevo
		 */
		String argsOrdenado[];

		argsOrdenado = this.ponerFormatEnPosicion1(args);

		argsOrdenado = this.ponerOutputEnPosicionFinal(argsOrdenado);

		return argsOrdenado;

	}


	public boolean estaElArgumentoOutput(String[] args) {

		for(int i=1; i < args.length; i++) {

			if (args[i].startsWith("--output-file=")) {

				return true;

			}

		}
		return false;

	}




	public String[] ponerFormatEnPosicion1(String[] args) {
		String[] argsOrdenado;
		if (this.estaElArgumentoFormat(args)) { //Si he especificado el formato

			argsOrdenado = new String[args.length]; 
			argsOrdenado[0] = args[0]; //El primer argumento es el numero siempre
			argsOrdenado[1] = this.obtenerFormato(args);

			/*i recorre el array nuevo
			 * j recorre el array viejo
			 * ambas aumentan juntas
			 */
			int i=2;
			for(int j=1; j < args.length; j++) {

				if (!args[j].startsWith("--format=")) {

					argsOrdenado[i] = args[j];

				}
				else {

					if(j < args.length-1) { //Si aun queda algo para recorrer

						j++;
						argsOrdenado[i] = args[j];

					}
				}
				i++;

			}



		}
		else { //Si no especifico formato

			argsOrdenado = new String[args.length+1]; 
			argsOrdenado[0] = args[0]; //El primer argumento es el numero siempre
			argsOrdenado[1] = "--format=pretty";

			for (int i=2; i < argsOrdenado.length; i++) {

				argsOrdenado[i] = args[i-1];

			}

		}

		return argsOrdenado;
	}


	/*Por como esta diseñado, este metodo solo recibe 
	 * el array una vez que ya tiene el formato en la posicion 1
	 * por eso copia esa parte y trabaja con lo demas.
	 * mismo funcionamiento que el otro ordenador
	 */
	public String[] ponerOutputEnPosicionFinal(String[] args) {

		if (!this.estaElArgumentoOutput(args)) {

			return args;

		}

		String[] argsOrdenado = new String[args.length]; 
		argsOrdenado[0] = args[0]; 
		argsOrdenado[1] = args[1];
		String parametroDeOutput = "";

		int i=2;
		for(int j=2; j < args.length; j++) {

			if (!args[j].startsWith("--output-file=")) {

				argsOrdenado[i] = args[j];
			}
			else {

				parametroDeOutput = args[j];
				if(j < args.length-1) { //Si aun queda algo para recorrer

					j++;
					argsOrdenado[i] = args[j];

				}
			}
			i++;

		}

		argsOrdenado[args.length-1] = parametroDeOutput;
		return argsOrdenado;


	}




	public String obtenerFormato(String[] args) {

		for (int i=0; i < args.length; i++) {

			if (args[i].startsWith("--format=")) {

				return args[i];

			}

		}

		throw new NoEstaElFormatoException();

	}


	public boolean estaElArgumentoFormat(String[] args) {

		for(int i=1; i < args.length; i++) {

			if (args[i].startsWith("--format=")) {

				return true;

			}

		}
		return false;

	}

}
