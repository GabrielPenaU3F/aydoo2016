package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FormateadorTest {
	
	/*
	@Test
	public void queFormateeCorrectamenteEl360EnPretty() {
		
		String[] entrada = new String[2];
		entrada[0] = "360";
		entrada[1] = "--format=pretty";
		String numeroPretty = Formateador.formatear(entrada);
		Assert.assertEquals(0, numeroPretty.compareTo("360: 2 2 2 3 3 5"));
		
	}
	
	@Test
	public void queFormateeCorrectamenteEl360EnQuiet() {
		
		String[] entrada = new String[2];
		entrada[0] = "360";
		entrada[1] = "--format=quiet";
		String numeroQuiet = Formateador.formatear(entrada);
		String numeroFormateado = String.format("2\n2\n2\n3\n3\n5\n");
		Assert.assertEquals(0, numeroFormateado.compareTo(numeroQuiet));
		
	}
	
	@Test
	public void queRechaceFormatoIncorrecto() {
		
		String mensajeRechazo = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		String[] entrada = new String[2];
		entrada[0] = "360";
		entrada[1] = "--format=algo";
		Assert.assertEquals(0, mensajeRechazo.compareTo(Formateador.formatear(entrada)));
	
	}
	
	@Test 
	public void queFormateePorDefaultEnPretty() {
		
		String[] entrada = new String[1];
		entrada[0] = "360";
		String mensaje = Formateador.formatear(entrada);
		Assert.assertEquals(0, mensaje.compareTo("360: 2 2 2 3 3 5"));
		
	}
	*/

}
