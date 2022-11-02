package proyectoMineria;


import java.io.PrintStream;
import java.time.LocalDate;

public class TicketOperacion {

    
    private Cliente cliente;
    private LocalDate fechaDeOperacion;
    private AdminVentas vendedor;
    private Material materialComprado;
    private Double total;

    
    
    
    
    public TicketOperacion(Material materialComprado, Cliente cliente, AdminVentas vendedor) {
        super();
        this.materialComprado = materialComprado;
        this.cliente = cliente;
        this.fechaDeOperacion = LocalDate.now();
        this.vendedor = vendedor;
        this.total = 0d;
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

    //getters y setters
    
    

 




 


    
    
}
