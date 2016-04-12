package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CuentaTest {
	
	private static Cuenta cuenta;
	
	@BeforeClass
	public static void prepararCuenta() {
		
		cuenta = new Cuenta();
		Mes marzo = new Mes("Marzo");
		
		Compra compraArtLibreria = new Compra(marzo);
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		ArticuloDeLibreria goma = new ArticuloDeLibreria("Goma", 1);
		compraArtLibreria.agregarArticulo(lapiz);
		compraArtLibreria.agregarArticulo(goma);
		
		Compra compraLibros = new Compra(marzo);
		Libro ecuaciones = new Libro("Ecuaciones Diferenciales", 200);
		Libro electronica = new Libro("Circuitos Electronicos", 150);
		compraLibros.agregarArticulo(ecuaciones);
		compraLibros.agregarArticulo(electronica);
		
		cuenta.agregarCompra(compraArtLibreria);
		cuenta.agregarCompra(compraLibros);
		
	}

	@Test
	public void queTengaLasComprasEfectuadas() {
		
		Mes marzo = new Mes("Marzo");
		Compra compraArtLibreria = new Compra(marzo);
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		ArticuloDeLibreria goma = new ArticuloDeLibreria("Goma", 1);
		compraArtLibreria.agregarArticulo(lapiz);
		compraArtLibreria.agregarArticulo(goma);
		
		Compra compraLibros = new Compra(marzo);
		Libro ecuaciones = new Libro("Ecuaciones Diferenciales", 200);
		Libro electronica = new Libro("Circuitos Electronicos", 150);
		compraLibros.agregarArticulo(ecuaciones);
		compraLibros.agregarArticulo(electronica);
		
		Assert.assertTrue(cuenta.contiene(compraArtLibreria));
		Assert.assertTrue(cuenta.contiene(compraLibros));
		
	}
	
	@Test
	public void queNoTengaAlgoQueNoCompre() {
		
		Mes marzo = new Mes("Marzo");
		Revista metalHammer = new Revista("Metal Hammer", 4, 10);
		Suscripcion suscripcionAMetalHammer = new Suscripcion(metalHammer);
		Compra compra = new Compra(marzo);
		compra.agregarArticulo(metalHammer);
		compra.agregarArticulo(suscripcionAMetalHammer);
		
		Assert.assertFalse(cuenta.contiene(compra));
		
	}
	
}
