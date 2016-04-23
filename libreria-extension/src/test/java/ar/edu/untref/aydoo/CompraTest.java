package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {
	
	@Test
	public void permiteAgregarUnLibroALaCompraDeJulio(){
		
		Mes julio = new Mes("Julio");
		Compra compra = new Compra(julio);
		Producto libro = new Libro("El principito", 20);
		
		compra.agregarProducto(libro);
		
		Assert.assertEquals(1, compra.getListaDeProductos().size());
	}
	
	@Test
	public void permiteAgregarUnaLapiceraALaCompraDeAgosto(){
		
		Mes agosto = new Mes("Agosto");
		Compra compra = new Compra(agosto);
		Producto lapicera = new ArticuloDeLibreria("Lapicera", 10);
		
		compra.agregarProducto(lapicera);
		
		Assert.assertEquals(1, compra.getListaDeProductos().size());
	}
	
	@Test
	public void permiteAgregarUnaRevistaALaCompraDeMayo(){
		
		Mes mayo = new Mes("Mayo");
		Compra compra = new Compra(mayo);
		Periodicidad semanal = new Periodicidad(7);
		Producto revista = new Revista("Viva", 15, semanal);
		
		compra.agregarProducto(revista);
				
		Assert.assertEquals(1, compra.getListaDeProductos().size());		
	}
	
	@Test
	public void permiteAgregarUnPeriodicoALaCompraDeJunio(){
		
		Mes junio = new Mes("Junio");
		Compra compra = new Compra(junio);
		Periodicidad diaria = new Periodicidad(1);
		Producto periodico = new Periodico("Clarin", 30, diaria);
		
		compra.agregarProducto(periodico);
		
		Assert.assertEquals(1, compra.getListaDeProductos().size());		
	}
}
