package proyectoMineria;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AdminStock extends Usuario {
	Validaciones v = new Validaciones();
    Deposito depositoDeMateriales;

    public AdminStock(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
        super(nombreUsuario, clave, cargo, estadoActivo, mineria);
        // TODO Auto-generated constructor stub
    }

    public void agregarMaterial() {
    	
    	String material;
        String pureza;
        String mensaje;
        String cantidad;

        mensaje=JOptionPane.showInputDialog("1-Agregar material al stock" //opcion del usuario
        		+ " \n2-Salir");
        
	        switch(Integer.parseInt(mensaje)) {
	        	
	        case 1:
	        	
				do {
	            material=JOptionPane.showInputDialog("Ingrese el tipo de material");
	     
	        	}while((v.validarTexto(material)!=true ));  //si el string es menor a 3 las letras y tiene valores especiales saldra error
		          
	        	System.out.println("ingresar pureza");
	            do {
	                pureza = JOptionPane.showInputDialog("Ingresar pureza");
	            } while (v.validacionNumerosVacios(pureza)!=true);
	            do {
	            	
	            	cantidad = JOptionPane.showInputDialog("Ingresar cantidad");
	            }while(v.validarCantidad(cantidad)!=true);
	            break;
	            
	        case 2: break;
	        
	        
	        default: 
	        	System.out.println("Opcion invalida");
	        	
	        break;
	        
	        }
	        
        }  
       /* String tipo;
        Double pureza;
        Double cantidad;
        Double precio;
        LocalDate fecha;
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingresar tipo de material");
        do {
            tipo = entrada.next();
            
        } while (v.validarTexto(tipo)!=true);

        System.out.println("ingresar pureza");
        do {
            pureza = entrada.nextDouble();
        } while (pureza < 0d || pureza > 100d);

        System.out.println("ingresar cantidad");
        do {
            cantidad = entrada.nextDouble();
        } while (cantidad < 0d || cantidad == null);

        System.out.println("ingresar precio");
        do {
            precio = entrada.nextDouble();
        } while (precio < 0d || precio == null);
        
        this.getDepositoDeMateriales().agregarStock(this, tipo, pureza, cantidad, precio);
*/
    

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
