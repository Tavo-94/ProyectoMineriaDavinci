package proyectoMineria;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Deposito {
    
    private List<Material> listaMateriales;
    private Double totalDeOro = 0d;
    private Double totalDePlata = 0d;
    private Double totalDeCobre = 0d;
    
    public Deposito() {
        super();
        this.listaMateriales = new ArrayList<>();
    }
    
    public void mostrarStock() {
        listaMateriales.forEach(System.out::println);
    }
    
    public void agregarStock(Usuario usuario, String tipo, Double pureza, Double cantidad, Double precio) {
        if (this.validarCargo(usuario)) {
            listaMateriales.add(new Material(tipo, pureza, cantidad, precio));
            System.out.println("Se Agrego Exitosamente!!!");
            if (tipo.equalsIgnoreCase("oro")) {
                this.totalDeOro += cantidad;
            }
            if (tipo.equalsIgnoreCase("plata")) {
                this.totalDePlata += cantidad;
            }
            if (tipo.equalsIgnoreCase("cobre")) {
                this.totalDeCobre += cantidad;
            }
        }
    }

    private boolean validarCargo(Usuario usuario) {
        // TODO Auto-generated method stub
        return usuario.getCargo().equalsIgnoreCase("Stock");
    }


    public Double sumaTotalDeOro() {
        
        return this.listaMateriales.stream().filter(m -> m.getTipo().equalsIgnoreCase("oro")).mapToDouble(m -> m.getCantidad()).sum() ;
        
    }

    public Double sumaTotalDePlata() {
        // TODO Auto-generated method stub
        return this.listaMateriales.stream().filter(m -> m.getTipo().equalsIgnoreCase("plata")).mapToDouble(m -> m.getCantidad()).sum() ;
    }

    public Double sumaTotalDeCobre() {
        // TODO Auto-generated method stub
        return this.listaMateriales.stream().filter(m -> m.getTipo().equalsIgnoreCase("cobre")).mapToDouble(m -> m.getCantidad()).sum() ;
    }
    
    //getters y setters
    
    public List<Material> getListaMateriales() {
        return listaMateriales;
    }
    
    public void setListaMateriales(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public Double getTotalDeOro() {
        return totalDeOro;
    }

    public void setTotalDeOro(Double totalDeOro) {
        this.totalDeOro = totalDeOro;
    }

    public Double getTotalDePlata() {
        return totalDePlata;
    }

    public void setTotalDePlata(Double totalDePlata) {
        this.totalDePlata = totalDePlata;
    }

    public Double getTotalDeCobre() {
        return totalDeCobre;
    }

    public void setTotalDeCobre(Double totalDeCobre) {
        this.totalDeCobre = totalDeCobre;
    }
    
}
