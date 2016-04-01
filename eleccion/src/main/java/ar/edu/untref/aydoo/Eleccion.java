package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

public class Eleccion {

	private List<Partido> partidos;
	private List<Provincia> provincias;
	
	public Eleccion (List<Partido> partidos, List<Provincia> provincias) {
		this.partidos = partidos;
		this.provincias = provincias;
	}
	
	public Candidato obtenerGanadorDelPartido(Partido partido) {
		this.validarPartido(partido);
		return partido.getGanador();
	}
	
	public void votar(Candidato candidato, Provincia provincia) {
		this.validarVoto(candidato, provincia);
		candidato.computarVoto();
	}
	
	public Partido getPartidoPorNombre(String nombre) {
		Iterator<Partido> iteradorPartidos = partidos.iterator();
		while(iteradorPartidos.hasNext()) {
			if (iteradorPartidos.next().getNombre() == nombre) {
				Partido buscado = iteradorPartidos.next();
				return buscado;
			}
		}
		throw new RuntimeException ("El partido no existe");
	}

	private void validarVoto(Candidato candidato, Provincia provincia) {
		this.validarProvincia(provincia);
		this.validarCandidato(candidato);
	}

	private void validarProvincia(Provincia provincia) {
		if (!provincias.contains(provincia)) {
			throw new RuntimeException("La provincia no existe, el voto es invalido");
		}
	}

	private void validarCandidato(Candidato candidato) {
		boolean candidatoEsValido = false;
		Iterator<Partido> iteradorPartidos = partidos.iterator();
		while(iteradorPartidos.hasNext()) {
			if (iteradorPartidos.next().tieneAlCandidato(candidato.getNombre()) == true) {
				candidatoEsValido = true;
			}
		}
		if (candidatoEsValido == false) throw new RuntimeException("El candidato no existe, el voto es invalido");
		
	}

	private void validarPartido(Partido partido) {
		if (!partidos.contains(partido)) {
			throw new RuntimeException("El partido no existe");
		}
	}
	
}
