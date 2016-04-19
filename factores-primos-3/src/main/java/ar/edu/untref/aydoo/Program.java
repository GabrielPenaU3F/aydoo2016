package ar.edu.untref.aydoo;


public class Program {

	private EscritorMinuscula escritorMinuscula;
	private SelectorDeOpciones selectorDeOpciones;
	
	private Program(String args[]) {
		
		this.escritorMinuscula = new EscritorMinuscula();
		this.selectorDeOpciones = new SelectorDeOpciones();
		this.ejecutar(args);
		
	}
	
	private void ejecutar(String args[]) {
		
		String argsMinuscula[] = this.escritorMinuscula.ponerEnMinuscula(args);
		System.out.print(this.selectorDeOpciones.factorizarConOpciones(argsMinuscula));
		
	}

	public static final void main(String args[]) {

		new Program(args);

	}

}
