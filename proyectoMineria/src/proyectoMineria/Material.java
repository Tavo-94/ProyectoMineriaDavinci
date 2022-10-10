package proyectoMineria;

public class Material {
	
	String tipo;
	double pureza;
	double cantidad;
	
	public Material(String tipo,double pureza,double cantidad){
		this.tipo=tipo;
		this.pureza=pureza;
		this.cantidad=cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPureza() {
		return pureza;
	}

	public void setPureza(double pureza) {
		this.pureza = pureza;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public String mostrarDatos() {
		
		
		
		return "Materian: "+ getTipo()+" Pureza: "+getPureza()+ " Cantidad: "+getCantidad();
	}

}