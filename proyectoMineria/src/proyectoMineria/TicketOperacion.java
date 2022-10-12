package proyectoMineria;


import java.io.PrintStream;
import java.time.LocalDate;

public class TicketOperacion {

    private Double cantidadDeMaterialComprado = 0.0;
    
    private double valorPromo = 0.0; //descuento
    private Double montoAbonado = 0.0;
    private Cliente cliente;
    private LocalDate fechaDeOperacion;
    private AdminVentas vendedor;

    
    
    
    
    public TicketOperacion(Double cantidadDeMaterialComprado, Double montoAbonado, Cliente cliente, AdminVentas vendedor) {
        super();
        this.cantidadDeMaterialComprado = cantidadDeMaterialComprado;
        this.montoAbonado = montoAbonado;
        this.cliente = cliente;
        this.fechaDeOperacion = LocalDate.now();
        this.vendedor = vendedor;
    }

    //excepcion si los parametros son ilegales
    public void Alerta(double cantidadDeMaterialComprado, double valor, double valorPromo, double montoAbonado) {
        if(cantidadDeMaterialComprado <= 0.0) {
            throw new IllegalArgumentException("Cantidad de material tiene que ser un numero positivo.");
        }
        if(valor <= 0.0){
            throw new IllegalArgumentException("Valor tiene que ser un numero positivo.");
        }
        if(valorPromo <= 0.0){
            throw new IllegalArgumentException("Valor tiene que ser un numero positivo.");
        }
        if(montoAbonado <= 0.0) {
            throw new IllegalArgumentException("Valor tiene que ser un numero positivo.");
        }
    }

    //getters y setters CantidadDeMaterialComprado
    public double getCantidadDeMaterialComprado() {
        return cantidadDeMaterialComprado;
    }
    public void setCantidadDeMaterialComprado(double cantidadDeMaterialComprado) {
        this.cantidadDeMaterialComprado = cantidadDeMaterialComprado;
    }



    //getters y setters ValorPromo
    public double getValorPromo() {
        return valorPromo;
    }
    public void setValorPromo(double valorPromo) {
        this.valorPromo = valorPromo;
    }

    //getters y setters MontoAbonado
    public double getMontoAbonado() {
        return montoAbonado;
    }
    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }

 




    public double materialPromo(String fecha,int n) {
        valorPromo+=getValorPromo()*n;
        System.out.println(fecha+"\t"+"P\t"+n+"\t"+getValorPromo()+"\t"+(getValorPromo()*n)+"\n");
        return getValorPromo()*n;
    }

    //imprime en consola el resumen de ventas
    public void resumen() {
        PrintStream p = System.out;
        p.println("\t\t\tMINERIA\n");
        p.println("Fecha\t\tTipo\tCant.\tValor\tSubtotal");
        p.println("\t\tTotal Material comprado:\t"+totalMaterial());
        p.println("\t\tTotal Material Promo :\t"+totalMaterialPromo());
        p.println("\t\tTotal General :\t"+total());
    }
    public double total() {
        return totalMaterial()+totalMaterialPromo();
    }
    public double totalMaterial() {
        return cantidadDeMaterialComprado;
    }
    public double totalMaterialPromo() {
        return valorPromo;
    }

    @Override
    public String toString() {
        return "TicketOperacion [cantidadDeMaterialComprado=" + cantidadDeMaterialComprado + ", valorPromo="
                + valorPromo + ", montoAbonado=" + montoAbonado + ", cliente=" + cliente + ", fechaDeOperacion="
                + fechaDeOperacion + ", vendedor=" + vendedor + "]";
    }
    
    
}
