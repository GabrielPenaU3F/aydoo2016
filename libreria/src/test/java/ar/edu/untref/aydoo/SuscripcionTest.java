package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {
	
	Revista lmd = new Revista("Le Monde Diplomatique", 4, 10);
	Suscripcion suscripcionALMD = new Suscripcion(lmd);
	
	@Test
	public void queDosSuscripcionesIgualesSeanIguales() {
		
		Suscripcion suscripcion = new Suscripcion(lmd);
		Assert.assertTrue(this.suscripcionALMD.equals(suscripcion));
		
	}
	
	@Test
	public void queDosSuscripcionesARevistasDistintasSeanDistintas() {
		
		Revista gente = new Revista("Gente", 4, 5);
		Suscripcion suscripcion = new Suscripcion(gente);
		Assert.assertFalse(this.suscripcionALMD.equals(suscripcion));
		
	}
	
	@Test
	public void queDosSuscripcionesAProductosDistintasSeanDistintas() {
		
		Diario clarin = new Diario("Clarin",30,10);
		Suscripcion suscripcion = new Suscripcion(clarin);
		Assert.assertFalse(this.suscripcionALMD.equals(suscripcion));
		
	}


}
