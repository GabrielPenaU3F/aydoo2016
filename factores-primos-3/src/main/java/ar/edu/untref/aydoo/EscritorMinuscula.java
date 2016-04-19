package ar.edu.untref.aydoo;

public class EscritorMinuscula {

	public String[] ponerEnMinuscula(String[] args) {
		
		String[] argsMinuscula = new String[args.length];
		for(int i=0; i < args.length; i++) {
			
			argsMinuscula[i] = (args[i].toLowerCase()); 
			
		}
		return argsMinuscula;
		
	}

}
