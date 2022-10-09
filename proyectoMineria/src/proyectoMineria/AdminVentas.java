package proyectoMineria;

import java.util.Scanner;

public class AdminVentas extends Usuario {

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


	@Override
	public String toString() {
		return "AdminVentas [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getNombreUsuario()="
				+ getNombreUsuario() + ", getClave()=" + getClave() + ", getCargo()=" + getCargo()
				+ ", getEstadoActivo()=" + getEstadoActivo() + ", getSessionActiva()=" + getSessionActiva()
				+ ", getMineria()=" + getMineria() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	



	
	

	

}
