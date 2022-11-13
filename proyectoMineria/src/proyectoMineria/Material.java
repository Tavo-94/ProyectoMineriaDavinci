package proyectoMineria;
import java.time.*;


public class Material {

        private Integer idMaterial;
        private String tipo;
        private Double pureza;
        private Double cantidad;//en kilos
        private LocalDateTime fecha_ingreso;
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
            this.setFecha_ingreso(LocalDateTime.now());            
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



        public Material() {
			// TODO Auto-generated constructor stub
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
            return "Material [tipo=" + tipo + ", pureza=" + pureza + ", cantidad=" + cantidad + ", fecha_ingreso=" + fecha_ingreso
                    + ", precio=" + precioBase + "]";
        }


		public LocalDateTime getFecha_ingreso() {
			return fecha_ingreso;
		}


		public void setFecha_ingreso(LocalDateTime fecha_ingreso) {
			this.fecha_ingreso = fecha_ingreso;
		}


        
        
        
        
        
        

    
	
	
}
