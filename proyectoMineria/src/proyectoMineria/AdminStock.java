package proyectoMineria;

import java.time.LocalDate;
import java.util.Scanner;

public class AdminStock extends Usuario {

    Deposito depositoDeMateriales;

    public AdminStock(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
        super(nombreUsuario, clave, cargo, estadoActivo, mineria);
        // TODO Auto-generated constructor stub
    }

    public void agregarMaterial(Scanner inputDelUsuario) {
        String tipo;
        Double pureza;
        Double cantidad;
        LocalDate fecha;

        System.out.println("ingresar tipo de material");
        do {
            tipo = inputDelUsuario.next();
            
        } while (tipo.isBlank() || tipo.isEmpty());

        System.out.println("ingresar pureza");
        do {
            pureza = inputDelUsuario.nextDouble();
        } while (pureza < 0d || pureza > 100d);

        System.out.println("ingresar cantidad");
        do {
            cantidad = inputDelUsuario.nextDouble();
        } while (cantidad < 0d || cantidad == null);

        this.getDepositoDeMateriales().agregarStock(this, tipo, pureza, cantidad);

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
