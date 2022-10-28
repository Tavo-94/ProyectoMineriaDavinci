package proyectoMineria;
import java.util.LinkedList;
	
public class Deposito {

	LinkedList<Material> Stock = new LinkedList<Material>();

	public boolean add(Material material) {
		 char [] letras = material.getTipo().toCharArray();
		 if (letras.length >= 3 && letras.length <= 15) {
			material.getCantidad();
			if(material.getCantidad()> 0 && material.getCantidad()== null){
			material.getPureza();
			
			}
		 }
		return false;
	}
	
	public Material buscarMaterial(String tipo) {
		Material material = new Material();
		for (int i = 0; i < Stock.size(); i++) {
			System.out.println(Stock.get(i));
			material=Stock.get(i);
			String aux = material.getTipo();
			
			if (aux.equals(tipo)) {
				return material;
				}
			}
		String aux = "0";
		material.setTipo(aux);
		return material ;
		}
	
	public boolean modificarStock(Material material){
		int index = IndexMaterial(material);
		Stock.set(index, material);
		return true;
	}
	
	private int IndexMaterial(Material material) {
		Material aux1 = new Material();
		for (int i = 0; i < Stock.size(); i++) {
			System.out.println(Stock.get(i));
			aux1 = Stock.get(i);
			String aux = aux1.getTipo();
			if (aux.equals(material.getTipo())) {
				return i;
			}
		}
		return 0;
	}
	
	public LinkedList<Material> getStock() {
		return Stock;
	}

	public void setStock(LinkedList<Material> stock) {
		Stock = stock;
	}

	@Override
	public String toString() {
		return "Deposito [Stock=" + Stock + "]";
	}

}
