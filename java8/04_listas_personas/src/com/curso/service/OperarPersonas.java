package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.model.Persona;

public class OperarPersonas {
	List<Persona> personas=new ArrayList<>();
	public OperarPersonas() {
		personas.add(new Persona("Alex","al@gg.com",20));				
		personas.add(new Persona("Juan","alfd@gg.com",29));
		personas.add(new Persona("Elena","al@gg.es",17));
		personas.add(new Persona("Marta","alaaoi@gg.com",34));
		personas.add(new Persona("Lucas","alert@gg.es",44));
		personas.add(new Persona("Alicia","sdfl@gg.com",35));
	}
	
	public List<Persona> ordenarPorEdad(){
		personas.sort((p1,p2)->p1.getEdad()-p2.getEdad());
		return personas;
	}
	public List<Persona> concatenarPersona(String data){
		/*personas.replaceAll(p->{
			p.setNombre(p.getNombre()+data);
			return p;
		});*/
		//personas.replaceAll(p->new Persona(p.getNombre()+data,p.getEmail(),p.getEdad()));
		personas.forEach(p->p.setNombre(p.getNombre()+data));
		return personas;
	}
	
	public List<Persona> quitarPersonasDominio(String dominio){
		personas.removeIf(p->p.getEmail().endsWith(dominio));
		return personas;
	}
}
