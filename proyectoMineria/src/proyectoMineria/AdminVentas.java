package proyectoMineria;

import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import negocio.ClienteDAO;
import negocio.DireccionDAO;

public class AdminVentas extends Usuario {

    Deposito deposito;

    public AdminVentas(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
        super(nombreUsuario, clave, cargo, estadoActivo, mineria);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void loguearse(Scanner inputUsuario) {
        // TODO Auto-generated method stub

    }

    @Override
    public void cambiarClave(Scanner inputUsuario) {
        // TODO Auto-generated method stub

    }

    @Override
    public void cerrarSesion() {
        // TODO Auto-generated method stub

    }

    public void visualizarStock() {
        this.getDeposito().mostrarStock();
    }

    public void nuevoTicket() {

        String nombre;
        String apellido;
        String dni;// Clave primaria
        Double cantMaterial = 0d;
        Double totalDeVenta;
        Boolean esMayorista = true;
        String calle;
        String altura;
        String codigoPostal;
        String ciudad;

        //creo cliente
        //creo materialComprado
        //creo ticket con Cliente, AdmminVentas, MaterialComprado
        //
        //INGRESO DATOS DEL CLIENTE
        System.out.println("Ingresar nombre del cliente");
        do {
            nombre = JOptionPane.showInputDialog("Ingresar nombre del cliente");

        } while (nombre.isBlank() || nombre.isEmpty());

        System.out.println("Ingresar apellido del cliente");
        do {
            apellido = JOptionPane.showInputDialog("Ingresar apellido del cliente");

        } while (apellido.isBlank() || apellido.isEmpty());

        System.out.println("Ingresar dni");
        do {
            dni = JOptionPane.showInputDialog("Ingresar DNI del cliente");

        } while (dni.isBlank() || dni.isEmpty());

        //INGRESO DATOS DE DIRECCION
        do {
            calle = JOptionPane.showInputDialog("Ingresar calle");

        } while (dni.isBlank() || dni.isEmpty());
        do {
            altura = JOptionPane.showInputDialog("Ingresar altura");

        } while (dni.isBlank() || dni.isEmpty());
        do {
            codigoPostal = JOptionPane.showInputDialog("Ingresar codigo postal");

        } while (dni.isBlank() || dni.isEmpty());
        do {
            ciudad = JOptionPane.showInputDialog("Ingresar ciudad");

        } while (dni.isBlank() || dni.isEmpty());
        
        //INGRESO DATOS DEL MATERIAL
        System.out.println("Ingresar tipo de material");

        String tipoDeMaterial = JOptionPane.showInputDialog("Ingresar tipo del material");
        
        cantMaterial = Double.parseDouble(JOptionPane.showInputDialog("ingresar Cantidad Requerida"));
        
        Double pureza = Double.parseDouble(JOptionPane.showInputDialog("ingresar la pureza"));
        
        //creo instacias de objetos
        
        Material materialComprado = new Material(tipoDeMaterial, pureza, cantMaterial);
        
        Cliente nuevoCliente = new Cliente(nombre, apellido, dni, esMayorista);

        DireccionCliente nuevaDireccion = new DireccionCliente(calle, altura, codigoPostal, ciudad);

        //agregamos direccion
        DireccionDAO direccionDao = new DireccionDAO();
        
        direccionDao.agregarNuevadireccion(nuevaDireccion);
        
        // agregamos cliente a la lista de la mineria (DAO cliente)
        ClienteDAO clienteDAO = new ClienteDAO();
        
        clienteDAO.agregarNuevoCliente(nuevoCliente, this, nuevaDireccion);
        
        //creamos nuevo ticket
        TicketOperacion nuevoTicket = new TicketOperacion(materialComprado, nuevoCliente, this);
   
        //calculo del TOTAL
        
        if (materialComprado.getPureza() >= 70 ) {
            totalDeVenta = materialComprado.getPrecio() * 2 * materialComprado.getCantidad();
        } else if (materialComprado.getPureza()>=50) {
            totalDeVenta = materialComprado.getPrecio() * 1.5 * materialComprado.getCantidad();
        } else {
            totalDeVenta = materialComprado.getPrecio() * materialComprado.getCantidad();
        }
        
        nuevoTicket.setTotal(totalDeVenta);
        
       

    }
    
    //pendiente descontar al total luego de cada nueva operacion segun el tipo de material

   

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }


    @Override
    public String toString() {
        return "AdminVentas [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getNombreUsuario()="
                + getNombreUsuario() + ", getClave()=" + getClave() + ", getCargo()=" + getCargo()
                + ", getEstadoActivo()=" + getEstadoActivo() + ", getSessionActiva()=" + getSessionActiva()
                + ", getMineria()=" + getMineria() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}
