package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class AlquilerDiarioTest {
    
    @Test
    public void quePuedaCrearElAlquilerDelHobbitPorSieteDias() {
        
        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerDiario = new AlquilerDiario(hobbit, 7);
        
        Assert.assertEquals("Alquiler El Hobbit", alquilerDiario.getNombre());
        Assert.assertEquals(7, alquilerDiario.getPeriodo());
        Assert.assertTrue(hobbit.equals(alquilerDiario.getLibro()));
        
    }
    
    @Test
    public void queElPrecioMensualSeCalculeCorrectamenteParaCincoDias() {
        
        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerDiario = new AlquilerDiario(hobbit, 5);
        Assert.assertEquals(50, alquilerDiario.getPrecio(), 0.0);
        
    }
    
    
    @Test(expected = PeriodoExcedidoException.class)
    public void queNoAlquilePor26Dias() {
        
        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerDiario = new AlquilerDiario(hobbit, 26);
        
    }
    
    @Test(expected = PeriodoExcedidoException.class)
    public void queNoAlquilePor2Dias() {
        
        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerDiario = new AlquilerDiario(hobbit, 2);
        
    }
    
}
