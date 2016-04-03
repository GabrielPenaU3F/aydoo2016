package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class VotoTest {

	private static Voto voto1;
	private static Voto voto2IgualAl1;
	private static Voto voto3MismoCandidatoQueElUno;
	private static Voto voto4MismoPartidoQueElUno;
	
	@BeforeClass //REHACER TODO
	public static void crearVotos() {
		
		Candidato candidato1 = new Candidato("Candidato Uno");
		Partido partido1 = new Partido("Partido Uno");
		Candidato candidato2IgualAl1 = new Candidato("Candidato Uno");
		Partido partido2IgualAl1 = new Partido("Partido Uno");
		Partido partido3 = new Partido("Partido Tres");
		Candidato candidato4 = new Candidato("Candidato Cuatro");
		
		voto1 = new Voto(candidato1, partido1);
		voto2IgualAl1 = new Voto(candidato2IgualAl1, partido2IgualAl1);
		voto3MismoCandidatoQueElUno = new Voto(candidato1, partido3);
		voto4MismoPartidoQueElUno = new Voto(candidato4, partido1);
	}
	
	@Test
	public void queEqualsDeVerdaderoConDosVotosIguales() {
		Assert.assertTrue(voto1.equals(voto2IgualAl1));
	}
	
	@Test
	public void queEqualsDeFalsoConDosVotosDeDistintosCandidatos() {
		Assert.assertFalse(voto1.equals(voto4MismoPartidoQueElUno));
	}
	
	@Test
	public void queEqualsDeFalsoConDosVotosDeDistintosPartidos() {
		Assert.assertFalse(voto1.equals(voto3MismoCandidatoQueElUno));
	}
	
}
