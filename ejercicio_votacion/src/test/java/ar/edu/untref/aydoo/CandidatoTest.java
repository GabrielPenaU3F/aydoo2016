package ar.edu.untref.aydoo;

import org.junit.BeforeClass;
import org.junit.Test;

public class CandidatoTest {
	
	private static Candidato candidato1;
	private static Candidato candidato2IgualAl1;
	
	@BeforeClass
	public static void prepararCandidatos() {
		candidato1 = new Candidato("Candidato Uno");
		candidato2IgualAl1 = new Candidato("Candidato Dos");
		Partido partido1 = new Partido("Partido Uno");
	}
	
	@Test
	public void queDosCandidatosIgualesSeanIguales() {
		
	}

}
