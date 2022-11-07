package proyectoMineria;
import java.time.LocalDate;


public class Material {

        private Integer idMaterial;
        private String tipo;
        private Double pureza;
        private Double cantidad;//en kilos
        private LocalDate fecha;
        private Double precioBase;
        private Double coeficientePurezaAlta;
        private Double coeficientePurezaMedia;
        private Double coeficientePurezaBaja;
        
        public Material(String tipo, Double pureza, Double cantidad) {
            super();
            this.tipo = tipo;
            this.pureza = pureza;
            this.cantidad = cantidad;
            this.seteoDePrecio(tipo);
            this.seteoDeCoeficientes(pureza);
            this.fecha = LocalDate.now();            
        }
        
        
        //Constructor para la query en MaterialDAO
        
        //no hace falta setear la fecha porque ya la deberia sacar de la tabla material en la DB
        
        //El precio base tampoco pero no afecta sacarlo de la DB o calcularlo en el codigo porque es una constante
        //en funcion del tipo de material
        public Material(Integer idMaterial, String tipo, Double pureza, Double cantidad) {
            super();
            this.idMaterial = idMaterial;
            this.tipo = tipo;
            this.pureza = pureza;
            this.cantidad = cantidad;
            this.seteoDePrecio(tipo);
            this.seteoDeCoeficientes(pureza);
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
        
        private void seteoDeCoeficientes(Double pureza) {
            if (pureza > 70) {
                this.coeficientePurezaAlta = 2d;
            }
            if (pureza > 30) {
                this.coeficientePurezaMedia = 1d;
            }
            if (pureza > 0) {
                this.coeficientePurezaBaja = 0.5d;
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

        

        
        
        public Integer getIdMaterial() {
            return idMaterial;
        }

        public void setIdMaterial(Integer idMaterial) {
            this.idMaterial = idMaterial;
        }

        public Double getPrecioBase() {
            return precioBase;
        }

        public void setPrecioBase(Double precioBase) {
            this.precioBase = precioBase;
        }

        public Double getCoeficientePurezaAlta() {
            return coeficientePurezaAlta;
        }

        public void setCoeficientePurezaAlta(Double coeficientePurezaAlta) {
            this.coeficientePurezaAlta = coeficientePurezaAlta;
        }

        public Double getCoeficientePurezaMedia() {
            return coeficientePurezaMedia;
        }

        public void setCoeficientePurezaMedia(Double coeficientePurezaMedia) {
            this.coeficientePurezaMedia = coeficientePurezaMedia;
        }

        public Double getCoeficientePurezaBaja() {
            return coeficientePurezaBaja;
        }

        public void setCoeficientePurezaBaja(Double coeficientePurezaBaja) {
            this.coeficientePurezaBaja = coeficientePurezaBaja;
        }

        @Override
        public String toString() {
            return "Material [tipo=" + tipo + ", pureza=" + pureza + ", cantidad=" + cantidad + ", fecha=" + fecha
                    + ", precio=" + precioBase + "]";
        }


        
        
        
        
        
        

    
	
	
}
