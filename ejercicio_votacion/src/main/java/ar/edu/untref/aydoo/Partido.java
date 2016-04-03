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


	public String getNombre() {
		return this.nombre;
	}

	
	/*Itero la lista y devuelvo el candidato con el nombre que busco. 
	 * Si no esta, lanzo una excepcion*/
	public Candidato getCandidatoPorNombre(String nombreCandidato) {
		Iterator<Candidato> iteradorCandidatos = this.candidatos.iterator();
		while(iteradorCandidatos.hasNext()) {
			Candidato actual = iteradorCandidatos.next();
			if(actual.getNombre() == nombreCandidato) {
				return actual;
			}
		}
		throw new RuntimeException ("Error. Candidato no encontrado.");
	}


	public void registrarCandidato(String nombreCandidato) {
		Candidato candidato = new Candidato(nombreCandidato);
		candidato.setPartido(this);
		this.candidatos.add(candidato);
	}
	
	public List<Candidato> getCandidatos() {
		return this.candidatos;
	}


	@Override
	public boolean equals(Object obj) { //Dos partidos son iguales si tienen mismo nombre
		Partido otroPartido = (Partido) obj;
		if(otroPartido.getNombre() != this.getNombre()) return false;
		return true;
	}
	

}
