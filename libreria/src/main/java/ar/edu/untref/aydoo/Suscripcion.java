package ar.edu.untref.aydoo;

public class Suscripcion implements Comprable {
	
	private Suscribible articulo;

	public Suscripcion(Suscribible articulo) {
		this.articulo = articulo;
	}
	
	public Suscribible getArticulo() {
		return this.articulo;
	}
	
}
