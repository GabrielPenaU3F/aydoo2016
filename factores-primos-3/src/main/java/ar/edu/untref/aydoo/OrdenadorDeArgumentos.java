package ar.edu.untref.aydoo;

public class OrdenadorDeArgumentos {

	public static String[] ordenar(String[] args) {


		/*Esto funciona de la siguiente manera:
		 * Si en el argumento especifico el format, el array nuevo tendra
		 * la misma longitud. 
		 * Si en el argumento no especifico el format, el array nuevo
		 * tendra un elemento mas, se le colocara un --format=pretty
		 * para eliminar ese problema de la logica del formateador
		 * El format quedara siempre en la posicion 1 del array nuevo
		 */
		String argsOrdenado[];

		if (estaElArgumentoFormat(args)) { //Si he especificado el formato
			
			argsOrdenado = new String[args.length]; 
			argsOrdenado[0] = args[0]; //El primer argumento es el numero siempre
			argsOrdenado[1] = obtenerFormato(args);
			for(int i=2; i < argsOrdenado.length; i++) {
				
				for(int j=1; j < args.length; j++) {
				
					if (args[j].startsWith("--format=")) {
						
						j++;
						
					}
				argsOrdenado[i] = args[j];
					
				}
				
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
	



	public static String obtenerFormato(String[] args) {
		
		for (int i=0; i < args.length; i++) {
			
			if (args[i].startsWith("--format=")) {
				
				return args[i];
				
			}
			
		}
		
		throw new NoEstaElFormatoException();
		
	}


	public static boolean estaElArgumentoFormat(String[] args) {

		for(int i=1; i < args.length; i++) {

			if (args[i].startsWith("--format=")) {

				return true;

			}

		}
		return false;

	}
	
}
