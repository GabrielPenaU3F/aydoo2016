package ar.edu.untref.aydoo;

public class HacedorDeCafeConLeche {

	private Cafetero cafetero;
	private Lechero lechero;
	
	public Vaso prepararEnEsteVaso(Vaso vaso) {
		Vaso vasoCafe = this.cafetero.prepararEnEsteVaso(vaso);
		Vaso vasoCafeConLeche = this.lechero.prepararEnEsteVaso(vasoCafe);
		return vasoCafeConLeche;
	}

}
