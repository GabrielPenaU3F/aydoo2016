package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;


public class AlquilerMensualTest {

    @Test
    public void quePuedaCrearElAlquilerDelHobbitPorUnMes() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerMensual = new AlquilerMensual(hobbit, 1);

        Assert.assertEquals("Alquiler El Hobbit", alquilerMensual.getNombre());
        Assert.assertEquals(1, alquilerMensual.getPeriodo());
        Assert.assertTrue(hobbit.equals(alquilerMensual.getLibro()));

    }

    @Test
    public void queElPrecioMensualSeCalculeCorrectamenteParaTresMeses() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerMensual = new AlquilerMensual(hobbit, 3);
        Assert.assertEquals(600, alquilerMensual.getPrecio(), 0.0);

    }


    @Test(expected = PeriodoExcedidoException.class)
    public void queNoAlquilePor6Meses() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerMensual = new AlquilerMensual(hobbit, 6);

    }

    @Test(expected = PeriodoExcedidoException.class)
    public void queNoAlquilePor0Meses() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerMensual = new AlquilerMensual(hobbit, 0);

    }
    
}
