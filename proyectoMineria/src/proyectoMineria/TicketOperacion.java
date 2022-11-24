package proyectoMineria;


import java.time.LocalDate;

public class TicketOperacion {

	private Cliente cliente;
    private LocalDate fechaDeOperacion;
    private AdminVentas vendedor;
    private Material materialComprado;
    private Double total;
    
	public TicketOperacion(Cliente cliente, LocalDate fechaDeOperacion, AdminVentas vendedor, Material materialComprado,
			Double total) {
		super();
		this.cliente = cliente;
		this.fechaDeOperacion = fechaDeOperacion;
		this.vendedor = vendedor;
		this.materialComprado = materialComprado;
		this.total = total;
	}
	public TicketOperacion(Material materialComprado2, Cliente nuevoCliente, AdminVentas adminVentas) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TicketOperacion [cliente=" + cliente + ", fechaDeOperacion=" + fechaDeOperacion + ", vendedor="
				+ vendedor + ", materialComprado=" + materialComprado + ", total=" + total + "]";
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
	public Material getMaterialComprado() {
		return materialComprado;
	}
	public void setMaterialComprado(Material materialComprado) {
		this.materialComprado = materialComprado;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
}
