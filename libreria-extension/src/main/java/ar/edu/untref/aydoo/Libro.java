package ar.edu.untref.aydoo;

public class Libro extends Producto {

	public Libro(String nombre, int precio) {

		super.setNombre(nombre);
		super.setPrecio(precio);

	}

    @Override
    public boolean equals(Object obj) {

        Libro otroLibro = (Libro)obj;
        if ((this.getNombre() == otroLibro.getNombre()) && (this.getPrecio() == otroLibro.getPrecio())) {

            return true;

        }
        return false;

    }
}
