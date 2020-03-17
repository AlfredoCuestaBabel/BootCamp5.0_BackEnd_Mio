package com.curso.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.curso.model.Contacto;

@Repository
public class ContactosServiceImpl implements ContactosService {

	@Autowired
	JdbcTemplate template;	
	
	@Override
	public void altaContacto(Contacto contacto) {
		
		String sql = "insert into contactos (nombre,email,edad) values(?,?,?)";
		template.update(sql,contacto.getNombre(),contacto.getEmail(),contacto.getEdad());
	}

	@Override
	public List<Contacto> obtenerContactos() {
		
		String sql  = "select * from contactos";
		
		return template.query(sql,(rs,f)-> new Contacto(
				rs.getInt("idContacto"),
				rs.getString("nombre"),
				rs.getString("email"),
				rs.getInt("edad")));
	}

	@Override
	public Contacto buscarContacto(String email) {
		
		String sql  = "select * from contactos where email=?";
		
		List<Contacto>  resultado = template.query(sql,(rs,f)-> new Contacto(
				rs.getInt("idContacto"),
				rs.getString("nombre"),
				rs.getString("email"),
				rs.getInt("edad")),
				email);
		
		return resultado.size()>0?resultado.get(0):null;
	}

	@Override
	public void eliminarContacto(int idContacto) {
		
		String sql = "delete from contactos where idContacto=?";
		template.update(sql,idContacto);
	}

	@Override
	public void actualizarEdad(String email, int edad) {
		
		String sql = "update contactos set edad=? where email=?";
		template.update(sql,edad,email);
	}

	@Override
	public List<Contacto> contactosEdadMax(int edad) {
		
		//String sql = "select * from contactos where edad<?";
		//return template.query(sql,)
		return null;
		
		//TODO copiar lo del profe
		
	}

}
