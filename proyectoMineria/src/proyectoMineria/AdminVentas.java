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

	 Validaciones v = new Validaciones();
	
    Deposito deposito;

    public AdminVentas(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
        super(nombreUsuario, clave, cargo, estadoActivo, mineria);
        // TODO Auto-generated constructor stub
    }
    
    
    
    
    
    

    public AdminVentas(String nombreUsuario, String clave) {
		super(nombreUsuario, clave);
		super.setCargo("ventas");
		
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
        
        listaDeMateriales = materialDAO.visualizarStock();
        
        System.out.println(" Tipo | Pureza | Cantidad | Precio |");
        for (Material material : listaDeMateriales) {
            System.out.println(material.getTipo() + "   |   " + material.getPureza()  + "   |   " +material.getCantidad() + "   |   " + material.getPrecioBase());
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
        String pureza;
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

        } while ((Validaciones.validarTexto(nombre)!=true || v.validacionTextoVacio(nombre)!=true));

        System.out.println("Ingresar apellido del cliente");
        do {
            apellido = JOptionPane.showInputDialog("Ingresar apellido del cliente");

        } while ((Validaciones.validarTexto(apellido)!=true || v.validacionTextoVacio(apellido)!=true));
        
        do {
            telefono = JOptionPane.showInputDialog("Ingresar telefono del cliente");
            
        } while ((v.validacionNumerosVacios(telefono)));

        //creo instancia de cliente para luego almacenarlo en la DB
        Cliente nuevoCliente = new Cliente(nombre, apellido, esMayorista, telefono);
        
        // agregamos cliente a la lista de la mineria (DAO cliente)
        ClienteDAO clienteDAO = new ClienteDAO();
        
        clienteDAO.agregarNuevoCliente(nuevoCliente, this);
        
        idCliente = clienteDAO.obtenerUltimoIDDeCliente();
        
        nuevoCliente.setIdCliente(idCliente);

        //INGRESO DATOS DE DIRECCION
        do {
            calle = JOptionPane.showInputDialog("Ingresar calle");

        } while ((v.validacionTextoVacio(calle)!=true));
        do {
            altura = JOptionPane.showInputDialog("Ingresar altura");

        } while ((v.validacionTextoVacio(altura)!=true));
        do {
            codigoPostal = JOptionPane.showInputDialog("Ingresar codigo postal");

        } while ((v.validacionNumerosVacios(codigoPostal)!=true || v.validacionCodPostal(codigoPostal)!=true));
        do {
            ciudad = JOptionPane.showInputDialog("Ingresar ciudad");

        } while ((v.validacionTextoVacio(ciudad)!=true));
        
        
        //Creo nueva Direccion y la agrego a la DB
        DireccionCliente nuevaDireccion = new DireccionCliente(calle, altura, codigoPostal, ciudad);
        
        nuevaDireccion.setIdCliente(idCliente);
        
        DireccionDAO direccionDao = new DireccionDAO();
        
        direccionDao.agregarNuevadireccion(nuevaDireccion);

        
        //INGRESO DATOS DEL MATERIAL

        do {
            tipoDeMaterial = JOptionPane.showInputDialog("Ingresar tipo del material");
        } while (v.validacionTextoVacio(tipoDeMaterial)!=true);
        
        cantMaterial = Double.parseDouble(JOptionPane.showInputDialog("ingresar Cantidad Requerida"));
        
        Object[] opcionPureza = {"alta", "media", "baja"};
        pureza = (String) JOptionPane.showInputDialog(null, "Ingresar pureza del material", "pureza", JOptionPane.DEFAULT_OPTION, null, opcionPureza, opcionPureza[0]);
        
        
        //Creo nuevo Material del pedido y los ingreso en la DB
        Material materialComprado = new Material(tipoDeMaterial, pureza, cantMaterial);
        
        MaterialDAO materialDAO = new MaterialDAO();
        
        materialDAO.agregarNuevoMaterialPedido(materialComprado);
        
        idMaterial = materialDAO.obtenerUltimoIDMaterialPedido();
        
        materialComprado.setIdMaterial(idMaterial);

        //creamos nuevo ticket
        TicketOperacion nuevoTicketPedido = new TicketOperacion(nuevoCliente, this, materialComprado);
   
        //calculo del TOTAL
            
        if (materialComprado.getPureza().equalsIgnoreCase("alta")) {
            total = materialComprado.getPrecioBase() * materialComprado.getCantidad() * materialComprado.getCoeficientePurezaAlta();
        } else if (materialComprado.getPureza().equalsIgnoreCase("media")) {
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
