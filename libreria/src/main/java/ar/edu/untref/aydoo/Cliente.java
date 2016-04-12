package ar.edu.untref.aydoo;

public class Cliente {

	private String nombre;
	private String apellido;
	private String direccion;
	private Libreria libreria;
	private Cuenta cuenta;
	private Compra canasta;
	
	public Cliente(Libreria libreria, String nombre, String apellido, String direccion) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.cuenta = new Cuenta();
		this.libreria = libreria;
		this.canasta = new Compra();
		
	}
	
	public String getNombre() {
		
		return this.nombre;
		
	}
	
	public String getApellido() {
		
		return this.apellido;
		
	}
	
	public String getDireccion() {
		
		return this.direccion;
		
	}
	
	public Cuenta getCuenta() {
		
		return this.cuenta;
		
	}

	
	public void agregarALaCanasta(Comprable articulo) {
		
		if(this.libreria.verificarSiEstaEnStock(articulo) == true) {

			canasta.agregarArticulo(articulo);
		
		}
		else throw new RuntimeException("El articulo no esta en stock");
		
	}
	
	public void efectuarCompra(Mes mes) {
		
		//Le paso el mes a la compra, la pongo en la cuenta y vacio la canasta
		this.canasta.setMes(mes);
		this.cuenta.agregarCompra(this.canasta);
		this.canasta = new Compra(mes);
		
	}

	@Override
	public boolean equals(Object obj) {
		
		Cliente cliente = (Cliente) obj;
		if(this.getNombre() == cliente.getNombre() && this.getApellido() == cliente.getApellido() && this.getDireccion() == cliente.getDireccion()) {
			
			return true;
			
		}
		return false;
		
	}

	
	
}
