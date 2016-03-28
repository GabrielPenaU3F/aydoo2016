package ar.edu.untref.aydoo;

public class HacedorDeTeConLeche {

	private HacedorDeTe hacedorDeTe;
	private Lechero lechero;
	
	public HacedorDeTeConLeche() {
		this.hacedorDeTe = new HacedorDeTe();
		this.lechero = new Lechero();
	}
	
	public Vaso prepararEnEsteVaso(Vaso vaso) {
		Vaso vasoTe = this.hacedorDeTe.prepararEnEsteVaso(vaso);
		Vaso vasoTeConLeche = this.lechero.prepararEnEsteVaso(vasoTe);
		return vasoTeConLeche;
	}

}
