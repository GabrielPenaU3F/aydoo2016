package ar.edu.untref.aydoo;

import java.util.List;
import java.util.Scanner;

public class Program 
{
    public static final void main(String arg[])
    {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al factorizador. Ingrese un numero para obtener todos sus factores primos");
        boolean continuar = true;
        while (continuar) {
        	System.out.println("Ingrese su numero");
        	Factorizador.factorizar(scanner.nextInt());
        	List<Integer> factores = Factorizador.getFactores();
        	System.out.print("Factores primos:   ");
        	for(int i=0; i < factores.size(); i++) {
        		System.out.print(factores.get(i));
        		System.out.print("    ");
        	}
        	System.out.println("Escriba 0 para ingresar otro numero, otro caracter para salir");
        	if(scanner.nextInt() != 0) {
        		continuar = false;
        	}
        }
    }
}
