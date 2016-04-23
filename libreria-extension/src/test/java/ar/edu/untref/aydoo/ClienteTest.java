package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void clienteHaceUnaCompraEnAgosto(){
		
		Cliente cliente = new Cliente("Pablo", "azquenaga 888");
		Mes agosto = new Mes("Agosto");
		Producto lapicera = new ArticuloDeLibreria("Lapicera", 5);
		Compra compra = new Compra(agosto);
		
		compra.agregarProducto(lapicera);
		cliente.agregarCompra(compra);
		
		Assert.assertEquals(compra, cliente.getListaDeCompras().get(0));
	}
}
