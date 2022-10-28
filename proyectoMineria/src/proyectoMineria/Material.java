package proyectoMineria;
import java.time.LocalDate;


public class Material {

        
        private String tipo;
        private Double pureza;
        private Double cantidad;//en kilos
        private LocalDate fecha;
        private Double precioBase;
        
        
        public Material(String tipo, Double pureza, Double cantidad) {
            super();
            this.tipo = tipo;
            this.pureza = pureza;
            this.cantidad = cantidad;
            this.seteoDePrecio(tipo);
            this.fecha = LocalDate.now();
        }

        private void seteoDePrecio(String tipo) {
            if (tipo.equalsIgnoreCase("oro")) {
                this.precioBase = 100_000d;
            }
            if (tipo.equalsIgnoreCase("plata")) {
                this.precioBase = 10_000d;
            }
            if (tipo.equalsIgnoreCase("cobre")) {
                this.precioBase = 1_000d;
            }
        }
        
        
        public String getTipo() {
            return tipo;
        }
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        public Double getPureza() {
            return pureza;
        }
        public void setPureza(Double pureza) {
            this.pureza = pureza;
        }
        public Double getCantidad() {
            return cantidad;
        }
        public void setCantidad(Double cantidad) {
            this.cantidad = cantidad;
        }
        public LocalDate getFecha() {
            return fecha;
        }
        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        
        
        public Double getPrecio() {
            return precioBase;
        }

        public void setPrecio(Double precio) {
            this.precioBase = precio;
        }

        @Override
        public String toString() {
            return "Material [tipo=" + tipo + ", pureza=" + pureza + ", cantidad=" + cantidad + ", fecha=" + fecha
                    + ", precio=" + precioBase + "]";
        }


        
        
        
        
        
        

    
	
	
}
