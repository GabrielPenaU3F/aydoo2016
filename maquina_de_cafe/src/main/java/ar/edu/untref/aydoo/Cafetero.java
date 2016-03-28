package ar.edu.untref.aydoo;

public class Cafetero {

	public Vaso prepararEnEsteVaso(Vaso vaso) {
		vaso.contenido.add("Cafe");
		return vaso;
	}

}
