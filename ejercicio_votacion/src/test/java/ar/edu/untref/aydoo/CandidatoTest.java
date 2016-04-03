package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CandidatoTest {
	
	private static Candidato candidato1;
	private static Candidato candidato2IgualAl1;
	private static Candidato candidato3;
	
	@BeforeClass
	public static void prepararCandidatos() {
		candidato1 = new Candidato("Candidato Uno");
		candidato2IgualAl1 = new Candidato("Candidato Uno");
		Partido partido1 = new Partido("Partido Uno");
		candidato1.setPartido(partido1);
		candidato2IgualAl1.setPartido(partido1);
		
		candidato3 = new Candidato("Candidato Tres");
		candidato3.setPartido(partido1);
	}
	
	@Test
	public void queEqualsDeTrueConDosCandidatosIguales() {
		Assert.assertTrue(candidato1.equals(candidato2IgualAl1));
	}
	
	@Test
	public void queEqualsDeFalseConDosCandidatosDistintosDelMismoPartido() {
		Assert.assertFalse(candidato1.equals(candidato3));
	}

}
