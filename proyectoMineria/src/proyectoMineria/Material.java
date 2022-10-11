package proyectoMineria;
import java.time.LocalDate;


public class Material {

        
        private String tipo;
        private Double pureza;
        private Double cantidad;
        private LocalDate fecha;
        
        
        public Material(String tipo, Double pureza, Double cantidad) {
            super();
            this.tipo = tipo;
            this.pureza = pureza;
            this.cantidad = cantidad;
            this.fecha = LocalDate.now();
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

        @Override
        public String toString() {
            return "Material [tipo=" + tipo + ", pureza=" + pureza + ", cantidad=" + cantidad + ", fecha=" + fecha
                    + "]";
        }
        
        
        
        
        

    
	
	
}
