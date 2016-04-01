package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Partido {
	
	private String nombre;
	private List<Candidato> candidatos;

	public Partido(String nombre) {
		this.nombre = nombre;
		this.candidatos = new LinkedList<Candidato>();
	}
	
	public Candidato getGanador() {
		Candidato actual = new Candidato("");
		Iterator<Candidato> iteradorCandidatos = candidatos.iterator();
		while(iteradorCandidatos.hasNext()) {
			if(iteradorCandidatos.next().getVotos() > actual.getVotos()) {
				actual = iteradorCandidatos.next();
			}
		}
		return actual;
	}
	
	public boolean tieneAlCandidato(String nombre) {
		Iterator<Candidato> iteradorCandidatos = candidatos.iterator();
		while (iteradorCandidatos.hasNext()) {
			if(iteradorCandidatos.next().getNombre() == nombre) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarCandidato(Candidato candidato) {
		candidato.setPartido(this);
		this.candidatos.add(candidato);
	}

	public String getNombre() {
		return this.nombre;
	}

}
