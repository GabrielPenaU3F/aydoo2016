package ar.edu.untref.aydoo;

public class Candidato {
	
	private int totalVotos;
	private Partido partido;
	private String nombre;
	
	public Candidato(String nombre) {
		this.nombre = nombre;
		this.totalVotos = 0;
	}

	public int getVotos() {
		return this.totalVotos;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void computarVoto() {
		totalVotos++;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public String getNombre() {
		return this.nombre;
	}

}
