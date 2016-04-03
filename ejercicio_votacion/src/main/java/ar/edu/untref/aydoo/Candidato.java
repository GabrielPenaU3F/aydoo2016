package ar.edu.untref.aydoo;

public class Candidato {

	private String nombre;
	private Partido partido;
	private int cantidadDeVotos;

	public Candidato(String nombre) {
		this.nombre = nombre;
		this.cantidadDeVotos=0;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@Override
	public boolean equals(Object obj) { //Dos candidatos son iguales si tienen mismo nombre y partido
		Candidato otro = (Candidato) obj;
		if((otro.getNombre() == this.getNombre()) && (otro.getPartido().equals(this.getPartido()))) {
			return true;
		} else return false;
	}

	public void sumarVoto() {
		this.cantidadDeVotos++;
	}
	
	public int getVotos() {
		return this.cantidadDeVotos;
	}
	
}