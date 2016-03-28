package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {
	
	private HacedorDeCafeConLeche hacedorDeCafeConLeche;
	private HacedorDeTeConLeche hacedorDeTeConLeche;
	private Azucarero azucarero;
	
	public MaquinaExpendedoraDeBebidas() {
		this.hacedorDeCafeConLeche = new HacedorDeCafeConLeche();
		this.hacedorDeTeConLeche = new HacedorDeTeConLeche();
		this.azucarero = new Azucarero();
	}
	
	public Vaso hacerCafeConLecheConNDeAzucar(int n) {
		Vaso vasoCafeVacio = new Vaso();
		Vaso vasoCafeLleno = this.hacedorDeCafeConLeche.prepararEnEsteVaso(vasoCafeVacio);
		Vaso vasoCafeTerminado = this.azucarero.ponerNCucharadas(n, vasoCafeLleno);
		return vasoCafeTerminado;
	}
	
	public Vaso hacerTeConLecheConNDeAzucar(int n) {
		Vaso vasoTeVacio = new Vaso();
		Vaso vasoTeLleno = this.hacedorDeTeConLeche.prepararEnEsteVaso(vasoTeVacio);
		Vaso vasoTeTerminado = this.azucarero.ponerNCucharadas(n, vasoTeLleno);
		return vasoTeTerminado;
	}

}
