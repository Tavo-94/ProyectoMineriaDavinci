package proyectoMineria;

import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AdminStock extends Usuario {

    Deposito depositoDeMateriales;
    Validaciones v = new Validaciones();
    
    public AdminStock(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
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
