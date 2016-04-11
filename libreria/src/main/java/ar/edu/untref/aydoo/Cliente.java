package ar.edu.untref.aydoo;

public class Cliente {

	private String nombre;
	private String apellido;
	private String direccion;
	
	public Cliente(String nombre, String apellido, String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
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
}
