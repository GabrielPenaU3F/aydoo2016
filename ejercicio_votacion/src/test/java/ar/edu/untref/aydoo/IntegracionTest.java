package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntegracionTest {

	private static Mesa mesa;


	@BeforeClass
	public static void prepararMesa() {
		mesa = new Mesa();
		Partido frenteRenovador = new Partido("Frente Renovador");
		frenteRenovador.registrarCandidato("Massa");
		mesa.registrarPartido(frenteRenovador);
	}

	@Test
	public void quePuedaVotarAMassa() {
		int exito = mesa.votar("Massa", "Frente Renovador");
		Assert.assertEquals(1, exito);
	}

	/*
	@Test
	public void quePuedaVerElVoto() {
		this.mesa.votar("Massa", "Frente Renovador");
		Voto votoMassa = new Voto("Massa", "Frente Renovador");
		Assert.assertTrue(votoMassa.equals(this.mesa.getUltimoVoto()));
	}
	
	@Test
	public void quePuedaVotarAMacriYAMassa() {
		int exitoMacri = this.mesa.votar("Macri", "Pro");
		int exitoMassa = this.mesa.votar("Massa", "Frente Renovador");
		Assert.assertEquals(1, exitoMacri);
		Assert.assertEquals(1, exitoMassa);
	}
	
	@Test
	public void quePuedaVerLosVotosDeMacriYMassa() {
		this.mesa.votar("Macri", "Pro");
		this.mesa.votar("Massa", "Frente Renovador");
		Assert.assertTrue(mesa.listarVotosComoString().contains("Macri"));
		Assert.assertTrue(mesa.listarVotosComoString().contains("Massa"));
	}*/

}
