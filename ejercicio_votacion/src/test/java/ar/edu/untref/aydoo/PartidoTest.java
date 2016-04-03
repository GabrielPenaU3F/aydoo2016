package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartidoTest {
	
	private Partido partido;
	
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
	
	

	
	
}
