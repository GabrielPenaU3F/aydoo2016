package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartidoTest {
	
	private Eleccion eleccion;

	/* Creo una eleccion, creo algunos candidatos y registro algunos votos */
	@Before
	public void prepararCandidatos() {
		List<Partido> partidos = new LinkedList<Partido>();
		List<Provincia> provincias = new LinkedList<Provincia>();
		Partido fr = new Partido("Frente Renovador");
		Partido pro = new Partido("Pro");
		Candidato massa = new Candidato("Massa");
		Candidato deLaSota = new Candidato("De La Sota");
		Candidato macri = new Candidato("Macri");
		Candidato carrio = new Candidato("Carrio");
		fr.agregarCandidato(massa);
		fr.agregarCandidato(deLaSota);
		pro.agregarCandidato(macri);
		pro.agregarCandidato(carrio);
		partidos.add(fr);
		partidos.add(pro);
		Provincia caba = new Provincia("Ciudad Autonoma de Buenos Aires");
		Provincia baires = new Provincia("Buenos Aires");
		Provincia cordoba = new Provincia ("Cordoba");
		provincias.add(caba);
		provincias.add(baires);
		provincias.add(cordoba);
		this.eleccion = new Eleccion(partidos, provincias);
		for (int i=0; i < 50; i++) {
			this.eleccion.votar(macri, caba);
		}
		for(int i=0; i < 6; i++) {
			this.eleccion.votar(carrio, caba);
		}
		for(int i=0; i < 40; i++) {
			this.eleccion.votar(massa, baires);
		}
		for (int i=0; i < 20; i++) {
			this.eleccion.votar(deLaSota, cordoba);
		}
	}
	
	@Test
	public void queElProTengaAMacri() {
		Assert.assertTrue(this.eleccion.getPartidoPorNombre("Pro").tieneAlCandidato("Macri"));
	}
	
	
	
}
