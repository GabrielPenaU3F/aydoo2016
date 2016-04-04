package ar.edu.untref.aydoo;

public class Voto {
	
	private Candidato candidato;
	private Partido partido;
	private Provincia provincia;


	public Voto(Candidato candidato, Partido partido, Provincia provincia) {
		this.candidato = candidato;
		this.partido = partido;
		this.provincia = provincia;
	}


	@Override
	public boolean equals(Object obj) {
		if((((Voto) obj).getNombreCandidato() == this.getNombreCandidato()) && ((Voto) obj).getNombrePartido() == this.getNombrePartido()) {
			return true;
		}
		 else return false;
	}


	public String getNombrePartido() {
		return this.partido.getNombre();
	}


	public String getNombreCandidato() {
		return this.candidato.getNombre();
	}


	public String getNombreProvincia() {
		return this.provincia.getNombre();
	}
	
	
	
}
