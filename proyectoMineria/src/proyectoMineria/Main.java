package proyectoMineria;

import java.util.Scanner;

import javax.swing.JOptionPane;

import interfazWindowBuilder.PantallaPrincipal;
<<<<<<< HEAD
import interfazWindowBuilder.mainpantalla;
=======
>>>>>>> prueba
import negocio.AdminVentasDao;

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        
        mainpantalla pantalla = new mainpantalla();
        pantalla.run();
        System.out.println("pantalla principal");
        
        //test conexion
        Mineria metalPlus = new Mineria("Metal plus");

        AdminSistema gus = new AdminSistema("Gus94", "456", "Admin", true, metalPlus);
        
        AdminVentas dani = new AdminVentas("daniBoy78", "1234", "Ventas", true, metalPlus);
        
        AdminVentasDao ventasDAO = new AdminVentasDao();
        
        //tests del AdminSistema
        
        // Funcional
        //gus.crearUsuario();
        
        // Funcional        
        //gus.eliminarAdminVentas();
        
        // Funcional
        //gus.eliminarAdminStock();
        
        
        
        //tests del AdminVentas
        
        //Es funcional
        //dani.nuevoTicket();
        
        //Es funcional
        //dani.visualizarStock();
        
        //Es funcional
        //dani.visualizarOperacionesDeVenta();
        
        //test Validacion del LogIn ventas
        
          if (ventasDAO.validarLoginVentas(dani)) {
          JOptionPane.showMessageDialog(null, "Login Exitoso", "Validacion LogIn",
          JOptionPane.INFORMATION_MESSAGE);
          } else {
          JOptionPane.showMessageDialog(null, "Error, volver a intentarlo",
          "Validacion LogIn", JOptionPane.WARNING_MESSAGE);
          }
         
                
        
=======
    	
    	PantallaPrincipal app = new PantallaPrincipal();
    	app.Aplicacion();
       
>>>>>>> prueba

    }

}
