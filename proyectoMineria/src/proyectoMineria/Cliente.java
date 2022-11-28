package proyectoMineria;

import java.util.List;

public class Cliente {
	
	List<Cliente>listaClientes;
	private String nombre;
	private String apellido;
	private String dni;
	private Boolean esMayorista;
    private String telefono;
    private Integer idCliente;
	
	public void agregarRegistroCliente(Usuario usuario,String nombre,String apellido,String dni) {
		
	    if (usuario.validarCargoVentas()) {
	    	
            listaClientes.add(new Cliente(nombre,apellido, esMayorista, telefono));
            System.out.println("Cliente registrado");

        }
		
	}

	public Cliente(List<Cliente> listaClientes, String nombre, String apellido, String dni, Boolean esMayorista,
			String telefono, Integer idCliente) {
		super();
		this.listaClientes = listaClientes;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.esMayorista = esMayorista;
		this.telefono = telefono;
		this.idCliente = idCliente;
	}


	public Cliente(String nombre2, String apellido2, Boolean esMayorista2, String telefono2) {
        // TODO Auto-generated constructor stub
    }


	

	public Cliente(String nombre, String apellido, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Cliente(Integer idCliente, String nombre, String apellido, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.idCliente = idCliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}


	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
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


	public Boolean getEsMayorista() {
		return esMayorista;
	}


	public void setEsMayorista(Boolean esMayorista) {
		this.esMayorista = esMayorista;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	@Override
	public String toString() {
		return "Cliente [listaClientes=" + listaClientes + ", nombre=" + nombre + ", apellido=" + apellido + ", dni="
				+ dni + ", esMayorista=" + esMayorista + ", telefono=" + telefono + ", idCliente=" + idCliente + "]";
	}
}

