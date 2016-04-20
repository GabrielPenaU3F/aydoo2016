package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Output extends Opcion {

	public Output () {

		this.parametros = new LinkedList<String>();
		this.opcion = "--output-file=";

	}

	@Override
	protected void solicitarEjecucionConParametro(SelectorDeOpciones selectorDeOpciones, String parametro) {
		
		if (parametro == "-") {
			
			this.imprimirEnConsola(selectorDeOpciones.getResultado());
			
		}
		else {
			
			this.guardarEnArchivo(selectorDeOpciones, parametro);
			
		}

	}

	private void guardarEnArchivo(SelectorDeOpciones selectorDeOpciones, String parametro) {
		
		File archivo = new File(parametro);
		File directoriosACrear = new File(archivo.getParent());
		directoriosACrear.mkdirs();
		
		try {
			FileWriter escritor = new FileWriter(archivo);
			escritor.write(selectorDeOpciones.getResultado());
			escritor.close();
			System.out.println("Entro aca");
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}

	private void imprimirEnConsola(String resultado) {
		
		System.out.println(resultado);
		
	}

	@Override
	protected String seleccionarParametro(String argumento) {
		
		if (argumento == "--output-file=-") return "-";
		return argumento.substring(14);
		
	}




}
