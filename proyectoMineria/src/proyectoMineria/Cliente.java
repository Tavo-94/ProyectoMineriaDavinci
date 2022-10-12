package proyectoMineria;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String apellido;
    private String dni;
    private Boolean esMayorista;

    
    
    public Cliente(String nombre,String apellido,String dni, Boolean esMayorista) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.esMayorista = esMayorista;
        
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


    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", esMayorista=" + esMayorista
                + "]";
    }
    
    


    }

