package proyectoMineria;
import java.util.*;

import Dominio.Clientes;

public class Deposito {

	private List <Material> stock;
		
	
	public void agregarMaterial(String nombre,Double pureza,Double cantidad) {
	stock.add(Material);
	
	}
	
	public void mostrarStock() {
		for (Material s : stock) {
			System.out.println(s.getNombre()+" "+s.getPureza()+" "+ s.getCantidad()"\n");
		}
	}
}
