package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FactorizadorTest {

	@Test
	public void queTresCincoYSieteSeanPrimos() {
		
		Assert.assertTrue(Factorizador.esPrimo(3));
		Assert.assertTrue(Factorizador.esPrimo(5));
		Assert.assertTrue(Factorizador.esPrimo(7));
		
	}
	
	@Test
	public void queCuatroSeisYOchoNoSeanPrimos() {
		
		Assert.assertFalse(Factorizador.esPrimo(4));
		Assert.assertFalse(Factorizador.esPrimo(6));
		Assert.assertFalse(Factorizador.esPrimo(8));
		
	}
	
	@Test
	public void queUnoYDosSeanPrimos() {
		
		Assert.assertTrue(Factorizador.esPrimo(1));
		Assert.assertTrue(Factorizador.esPrimo(2));
		
	}
	
	@Test
	public void dosMenorDivisorDe80() {
		
		Assert.assertEquals(2, Factorizador.buscarMenorDivisor(80));
		
	}
	
	@Test
	public void tresMenorDivisorDe15() {
		
		Assert.assertEquals(3, Factorizador.buscarMenorDivisor(15));
		
	}
	
	@Test
	public void queFactoriceCorrectamenteEl20() {
		
		Factorizador.obtenerFactores(20);
		List<Integer> listaFactores = Factorizador.obtenerFactores(20);
		Assert.assertEquals(2, (int)listaFactores.get(0));
		Assert.assertEquals(2, (int)listaFactores.get(1));
		Assert.assertEquals(5, (int)listaFactores.get(2));
		
	}
	
	@Test
	public void queFactoriceCorrectamenteEl121() {
		
		Factorizador.obtenerFactores(121);
		List<Integer> listaFactores = Factorizador.obtenerFactores(121);
		Assert.assertEquals(11, (int)listaFactores.get(0));
		Assert.assertEquals(11, (int)listaFactores.get(1));
		
	}
	
}
