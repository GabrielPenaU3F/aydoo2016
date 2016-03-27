package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FormateadorTest {
	
	@Test
	public void queFormateeCorrectamenteEl360EnPretty() {
		String numeroPretty = Formateador.formatear("360", "--format=pretty");
		Assert.assertEquals(0, numeroPretty.compareTo("360: 2 2 2 3 3 5"));
	}
	
	@Test
	public void queFormateeCorrectamenteEl360EnQuiet() {
		String numeroQuiet = Formateador.formatear("360", "--format=quiet");
		String numeroFormateado = String.format("2/n2/n2/n3/n3/n5/n");
		Assert.assertEquals(0, numeroFormateado.compareTo(numeroQuiet));
	}
	

}
