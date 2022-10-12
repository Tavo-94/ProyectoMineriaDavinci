package proyectoMineria;

import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AdminVentas extends Usuario {

    Deposito deposito;
    Cliente registroClientes;

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

    public void nuevoRegistroDeOperacion(Scanner inputRegistro) {

        String nombre;
        String apellido;
        String dni;// Clave primaria
        String cantMaterial = "";
        Double totalDeVenta;
        Boolean esMayorista = null;
        Cliente cliente;

        System.out.println("Ingresar nombre del cliente");
        do {
            nombre = inputRegistro.next();

        } while (nombre.isBlank() || nombre.isEmpty());

        System.out.println("Ingresar apellido del cliente");
        do {
            apellido = inputRegistro.next();

        } while (apellido.isBlank() || apellido.isEmpty());

        System.out.println("Ingresar dni");
        do {
            dni = inputRegistro.next();

        } while (dni.isBlank() || dni.isEmpty());

        System.out.println("Ingresar tipo de material");

        final String material = inputRegistro.next();

        if (material.equalsIgnoreCase("ORO")) {
            System.out.println("Ingresar cantidad vendida");
            do {
                cantMaterial = inputRegistro.next();

            } while (Double.parseDouble(cantMaterial) < 0d || cantMaterial == null
                    || Double.parseDouble(cantMaterial) > deposito.getTotalDeOro());

            deposito.setTotalDeOro(deposito.getTotalDeOro() - Double.parseDouble(cantMaterial));

        }
        if (material.equalsIgnoreCase("PLATA")) {
            System.out.println("Ingresar cantidad vendida");
            do {
                cantMaterial = inputRegistro.next();

            } while (Double.parseDouble(cantMaterial) < 0d || cantMaterial == null
                    || Double.parseDouble(cantMaterial) > deposito.getTotalDePlata());

            deposito.setTotalDeOro(deposito.getTotalDeOro() - Double.parseDouble(cantMaterial));

        }
        if (material.equalsIgnoreCase("COBRE")) {
            System.out.println("Ingresar cantidad vendida");
            do {
                cantMaterial = inputRegistro.next();

            } while (Double.parseDouble(cantMaterial) < 0d || cantMaterial == null
                    || Double.parseDouble(cantMaterial) > deposito.getTotalDeCobre());

            deposito.setTotalDeOro(deposito.getTotalDeOro() - Double.parseDouble(cantMaterial));

        }

        // Creamos nuevo cliente

        cliente = new Cliente(nombre, apellido, dni, esMayorista);

        // agregamos cliente a la lista de la mineria
        this.getMineria().getListaClientes().add(cliente);

        // totalizamos el precio (por ahora es el primedio de todos los precios de un
        // TIPO de material)

        Double precioDelMaterial = this.getDeposito().getListaMateriales().stream()
                .filter(mat -> mat.getTipo().equalsIgnoreCase(material))
                .collect(Collectors.averagingDouble(m -> m.getPrecio()));
        System.out.println(precioDelMaterial + " Precio del material");

        totalDeVenta = Double.parseDouble(cantMaterial) * precioDelMaterial;
        
        //aplico el descuento si es o no mayorista
        if (cliente.getEsMayorista()) {
            totalDeVenta = totalDeVenta * 0.9;
        }

        // Agregar operacion de venta a la lista

        this.getMineria().getListaDeOperaciones()
                .add(new TicketOperacion(Double.parseDouble(cantMaterial), totalDeVenta, cliente, this));
    }
    
    //pendiente descontar al total luego de cada nueva operacion segun el tipo de material

    public Cliente getRegistroCliente() {

        return registroClientes;
    }

    public void setRegistroCliente(Cliente registroClientes) {
        this.registroClientes = registroClientes;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public Cliente getRegistroClientes() {
        return registroClientes;
    }

    public void setRegistroClientes(Cliente registroClientes) {
        this.registroClientes = registroClientes;
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
