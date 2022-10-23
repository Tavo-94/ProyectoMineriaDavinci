package proyectoMineria;

import java.util.Scanner;

public class AdminStock extends Usuario {
	
    public AdminStock(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
        super(nombreUsuario, clave, cargo, estadoActivo, mineria);
    }
	
	static Scanner entrada = new Scanner(System.in);
	
	static Deposito stock = new Deposito();

	public void Login() {
		
		SobreCarga();
		System.out.println("Bienvenido");
		imprimirMenu();
	}
	
	private void SobreCarga() {
		Material material = new Material();
		material.setTipo(null);
		material.setCantidad(null);
		material.setPureza(null);
		material.setFecha(null);
		stock.add(material);
	}
	
	private void imprimirMenu() {
		System.out.println("Por favor escoja una de las siguientes opciones");
		System.out.println("Para acceder a la opci�n escriba el numero que corresponda");
		System.out.println("1.Agregar material ");
		System.out.println("2.Buscar material");
		System.out.println("3.Modificar Stock");
		System.out.println("3.Mostrar Stock");
		System.out.println("5.Salir");
		
		int opcion = entrada.nextInt();
		switch (opcion) {
		case 1: agregarMaterial();
			break;
		case 2: buscarMaterial();
			break;
		case 3: modificarStock(null);
			break;
		case 4: mostrarStock();
		    break;
		case 5: Salir();
			break;
			default: System.out.println("Se eligio una opci�n incorrecta volver a intentar");
				break;
			}
	}

	private void agregarMaterial() {
		System.out.println("ingresar tipo de material");
		Material material = new Material();
		material.setTipo(entrada.next());
		System.out.println("ingresar cantidad");
		material.setCantidad(entrada.nextDouble());
        System.out.println("ingresar pureza");
        material.setPureza(entrada.nextDouble());
        System.out.println("ingresar fecha");
        material.setFecha(entrada.nextDouble());
        if(stock.add(material)== true) {
        	System.out.println("Se agrego correctamente el alumno");
        } else {
        	System.out.println("no se pudo agregar correctamente");
        	System.out.println("si deseas agregar nuevamente un material ");
			System.out.println("seleccionar opcion 1");
			}
       		imprimirMenu();
	}
       		
	private void buscarMaterial() {
		System.out.println("Ingrese tipo de material que desea buscar");
		String tipo = entrada.next();
		Material material = new Material();
		material = stock.buscarMaterial(tipo); 
		if(material.getTipo() == "0" ) {
			System.out.println("el material no se encontro");
		}else {
			System.out.println("El material es");
			System.out.println(material);
		}
		 imprimirMenu();
	}
	
	private void modificarStock(Material material) {
		System.out.println("Ingrese el tipo de material");
		material.setTipo(entrada.next());
		System.out.println("Ingrese cantidad");
		material.setCantidad(entrada.nextDouble());
		System.out.println("Ingrese pureza");
		material.setPureza(entrada.nextDouble());
		if(stock.modificarStock(material)) {
			System.out.println("el Stock se pudo editar correctamente");
		}else {
			System.out.println("no se pudo editar el stock");
		}
		
		 imprimirMenu();
	}
	private void mostrarStock() {
		System.out.println(stock);
		imprimirMenu();
		
	}
	private void Salir() {
		System.out.println("El programa finalizo");
		System.exit(0);
	}
    @Override
    public String toString() {
        return "AdminStock [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getNombreUsuario()="
                + getNombreUsuario() + ", getClave()=" + getClave() + ", getCargo()=" + getCargo()
                + ", getEstadoActivo()=" + getEstadoActivo() + ", getSessionActiva()=" + getSessionActiva()
                + ", getMineria()=" + getMineria() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

	public static Scanner getEntrada() {
		return entrada;
	}

	public static void setEntrada(Scanner entrada) {
		AdminStock.entrada = entrada;
	}

	public static Deposito getStock() {
		return stock;
	}

	public static void setStock(Deposito stock) {
		AdminStock.stock = stock;
	}

	@Override
	public void loguearse(Scanner inputDelUsuario) {
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

}
