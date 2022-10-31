package proyectoMineria;

public class Validaciones {
	


	public static boolean validarTexto(String cadenaTexto) { 
		return cadenaTexto.matches("[a-zA-z]+([ '-][a-zA-Z]+)*"); //expresiones regulares permitidas
		}


	
	public static boolean validarDNI(String dniPersona) {
		
		return dniPersona.matches("^[0-9]{8}$"); //expresiones regulares permitidas numeros del 0-9 (8 en total)
	}
	

	
	public boolean validacionTextoVacio(String cadenaTexto) { //valida si una cadena de texto esta vacia y si es menor a 3
		
			if(cadenaTexto.isBlank() || cadenaTexto.isEmpty() || cadenaTexto.length()<3) {
				return false;
			}
			else {
				return true;
			}
		
	}
    

	public boolean validacionNumerosVacios(String cadenaNumerica) { //valida cadenas numericas que no esten vacias
			
			if(cadenaNumerica.isBlank() || cadenaNumerica.isEmpty()) {
				return false;
			}
			else {
				return true;
			}
		
	}
	
	
}
