package proyectoMineria;

import java.util.Scanner;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private String nombreUsuario; //Clave primaria de la clase
	private String clave;
	private String cargo;
	private Mineria mineria;
	private Boolean estadoActivo;
	private Boolean sessionActiva;
	
	
	
	
	
	public Usuario(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.cargo = cargo;
		this.estadoActivo = estadoActivo;
		this.sessionActiva = false;
		this.mineria = mineria;
	}
	public abstract void loguearse(Scanner inputDelUsuario);
	public abstract void cambiarClave(Scanner inputUsuario);
	public abstract void cerrarSesion();
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Boolean getEstadoActivo() {
		return estadoActivo;
	}
	public void setEstadoActivo(Boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}
	public Boolean getSessionActiva() {
		return sessionActiva;
	}
	public void setSessionActiva(Boolean sessionActiva) {
		this.sessionActiva = sessionActiva;
	}
	public Mineria getMineria() {
		return mineria;
	}
	public void setMineria(Mineria mineria) {
		this.mineria = mineria;
	}
	public void loguearse(Scanner inputDelUsuario, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
    public boolean validarCargoVentas() {
        // TODO Auto-generated method stub
        return getCargo().equalsIgnoreCase("Ventas");
    }
    
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario=" + nombreUsuario + ", clave="
				+ clave + ", cargo=" + cargo + ", mineria=" + mineria + ", estadoActivo=" + estadoActivo
				+ ", sessionActiva=" + sessionActiva + "]";
	}
	
	
	
	
	
}
