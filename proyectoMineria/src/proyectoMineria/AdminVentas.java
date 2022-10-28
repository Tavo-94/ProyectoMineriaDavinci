package proyectoMineria;

import java.util.Scanner;

public class AdminVentas extends Usuario {
	
	public AdminVentas(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
        super(nombreUsuario, clave, cargo, estadoActivo, mineria);
    }

	static Scanner entrada = new Scanner(System.in);
	
	static Cliente base = new Cliente();
	
	static Deposito stock = new Deposito();
	
	static TicketOperacion venta = new TicketOperacion();
	
	private void imprimirMenu() {
		System.out.println("Por favor escoja una de las siguientes opciones");
		System.out.println("Para acceder a la opci�n escriba el numero que corresponda");
		System.out.println("1.Agregar cliente ");
		System.out.println("2.Buscar cliente");
		System.out.println("3.Mostrar Stock");
		System.out.println("4.Crear Ticket de Venta");
		System.out.println("5.Salir");
		
		int opcion = entrada.nextInt();
		switch (opcion) {
		case 1: agregarCliente();
			break;
		case 2: buscarCliente();
			break;
		case 3: mostrarStock(null);
			break;
		case 4: crearTicket(null);
		    break;
		case 5: Salir();
			break;
			default: System.out.println("Se eligio una opci�n incorrecta volver a intentar");
				break;
			}
	}
	
	private void menuAlter(Cliente cliente) {
		System.out.println("1.Borrar cliente ");
		System.out.println("2.Editar cliente");
		System.out.println("3.Menu principal");
		
		int opcion = entrada.nextInt();
		switch (opcion) {
		case 1: borrarCliente(cliente);
			break;
		case 2: editarCliente(cliente);
			break;
		case 3: imprimirMenu();
			break;
			default: System.out.println("Se eligio una opci�n incorrecta volver a intentar");
				break;
			}
	}
	private void borrarCliente(Cliente cliente) {
		System.out.println("Esta seguro de querer borrar a "+ cliente+ "?");
		System.out.println("si esta seguro presione 1");
		int aux = entrada.nextInt();
		if(aux ==1) {
			if(base.borrarCliente(cliente)) {
				System.out.println("se borro exitosamente");
			}
		}else {
			imprimirMenu();
		}
	}
	private void editarCliente(Cliente cliente) {
		System.out.println("Ingrese el nombre de cliente");		
		System.out.println("Debe ser un nombre de minimo 3 letras y maximo 60");
		cliente.setNombre(entrada.next());
		System.out.println("Ingrese apellido");
		System.out.println("Debe ser un apellido de minimo 3 letras y maximo 60");
		cliente.setApellido(entrada.next());
		if(base.editarCliente(cliente)) {
			System.out.println("el cliente se pudo editar correctamente");
		}else {
			System.out.println("no se pudo editar el cliente");
		}
		
		 imprimirMenu();
	}
	
	private void agregarCliente() {
		Cliente cliente = new Cliente();
		System.out.println("ingresar nombre del cliente");
		cliente.setNombre(entrada.next());
		System.out.println("ingresar apellido del cliente");
		cliente.setApellido(entrada.next());
		System.out.println("ingresar DNI del cliente");
		cliente.setDni(entrada.next());
		System.out.println("ingresar si el cliente es Mayorista");
		cliente.setEsMayorista(null);
       		if(base.add(cliente)== true) {
				 System.out.println("Se agrego correctamente el cliente");
			 } else {
				 System.out.println("no se pudo agregar correctamente");
					System.out.println("si deseas agregar nuevamente un cliente ");
					System.out.println("seleccionar opcion 1");	
					}
       		imprimirMenu();
       		}
	
	private void buscarCliente() {
		System.out.println("Ingrese dni del cliente a buscar");
		String dni = entrada.next();
		Cliente cliente = new Cliente();
		cliente = base.buscarCliente(dni); 
		if(cliente.getDni() == "0" ) {
			System.out.println("el cliente no se encontro");
		}else {
			System.out.println("El cliente es");
			System.out.println(cliente);
			menuAlter(cliente);
		}
		 imprimirMenu();
	}
	
	private void mostrarStock(Deposito deposito) {
		System.out.println(stock);
		imprimirMenu();
		
	}
	
	public void crearTicket(TicketOperacion ticket) {
    	ticket.getCliente().getDni();
    	ticket.getCantidadDeMaterialComprado();
	if(ticket.getCantidadDeMaterialComprado()!=0) {
    	ticket.getMaterial().getTipo();
    	if (ticket.getMaterial().getTipo().equals("oro")); double costo=0; {
        	if (ticket.getMaterial().getPureza()<=100 && ticket.getMaterial().getPureza()>=70) {
        		 costo = ticket.getCantidadDeMaterialComprado() * 100000;
        		}
        		if (ticket.getMaterial().getPureza()<=69 && ticket.getMaterial().getPureza()>=40) {
        			 costo = ticket.getCantidadDeMaterialComprado() * 75000;
       			}
       			if (ticket.getMaterial().getPureza()<=49 && ticket.getMaterial().getPureza()>=10) {
       				 costo = ticket.getCantidadDeMaterialComprado() * 50000;
       			}
       		}
    	if (ticket.getMaterial().tipo.equals("plata"));{
        	if (ticket.getMaterial().getPureza()<=100 && ticket.getMaterial().getPureza()>=70) {
        		 costo = ticket.getCantidadDeMaterialComprado() * 10000;
        		}
        		if (ticket.getMaterial().getPureza()<=69 && ticket.getMaterial().getPureza()>=40) {
        			 costo = ticket.getCantidadDeMaterialComprado() * 7500;
       			}
       			if (ticket.getMaterial().getPureza()<=49 && ticket.getMaterial().getPureza()>=10) {
       				 costo = ticket.getCantidadDeMaterialComprado() * 5000;
       			}
       		}
		if (ticket.getMaterial().tipo.equals("cobre"));{
        	if (ticket.getMaterial().getPureza()<=100 && ticket.getMaterial().getPureza()>=70) {
        		 costo = ticket.getCantidadDeMaterialComprado() * 1000;
        		}
        		if (ticket.getMaterial().getPureza()<=69 && ticket.getMaterial().getPureza()>=40) {
        			 costo = ticket.getCantidadDeMaterialComprado() * 750;
       			}
       			if (ticket.getMaterial().getPureza()<=49 && ticket.getMaterial().getPureza()>=10) {
       				 costo = ticket.getCantidadDeMaterialComprado() * 500;
       			}
       		}
		if (ticket.getCliente().getEsMayorista()== true) {
			double precioT = 0.8 * costo;
			ticket.setPrecio(precioT);
			}
		ticket.setPrecio(costo);
		}
    }
	
	private void Salir() {
		System.out.println("El programa finalizo");
		System.exit(0);
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
