package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class VotoTest {

	private static Voto voto1;
	private static Voto voto2IgualAl1;
	private static Voto voto3MismoCandidatoQueElUno;
	private static Voto voto3MismoPartidoQueElUno;
	
	@BeforeClass
	public static void crearVotos() {
		Partido partido1 = new Partido("Partido Uno");
		Partido partido3 = new Partido("Partido Tres");
		Candidato candidato1 = new Candidato("Candidato Uno", partido1);
		Candidato candidato2 = new Candidato("Candidato Uno", partido1);
		Candidato candidato3MismoCandidatoQueElUno = new Candidato("Candidato Uno", partido3);
		Candidato candidato4MismoPartidoQueElUno = new Candidato("Candidato Cuatro", partido1);
		voto1 = new Voto(candidato1, partido1);
		voto2IgualAl1 = new Voto(candidato2, partido1);
		voto3MismoCandidatoQueElUno = new Voto(candidato3MismoCandidatoQueElUno, partido3);
		voto3MismoPartidoQueElUno = new Voto(candidato4MismoPartidoQueElUno, partido1);
	}
	
	@Test
	public void queEqualsDeVerdaderoConDosVotosIguales() {
		Assert.assertTrue(voto1.equals(voto2IgualAl1));
	}
	
	@Test
	public void queEqualsDeFalsoConDosVotosDeDistintosCandidatos() {
		Assert.assertFalse(voto1.equals(voto3MismoPartidoQueElUno));
	}
	
	@Test
	public void queEqualsDeFalsoConDosVotosDeDistintosPartidos() {
		Assert.assertFalse(voto1.equals(voto3MismoCandidatoQueElUno));
	}
	
}
