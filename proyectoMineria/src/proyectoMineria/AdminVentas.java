package proyectoMineria;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import negocio.ClienteDAO;
import negocio.DireccionDAO;
import negocio.MaterialDAO;
import negocio.TicketOperacionDAO;

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

    
    //faltaria implementar un JTable o en un OptionPane para mostrar los datos
    public void visualizarStock() {

        MaterialDAO materialDAO = new MaterialDAO();
        
        ArrayList<Material> listaDeMateriales = new ArrayList<>();
        
        listaDeMateriales= materialDAO.visualizarStock();
        
        for (Material material : listaDeMateriales) {
            System.out.println(material.getTipo() + " | " + material.getCantidad() + " | " + material.getPureza() + " | " + material.getPrecioBase());
        }
    }
    
    public void visualizarOperacionesDeVenta() {
        TicketOperacionDAO ticketDAO = new TicketOperacionDAO();
        
        ticketDAO.mostrarTodasLasOperaciones();
    }  

    public void nuevoTicket() {

        //datos del cliente 
        String nombre;
        String apellido;
        String telefono;
        
        //Datos del material vendido
        Integer idMaterial;
        String tipoDeMaterial;
        Double pureza;
        Double cantMaterial = 0d;
        Double totalDeVenta;
        Boolean esMayorista = true;
        
        //Datos de la direccion
        String calle;
        String altura;
        String codigoPostal;
        String ciudad = null;
        Integer idCliente = null;
        
        //datos del pedido
        Double total;

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
        
        do {
            telefono = JOptionPane.showInputDialog("Ingresar telefono del cliente");
            
        } while (telefono.isBlank() || telefono.isEmpty());

        //creo instancia de cliente para luego almacenarlo en la DB
        Cliente nuevoCliente = new Cliente(null, nombre, apellido, ciudad, esMayorista, telefono, idCliente);
        
        // agregamos cliente a la lista de la mineria (DAO cliente)
        ClienteDAO clienteDAO = new ClienteDAO();
        
        clienteDAO.agregarNuevoCliente(nuevoCliente, this);
        
        idCliente = clienteDAO.obtenerUltimoIDDeCliente();
        
        nuevoCliente.setIdCliente(idCliente);

        //INGRESO DATOS DE DIRECCION
        do {
            calle = JOptionPane.showInputDialog("Ingresar calle");

        } while (calle.isBlank() || calle.isEmpty());
        do {
            altura = JOptionPane.showInputDialog("Ingresar altura");

        } while (altura.isBlank() || altura.isEmpty());
        do {
            codigoPostal = JOptionPane.showInputDialog("Ingresar codigo postal");

        } while (codigoPostal.isBlank() || codigoPostal.isEmpty());
        do {
            ciudad = JOptionPane.showInputDialog("Ingresar ciudad");

        } while (ciudad.isBlank() || ciudad.isEmpty());
        
        
        //Creo nueva Direccion y la agrego a la DB
        DireccionCliente nuevaDireccion = new DireccionCliente(calle, altura, codigoPostal, ciudad);
        
        nuevaDireccion.setIdCliente(idCliente);
        
        DireccionDAO direccionDao = new DireccionDAO();
        
        direccionDao.agregarNuevadireccion(nuevaDireccion);

        
        //INGRESO DATOS DEL MATERIAL

        tipoDeMaterial = JOptionPane.showInputDialog("Ingresar tipo del material");
        
        cantMaterial = Double.parseDouble(JOptionPane.showInputDialog("ingresar Cantidad Requerida"));
        
        pureza = Double.parseDouble(JOptionPane.showInputDialog("ingresar la pureza"));
        
        //Creo nuevo Material del pedido y los ingreso en la DB
        Material materialComprado = new Material(tipoDeMaterial, pureza, cantMaterial);
        
        MaterialDAO materialDAO = new MaterialDAO();
        
        materialDAO.agregarNuevoMaterialPedido(materialComprado);
        
        idMaterial = materialDAO.obtenerUltimoIDMaterialPedido();
        
        materialComprado.setIdMaterial(idMaterial);

        //creamos nuevo ticket
        TicketOperacion nuevoTicketPedido = new TicketOperacion(materialComprado, nuevoCliente, this);
   
        //calculo del TOTAL
            
        if (materialComprado.getPureza() >= 70 ) {
            total = materialComprado.getPrecioBase() * materialComprado.getCantidad() * materialComprado.getCoeficientePurezaAlta();
        } else if (materialComprado.getPureza()>=50) {
            total = materialComprado.getPrecioBase() * materialComprado.getCantidad() * materialComprado.getCoeficientePurezaMedia();
        } else {
            total = materialComprado.getPrecioBase() * materialComprado.getCantidad() * materialComprado.getCoeficientePurezaBaja();
        }
        
        nuevoTicketPedido.setTotal(total);
        
        TicketOperacionDAO ticketOperacionDAO = new TicketOperacionDAO();
        
        ticketOperacionDAO.agregarNuevoTicketOperacionDelPedido(nuevoTicketPedido, this, nuevoCliente, materialComprado);
        
        //elimino los registros necesarios del deposito para reflejar la venta realizada
        materialDAO.eliminarMaterialCompradoDeLaTablaMaterial(materialComprado);

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
