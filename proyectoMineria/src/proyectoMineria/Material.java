package proyectoMineria;

public class Material {

	public String tipo;
	Double cantidad;
	Double pureza;
	Double fecha;
	
	public Material(String tipo, Double cantidad, Double pureza, Double fecha) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.pureza = pureza;
		this.fecha = fecha;
	}
	
	public Material() {
		// TODO Auto-generated constructor stub
	} 

	@Override
	public String toString() {
		return "material [tipo=" + tipo + ", cantidad=" + cantidad + ", pureza=" + pureza + ", fecha=" + fecha + "]";
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public Double getPureza() {
		return pureza;
	}

	public void setPureza(Double pureza) {
		this.pureza = pureza;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public double getFecha() {
		return fecha;
	}

	public void setFecha(Double fecha) {
		this.fecha = fecha;
	}
	
	
	
}
