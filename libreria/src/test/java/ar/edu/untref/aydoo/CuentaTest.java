package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CuentaTest {
	
	private static Cuenta cuenta;
	
	@BeforeClass
	public static void prepararCuenta() {
		
		cuenta = new Cuenta();
		
		Compra compraArtLibreria = new Compra();
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		ArticuloDeLibreria goma = new ArticuloDeLibreria("Goma", 1);
		compraArtLibreria.agregarArticulo(lapiz);
		compraArtLibreria.agregarArticulo(goma);
		
		Compra compraLibros = new Compra();
		Libro ecuaciones = new Libro("Ecuaciones Diferenciales", 200);
		Libro electronica = new Libro("Circuitos Electronicos", 150);
		compraLibros.agregarArticulo(ecuaciones);
		compraLibros.agregarArticulo(electronica);
		
		cuenta.agregarCompra(compraArtLibreria);
		cuenta.agregarCompra(compraLibros);
		
	}

	@Test
	public void queTengaLasComprasEfectuadas() {
		
		Compra compraArtLibreria = new Compra();
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		ArticuloDeLibreria goma = new ArticuloDeLibreria("Goma", 1);
		compraArtLibreria.agregarArticulo(lapiz);
		compraArtLibreria.agregarArticulo(goma);
		
		Compra compraLibros = new Compra();
		Libro ecuaciones = new Libro("Ecuaciones Diferenciales", 200);
		Libro electronica = new Libro("Circuitos Electronicos", 150);
		compraLibros.agregarArticulo(ecuaciones);
		compraLibros.agregarArticulo(electronica);
		
		Assert.assertTrue(cuenta.contiene(compraArtLibreria));
		Assert.assertTrue(cuenta.contiene(compraLibros));
		
	}
	
	@Test
	public void queNoTengaAlgoQueNoCompre() {
		
		Revista metalHammer = new Revista("Metal Hammer", 4, 10);
		Suscripcion suscripcionAMetalHammer = new Suscripcion(metalHammer);
		Compra compra = new Compra();
		compra.agregarArticulo(metalHammer);
		compra.agregarArticulo(suscripcionAMetalHammer);
		
		Assert.assertFalse(cuenta.contiene(compra));
		
	}
	
}
