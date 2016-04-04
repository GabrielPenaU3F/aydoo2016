package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {

	private Mesa mesa;


	@Before
	public void prepararMesa() {
		this.mesa = new Mesa();
		
		Provincia baires = new Provincia("Buenos Aires");
		Provincia caba = new Provincia("Ciudad Autonoma de Buenos Aires");
		this.mesa.registrarProvincia(baires);
		this.mesa.registrarProvincia(caba);
		
		Partido frenteRenovador = new Partido("Frente Renovador");
		frenteRenovador.registrarCandidato("Massa");
		this.mesa.registrarPartido(frenteRenovador);
		
		Partido pro = new Partido("Pro");
		pro.registrarCandidato("Macri");
		this.mesa.registrarPartido(pro);
		
		Partido fpv = new Partido("FPV");
		fpv.registrarCandidato("Scioli");
		this.mesa.registrarPartido(fpv);
	}

	@Test
	public void quePuedaVotarAMassa() {
		int exito = this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		Assert.assertEquals(1, exito);
	}


	@Test
	public void quePuedaVerElVoto() {
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		Assert.assertEquals("Massa", this.mesa.getUltimoVoto().getNombreCandidato());
		Assert.assertEquals("Frente Renovador", this.mesa.getUltimoVoto().getNombrePartido());
	}
	
	
	@Test
	public void quePuedaVotarAMacriYAMassa() {
		int exitoMacri = this.mesa.votar("Macri", "Pro", "Ciudad Autonoma de Buenos Aires");
		int exitoMassa = this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		Assert.assertEquals(1, exitoMacri);
		Assert.assertEquals(1, exitoMassa);
	}
	

	@Test
	public void quePuedaVerLosVotosDeMacriYMassa() {
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		Assert.assertTrue(mesa.listarParaCadaVotoElNombreDelCandidato().contains("Macri"));
		Assert.assertTrue(mesa.listarParaCadaVotoElNombreDelCandidato().contains("Massa"));
	}
	
	@Test
	public void queSiVotoAMassaTresVecesSeComputenTodosLosVotos() {
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
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
	
	@Test
	public void queDevuelvaAlCandidatoConMasVotos() {
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		Assert.assertEquals("Macri", this.mesa.obtenerCandidatoConMasVotos());
	}

	@Test
	public void queNoDevuelvaAUnCandidatoQueNoTieneMayoriaDeVotos() {
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Macri", "Pro", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		Assert.assertNotEquals("Scioli", this.mesa.obtenerCandidatoConMasVotos());
	}
	
	@Test
	public void queMeDevuelvaElPartidoConMasVotosEnUnaProvincia() {
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		Assert.assertEquals("FPV", this.mesa.obtenerPartidoConMasVotosEnUnaProvincia("Buenos Aires"));
	}
	
	@Test
	public void queNoMeDevuelvaUnPartidoQueNoSeaElQueTieneMasVotosEnUnaProvincia() {
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Massa", "Frente Renovador", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		this.mesa.votar("Scioli", "FPV", "Buenos Aires");
		Assert.assertNotEquals("Massa", this.mesa.obtenerPartidoConMasVotosEnUnaProvincia("Buenos Aires"));
	}
	
	@Test
	public void quePuedaVotarEnBlanco() {
		this.mesa.votar("", "", "Buenos Aires");
		Assert.assertEquals(this.mesa.getUltimoVoto().getNombreCandidato(), "VotoEnBlanco");
		Assert.assertEquals(this.mesa.getUltimoVoto().getNombrePartido(), "VotoEnBlanco");
		Assert.assertEquals(this.mesa.getUltimoVoto().getNombreProvincia(), "Buenos Aires");
	}
	
	
}
