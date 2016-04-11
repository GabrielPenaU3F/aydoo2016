package ar.edu.untref.aydoo;

public class Mes {
	
	private String nombre;
	
	public Mes(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		
		return this.nombre;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		Mes mes = (Mes) obj;
		if(mes.getNombre() == this.nombre) {
			
			return true;
			
		}
		else return false;
			
	}
	
	

}
