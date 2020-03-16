package com.curso.pruebas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> lista=Arrays.asList(6,3,7,11,23,4,5,11,3,9,50,62,11);
		/*Stream<Integer> st=lista.stream();
		st.distinct().forEach(i->System.out.println(i));*/
		//Si el stream se ha consumido, no se puede volver a utilizar
		//System.out.println(st.distinct().count());
		
		
		/*Muestra todos los números, quitando duplicados
		 * lista
			.stream()
			.distinct()
			.forEach(i->System.out.println(i));*/
		//muestra la suma de todos los números, sin duplicados
		System.out.println(lista
			.stream()
			.mapToInt(i->i)
			.distinct()
			.sum());
		
	}

}
