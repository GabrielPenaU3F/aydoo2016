package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionTest {

	Mesa mesa = new Mesa();
	
	@Test
	public void quePuedaVotar() {
		int exito = mesa.votar();
		Assert.assertEquals(1, exito);
	}
	
}
