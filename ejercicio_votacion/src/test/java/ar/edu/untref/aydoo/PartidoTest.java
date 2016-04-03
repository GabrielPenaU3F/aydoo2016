package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PartidoTest {
	
	private Partido partido;
	/*Estos tres que siguen solo sirven para probar el equals*/
	private static Partido partido1;
	private static Partido partido2IgualAl1;
	private static Partido partido3;
	
	@BeforeClass
	public static void prepararPartidos() {
		partido1 = new Partido("Partido Uno");
		partido2IgualAl1 = new Partido("Partido Uno");
		partido3 = new Partido("Partido Tres");
	}
	
	@Before
	public void prepararPartido() {
		this.partido = new Partido("Un partido");
	}
	
	@Test
	public void queRegistreUnCandidatoCorrectamenteYMeDigaSiEsta() {
		Candidato unCandidato = new Candidato("Un candidato");
		unCandidato.setPartido(partido);
		partido.registrarCandidato("Un candidato");
		Assert.assertTrue(unCandidato.equals(partido.getCandidatoPorNombre("Un candidato")));
	}
	
	@Test(expected=RuntimeException.class)
	public void siDelCanioNoEstaEntoncesQueCuandoLoBuscoNoEste() {
		Candidato macri = new Candidato("Macri");
		macri.setPartido(partido);
		partido.registrarCandidato("Macri");
		partido.getCandidatoPorNombre("Del Canio");
	}
	
	@Test
	public void queEqualsDeVerdaderoConDosPartidosIguales() {
		Assert.assertTrue(partido1.equals(partido2IgualAl1));
	}
	
	@Test
	public void queEqualsDeFalsoConDosPartidosDistintos() {
		Assert.assertFalse(partido3.equals(partido1));
	}

	
	
}
