package pruebas;

import java.util.HashMap;

public class TestMap {

	public static void main(String[] args) {
		HashMap<Integer,String> empleados=new HashMap<>();
		empleados.put(100, "empleado1");
		empleados.put(30, "empleado2");
		empleados.put(125, "empleado3");
		empleados.put(65, "empleado4");
		empleados.put(16, "empleado5");
		empleados.replaceAll((k,v)->v+"-"+k);
		empleados.forEach((k,v)->System.out.println(v));

	}

}
