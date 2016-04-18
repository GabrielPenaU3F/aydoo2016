package ar.edu.untref.aydoo;


public class Program 
{
    public static final void main(String args[])
    {
    	
    	String argsMinuscula[] = EscritorMinuscula.ponerEnMinuscula(args);
    	System.out.print(SelectorDeOpciones.factorizarConOpciones(argsMinuscula));
    	
    }
    
}
