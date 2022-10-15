package proyectoMineria;
import java.time.LocalDate;

public class Material {

	public String tipo;
	Double cantidad;
	Double pureza;
	Double precio;
	LocalDate fecha;
	
	public Material(String tipo, Double cantidad, Double pureza, Double precio, LocalDate fecha) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.pureza = pureza;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	public Material() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "material [tipo=" + tipo + ", cantidad=" + cantidad + ", pureza=" + pureza + ", precio=" + precio + ", fecha=" + fecha + "]";
	}
	
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	
}
