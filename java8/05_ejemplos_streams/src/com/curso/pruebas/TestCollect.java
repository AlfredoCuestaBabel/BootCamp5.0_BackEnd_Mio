package com.curso.pruebas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCollect {
	public static void main(String[] args) {
		List<Integer> lista=Arrays.asList(6,3,7,11,23,4,5,11,3,9,50,62,11);
		//eliminar duplicados y generar nueva lista con los pares
		lista
			.stream()
			.distinct()
			.filter(n->n%2==0)
			.collect(Collectors.toList())//transforma en una lista
			.forEach(l->System.out.println(l));
	
	}
}
