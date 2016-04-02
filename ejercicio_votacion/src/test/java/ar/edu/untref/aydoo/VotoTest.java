package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VotoTest {

	@Test
	public void queEqualsDeVerdaderoConDosVotosIguales() {
		Voto voto1 = new Voto("c1","p1");
		Voto voto2 = new Voto("c1","p1");
		Assert.assertTrue(voto1.equals(voto2));
	}
	
	@Test
	public void queEqualsDeFalsoConDosVotosDistintos() {
		Voto voto1 = new Voto("c1","p1");
		Voto voto2 = new Voto("c2","p2");
		Assert.assertFalse(voto1.equals(voto2));
	}
	
}
