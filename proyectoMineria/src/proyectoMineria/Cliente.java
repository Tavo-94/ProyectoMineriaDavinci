package proyectoMineria;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	List<Cliente>listaClientes;
	private String nombre;
	private String apellido;
	private String dni;

	
	
	public Cliente(String nombre,String apellido,String dni) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;

        this.listaClientes = new ArrayList<>();

	}


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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	
	public void agregarRegistroCliente(Usuario usuario,String nombre,String apellido,String dni) {
		
	    if (usuario.validarCargoVentas()) {
	    	
            listaClientes.add(new Cliente(nombre,apellido, dni));
            System.out.println("Cliente registrado");
     

        }
		
	}

}
