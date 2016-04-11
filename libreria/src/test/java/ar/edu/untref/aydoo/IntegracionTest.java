package ar.edu.untref.aydoo;

import org.junit.BeforeClass;

public class IntegracionTest {
	
	private static Libreria libreria;
	
	@BeforeClass
	public static void prepararDatosDePrueba() {
		Revista barcelona = new Revista("Barcelona", 2, 20);
		Revista grafico = new Revista("El Grafico", 1, 30);
		Libro hobbit = new Libro("El Hobbit", 50);
		ArticuloDeLibreria lapicera = new ArticuloDeLibreria("Lapicera", 5);
		Diario pagina12 = new Diario("Pagina12", 30, 12);
		Diario clarin = new Diario("Clarin", 30, 13);
		libreria.agregarProducto(barcelona);
		libreria.agregarProducto(grafico);
		libreria.agregarProducto(hobbit);
		libreria.agregarProducto(lapicera);
		libreria.agregarProducto(pagina12);
		libreria.agregarProducto(clarin);
	}

	
}
