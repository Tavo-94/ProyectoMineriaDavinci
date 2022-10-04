package proyectoMineria;

import java.util.ArrayList;
import java.util.List;

public class AdminSistema extends Usuario {

	private List<Usuario> listaUsuariosVentas;
	private List<Usuario> listaUsuariosStock;

	public AdminSistema(String nombreUsuario, String clave, String cargo, Boolean estadoActivo) {
		super(nombreUsuario, clave, cargo, estadoActivo);
		// TODO Auto-generated constructor stub
		this.listaUsuariosVentas = new ArrayList<>();
		this.listaUsuariosStock = new ArrayList<>();
	}

	@Override
	public void loguearse(String nombreDeUsuario, String clave) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiarClave(String claveNueva) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cerrarSesion() {
		// TODO Auto-generated method stub

	}

	public void crearUsuario(String nombreUsuario, String clave, String cargo, Boolean estadoActivo) {
		if (cargo.equalsIgnoreCase("ventas")) {
			listaUsuariosVentas.add(new AdminVentas(nombreUsuario, clave, cargo, estadoActivo));
		} else if (cargo.equalsIgnoreCase("stock")) {
			listaUsuariosStock.add(new AdminStock(nombreUsuario, clave, cargo, estadoActivo));
		} else {
			System.out.println("***************************");
			System.out.println("Cargo ingresado invalido!!!");
			System.out.println("***************************");
		}

	}
	
	public void validarDatos(String nombreUsuario, String clave, String cargo, Boolean estadoActivo) {
		//usar listas + stream api para recorrer toda la coleccion y verificar que el nombre de usuario y el cargo no se encuentre ya ingresados en la coleccion de <usuarios>
	}

}
