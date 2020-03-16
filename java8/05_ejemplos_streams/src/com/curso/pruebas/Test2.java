package com.curso.pruebas;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		String[] productos= {"teclado","telefono","raton","pen","teclado","monitor","telefono","memoria"};
		//quitando los duplicados, indicar el total de caracteres que suman todos los productos
		
		System.out.println(Arrays.stream(productos)
			.distinct()
			.mapToInt(p->p.length()) //convierte el Stream de cadenas, en un stream de enteros
			.sum());
		
		//quitando los duplicados, mostrar producto con más caracteres
		System.out.println(Arrays.stream(productos)
			.distinct()
			.max((a,b)->a.length()-b.length())
			.get());
		
		//mostrar el producto que tenga menos de 3 caracteres
		System.out.println(Arrays.stream(productos)
				.distinct()
				.filter(s->s.length()<5)
				.findFirst()
				.orElse("-nada-"));
	}

}
