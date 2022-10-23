package Datos;

import java.util.ArrayList;
import java.util.List;

public class Mineria {

	String nombre;
	private List<Usuario> listaUsuariosVentas;
	private List<Usuario> listaUsuariosStock;
	private List<Usuario> listaUsuariosAdmin;
    private List<Cliente> listaClientes;
    private List<TicketOperacion> listaDeOperaciones;
    
	
	
	public Mineria(String nombre) {
		super();
		this.nombre = nombre;
		this.listaUsuariosVentas = new ArrayList<>();
		this.listaUsuariosStock = new ArrayList<>();
		this.listaUsuariosAdmin = new ArrayList<>();
		this.listaClientes = new ArrayList<>();
		this.listaDeOperaciones = new ArrayList<>();
	}

	

	public void agregarAdmin(AdminSistema admin) {
		this.listaUsuariosAdmin.add(admin);
	}
	
	public void loguearse(String nombreUsuario, String clave) {
		// TODO Auto-generated method stub
		
		if (this.validarLogIn(nombreUsuario, clave)) {
			System.out.println("Log In exitoso");
			listaUsuariosAdmin.stream().filter(admin -> admin.getNombreUsuario().equals(nombreUsuario)).forEach(admin -> admin.setSessionActiva(true));
		} else {
			System.out.println("Credenciales invalidas");
		}
		
	}
	
	public Boolean validarLogIn(String nombreUsuario, String clave) {
		return listaUsuariosAdmin.stream().anyMatch(admin -> admin.getNombreUsuario().equals(nombreUsuario) && admin.getClave().equals(clave));
	}

	public void cambiarClave(String nombreUsuario, String claveNueva) {
		if (this.listaUsuariosAdmin.stream().anyMatch(admin -> admin.getNombreUsuario().equals(nombreUsuario))) {
			listaUsuariosAdmin.stream().filter(admin -> admin.getNombreUsuario().equals(nombreUsuario)).forEach(admin -> admin.setClave(claveNueva));;
		}
	}
	
	public List<Usuario> getListaUsuariosVentas() {
		return listaUsuariosVentas;
	}


	public void setListaUsuariosVentas(List<Usuario> listaUsuariosVentas) {
		this.listaUsuariosVentas = listaUsuariosVentas;
	}


	public List<Usuario> getListaUsuariosStock() {
		return listaUsuariosStock;
	}


	public void setListaUsuariosStock(List<Usuario> listaUsuariosStock) {
		this.listaUsuariosStock = listaUsuariosStock;
	}


	public List<Usuario> getListaUsuariosAdmin() {
		return listaUsuariosAdmin;
	}
	
	


	public List<Cliente> getListaClientes() {
        return listaClientes;
    }



    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }



    public void setListaUsuariosAdmin(List<Usuario> listaUsuariosAdmin) {
		this.listaUsuariosAdmin = listaUsuariosAdmin;
	}
    
    


	public List<TicketOperacion> getListaDeOperaciones() {
        return listaDeOperaciones;
    }



    public void setListaDeOperaciones(List<TicketOperacion> listaDeOperaciones) {
        this.listaDeOperaciones = listaDeOperaciones;
    }



    @Override
	public String toString() {
		return "Mineria [nombre=" + nombre + "]";
	}


	public void bajaUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		this.listaUsuariosAdmin.stream().filter(admin -> admin.getNombreUsuario().equals(nombreUsuario)).forEach(admin -> admin.setEstadoActivo(false));
	}


	public void altaUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		this.listaUsuariosAdmin.stream().filter(admin -> admin.getNombreUsuario().equals(nombreUsuario)).forEach(admin -> admin.setEstadoActivo(true));
	}





	
	
	
}
