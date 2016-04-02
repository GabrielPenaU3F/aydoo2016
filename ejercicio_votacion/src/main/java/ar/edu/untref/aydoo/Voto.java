package ar.edu.untref.aydoo;

public class Voto {
	
	private String nombreCandidato;
	private String nombrePartido;


	public Voto(String nombreCandidato, String nombrePartido) {
		this.nombreCandidato = nombreCandidato;
		this.nombrePartido = nombrePartido;
	}


	@Override
	public boolean equals(Object obj) {
		if((((Voto) obj).getNombreCandidato() == this.getNombreCandidato()) && ((Voto) obj).getNombrePartido() == this.getNombrePartido()) {
			return true;
		}
		 else return false;
	}


	public String getNombrePartido() {
		return this.nombrePartido;
	}


	public String getNombreCandidato() {
		return this.nombreCandidato;
	}
	
	
	
}
