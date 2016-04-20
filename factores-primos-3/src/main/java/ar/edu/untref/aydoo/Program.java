package ar.edu.untref.aydoo;


public class Program {

	private EscritorMinuscula escritorMinuscula;
	private SelectorDeOpciones selectorDeOpciones;

	public Program(String args[]) {

		this.escritorMinuscula = new EscritorMinuscula();
		this.selectorDeOpciones = new SelectorDeOpciones();
		this.ejecutar(args);

	}


	public String ejecutar(String args[]) {

		String argsMinuscula[] = this.escritorMinuscula.ponerEnMinuscula(args);
		String resultado = this.selectorDeOpciones.factorizarConOpciones(argsMinuscula);
		return resultado;

	}

	public static final void main(String args[]) {

		new Program(args);

	}

}
