package service;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Pedido;

@Service

public class GestorPedidosImpl implements GestorPedidos {
	Path path;
	final String dir="/Volumes/Transcend/Programacion/BabelCamp5/2.BackEnd/ejercicios/java8/pedidos.txt";
	public GestorPedidosImpl() {
		path=Paths.get(dir);
	}
	@Override
	public void grabarPedido(Pedido pedido) {
		try(PrintStream out=new PrintStream(Files.newOutputStream(path, StandardOpenOption.APPEND));){			
			out.println(pedido.toString());
		}	
		catch(IOException ex){
			ex.printStackTrace();		
		}
	}

	@Override
	public double promedioSeccion(String seccion) {
		try {
			return Files.lines(path,Charset.forName("UTF-8"))
				.filter(s->s.split("[|]")[3].equals(seccion))
				.collect(Collectors.averagingDouble(s->Integer.parseInt(s.split("[|]")[1])*Double.parseDouble(s.split("[|]")[2])));
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return 0.0;
		}
	}
	@Override
	public double totalProducto(String producto) {
		try {
			return Files.lines(path)
				.filter(s->s.split("[|]")[0].equals(producto))
				.mapToDouble(s->Integer.parseInt(s.split("[|]")[1])*Double.parseDouble(s.split("[|]")[2]))
				.sum();
				
				//.collect(Collectors.summingDouble(s->Integer.parseInt(s.split("[|]")[1])*Double.parseDouble(s.split("[|]")[2])));
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return 0.0;
		}
	}
	@Override
	public Pedido pedidoSuperior() {
		try {
			return Files.lines(path)
				.map(s->new Pedido(s.split("[|]")[0],
						Integer.parseInt(s.split("[|]")[1]),
						Double.parseDouble(s.split("[|]")[2]),
						s.split("[|]")[3],
						LocalDate.parse(s.split("[|]")[4])
						))
				.max((p1,p2)->(p1.getUnidades()*p1.getPrecioUnitario()-p2.getUnidades()*p2.getPrecioUnitario()>0?1:-1)) //se debe devolver entero como resultado de la lambda
				.get();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	@Override
	public List<Pedido> pedidosSeccion(String seccion) {
		try {
			return Files.lines(path)
				.filter(s->s.split("[|]")[3].equals(seccion))
				.map(s->new Pedido(s.split("[|]")[0],
						Integer.parseInt(s.split("[|]")[1]),
						Double.parseDouble(s.split("[|]")[2]),
						s.split("[|]")[3],
						LocalDate.parse(s.split("[|]")[4])
						))
				.collect(Collectors.toList());
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		catch(DateTimeParseException ex) {
			return null;
		}
	}
	@Override
	public List<String> secciones() {
		try {
			return Files.lines(path)
				.map(s->s.split("[|]")[3])
				.distinct()
				.collect(Collectors.toList());
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@Override
	public Pedido pedidoMasReciente() {
		try {
			return Files.lines(path)
				.map(s->new Pedido(s.split("[|]")[0],
						Integer.parseInt(s.split("[|]")[1]),
						Double.parseDouble(s.split("[|]")[2]),
						s.split("[|]")[3],
						LocalDate.parse(s.split("[|]")[4])
						))
				.max((p1,p2)->p1.getFecha().compareTo(p2.getFecha()))
				.get();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		catch(DateTimeParseException ex) {
			return new Pedido("error",0,0,"",LocalDate.now());
		}
	}
	@Override
	public List<Pedido> pedidosPosterioresFecha(LocalDate fecha) {
		try {
			return Files.lines(path)
				.map(s->new Pedido(s.split("[|]")[0],
						Integer.parseInt(s.split("[|]")[1]),
						Double.parseDouble(s.split("[|]")[2]),
						s.split("[|]")[3],
						LocalDate.parse(s.split("[|]")[4])
						))
				.filter(p->p.getFecha().isAfter(fecha))
				.collect(Collectors.toList());
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		catch(DateTimeParseException ex) {
			return null;
		}
	}
	@Override
	public List<Pedido> pedidosPosterioresFecha(Date fecha) {
		LocalDate local=Instant.ofEpochMilli(fecha.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		return pedidosPosterioresFecha(local);
	}
	@Override
	public List<Pedido> pedidosRangoFecha(LocalDate fecha, Period periodo) {
		try {
			return Files.lines(path)
				.map(s->new Pedido(s.split("[|]")[0],
						Integer.parseInt(s.split("[|]")[1]),
						Double.parseDouble(s.split("[|]")[2]),
						s.split("[|]")[3],
						LocalDate.parse(s.split("[|]")[4])
						))
				.filter(p->p.getFecha().isAfter(fecha)&&p.getFecha().isBefore(fecha.plus(periodo)))
				.collect(Collectors.toList());
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		catch(DateTimeParseException ex) {
			return null;
		}
	}

	
	
	

}
