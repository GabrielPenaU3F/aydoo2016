package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class AlquilerCuatrimestralTest {

    @Test
    public void quePuedaCrearElAlquilerDelHobbitPorUnCuatrimestre() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerCuatri = new AlquilerCuatrimestral(hobbit, 1);

        Assert.assertEquals("Alquiler El Hobbit", alquilerCuatri.getNombre());
        Assert.assertEquals(1, alquilerCuatri.getPeriodo());
        Assert.assertTrue(hobbit.equals(alquilerCuatri.getLibro()));

    }

    @Test
    public void queElPrecioCuatrimestralConDescuentoSeCalculeCorrectamenteParaUnCuatrimestre() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerCuatri = new AlquilerCuatrimestral(hobbit, 1);
        Assert.assertEquals(720.0, alquilerCuatri.getPrecio(), 0.0);

    }
    
    
}
