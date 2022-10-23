package proyectoMineria;
import java.time.LocalDate;
import java.util.LinkedList;

public class TicketOperacion {

	LinkedList<TicketOperacion> Venta = new LinkedList<TicketOperacion>();
	LinkedList<Cliente> Base = new LinkedList<Cliente>();
	
    private Double cantidadDeMaterialComprado = 0.0;
    private Material material;
    private double total; //descuento
    private Double precio;
    private Cliente cliente;
    private LocalDate fechaDeOperacion;
    private AdminVentas vendedor;

    
    
    
    
    public TicketOperacion(Double cantidadDeMaterialComprado, Cliente cliente, AdminVentas vendedor, Double precio, Material Material) {
        super();
        this.cantidadDeMaterialComprado = cantidadDeMaterialComprado;
        this.material = Material;
        this.precio = precio;
        this.cliente = cliente;
        this.fechaDeOperacion = LocalDate.now();
        this.vendedor = vendedor;
    }
    
    public void add(TicketOperacion ticket) {
    	cliente.getDni();
    	ticket.getCantidadDeMaterialComprado();
	if(ticket.getCantidadDeMaterialComprado()!=0) {
    	material.getTipo();
    	if (material.tipo.equals("oro"));{
        	if (material.getPureza()<=100 && material.getPureza()>=70) {
        		double costo = ticket.getCantidadDeMaterialComprado() * 100000;
        		ticket.setPrecio (costo);
        		}
        		if (material.getPureza()<=69 && material.getPureza()>=40) {
       			double costo = ticket.getCantidadDeMaterialComprado() * 75000;
       			ticket.setPrecio(costo);
       			}
       			if (material.getPureza()<=49 && material.getPureza()>=10) {
       			double costo = ticket.getCantidadDeMaterialComprado() * 5000;
       			ticket.setPrecio(costo);
       			}
       		}
		if (material.tipo.equals("cobre"));{
        	if (material.getPureza()<=100 && material.getPureza()>=70) {
        		double costo = ticket.getCantidadDeMaterialComprado() * 1000;
        		ticket.setPrecio(costo);
        		}
        		if (material.getPureza()<=69 && material.getPureza()>=40) {
       			double costo = ticket.getCantidadDeMaterialComprado() * 750;
       			ticket.setPrecio(costo);
       			}
       			if (material.getPureza()<=49 && material.getPureza()>=10) {
       			double costo = ticket.getCantidadDeMaterialComprado() * 500;
       			ticket.setPrecio(costo);
       			}
       		}
		if (cliente.getEsMayorista()== true) {
			double Ctotal = 0.8 * ticket.getPrecio();
			ticket.setTotal(Ctotal);
			}
		ticket.setTotal(ticket.getPrecio());
		}
    }

	public TicketOperacion(LinkedList<TicketOperacion> venta, LinkedList<Cliente> base,
			Double cantidadDeMaterialComprado, Material material, double total, Double precio, Cliente cliente,
			LocalDate fechaDeOperacion, AdminVentas vendedor) {
		super();
		Venta = venta;
		Base = base;
		this.cantidadDeMaterialComprado = cantidadDeMaterialComprado;
		this.material = material;
		this.total = total;
		this.precio = precio;
		this.cliente = cliente;
		this.fechaDeOperacion = fechaDeOperacion;
		this.vendedor = vendedor;
	}

	public LinkedList<TicketOperacion> getVenta() {
		return Venta;
	}

	public void setVenta(LinkedList<TicketOperacion> venta) {
		Venta = venta;
	}

	public LinkedList<Cliente> getBase() {
		return Base;
	}

	public void setBase(LinkedList<Cliente> base) {
		Base = base;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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
		return "TicketOperacion [Venta=" + Venta + ", Base=" + Base + ", cantidadDeMaterialComprado="
				+ cantidadDeMaterialComprado + ", material=" + material + ", total=" + total + ", precio=" + precio
				+ ", cliente=" + cliente + ", fechaDeOperacion=" + fechaDeOperacion + ", vendedor=" + vendedor + "]";
	}
}
