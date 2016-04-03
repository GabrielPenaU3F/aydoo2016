package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mesa {
	
	private List<Voto> votos;
	private List<Partido> partidos;
	
	public Mesa() {
		this.votos = new LinkedList<Voto>();
		this.partidos = new LinkedList<Partido>();
	}

	public int votar(String nombreCandidato, String nombrePartido) {
		Candidato candidatoAVotar = this.validarPartidoYObtenerCandidato(nombreCandidato, nombrePartido);
		Partido partidoAVotar = candidatoAVotar.getPartido();
		Voto voto = new Voto(candidatoAVotar, partidoAVotar);
		this.votos.add(voto);
		return 1;
	}
	
	/*Itero la lista de partidos y al partido con el nobmre
	 * que me dan, le pido su candidato con el nombre que busco 
	 * Si el partido no esta, lanzo una excepcion*/
	private Candidato validarPartidoYObtenerCandidato(String nombreCandidato, String nombrePartido) {
		Iterator<Partido> iteradorPartidos = this.partidos.iterator();
		while(iteradorPartidos.hasNext()) {
			if(iteradorPartidos.next().getNombre() == nombrePartido) {
				Candidato candidatoBuscado = iteradorPartidos.next().getCandidatoPorNombre(nombreCandidato);
				return candidatoBuscado;
			}
		}
		throw new RuntimeException ("Error. Partido no encontrado");
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
	
	public void registrarPartido(Partido partido) {
		this.partidos.add(partido);
	}

	
}
