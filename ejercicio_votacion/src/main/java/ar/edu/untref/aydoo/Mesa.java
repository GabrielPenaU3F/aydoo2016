package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mesa {

	private List<Voto> votos;
	private List<Partido> partidos;
	private List<Provincia> provincias;

	public Mesa() {
		this.votos = new LinkedList<Voto>();
		this.partidos = new LinkedList<Partido>();
		this.provincias = new LinkedList<Provincia>();
	}

	public int votar(String nombreCandidato, String nombrePartido, String nombreProvincia) {
		if((nombreCandidato != "") && (nombrePartido != "")) {
			Candidato candidatoAVotar = this.validarPartidoYObtenerCandidato(nombreCandidato, nombrePartido);
			Partido partidoAVotar = candidatoAVotar.getPartido();
			Provincia provinciaAVotar = this.getProvinciaPorNombre(nombreProvincia);
			Voto voto = new Voto(candidatoAVotar, partidoAVotar, provinciaAVotar);
			this.votos.add(voto);
			return 1;
		}
		else if ((nombreCandidato == "") && (nombrePartido == "")) {
			Partido pBlanco = new Partido("VotoEnBlanco");
			Candidato cBlanco = new Candidato("VotoEnBlanco");
			Provincia provinciaAVotar = this.getProvinciaPorNombre(nombreProvincia);
			Voto votoEnBlanco = new Voto(cBlanco, pBlanco, provinciaAVotar);
			this.votos.add(votoEnBlanco);
			return 1;
		}
		return 0;
	}

	private Provincia getProvinciaPorNombre(String nombreProvincia) {
		Iterator<Provincia> iteradorProvincias = this.provincias.iterator();
		while(iteradorProvincias.hasNext()) {
			Provincia actual = iteradorProvincias.next();
			if(actual.getNombre() == nombreProvincia) {
				return actual;
			}
		}
		throw new RuntimeException("Error. Provincia no encontrada");
	}

	/*Itero la lista de partidos y al partido con el nobmre
	 * que me dan, le pido su candidato con el nombre que busco 
	 * Si el partido no esta, lanzo una excepcion*/
	private Candidato validarPartidoYObtenerCandidato(String nombreCandidato, String nombrePartido) {
		Iterator<Partido> iteradorPartidos = this.partidos.iterator();
		while(iteradorPartidos.hasNext()) {
			Partido actual = iteradorPartidos.next();
			if(actual.getNombre() == nombrePartido) {
				Candidato candidatoBuscado = actual.getCandidatoPorNombre(nombreCandidato);
				return candidatoBuscado;
			}
		}
		throw new RuntimeException ("Error. Partido no encontrado");
	}

	/*Devuelve una lista que tiene en cada posicion
	 * el nombre del candidato votado en la misma posicion 
	 * de la lista de votos*/
	public List<String> listarParaCadaVotoElNombreDelCandidato() {
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

	public String obtenerCandidatoConMasVotos() {
		Candidato candidatoConMasVotos = new Candidato("-");
		this.computarVotosHastaElMomento();
		Iterator<Partido> iteradorPartidos = this.partidos.iterator();
		while(iteradorPartidos.hasNext()) {
			Partido partidoActual = iteradorPartidos.next();
			Iterator<Candidato> iteradorCandidatos = partidoActual.getCandidatos().iterator();
			while(iteradorCandidatos.hasNext()) {
				Candidato candidatoActual = iteradorCandidatos.next();
				if(candidatoActual.getVotos() > candidatoConMasVotos.getVotos()) {
					candidatoConMasVotos = candidatoActual;
				}
			}
		}
		if(candidatoConMasVotos.getNombre() == "-") throw new RuntimeException("No hay votos computados para ningun candidato");
		return candidatoConMasVotos.getNombre();
	}

	/*Obtengo la informacion de los votos y le doy a cada candidato
	 * la cantidad que obtuvieron */
	private void computarVotosHastaElMomento() {
		Iterator<Voto> iteradorVotos = votos.iterator();
		while(iteradorVotos.hasNext()) {
			Voto actual = iteradorVotos.next();
			Candidato candidatoActual = this.validarPartidoYObtenerCandidato(actual.getNombreCandidato(), actual.getNombrePartido());
			candidatoActual.sumarVoto();
		}
	}

	public void registrarProvincia(Provincia provincia) {
		this.provincias.add(provincia);
	}


	public String obtenerPartidoConMasVotosEnUnaProvincia(String nombreProvincia) {
		Partido partidoConMasVotosPorIteracion = new Partido("");
		int cantidadDeVotosMaximaEnUnPartidoHastaAhora=0;
		List<Voto> votosEnLaProvinciaQueQuiero = this.obtenerListaDeVotosEnProvincia(nombreProvincia);
		Iterator<Partido> iteradorPartidos = this.partidos.iterator();
		while (iteradorPartidos.hasNext()) {
			Partido partidoActual = iteradorPartidos.next();
			Iterator<Voto> iteradorVotos = votosEnLaProvinciaQueQuiero.iterator();
			int votosEnEstePartido=0;
			while (iteradorVotos.hasNext()) {
				Voto votoActual = iteradorVotos.next();
				if(votoActual.getNombrePartido() == partidoActual.getNombre()) {
					votosEnEstePartido++;
				}
			}
			if(votosEnEstePartido > cantidadDeVotosMaximaEnUnPartidoHastaAhora) {
				cantidadDeVotosMaximaEnUnPartidoHastaAhora = votosEnEstePartido;
				partidoConMasVotosPorIteracion = partidoActual;
			}
		}
		if(partidoConMasVotosPorIteracion.getNombre() == "") {
			throw new RuntimeException("Aun no se han computado votos para ningun partido en esta provincia");
		}
		return partidoConMasVotosPorIteracion.getNombre();
	}


	/*Dada una provincia, devuelvo un subconjunto de los votos 
	 * que solo contenga los de esa provincia*/
	private List<Voto> obtenerListaDeVotosEnProvincia(String nombreProvincia) {
		List<Voto> listaDeVotosEnLaProvinciaQueQuiero = new LinkedList<Voto>();
		Iterator<Voto> iteradorVotos = this.votos.iterator();
		while (iteradorVotos.hasNext()) {
			Voto actual = iteradorVotos.next();
			if(actual.getNombreProvincia() == nombreProvincia) {
				listaDeVotosEnLaProvinciaQueQuiero.add(actual);
			}
		}
		return listaDeVotosEnLaProvinciaQueQuiero;
	}


}
