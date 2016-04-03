package ar.edu.untref.aydoo;

public class Candidato {

	private String nombre;
	private Partido partido;

	public Candidato(String nombre) {
		this.nombre = nombre;
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
	public boolean equals(Object obj) {
		Candidato otro = (Candidato) obj;
		if((otro.getNombre() == this.getNombre()) && (otro.getPartido().equals(this.getPartido()))) {
			return true;
		} else return false;
	}
	
}