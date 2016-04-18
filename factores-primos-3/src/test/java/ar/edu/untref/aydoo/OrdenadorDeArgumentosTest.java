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
	
}
