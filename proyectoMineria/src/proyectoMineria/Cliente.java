package proyectoMineria;

import java.util.LinkedList;

public class Cliente {
	
	LinkedList<Cliente> Base = new LinkedList<Cliente>();

    private String nombre;
    private String apellido;
    private String dni;
    private Boolean esMayorista;

	public boolean add(Cliente cliente) {
		char [] letras = cliente.getNombre().toCharArray();
		if(letras.length >= 3 && letras.length <= 60 ) {
			String apellido = cliente.getApellido();
			letras= apellido.toCharArray();
			if(letras.length>= 3 && letras.length<= 60) {
				String dni = cliente.getDni();
				letras = dni.toCharArray();
				if(letras.length == 8) {
					cliente.getEsMayorista();
					if(cliente.getEsMayorista() == true) {
						return true;}
				Base.add(cliente);
				return true;
				}
			}
		}
		return false;
	}
	
	public Cliente buscarCliente(String dni) {
		Cliente cliente = new Cliente();
		for (int i = 0; i < Base.size(); i++) {
			System.out.println(Base.get(i));
           cliente=Base.get(i);
           String aux = cliente.getDni();
  
           if(aux.equals(dni)) {
        	   //System.out.println("Lo encontr�");
        	   return cliente ;        	   
           }
		}
		String aux = "0";
		cliente.setDni(aux);
		//System.out.println("no encontre");
		return cliente ;
	}

	public boolean borrarCliente(Cliente cliente) {
		
		if(Base.remove(cliente)) {			
			return true; 
		}else {			
			return false;
		}
	}
	public int Indexcliente(Cliente cliente) {
		Cliente aux = new Cliente();
		for (int i = 0; i < Base.size(); i++) {
			System.out.println(Base.get(i));
			aux=Base.get(i);
           String dni = cliente.getDni();
  
           if(aux.getDni().equals(dni)) {
        	   System.out.println("la posicion es" + i);
        	   return i ;        	   
           }
		}
		return 0;
	}
		public boolean editarCliente(Cliente cliente) {
		int aux = Indexcliente(cliente);
		Base.set(aux, cliente);
		return true;
	}
		
		
		public LinkedList<Cliente> getBase() {
			return Base;
		}


		public void setBase(LinkedList<Cliente> base) {
			Base = base;
		}

	public Cliente(LinkedList<Cliente> base, String nombre, String apellido, String dni, Boolean esMayorista) {
			super();
			Base = base;
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.esMayorista = esMayorista;
	}
	
    public Cliente(String nombre, String apellido, String dni, Boolean esMayorista) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.esMayorista = esMayorista;
        
    }

	public Cliente() {
		// TODO Auto-generated constructor stub
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
}
