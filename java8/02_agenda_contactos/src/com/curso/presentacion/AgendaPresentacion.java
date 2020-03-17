package com.curso.presentacion;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.model.Contacto;
import com.curso.service.ContactosService;

public class AgendaPresentacion {

	public static void main(String[] args) {
		//iniciar Spring
		BeanFactory factory=new ClassPathXmlApplicationContext("springConfig.xml");
		ContactosService service=factory.getBean(ContactosService.class);
		String nombre, email;
		int edad,op;
		//creamos objeto Scanner para interaccionar con el usuario
		//a través de línea de comandos
		
		Scanner sc=new Scanner(System.in);
		do {
			menu();
			op=Integer.parseInt(sc.nextLine());
			switch(op) {
			
				case 1:
					System.out.println("Nombre: ");
					nombre=sc.nextLine();
					System.out.println("Email: ");
					email=sc.nextLine();
					System.out.println("Edad: ");
					edad=Integer.parseInt(sc.nextLine());
					service.altaContacto(new Contacto(0,nombre,email,edad));
					break;
					
				case 2:
					System.out.println("Email: ");
					email=sc.nextLine();
					Contacto contacto=service.buscarContacto(email);
					if(contacto!=null) {
						System.out.println(contacto.getNombre()+"-"+contacto.getEmail());
					}else {
						System.out.println("Lo siento, ese contacto no existe");
					}
					break;
					
				case 3:
					System.out.println("idContacto: ");
					int id=Integer.parseInt(sc.nextLine());
					service.eliminarContacto(id);

					break;
					
				case 4:
					List<Contacto> contactos=service.obtenerContactos();
					contactos.forEach(c->System.out.println(c.getNombre()+"-"+c.getEmail()));
					break;
			}
			
		}while(op!=5);
	}

	private static void menu() {
		System.out.println("1. Alta contacto");
		System.out.println("2. Buscar contacto");
		System.out.println("3. Eliminar contacto");
		System.out.println("4. Recuperar contactos");
		System.out.println("5. Salir");
	}


}
