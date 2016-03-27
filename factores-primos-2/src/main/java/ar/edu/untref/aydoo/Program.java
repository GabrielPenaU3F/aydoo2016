package ar.edu.untref.aydoo;

import java.util.List;
import java.util.Scanner;

public class Program 
{
    public static final void main(String arg[])
    {
    	Scanner scanner = new Scanner(System.in);
    	int numero = scanner.nextInt();
        Factorizador.factorizar(numero);
        List<Integer> factores = Factorizador.getFactores();
        System.out.print(numero + ": ");
        for(int i=0; i < factores.size(); i++) {
        	System.out.print(factores.get(i));
        	System.out.print(" ");
        }

    }
}
