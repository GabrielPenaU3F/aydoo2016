package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FormatTest {

	private static Format format;
	private static List<Integer> factores;

	@BeforeClass
	public static void inicializarFormat() {

		format = new Format();
		factores = new LinkedList<Integer>();
		factores.add(2);
		factores.add(2);
		factores.add(2);
		factores.add(3);
		factores.add(3);
		factores.add(5);

	}

	@Test
	public void queFormateeCorrectamenteEl360EnPretty() {

		String mensaje = "360:";
		String numeroPretty = format.formatearPretty(mensaje, factores);
		Assert.assertEquals(0, numeroPretty.compareTo("360: 2 2 2 3 3 5"));

	}


	@Test
	public void queFormateeCorrectamenteEl360EnQuiet() {

		String mensaje = "";
		String numeroQuiet = format.formatearQuiet(mensaje, factores);
		String numeroFormateado = String.format("2\n2\n2\n3\n3\n5\n");
		Assert.assertEquals(0, numeroFormateado.compareTo(numeroQuiet));

	}



}
