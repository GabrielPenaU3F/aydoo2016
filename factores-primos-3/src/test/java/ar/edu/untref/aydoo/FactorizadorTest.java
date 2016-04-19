package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactorizadorTest {
	
	private static Factorizador factorizador;
	
	@BeforeClass
	public static void inicializarFactorizador() {
		
		factorizador = new Factorizador();
		
	}

	@Test
	public void queTresCincoYSieteSeanPrimos() {
		
		Assert.assertTrue(factorizador.esPrimo(3));
		Assert.assertTrue(factorizador.esPrimo(5));
		Assert.assertTrue(factorizador.esPrimo(7));
		
	}
	
	@Test
	public void queCuatroSeisYOchoNoSeanPrimos() {
		
		Assert.assertFalse(factorizador.esPrimo(4));
		Assert.assertFalse(factorizador.esPrimo(6));
		Assert.assertFalse(factorizador.esPrimo(8));
		
	}
	
	@Test
	public void queUnoYDosSeanPrimos() {
		
		Assert.assertTrue(factorizador.esPrimo(1));
		Assert.assertTrue(factorizador.esPrimo(2));
		
	}
	
	@Test
	public void dosMenorDivisorDe80() {
		
		Assert.assertEquals(2, factorizador.buscarMenorDivisor(80));
		
	}
	
	@Test
	public void tresMenorDivisorDe15() {
		
		Assert.assertEquals(3, factorizador.buscarMenorDivisor(15));
		
	}
	
	@Test
	public void queFactoriceCorrectamenteEl20() {
		
		factorizador.obtenerFactores(20);
		List<Integer> listaFactores = factorizador.obtenerFactores(20);
		Assert.assertEquals(2, (int)listaFactores.get(0));
		Assert.assertEquals(2, (int)listaFactores.get(1));
		Assert.assertEquals(5, (int)listaFactores.get(2));
		
	}
	
	@Test
	public void queFactoriceCorrectamenteEl121() {
		
		factorizador.obtenerFactores(121);
		List<Integer> listaFactores = factorizador.obtenerFactores(121);
		Assert.assertEquals(11, (int)listaFactores.get(0));
		Assert.assertEquals(11, (int)listaFactores.get(1));
		
	}
	
}
