package proyectoMineria;

import java.time.LocalDate;
import java.util.LinkedList;

public class TicketOperacion {

	LinkedList<TicketOperacion> Venta = new LinkedList<TicketOperacion>();
	
    private Double cantidadDeMaterialComprado = 0.0;
    private Material material;
    private Double precio;
    private Cliente cliente;
    private LocalDate fechaDeOperacion;
    private AdminVentas vendedor;

    
    
    
    
    public TicketOperacion(Material Material, Double costo, Double cantidadDeMaterialComprado, Double precio, Cliente cliente, AdminVentas vendedor) {
        super();
        this.cantidadDeMaterialComprado = cantidadDeMaterialComprado;
        this.material = Material;
        this.precio = precio;
        this.cliente = cliente;
        this.fechaDeOperacion = LocalDate.now();
        this.vendedor = vendedor;
    }
    
	public TicketOperacion(LinkedList<TicketOperacion> venta, LinkedList<Cliente> base,
			Double cantidadDeMaterialComprado, Material material, Double precio, Cliente cliente,
			LocalDate fechaDeOperacion, AdminVentas vendedor, Double costo) {
		super();
		Venta = venta;
		this.cantidadDeMaterialComprado = cantidadDeMaterialComprado;
		this.material = material;
		this.precio = precio;
		this.cliente = cliente;
		this.fechaDeOperacion = fechaDeOperacion;
		this.vendedor = vendedor;
	}

	public TicketOperacion() {
		// TODO Auto-generated constructor stub
	}

	public LinkedList<TicketOperacion> getVenta() {
		return Venta;
	}

	public void setVenta(LinkedList<TicketOperacion> venta) {
		Venta = venta;
	}

	public Double getCantidadDeMaterialComprado() {
		return cantidadDeMaterialComprado;
	}

	public void setCantidadDeMaterialComprado(Double cantidadDeMaterialComprado) {
		this.cantidadDeMaterialComprado = cantidadDeMaterialComprado;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaDeOperacion() {
		return fechaDeOperacion;
	}

	public void setFechaDeOperacion(LocalDate fechaDeOperacion) {
		this.fechaDeOperacion = fechaDeOperacion;
	}

	public AdminVentas getVendedor() {
		return vendedor;
	}

	public void setVendedor(AdminVentas vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "TicketOperacion [Venta=" + Venta + ", cantidadDeMaterialComprado="
				+ cantidadDeMaterialComprado + ", material=" + material + ", precio=" + precio
				+ ", cliente=" + cliente + ", fechaDeOperacion=" + fechaDeOperacion + ", vendedor=" + vendedor + "]";
	}

}
