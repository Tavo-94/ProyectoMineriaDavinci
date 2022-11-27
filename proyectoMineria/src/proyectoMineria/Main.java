package proyectoMineria;

import negocio.AdminStockDAO;
import negocio.AdminVentasDao;

public class Main {

    public static void main(String[] args) {
        
        //test conexion
        Mineria metalPlus = new Mineria("Metal plus");

        //AdminSistema gus = new AdminSistema("gus94", "456", "Admin", true, metalPlus);
        
       // AdminVentas dani = new AdminVentas("daniBoy78", "1234", "Ventas", true, metalPlus);
        
        AdminStockDAO den = new AdminStockDAO ("den", "1234", "Stock", true, metalPlus);
        
        //AdminVentasDao ventasDAO = new AdminVentasDao();
        
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
        
        
        //test del AdminStock
        
        //den.agregarMaterial(null);
        
        //den.mostrarStock();
        
        //den.mostrarStockTipo(null);
        
        //den.mostrarStockTipoPurezaAlta(null);
        
        //den.mostrarStockTipoPurezaMedia(null);
        
        //den.mostrarStockTipoPurezaBaja(null);
        
        //den.buscarMaterial(null, null);
        
        den.eliminarMaterial();
   
        

    }

}
