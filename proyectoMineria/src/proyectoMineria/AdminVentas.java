package proyectoMineria;

import java.util.Scanner;

public class AdminVentas extends Usuario {

	Cliente registroClientes;
	
	public AdminVentas(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
		super(nombreUsuario, clave, cargo, estadoActivo, mineria);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void loguearse(Scanner inputUsuario) {
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
	
	public void visualizarStock(Deposito deposito) {
		deposito.mostrarStock();
	}

    public void nuevoRegistro(Scanner inputRegistro,Cliente cliente,Deposito deposito) {	
    	
    	String material;
    	String nombre;
    	String apellido;
    	String dni;
    	String cantMaterial;
    	
	    	if(cliente.getAlta()==true) {
	            System.out.println("Ingresar nombre del cliente");
	            do {
	                nombre = inputRegistro.next();
	                
	            } while (nombre.isBlank() || nombre.isEmpty());
		            
		            System.out.println("Ingresar apellido del cliente");
		            do {
		                apellido = inputRegistro.next();
		                
		            } while (apellido.isBlank() || apellido.isEmpty());
		            
		            System.out.println("Ingresar dni");
		            do {
		                dni = inputRegistro.next();
		                
		            } while (dni.isBlank() || dni.isEmpty());
		            
		            System.out.println("Ingresar cantidad a registrar");
		            do {
		                cantMaterial = inputRegistro.next();  
		            } while (Double.parseDouble(cantMaterial) < 0d || cantMaterial == null);
		            
		            System.out.println("Ingresar material");
		            do {
		                material = inputRegistro.next();  
       
					                if(material.equalsIgnoreCase("ORO") /*&& Double.parseDouble(cantMaterial) > deposito.getTotalDeOro()*/) {
					                	deposito.setTotalDeOro(deposito.getTotalDeOro()-Double.parseDouble(cantMaterial));
					                }
					                if(material.equalsIgnoreCase("PLATA")/*&& Double.parseDouble(cantMaterial) > deposito.getTotalDePlata()*/) {
					                	deposito.setTotalDePlata(deposito.getTotalDePlata()-Double.parseDouble(cantMaterial));

					                }
					                if(material.equalsIgnoreCase("COBRE")/*&& Double.parseDouble(cantMaterial) > deposito.getTotalDeCobre()*/) {
					                	deposito.setTotalDeCobre(deposito.getTotalDeCobre()-Double.parseDouble(cantMaterial));

					                }
	

		                
		            } while (material.isBlank() || material.isEmpty());
		            
		       
		            		this.getRegistroCliente().agregarRegistroCliente(this, nombre, apellido, dni);
	                
	    	}
	    	
	    	else {
	    		System.out.println("El cliente no esta registrado");
	    	}
    	
        
    	
	}
    
    
    
    public Cliente getRegistroCliente(){
    	
    	return registroClientes;
    }
    public void setRegistroCliente(Cliente registroClientes) {
        this.registroClientes = registroClientes;
    }

	@Override
	public String toString() {
		return "AdminVentas [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getNombreUsuario()="
				+ getNombreUsuario() + ", getClave()=" + getClave() + ", getCargo()=" + getCargo()
				+ ", getEstadoActivo()=" + getEstadoActivo() + ", getSessionActiva()=" + getSessionActiva()
				+ ", getMineria()=" + getMineria() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	



	
	

	

}
