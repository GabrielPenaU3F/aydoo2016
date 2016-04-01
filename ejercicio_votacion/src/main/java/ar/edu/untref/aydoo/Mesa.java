package ar.edu.untref.aydoo;


public class Mesa {
	
	private Voto voto;

	public int votar(String nombreCandidato) {
		this.voto = new Voto(nombreCandidato);
		return 1;
	}

	public void listarVotos() {
		// TODO Auto-generated method stub
		
	}

	public Voto getVoto() {
		return this.voto;
	}

	
}
