package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompraTest {
	
	private static Compra compra;
	
	@BeforeClass
	public static void crearCompra() {
		
		Mes marzo = new Mes("Marzo");
		compra = new Compra(marzo);
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		Revista paparazzi = new Revista ("Paparazzi", 4, 20);
		Suscripcion suscripcionAPaparazzi = new Suscripcion (paparazzi);
		compra.agregarArticulo(lapiz);
		compra.agregarArticulo(paparazzi);
		compra.agregarArticulo(suscripcionAPaparazzi);
		
	}
	
	@Test
	public void queEstenLosArticulosQueVoyAComprar() {
		
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		Revista paparazzi = new Revista ("Paparazzi", 4, 20);
		Suscripcion suscripcionAPaparazzi = new Suscripcion (paparazzi);
		
		Assert.assertTrue(compra.contiene(lapiz));
		Assert.assertTrue(compra.contiene(paparazzi));
		Assert.assertTrue(compra.contiene(suscripcionAPaparazzi));
		
	}
	
	@Test
	public void queNoEsteUnArticuloQueNoVoyAComprar() {
		
		ArticuloDeLibreria goma = new ArticuloDeLibreria("goma", 2);

		Assert.assertFalse(compra.contiene(goma));
		
	}
	
	@Test
	public void queDosComprasIgualesSeanIguales() {
		
		Mes marzo = new Mes("Marzo");
		Compra otraCompra = new Compra(marzo);
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		Revista paparazzi = new Revista ("Paparazzi", 4, 20);
		Suscripcion suscripcionAPaparazzi = new Suscripcion (paparazzi);
		otraCompra.agregarArticulo(lapiz);
		otraCompra.agregarArticulo(paparazzi);
		otraCompra.agregarArticulo(suscripcionAPaparazzi);
		
	}
	
	@Test
	public void queDosComprasDeDistintosArticulosSeanDistintas() {
		
		Mes marzo = new Mes("Marzo");
		Compra otraCompra = new Compra(marzo);
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		Libro fisicaConceptual = new Libro ("Fisica Conceptual", 250);
		otraCompra.agregarArticulo(lapiz);
		otraCompra.agregarArticulo(fisicaConceptual);
		
		Assert.assertFalse(compra.equals(otraCompra));
		
	}
	
	@Test
	public void queDosComprasDeDistintosMesesSeanDistintas() {
		
		Mes abril = new Mes("Abril");
		Compra otraCompra = new Compra(abril);
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria("Lapiz", 2);
		Revista paparazzi = new Revista ("Paparazzi", 4, 20);
		Suscripcion suscripcionAPaparazzi = new Suscripcion (paparazzi);
		otraCompra.agregarArticulo(lapiz);
		otraCompra.agregarArticulo(paparazzi);
		otraCompra.agregarArticulo(suscripcionAPaparazzi);
		
		Assert.assertFalse(compra.equals(otraCompra));
		
	}

}
