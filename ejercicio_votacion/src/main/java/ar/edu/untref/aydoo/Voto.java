package ar.edu.untref.aydoo;

public class Voto {
	
	private String nombreCandidato;
	private String nombrePartido;


	public Voto(String nombreCandidato) {
		this.nombreCandidato = nombreCandidato;
	}


	@Override
	public boolean equals(Object obj) {
		if((((Voto) obj).getNombreCandidato() == this.getNombreCandidato()) && ((Voto) obj).getNombrePartido() == this.getNombrePartido()) {
			return true;
		}
		 else return false;
	}


	private String getNombrePartido() {
		return this.nombrePartido;
	}


	private String getNombreCandidato() {
		return this.nombreCandidato;
	}
	
	
	
}
