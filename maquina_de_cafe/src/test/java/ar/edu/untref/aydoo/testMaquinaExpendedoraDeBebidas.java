package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class testMaquinaExpendedoraDeBebidas {
	
	MaquinaExpendedoraDeBebidas expendedora;
	
	@Before
	public void instanciar() {
		this.expendedora = new MaquinaExpendedoraDeBebidas();
	}
	
	@Test
	public void queHagaCafeConLecheCon6DeAzucar() {
		Vaso vaso = this.expendedora.hacerCafeConLecheConNDeAzucar(6);
		Assert.assertEquals(6, vaso.azucar);
		Assert.assertTrue(vaso.contenido.contains("Cafe"));
		Assert.assertTrue(vaso.contenido.contains("Leche"));
	}

	@Test
	public void queHagaTeConLecheCon4DeAzucar() {
		Vaso vaso = this.expendedora.hacerTeConLecheConNDeAzucar(4);
		Assert.assertEquals(4, vaso.azucar);
		Assert.assertTrue(vaso.contenido.contains("Te"));
		Assert.assertTrue(vaso.contenido.contains("Leche"));
	}
	
}
