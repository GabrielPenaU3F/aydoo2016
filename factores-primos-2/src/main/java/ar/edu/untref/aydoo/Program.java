package ar.edu.untref.aydoo;

import java.util.List;
import java.util.Scanner;

public class Program 
{
    public static final void main(String args[])
    {
        String pretty = "--format=pretty";
        String quiet = "--format=quiet";
        if (args[1].compareToIgnoreCase(pretty) == 0) {
        	System.out.print(Formateador.formatearPretty(args[0]));
        } else if (args[1].compareToIgnoreCase(quiet) == 0) {
        	System.out.print(Formateador.formatearQuiet(args[0]));
        } else {
        	System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
        }

    }
    
    private static void mostrarEnQuiet(int numero) {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarEnPretty(int numero) {
    	Factorizador.factorizar(numero);
        List<Integer> factores = Factorizador.getFactores();
        System.out.print(numero + ": ");
        for(int i=0; i < factores.size(); i++) {
        	System.out.print(factores.get(i));
        	System.out.print(" ");
        }
    }
}
