package proyectoMineria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class Mineria {

	String nombre;
	private List<AdminVentas> listaUsuariosVentas;
	private List<AdminStock> listaUsuariosStock;
	private List<AdminSistema> listaUsuariosAdmin;
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
		
		if (this.validarLogInSistema(nombreUsuario, clave)) {
			System.out.println("Log In exitoso");
			listaUsuariosAdmin.stream().filter(admin -> admin.getNombreUsuario().equals(nombreUsuario)).forEach(admin -> admin.setSessionActiva(true));
		} else {
			System.out.println("Credenciales invalidas");
		}
		
	}
	
	public Boolean validarLogInSistema(String nombreUsuario, String clave) {
		return listaUsuariosAdmin.stream().anyMatch(admin -> admin.getNombreUsuario().equals(nombreUsuario) && admin.getClave().equals(clave));
	}
	
	public Boolean validarLogInVentas(String nombreUsuario, String clave) {
        return listaUsuariosVentas.stream().anyMatch(ventas -> ventas.getNombreUsuario().equals(nombreUsuario) && ventas.getClave().equals(clave));
	}
	public Boolean validarLogInStock(String nombreUsuario, String clave) {
	    return listaUsuariosStock.stream().anyMatch(stock -> stock.getNombreUsuario().equals(nombreUsuario) && stock.getClave().equals(clave));
	}

	public void cambiarClave(String nombreUsuario, String claveNueva) {
		if (this.listaUsuariosAdmin.stream().anyMatch(admin -> admin.getNombreUsuario().equals(nombreUsuario))) {
			listaUsuariosAdmin.stream().filter(admin -> admin.getNombreUsuario().equals(nombreUsuario)).forEach(admin -> admin.setClave(claveNueva));;
		}
	}
	
	
	


	public List<AdminVentas> getListaUsuariosVentas() {
        return listaUsuariosVentas;
    }



    public void setListaUsuariosVentas(List<AdminVentas> listaUsuariosVentas) {
        this.listaUsuariosVentas = listaUsuariosVentas;
    }



    public List<AdminStock> getListaUsuariosStock() {
        return listaUsuariosStock;
    }



    public void setListaUsuariosStock(List<AdminStock> listaUsuariosStock) {
        this.listaUsuariosStock = listaUsuariosStock;
    }



    public List<AdminSistema> getListaUsuariosAdmin() {
        return listaUsuariosAdmin;
    }



    public void setListaUsuariosAdmin(List<AdminSistema> listaUsuariosAdmin) {
        this.listaUsuariosAdmin = listaUsuariosAdmin;
    }



    public List<Cliente> getListaClientes() {
        return listaClientes;
    }



    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
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

	public AdminSistema usuarioAdminLogeado(String nombreUsuario, String contraseña) {
        return this.listaUsuariosAdmin.stream().filter(admin -> admin.getNombreUsuario().equals(nombreUsuario) && admin.getClave().equals(contraseña)).findFirst().get();
	    
	}
	
	public AdminVentas usuarioVentasLogeado(String nombreUsuario, String contraseña) {
	    return this.listaUsuariosVentas.stream().filter(venta -> venta.getNombreUsuario().equals(nombreUsuario) && venta.getClave().equals(contraseña)).findFirst().get();
	    
	}
	
	public AdminStock usuarioStockLogeado(String nombreUsuario, String contraseña) {
	    return this.listaUsuariosStock.stream().filter(stock -> stock.getNombreUsuario().equals(nombreUsuario) && stock.getClave().equals(contraseña)).findFirst().get();
	    
	}



	
	
	
}
