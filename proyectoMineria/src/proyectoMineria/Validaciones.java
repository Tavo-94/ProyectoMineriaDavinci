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
	
	public static boolean validarPassword(String cadenaTexto) {
		
		return cadenaTexto.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$");
		
	}
	
	public boolean validarASCII(String cadenaTexto) {
		int contador =0;
		int valorASCII=0;
		boolean validador = false;
		
		for(int i = 0; i<cadenaTexto.length();i++) {
			
			char caracter = cadenaTexto.charAt(i);
			valorASCII = (int) caracter;
				if(valorASCII < 97 || valorASCII > 122) {
					
					contador++;
					validador = true;
				}
				else {
					validador = false;
				}
		
		}
		return validador;
		
	}
	
	
}
