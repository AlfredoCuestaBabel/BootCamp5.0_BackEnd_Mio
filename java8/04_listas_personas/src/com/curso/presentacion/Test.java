package com.curso.presentacion;

import java.util.List;

import com.curso.model.Persona;
import com.curso.service.OperarPersonas;

public class Test {

	public static void main(String[] args) {
		OperarPersonas operar=new OperarPersonas();
		//ordenacion
		//List<Persona> ordenadas=operar.ordenarPorEdad();
		//ordenadas.forEach(p->System.out.println(p.getNombre()));
		//transformacion
		List<Persona> transformacion=operar.concatenarPersona("sss");
		transformacion.forEach(p->System.out.println(p.getNombre()));
	}

}
