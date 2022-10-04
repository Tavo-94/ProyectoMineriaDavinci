package proyectoMineria;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private String nombreUsuario; //Clave primaria de la clase
	private String clave;
	private String cargo;
	private Boolean estadoActivo;
	
	
	
	
	
	public Usuario(String nombreUsuario, String clave, String cargo, Boolean estadoActivo) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.cargo = cargo;
		this.estadoActivo = estadoActivo;
	}
	public abstract void loguearse(String nombreDeUsuario, String clave);
	public abstract void cambiarClave(String claveNueva);
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
	
	
}
