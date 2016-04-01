package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mesa {
	
	private List<Voto> votos;
	
	public Mesa() {
		this.votos = new LinkedList<Voto>();
	}

	public int votar(String nombreCandidato) {
		Voto voto = new Voto(nombreCandidato);
		this.votos.add(voto);
		return 1;
	}
	
	/*Devuelve una lista que tiene en cada posicion
	 * el nombre del candidato votado en la misma posicion 
	 * de la lista de votos*/
	public List<String> listarVotosComoString() {
		List<String> listaVotosComoString = new LinkedList<String>();
		Iterator<Voto> iteradorVotos = this.votos.iterator();
		while(iteradorVotos.hasNext()) {
			listaVotosComoString.add(iteradorVotos.next().getNombreCandidato());
		}
		return listaVotosComoString;
	}

	/*Devuelvo el ultimo voto de la lista*/
	public Voto getUltimoVoto() {
		return this.votos.get(this.votos.size() -1);
	}

	
}
