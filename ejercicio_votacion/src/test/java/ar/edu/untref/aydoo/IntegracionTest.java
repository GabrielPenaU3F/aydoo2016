package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntegracionTest {

	private Mesa mesa;


	@Before
	public void prepararMesa() {
		this.mesa = new Mesa();
		
		Partido frenteRenovador = new Partido("Frente Renovador");
		frenteRenovador.registrarCandidato("Massa");
		this.mesa.registrarPartido(frenteRenovador);
		
		Partido pro = new Partido("Pro");
		pro.registrarCandidato("Macri");
		this.mesa.registrarPartido(pro);
		
	}

	@Test
	public void quePuedaVotarAMassa() {
		int exito = this.mesa.votar("Massa", "Frente Renovador");
		Assert.assertEquals(1, exito);
	}


	@Test
	public void quePuedaVerElVoto() {
		this.mesa.votar("Massa", "Frente Renovador");
		Assert.assertEquals("Massa", this.mesa.getUltimoVoto().getNombreCandidato());
		Assert.assertEquals("Frente Renovador", this.mesa.getUltimoVoto().getNombrePartido());
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
		Assert.assertTrue(mesa.listarParaCadaVotoElNombreDelCandidato().contains("Macri"));
		Assert.assertTrue(mesa.listarParaCadaVotoElNombreDelCandidato().contains("Massa"));
	}
	
	@Test
	public void queSiVotoAMassaTresVecesSeComputenAmbosVotos() {
		this.mesa.votar("Massa", "Frente Renovador");
		this.mesa.votar("Massa", "Frente Renovador");
		this.mesa.votar("Massa", "Frente Renovador");
		List<String> listaPorCadaVotoElNombreDelCandidato = this.mesa.listarParaCadaVotoElNombreDelCandidato();
		Iterator<String> iteradorListaPorCadaVotoElNombreDelCandidato = listaPorCadaVotoElNombreDelCandidato.iterator();
		int cuenta=0;
		while(iteradorListaPorCadaVotoElNombreDelCandidato.hasNext()) {
			String actual = iteradorListaPorCadaVotoElNombreDelCandidato.next();
			if(actual == "Massa") {
				cuenta++;
			}
		}
		Assert.assertEquals(3, cuenta);
	}

}
