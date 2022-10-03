package proyectoMineria;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String clave;
	private String cargo;
	private Boolean estadoActivo;
	
	
	
	
	
	public abstract void loguearse(String nombreDeUsuario, String clave);
	public abstract void cambiarClave(String claveNueva);
	public abstract void cerrarSesion();
}
