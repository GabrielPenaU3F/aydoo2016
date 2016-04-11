package ar.edu.untref.aydoo;

public class Suscripcion implements Comprable {
	
	private Suscribible articulo;
	//Se asume que las suscripciones solo pueden ser anuales

	public Suscripcion(Suscribible articulo) {
		
		this.articulo = articulo;
		
	}
	
	public Suscribible getArticulo() {
		
		return this.articulo;
		
	}
	
}
