package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {

	@Test
	public void permiteAgregarUnCliente(){
		
		Libreria libreria = new Libreria();
		Cliente cliente = new Cliente("Pablo", "roca 349");
		libreria.agregarCliente(cliente);
				
		Assert.assertEquals(cliente, libreria.getListaDeClientes().get(0));
	}
	
	@Test
	public void unClienteCompraUnLibroEnNoviembreYNoEstaSuscripto(){
		
		Libreria libreria = new Libreria();
		Cliente marcos = new Cliente("Marcos", "tribulato 435");
		Mes noviembre = new Mes("Noviembre");
		Compra compra = new Compra(noviembre);
		Producto libroDeCocina = new Libro("Cocina profesional", 100);
		double montoEsperado = 100.0;
		
		compra.agregarProducto(libroDeCocina);
		marcos.agregarCompra(compra);
		libreria.agregarCliente(marcos);
		
		Assert.assertEquals(montoEsperado, libreria.calcularMontoTotal(marcos), 0.0);		
	}
	
	@Test
	public void unClienteCompraUnLibroYUnArticuloDeLibreriaEnMayoYNoEstaSuscripto(){
		
		Libreria libreria = new Libreria();
		Cliente pablo = new Cliente("Pablo", "peron 321");
		Mes mayo = new Mes("Mayo");
		Compra compra = new Compra(mayo);
		Producto libroDeConstruccion = new Libro("Construcciones basicas", 50);
		Producto folios = new ArticuloDeLibreria("Folios", 10);
		double montoEsperado = 62.1;
		
		libreria.agregarCliente(pablo);
		compra.agregarProducto(libroDeConstruccion);
		compra.agregarProducto(folios);
		pablo.agregarCompra(compra);		
		
		Assert.assertEquals(montoEsperado, libreria.calcularMontoTotal(pablo), 0.0);
	}
	
	@Test
	public void elClienteJuanCompraCuatroArticulosEnAgostoSinSuscripcion(){
		
		Libreria libreria = new Libreria();
		Cliente juan = new Cliente("Juan", "mitre 123");
		Mes agosto = new Mes("Agosto");
		Compra compra = new Compra(agosto);
		Producto elHobbit = new Libro("El Hobbit", 50);
		Producto lapicera1 = new ArticuloDeLibreria("Lapicera", 5);
		Producto lapicera2 = new ArticuloDeLibreria("Lapicera", 5);
		Periodicidad mensual = new Periodicidad(30);
		Producto elGrafico = new Revista("El Grafico", 30, mensual);
		
		libreria.agregarCliente(juan);
		compra.agregarProducto(elHobbit);
		compra.agregarProducto(lapicera1);
		compra.agregarProducto(lapicera2);
		compra.agregarProducto(elGrafico);
		juan.agregarCompra(compra);
				
		double montoEsperado = 92.1;
		
		Assert.assertEquals(montoEsperado, libreria.calcularMontoTotal(juan), 0.0);
	}
	
	@Test
	public void elClientePedroCompraUnaRevistaConSuscripcionQuincenalEnFebrero(){
		
		Libreria libreria = new Libreria();
		Cliente pedro = new Cliente("Pedro", "saavedra 453");
		Mes febrero = new Mes("Febrero");
		Compra compra = new Compra(febrero);
		Periodicidad quincenal = new Periodicidad(15);
		Suscribible revistaPronto = new Revista("Revista Pronto", 25, quincenal);
		
		libreria.agregarCliente(pedro);
		compra.agregarProductoSuscribible(revistaPronto, false);
		pedro.agregarCompra(compra);
				
		double montoEsperado = 50;
		
		Assert.assertEquals(montoEsperado, libreria.calcularMontoTotal(pedro), 0.0);
	}	
	
	@Test
	public void elClienteMariaCompraCuatroArticulosEnEneroConSuscripcion(){
		
		Libreria libreria = new Libreria();
		Cliente maria = new Cliente("Maria", "San Juan 3453");
		Mes enero = new Mes("Enero");
		Compra compra = new Compra(enero);
		Periodicidad quincenal = new Periodicidad(15);
		Suscribible revistaBarcelona = new Revista("Revista Barcelona", 20, quincenal);
		Periodicidad diaria = new Periodicidad(1);
		Producto diarioPagina12 = new Periodico("Diario Pagina 12", 12, diaria);
			
		compra.agregarProductoSuscribible(revistaBarcelona, true);
		compra.agregarProducto(diarioPagina12);
		maria.agregarCompra(compra);
		libreria.agregarCliente(maria);
		
		double montoEsperado = 44;
		
		Assert.assertEquals(montoEsperado, libreria.calcularMontoTotal(maria), 0.0);
	}
}
