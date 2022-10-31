package proyectoMineria;

import java.util.Scanner;

import javax.swing.JOptionPane;

import negocio.AdminVentasDao;

public class Main {

    public static void main(String[] args) {
        
        //test conexion
        Mineria metalPlus = new Mineria("Metal plus");

        AdminSistema gus = new AdminSistema("Gus94", "456", "Admin", true, metalPlus);
        
        AdminVentas dani = new AdminVentas("daniBoy78", "1234", "Ventas", true, metalPlus);
        
        AdminVentasDao ventasDAO = new AdminVentasDao();
        
        //gus.crearUsuario();
        
        //gus.eliminarAdminVentas();
          
        //dani.nuevoTicket();
        
        ventasDAO.validarLoginVentas(dani);        
        /*
         * Scanner input = new Scanner(System.in);
         * 
         * Mineria metalPlus = new Mineria("Metal plus");
         * 
         * AdminSistema gus = new AdminSistema("Gus94", "456", "Admin", true,
         * metalPlus);
         * 
         * Deposito deposito = new Deposito();
         * 
         * AdminStock admin = new AdminStock("den", "1234", "Stock", true, metalPlus);
         * 
         * admin.setDepositoDeMateriales(deposito);
         * 
         * admin.agregarMaterial(input);
         * 
         * deposito.mostrarStock();
         * 
         * admin.agregarMaterial(input);
         * 
         * deposito.mostrarStock();
         * 
         * admin.mostrarTotalOro();
         * 
         * AdminVentas vendedor = new AdminVentas("ari", "1234", "ventas", true,
         * metalPlus);
         * 
         * vendedor.setDeposito(deposito);
         * 
         * vendedor.nuevoRegistroDeOperacion(input);
         * 
         * metalPlus.getListaClientes().forEach(System.out::println);
         * metalPlus.getListaDeOperaciones().forEach(System.out::println);
         * 
         * deposito.mostrarStock();
         * admin.mostrarTotalOro();
         */        
        
        /*
         * System.out.println("***************************");
         * System.out.println("Caso login y alta de usuarios");
         * System.out.println("***************************");
         * 
         * 
         * 
         * 
         * 
         * System.out.println(gus);
         * 
         * metalPlus.agregarAdmin(gus);
         * 
         * gus.darDeBaja(input);
         * 
         * System.out.println(gus);
         * 
         * gus.darDeAlta(input);
         * 
         * System.out.println(gus);
         * 
         * 
         * 
         * gus.loguearse(input);
         * 
         * metalPlus.getListaUsuariosAdmin().forEach(System.out::println);
         * 
         * gus.cambiarClave(input);
         * 
         * metalPlus.getListaUsuariosAdmin().forEach(System.out::println);
         * 
         * 
         * 
         * //creo 1er usuario gus.crearUsuario(input);
         * 
         * System.out.println("***************************");
         * System.out.println("Lista de Admins Stock");
         * System.out.println("***************************");
         * 
         * gus.getMineria().getListaUsuariosStock().forEach(System.out::println);
         * 
         * System.out.println("***************************");
         * System.out.println("Lista de Admins Ventas");
         * System.out.println("***************************");
         * 
         * gus.getMineria().getListaUsuariosVentas().forEach(System.out::println);
         * 
         * //Creo 2do usuario
         * 
         * gus.crearUsuario(input);
         * 
         * System.out.println("***************************");
         * System.out.println("Lista de Admins Stock");
         * System.out.println("***************************");
         * 
         * gus.getMineria().getListaUsuariosStock().forEach(System.out::println);
         * 
         * System.out.println("***************************");
         * System.out.println("Lista de Admins Ventas");
         * System.out.println("***************************");
         * 
         * gus.getMineria().getListaUsuariosVentas().forEach(System.out::println);
         * 
         * //creo 3er usuario
         * 
         * gus.crearUsuario(input);
         * 
         * System.out.println("***************************");
         * System.out.println("Lista de Admins Stock");
         * System.out.println("***************************");
         * 
         * gus.getMineria().getListaUsuariosStock().forEach(System.out::println);
         * 
         * System.out.println("***************************");
         * System.out.println("Lista de Admins Ventas");
         * System.out.println("***************************");
         * 
         * gus.getMineria().getListaUsuariosVentas().forEach(System.out::println);
         */

        //input.close();
    }

}
