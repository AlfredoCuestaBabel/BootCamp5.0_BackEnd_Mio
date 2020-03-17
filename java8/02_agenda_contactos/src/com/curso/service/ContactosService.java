package com.curso.service;

import java.util.List;

import com.curso.model.Contacto;

public interface ContactosService {

	void altaContacto(Contacto contacto);
	List<Contacto> obtenerContactos();
	Contacto buscarContacto(String email);
	void eliminarContacto(int idContacto);
	void actualizarEdad(String email, int edad);
	List<Contacto> contactosEdadMax(int edad);
	
}
