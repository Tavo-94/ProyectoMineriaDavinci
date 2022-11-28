package proyectoMineria;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class AdminStock extends Usuario {

    Deposito depositoDeMateriales;
    Validaciones v = new Validaciones();
    
    public AdminStock(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
        super(nombreUsuario, clave, cargo, estadoActivo, mineria);
        // TODO Auto-generated constructor stub
    }
    
    public void agregarMaterial() {

        String material;
        String mensaje;
        
        mensaje=JOptionPane.showInputDialog("1-Agregar material al stock" //opcion del usuario
        		+ " \n2-Salir");
        
	        switch(Integer.parseInt(mensaje)) {
	        	
	        case 1:
	        	
	        	do {
	            material=JOptionPane.showInputDialog("Ingrese el tipo de material");
	     
	        	}while((Validaciones.validarTexto(material)!=true || material.length()<3));  //si el string es menor a 3 las letras y tiene valores especiales saldra error
		                  
	            break;
	            
	        case 2: break;
	        
	        
	        default: 
	        	System.out.println("Opcion invalida");
	        	
	        break;
	        
	        }
	        
        }
    
    public AdminStock(String nombreUsuario, String clave) {
		super(nombreUsuario, clave);
		// TODO Auto-generated constructor stub
		
		this.setCargo("stock");
	}

    public void mostrarTotalOro() {
        System.out.println(this.getDepositoDeMateriales().sumaTotalDeOro());
    }

    public void mostrarTotalPlata() {
        System.out.println(this.getDepositoDeMateriales().sumaTotalDePlata());
    }

    public void mostrarTotalCobre() {
        System.out.println(this.getDepositoDeMateriales().sumaTotalDeCobre());
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

    public Deposito getDepositoDeMateriales() {
        return depositoDeMateriales;
    }

    public void setDepositoDeMateriales(Deposito depositoDeMateriales) {
        this.depositoDeMateriales = depositoDeMateriales;
    }

    @Override
    public String toString() {
        return "AdminStock [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getNombreUsuario()="
                + getNombreUsuario() + ", getClave()=" + getClave() + ", getCargo()=" + getCargo()
                + ", getEstadoActivo()=" + getEstadoActivo() + ", getSessionActiva()=" + getSessionActiva()
                + ", getMineria()=" + getMineria() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}
