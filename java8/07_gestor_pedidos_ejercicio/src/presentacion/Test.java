package presentacion;

import java.time.LocalDate;
import java.time.Period;

import service.GestorPedidos;
import service.GestorPedidosImpl;

public class Test {

	public static void main(String[] args) {
		GestorPedidos gestor=new GestorPedidosImpl();
		System.out.println("Promedio alimentación " +gestor.promedioSeccion("alimentación"));
		System.out.println("Total ventas de galletas " +gestor.totalProducto("galletas"));
		System.out.println("PedidoMayor " +gestor.pedidoSuperior());
		System.out.println("Pedidos sección de deportes" +gestor.pedidosSeccion("deportes"));
		/*System.out.println("Pedido más reciente "+gestor.pedidoMasReciente());
		System.out.println("Pedidos posteriores fecha "+gestor.pedidosPosterioresFecha(LocalDate.of(2019, 05, 10)));		
		System.out.println("Pedidos entre fechas "+gestor.pedidosRangoFecha(LocalDate.of(2019, 05, 10),Period.of(0, 5, 2)));
		*/
	}

}
