package ar.edu.untref.aydoo;

import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;

public class LibreriaTest {
	
	private static Libreria libreria;
	
	@BeforeClass
	public static void prepararDatos() {

		libreria = new Libreria();
		Revista barcelona = new Revista("Barcelona", 2, 20);
		Libro hobbit = new Libro("El Hobbit", 50);
		libreria.agregarProducto(barcelona);
		libreria.agregarProducto(hobbit);
		
	}
	
	@Test
	public void queElHobbitEste() {
		
		Libro hobbit = new Libro("El Hobbit", 50);
		Assert.assertTrue(libreria.tieneEnStock(hobbit));
		
	}

}
