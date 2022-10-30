package proyectoMineria;

public class DireccionCliente {

    private String calle;
    private String altura;
    private String codigoPostal;
    private String ciudad;
    private Integer idCliente;
    
    public DireccionCliente(String calle, String altura, String codigoPostal, String ciudad) {
        super();
        this.calle = calle;
        this.altura = altura;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.idCliente = null;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
