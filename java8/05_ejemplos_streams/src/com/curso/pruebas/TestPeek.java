package com.curso.pruebas;

import java.util.Arrays;
import java.util.List;

public class TestPeek {

	public static void main(String[] args) {
		List<Integer> lista=Arrays.asList(6,3,7,11,23,4,5,11,3,9,50,62,11);
		lista
			.stream()
			.distinct()
			.filter(n->n%2==0) //6,4,50,62
			.peek(s->System.out.println(s))
			.anyMatch(n->n>10);

	}

}
