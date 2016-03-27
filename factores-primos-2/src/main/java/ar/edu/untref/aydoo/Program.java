package ar.edu.untref.aydoo;

import java.util.List;
import java.util.Scanner;

public class Program 
{
    public static final void main(String args[])
    {
    	int numero = Integer.parseInt(args[0]);
        Factorizador.factorizar(numero);
        List<Integer> factores = Factorizador.getFactores();
        System.out.print(numero + ": ");
        for(int i=0; i < factores.size(); i++) {
        	System.out.print(factores.get(i));
        	System.out.print(" ");
        }

    }
}
