package proyectoMineria;
import java.time.*;


public class Material {

        private Integer idMaterial;
        private String tipo;
        private String pureza;
        private Double cantidad;//en kilos
        private LocalDate fecha_de_ingreso;
        private Double precioBase;
        private Double coeficientePurezaAlta;
        private Double coeficientePurezaMedia;
        private Double coeficientePurezaBaja;
        

        
        
        public Material(Integer idMaterial, String tipo, String pureza, Double cantidad, LocalDate fecha_de_ingreso,
				Double precioBase) {
			super();
			this.idMaterial = idMaterial;
			this.tipo = tipo;
			this.pureza = pureza;
			this.cantidad = cantidad;
			this.fecha_de_ingreso = fecha_de_ingreso;
			this.precioBase = precioBase;
			this.coeficientePurezaAlta = coeficientePurezaAlta;
			this.coeficientePurezaMedia = coeficientePurezaMedia;
			this.coeficientePurezaBaja = coeficientePurezaBaja;
		}


		//Constructor para la query en MaterialDAO
        
        //no hace falta setear la fecha porque ya la deberia sacar de la tabla material en la DB
        
        //El precio base tampoco pero no afecta sacarlo de la DB o calcularlo en el codigo porque es una constante
        //en funcion del tipo de material



        public Material() {
			// TODO Auto-generated constructor stub
		}


		public Material(String tipoDeMaterial, Double pureza2, Double cantMaterial) {
			// TODO Auto-generated constructor stub
		}


		public Material(Integer iD, String material, String pureza2, Double cantidad2, LocalDate fecha_de_Ingreso2,
				int iD_Deposito) {
			// TODO Auto-generated constructor stub
		}


		public Material(int int1, String string, String string2, double double1) {
			// TODO Auto-generated constructor stub
		}



		public Material(String tipo, String pureza, Double cantidad) {
			super();
			this.tipo = tipo;
			this.pureza = pureza;
			this.cantidad = cantidad;
			this.seteoDePrecio(tipo);
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
        
        private void seteoDeCoeficientes(String pureza) {
            if (pureza == "Alta") {
                this.coeficientePurezaAlta = 2d;
            }
            if (pureza == "Media") {
                this.coeficientePurezaMedia = 1d;
            }
            if (pureza == "Baja") {
                this.coeficientePurezaBaja = 0.5d;
            }            
        }
        
        
        public String getTipo() {
            return tipo;
        }
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        public String getPureza() {
            return pureza;
        }
        public void setPureza(String pureza) {
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
            return "Material [tipo=" + tipo + ", pureza=" + pureza + ", cantidad=" + cantidad + ", fecha_ingreso=" + fecha_de_ingreso
                    + ", precio=" + precioBase + "]";
        }


		public LocalDate getFecha_ingreso() {
			return fecha_de_ingreso;
		}


		public void setFecha_ingreso(LocalDate fecha_de_ingreso) {
			this.fecha_de_ingreso = fecha_de_ingreso;
		}
	
	
}
