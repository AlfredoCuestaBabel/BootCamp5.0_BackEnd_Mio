package com.curso.presentation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.curso.service.Operaciones;

public class Pruebas {

	public static void main(String[] args) {
		List<Integer> lista=Arrays.asList(6,20,11,7,23,9);
		Operaciones operaciones=new Operaciones();
		operaciones.imprimir(lista, new Pares());
		operaciones.proceso(lista, new Pares(),new Process());
	}

}

class Pares implements Predicate<Integer>{
	@Override
	public boolean test(Integer t) {	
		return (t%2==0);
	}	
}

class Process implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println(t);
		
	}
	
}
