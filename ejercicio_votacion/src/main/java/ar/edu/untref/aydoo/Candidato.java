package ar.edu.untref.aydoo;

public class Candidato {
	
	private String nombre;
	private Partido partido;

	public Candidato(String nombre, Partido partido) {
		this.nombre = nombre;
		this.partido = partido;
		this.partido.registrarCandidato(this);
	}

	public String getNombre() {
		return this.nombre;
	}

	public Partido getPartido() {
		return this.partido;
	}
	

}
