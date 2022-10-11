package proyectoMineria;


import java.util.Scanner;

public class AdminSistema extends Usuario {

	public AdminSistema(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
		super(nombreUsuario, clave, cargo, estadoActivo, mineria);
		// TODO Auto-generated constructor stub

	}

	
	@Override
	public void loguearse(Scanner inputDelUsuario) {
		// TODO Auto-generated method stub
		
		String nombreUsuario;
		String clave;
		
		System.out.println("ingresar nombre de usuario");
		do {
			nombreUsuario = inputDelUsuario.next();
		} while (nombreUsuario.isBlank() || nombreUsuario.isEmpty());
		
		System.out.println("ingresar clave");
		do {
			clave = inputDelUsuario.next();
		} while (clave.isBlank() || clave.isEmpty());
		
		this.getMineria().loguearse(nombreUsuario, clave);
		
		/*
		String nombreUsuario;
		String clave;
		
		System.out.println("ingresar nombre de usuario");
		do {
			nombreUsuario = inputDelUsuario.next();
		} while (nombreUsuario.isBlank() || nombreUsuario.isEmpty());
		
		System.out.println("ingresar clave");
		do {
			clave = inputDelUsuario.next();
		} while (clave.isBlank() || clave.isEmpty());
		
		if (this.validarLogIn(nombreUsuario, clave)) {
			System.out.println("Log In exitos");
			this.setSessionActiva(true);
		} else {
			System.out.println("Credenciales invalidas");
			
		}
		*/
	}
	
		
	@Override
	public void cambiarClave(Scanner inputDelUsuario) {
		// TODO Auto-generated method stub
		String nombreUsuario;
		String clave;
		String claveNueva;

		System.out.println("ingresar nombre de usuario");
		do {
			nombreUsuario = inputDelUsuario.next();
		} while (nombreUsuario.isBlank() || nombreUsuario.isEmpty());
		
		System.out.println("ingresar clave actual");
		do {
			clave = inputDelUsuario.next();
		} while (clave.isBlank() || clave.isEmpty());

		System.out.println("ingresar clave nueva");
		do {
			claveNueva = inputDelUsuario.next();
		} while (claveNueva.isBlank() || claveNueva.isEmpty());
		
		if (this.validarLogIn(nombreUsuario, clave)) {
			this.getMineria().cambiarClave(nombreUsuario, claveNueva);
		}
	}


	@Override
	public void cerrarSesion() {
		// TODO Auto-generated method stub
		this.setSessionActiva(false);
	}
//creo instancia de adimin ventas
	public void crearUsuario(Scanner inputDelUsuario) {
		
		String nombreUsuario;
		String clave;
		String cargo;
		Boolean estadoActivo;
		
		System.out.println("ingresar nombre de usuario");
		do {
			nombreUsuario = inputDelUsuario.next();
		} while (nombreUsuario.isBlank() || nombreUsuario.isEmpty());
		
		System.out.println("ingresar clave");
		do {
			clave = inputDelUsuario.next();
		} while (clave.isBlank() || clave.isEmpty());
		
		System.out.println("ingresar cargo");
		do {
			cargo = inputDelUsuario.next();
		} while (cargo.isBlank() || cargo.isEmpty());
		
		System.out.println("es un usario activo?");
		do {
			estadoActivo = inputDelUsuario.nextBoolean();
		} while (estadoActivo == null);
		
		if (!this.validarNombreDeUsuario(nombreUsuario)) {	
			if (cargo.equalsIgnoreCase("ventas")) {

				this.getMineria().getListaUsuariosVentas().add(new AdminVentas(nombreUsuario, clave, cargo, estadoActivo, this.getMineria()));
			} else if (cargo.equalsIgnoreCase("stock")) {
				this.getMineria().getListaUsuariosStock().add(new AdminStock(nombreUsuario, clave, cargo, estadoActivo, this.getMineria()));
			} else {
				System.out.println("***************************");
				System.out.println("Cargo ingresado invalido!!!");
				System.out.println("***************************");
			}
		} else {
			System.out.println("***************************");
			System.out.println("Nombre de usuario ingresado invalido!!!");
			System.out.println("Ya Existe un usuario con ese nombre");
			System.out.println("***************************");
		}
		


	}
	
	public void darDeBaja(Scanner inputDelUsuario) {
		String nombreUsuario;
		
		System.out.println("ingresar nombre de usuario a dar de baja");
		do {
			nombreUsuario = inputDelUsuario.next();
		} while (nombreUsuario.isBlank() || nombreUsuario.isEmpty());
		
		this.getMineria().bajaUsuario(nombreUsuario);
	}
	
	public void darDeAlta(Scanner inputDelUsuario) {
		String nombreUsuario;
		
		System.out.println("ingresar nombre de usuario a dar de Alta");
		do {
			nombreUsuario = inputDelUsuario.next();
		} while (nombreUsuario.isBlank() || nombreUsuario.isEmpty());
		
		this.getMineria().altaUsuario(nombreUsuario);
	}
	
	/*public Boolean validarDatos(String nombreUsuario, String clave, String cargo, Boolean estadoActivo) {
		//usar listas + stream api para recorrer toda la coleccion y verificar que el nombre de usuario y el cargo no se encuentre ya ingresados en la coleccion de <usuarios>
		return listaUsuariosStock.stream().anyMatch(x -> x.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
	}*/
	
	public Boolean validarNombreDeUsuario(String nombreUsusario) {
		return this.getMineria().getListaUsuariosStock().stream()
				.anyMatch(adminStock -> adminStock.getNombreUsuario().equalsIgnoreCase(nombreUsusario)) || 
				this.getMineria().getListaUsuariosVentas()
				.stream()
				.anyMatch(adminVentas -> adminVentas.getNombreUsuario().equals(nombreUsusario));
	}
	
	public Boolean validarLogIn(String nombreUsuario, String clave) {
		return this.getMineria().getListaUsuariosAdmin().stream().anyMatch(admin -> admin.getNombreUsuario().equals(nombreUsuario) && admin.getClave().equals(clave));		
	}


	@Override
	public String toString() {
		return "AdminSistema [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getNombreUsuario()="
				+ getNombreUsuario() + ", getClave()=" + getClave() + ", getCargo()=" + getCargo()
				+ ", getEstadoActivo()=" + getEstadoActivo() + ", getSessionActiva()=" + getSessionActiva()
				+ ", getMineria()=" + getMineria() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	




	
	

}
