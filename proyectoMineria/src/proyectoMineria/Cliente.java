package proyectoMineria;

public class Cliente {

    private String nombre;
    private String apellido;
    private Boolean esMayorista;
    private String telefono;
    private Integer idCliente;

    
     
    public Cliente(String nombre, String apellido, Boolean esMayorista, String telefono) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.esMayorista = esMayorista;
        this.telefono = telefono;
        this.idCliente = null;
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
        return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", esMayorista=" + esMayorista
                + "]";
    }
    
    


    }
