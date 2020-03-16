package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.model.Persona;

public class PersonasService {
	List<Persona> personas=new ArrayList<>();
	public PersonasService() {
		personas.add(new Persona("Alex","al@gg.com",20));				
		personas.add(new Persona("Juan","alfd@gg.com",29));
		personas.add(new Persona("Elena","al@gg.es",17));
		personas.add(new Persona("Marta","alaaoi@gg.com",34));
		personas.add(new Persona("Lucas","alert@gg.es",44));
		personas.add(new Persona("Alicia","sdfl@gg.com",35));
	}
	
	public Persona personaMasJoven() {
		
	}
	
	//devuelve cuantas personas tienen una edad superior a la media
	public int superiorMedia() {
		
	}
	
	public List<Persona> ordenadasPorEdad(){
		
	}
	
	public List<String> obtenerListaNombres(){
		
	}
	
	public List<Persona> personasDominio(String dominio){
		
	}
	//clave email, valor nombre
	public Map<String,String> tablaPersonas(){
		
	}
}
