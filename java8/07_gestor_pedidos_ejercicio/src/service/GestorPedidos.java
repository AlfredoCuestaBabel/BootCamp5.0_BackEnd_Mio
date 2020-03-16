package service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import model.Pedido;

public interface GestorPedidos {
	void grabarPedido(Pedido pedido);
	double promedioSeccion(String seccion);
	double totalProducto(String producto);
	Pedido pedidoSuperior();
	List<Pedido> pedidosSeccion(String seccion);
	Pedido pedidoMasReciente();
	List<Pedido> pedidosPosterioresFecha(LocalDate fecha);
	List<Pedido> pedidosPosterioresFecha(Date fecha);
	
	List<Pedido> pedidosRangoFecha(LocalDate fecha, Period periodo);
	List<String> secciones();
}
