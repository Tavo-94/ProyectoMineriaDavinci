package proyectoMineria;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Deposito {
    
    private List<Material> listaMateriales;
    
    
    public Deposito() {
        super();
        this.listaMateriales = new ArrayList<>();
    }
    
    public void mostrarStock() {
        listaMateriales.forEach(System.out::println);
    }
    
    public void agregarStock(Usuario usuario, String tipo, Double pureza, Double cantidad) {
        if (this.validarCargo(usuario)) {
            listaMateriales.add(new Material(tipo, pureza, cantidad));
            System.out.println("Se Agrego Exitosamente!!!");
        }
    }

    private boolean validarCargo(Usuario usuario) {
        // TODO Auto-generated method stub
        return usuario.getCargo().equalsIgnoreCase("Stock");
    }

    public List<Material> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
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
}
