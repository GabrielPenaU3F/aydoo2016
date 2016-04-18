package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class OrdenadorDeArgumentosTest {

	private String[] string;
	
	@Before
	public void prepararArray() {
		
		this.string = new String[3];
		this.string[0] = "1";
		this.string[1] = "--format=pretty";
		this.string[2] = "blabla";
		
	}
	
	@Test
	public void queObtengaElFormatoPretty() {
		
		Assert.assertEquals("--format=pretty", OrdenadorDeArgumentos.obtenerFormato(this.string));
		
	}
	
	@Test(expected= NoEstaElFormatoException.class)
	public void queNoObtengaElFormatoPretty() {
		
		this.string[1] = "agagsa";
		OrdenadorDeArgumentos.obtenerFormato(this.string);
		
	}
	
	@Test
	public void queEsteElFormato() {
		
		Assert.assertTrue(OrdenadorDeArgumentos.estaElArgumentoFormat(this.string));
		
	}
	
	@Test
	public void queNoEsteElFormato() {
		
		this.string[2] = "sghñhñh";
		Assert.assertTrue(OrdenadorDeArgumentos.estaElArgumentoFormat(this.string));
		
	}
	
	@Test
	public void queAgregueElFormatoPrettyYOrdeneCorrectamenteElFormatoEnLaPrimerPosicion() {
		
		this.string[1] = "blabla";
		this.string[2] = "alagsdh";
		String esperado[] = new String[4];
		esperado[0] = "1";
		esperado[1] = "--format=pretty";
		esperado[2] = "blabla";
		esperado[3] = "alagsdh";
		Assert.assertArrayEquals(esperado, OrdenadorDeArgumentos.ordenar(this.string));
		
	}
	
	@Test
	public void queOrdeneCorrectamenteElFormatoEnLaPrimerPosicionConElFormatoYaIndicado() {
		
		this.string[1] = "blabla";
		this.string[2] = "--format=pretty";
		String esperado[] = new String[3];
		esperado[0] = "1";
		esperado[1] = "--format=pretty";
		esperado[2] = "blabla";
		Assert.assertArrayEquals(esperado, OrdenadorDeArgumentos.ordenar(this.string));
		
	}
	
}
