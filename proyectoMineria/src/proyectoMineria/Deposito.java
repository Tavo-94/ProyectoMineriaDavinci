package proyectoMineria;
import java.util.LinkedList;
	
public class Deposito {
	
	public static void main(String[] args) {
		
		Double costo;
		AdminStock i1 = new AdminStock();
		i1.Login();
	}
	
	LinkedList<Material> Stock = new LinkedList<Material>();
	
	public boolean add(Material material) {
		 char [] letras = material.getTipo().toCharArray();
		 if (letras.length >= 3 && letras.length <= 15) {
			material.getCantidad();
			if(material.getCantidad()> 0d || material.getCantidad()== null);
			material.getPureza();
			if(material.getPureza() < 0d || material.getPureza() > 100d);
			if (material.tipo.equals("oro"));
	        	if (material.getPureza()<=100|| material.getPureza()>=70) {
	        		double costo = material.getCantidad() * 100000;
	        		material.getPrecio();
	       		}
	       		if (material.getPureza()<=69|| material.getPureza()>=40) {
	       			double costo = material.getCantidad() * 75000;
	       			material.getPrecio();
	       		}
	       		else {
	       			double costo = material.getCantidad() * 75000;
	       			material.getPrecio();
	       		}
			return true;
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
	
		/*private List<Material> listaMaterial;
		
		public Deposito() {
			super();
			this.listaMaterial = new ArrayList<>();
		}
		
		public void agregarStock(String tipo, Double pureza, Double cantidad, Double precio) {
			listaMaterial.add(new Material(tipo, pureza, cantidad, precio, null));
			System.out.println("Se Agrego Exitosamente!!!");
			listaMaterial.add(listaMaterial);
		}
		
		
		public List<Material> getListMaterial() {
			return listaMaterial;
		}
		public void setListMaterial(List<Material> listMaterial) {
			this.listaMaterial = listMaterial;
		}*/

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
