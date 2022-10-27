package proyectoMineria;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class InterfazUI {
    
    private Mineria mineria;
    
    
    public void menuPrincipal() {
        String nombreDeUsuario;
        String clave;
        Usuario usuarioLogeado;
        AdminSistema usuarioSistema = null;
        AdminVentas usuarioVentas = null;
        AdminStock usuarioStock = null;
        
        do {
            nombreDeUsuario = JOptionPane.showInputDialog("Ingresar Nombre de Usuario:");
        } while (validarString(nombreDeUsuario));
        do {
            clave = JOptionPane.showInputDialog("Ingresar clave:");
        } while (validarString(clave));

        
        if (mineria.validarLogInSistema(nombreDeUsuario, clave) || mineria.validarLogInStock(nombreDeUsuario, clave) || mineria.validarLogInVentas(nombreDeUsuario, clave)) {

            if (mineria.validarLogInSistema(nombreDeUsuario, clave)) {
                usuarioSistema = mineria.usuarioAdminLogeado(nombreDeUsuario, clave);
            }
            if (mineria.validarLogInStock(nombreDeUsuario, clave)) {
                usuarioStock = mineria.usuarioStockLogeado(nombreDeUsuario, clave);
            }
            if (mineria.validarLogInVentas(nombreDeUsuario, clave)) {
                usuarioVentas = mineria.usuarioVentasLogeado(nombreDeUsuario, clave);
            }
            
            Integer seleccion = seleccionDelUsuario(usuarioSistema, usuarioVentas, usuarioStock);

            
            switch (seleccion) {
                case 0:
                    
                    break;

                default:
                    break;
            }
        }
        
    }
    
    private Integer seleccionDelUsuario(AdminSistema usuarioSistema, AdminVentas usuarioVentas, AdminStock usuarioStock) {
        
        Integer seleccion = 0;
        if (usuarioSistema != null) {
            Object[] opciones = {"Crear usuario Ventas", "Crear usuario Stock", "Inhabilitar Usuario", "Habilitar usuario", "Salir"};
            seleccion = JOptionPane.showOptionDialog(null, "Selecciona la operacion deseada", "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);
        }
        
        if (usuarioVentas != null) {
            Object[] opciones = {"Ingresar Material", "Mostrar total de stock", "Salir"};
            seleccion = JOptionPane.showOptionDialog(null, "Selecciona la operacion deseada", "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);
            
        }
        
        if (usuarioStock != null) {            
            Object[] opciones = {"Crear nueva venta","Mostrar balance de ventas", "Ver stock", "Salir"};
            seleccion = JOptionPane.showOptionDialog(null, "Selecciona la operacion deseada", "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);
        }
        
        return seleccion;
        
    }


    private boolean esUsuarioVentas(Usuario usuarioLogeado) {
        // TODO Auto-generated method stub
        return usuarioLogeado.getCargo().equalsIgnoreCase("ventas");
    }

    private boolean esUsuarioStock(Usuario usuarioLogeado) {
        // TODO Auto-generated method stub
        return usuarioLogeado.getCargo().equalsIgnoreCase("stock");
    }

    private boolean esUsuarioAdmin(Usuario usuarioLogeado) {
        // TODO Auto-generated method stub
        return usuarioLogeado.getCargo().equalsIgnoreCase("admin");
    }

    public Boolean logInSistema(String nombreDeUsuario, String clave) {
        
        return this.mineria.validarLogInSistema(nombreDeUsuario, clave);   
    }
    
    public Boolean validarString(String aValidar) {
        return aValidar.isBlank() || aValidar.isEmpty() || aValidar == null;     
    }
    
    
}
