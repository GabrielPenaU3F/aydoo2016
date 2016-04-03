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
			if(iteradorCandidatos.next().getNombre() == nombreCandidato) {
				return iteradorCandidatos.next();
			}
		}
		throw new RuntimeException ("Error. Candidato no encontrado.");
	}


	public void registrarCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}
	
	

}
