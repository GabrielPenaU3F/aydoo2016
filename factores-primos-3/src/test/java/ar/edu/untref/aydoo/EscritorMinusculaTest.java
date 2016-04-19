package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EscritorMinusculaTest {
	
	private static EscritorMinuscula escritor;
	
	@BeforeClass
	public static void inicializarEscritor() {
		
		escritor = new EscritorMinuscula();
		
	}
	
	@Test
	public void queSiEstaEnMinusculaLoDejeEnMinuscula() {
		
		String arrayEnMinuscula[] = new String[4];
		arrayEnMinuscula[0] = "0";
		arrayEnMinuscula[1] = "hola";
		arrayEnMinuscula[2] = "chau";
		arrayEnMinuscula[3] = "hola y chau";
		
		Assert.assertArrayEquals(arrayEnMinuscula, escritor.ponerEnMinuscula(arrayEnMinuscula));
		
	}
	
	@Test
	public void queLoQueEstaEnMayusculaLoPaseAMinuscula() {
		
		String arrayOriginal[] = new String[4];
		arrayOriginal[0] = "0";
		arrayOriginal[1] = "HOLA--";
		arrayOriginal[2] = "ChaU++";
		arrayOriginal[3] = "hOl4 Y cH4u";
		
		String arrayEnMinuscula[] = new String[4];
		arrayEnMinuscula[0] = "0";
		arrayEnMinuscula[1] = "hola--";
		arrayEnMinuscula[2] = "chau++";
		arrayEnMinuscula[3] = "hol4 y ch4u";
		
		Assert.assertArrayEquals(arrayEnMinuscula, escritor.ponerEnMinuscula(arrayOriginal));
		
	}

}
