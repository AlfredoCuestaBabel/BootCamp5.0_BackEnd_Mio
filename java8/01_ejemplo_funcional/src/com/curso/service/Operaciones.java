package com.curso.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Operaciones {
	public void imprimir(List<Integer> numeros,Predicate<Integer> criterio) {
		for(Integer i:numeros) {
			if(criterio.test(i)) {
				System.out.println(i);
			}
		}
	}
	
	public void proceso(List<Integer> numeros,Predicate<Integer> criterio,Consumer<Integer> consumer) {
		for(Integer i:numeros) {
			if(criterio.test(i)) {
				consumer.accept(i);
			}
		}
	}
}
