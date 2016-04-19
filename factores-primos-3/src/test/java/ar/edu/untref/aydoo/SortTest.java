package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {
	
	private Sort ordenador;
	
	@Test
	public void queOrdeneCorrectamenteEnOrdenAscendenteUnaListaDesordenada() {
		
		this.ordenador = new Sort();
		
		List<Integer> listaDesordenada = new LinkedList<Integer>();
		listaDesordenada.add(10);
		listaDesordenada.add(6);
		listaDesordenada.add(15);
		listaDesordenada.add(0);
		listaDesordenada.add(7);
		listaDesordenada.add(12);
		this.ordenador.ordenarAscendente(listaDesordenada);
		
		List<Integer> listaOrdenada = new LinkedList<Integer>();
		listaOrdenada.add(0);
		listaOrdenada.add(6);
		listaOrdenada.add(7);
		listaOrdenada.add(10);
		listaOrdenada.add(12);
		listaOrdenada.add(15);
		
		Assert.assertTrue(listaDesordenada.equals(listaOrdenada));
		
	}
	
	@Test
	public void queOrdeneCorrectamenteEnOrdenDescendenteUnaListaDesordenada() {
		
		this.ordenador = new Sort();
		
		List<Integer> listaDesordenada = new LinkedList<Integer>();
		listaDesordenada.add(10);
		listaDesordenada.add(6);
		listaDesordenada.add(15);
		listaDesordenada.add(0);
		listaDesordenada.add(7);
		listaDesordenada.add(12);
		this.ordenador.ordenarDescendente(listaDesordenada);
		
		List<Integer> listaOrdenada = new LinkedList<Integer>();
		listaOrdenada.add(15);
		listaOrdenada.add(12);
		listaOrdenada.add(10);
		listaOrdenada.add(7);
		listaOrdenada.add(6);
		listaOrdenada.add(0);
		
		Assert.assertTrue(listaDesordenada.equals(listaOrdenada));
		
	}
	
	@Test
	public void queNoModifiqueUnaListaOrdenadaDescendente() {
		
		this.ordenador = new Sort();
		
		List<Integer> listaOrdenada = new LinkedList<Integer>();
		listaOrdenada.add(15);
		listaOrdenada.add(12);
		listaOrdenada.add(10);
		listaOrdenada.add(7);
		listaOrdenada.add(6);
		listaOrdenada.add(0);
		
		List<Integer> listaDosVecesOrdenada = listaOrdenada;
		this.ordenador.ordenarDescendente(listaDosVecesOrdenada);
		
		Assert.assertTrue(listaDosVecesOrdenada.equals(listaOrdenada));
		
	}
	
	@Test
	public void queNoModifiqueUnaListaOrdenadaAscendente() {
		
		this.ordenador = new Sort();
		
		List<Integer> listaOrdenada = new LinkedList<Integer>();
		listaOrdenada.add(0);
		listaOrdenada.add(6);
		listaOrdenada.add(7);
		listaOrdenada.add(10);
		listaOrdenada.add(12);
		listaOrdenada.add(15);
		
		List<Integer> listaDosVecesOrdenada = listaOrdenada;
		this.ordenador.ordenarAscendente(listaDosVecesOrdenada);
		
		Assert.assertTrue(listaDosVecesOrdenada.equals(listaOrdenada));
		
	}

}
