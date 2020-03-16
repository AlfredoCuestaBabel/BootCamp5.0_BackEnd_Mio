package pruebas;

import java.util.ArrayList;
import java.util.List;

public class TestLista {

	public static void main(String[] args) {
		List<Integer> numeros=new ArrayList<>();
		numeros.add(3);numeros.add(9);numeros.add(4);
		numeros.add(11);numeros.add(8);numeros.add(22);numeros.add(1);
		//elimina los pares
		numeros.removeIf(t->t%2==0);
		//sustituye cada número por su cuadrado
		numeros.replaceAll(t->t*t);
		//ordenación menor a mayor
		numeros.sort((a,b)->a-b);
		numeros.forEach(t->System.out.println(t));
		
		
	}

}
