package ar.edu.untref.aydoo;

import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

public class IntegracionTest {
	
	private Program programa;
	
	@After
	public void limpiarPrograma() {
		
		this.programa = null;
		
	}
	
	@Test
	public void queFactoriceCorrectamenteEl360SinFormatoEnOrdenDescendente() {
		
		String[] args = new String[2];
		args[0] = "360";
		args[1] = "--sort:des";
		this.programa = new Program(args);
		String esperado = "360: 5 3 3 2 2 2";
		
		Assert.assertEquals(esperado, programa.ejecutar(args));
		
	}

	@Test
	public void queFactoriceCorrectamenteEl360ConFormatoPrettyEnOrdenAscendente() {
		
		String[] args = new String[3];
		args[0] = "360";
		args[1] = "--sort:asc";
		args[2] = "--format=pretty";
		this.programa = new Program(args);
		String esperado = "360: 2 2 2 3 3 5";
		
		Assert.assertEquals(esperado, programa.ejecutar(args));
		
	}
	
	@Test(expected=OpcionInexistenteException.class) 
	public void queNoFuncioneSiLePasoUnaOpcionIncorrecta() {
		
		String[] args = new String[3];
		args[0] = "360";
		args[1] = "--sort:asc";
		args[2] = "caca-total";
		this.programa = new Program(args);
		
	}
	
	@Test(expected=ParametroInexistenteException.class)
	public void queNoFuncioneSiLePasoUnFormatoIncorrecto() {
		
		String[] args = new String[3];
		args[0] = "360";
		args[1] = "--sort:asc";
		args[2] = "--format=caca";
		this.programa = new Program(args);
		
	}
	
	@Test(expected=ParametroInexistenteException.class)
	public void queNoFuncioneSiLePasoUnOrdenIncorrecto() {
		
		String[] args = new String[3];
		args[0] = "360";
		args[1] = "--sort:desordenado";
		args[2] = "--format=quiet";
		this.programa = new Program(args);

	}
	
	
	
}
