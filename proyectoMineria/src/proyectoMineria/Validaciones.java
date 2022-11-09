package proyectoMineria;

public class Validaciones {
	


	public static boolean validarTexto(String cadenaTexto) { 

		if(cadenaTexto.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")){
			JOptionPane.showMessageDialog("Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog("La contraseña no cumple con los requisitos (Debe tener numeros, letras, caracteres especiales, sin espacios y ser de mínimo 8 caracteres");
		}


		return cadenaTexto.matches("[a-zA-z]+([ '-][a-zA-Z]+)*"); //expresiones regulares permitidas
		}


	
	public static boolean validarDNI(String dniPersona) {
		
		if(dniPersona.matches("^[0-9]{8}$")){
			JOptionPane.showMessageDialog("Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog("Mal ingresado, El dni esta conformado por 8 números");
		}

		return dniPersona.matches("^[0-9]{8}$"); //expresiones regulares permitidas numeros del 0-9 (8 en total)
	}
	

	
	public boolean validacionTextoVacio(String cadenaTexto) { //valida si una cadena de texto esta vacia y si es menor a 3
		
			if(cadenaTexto.isBlank() || cadenaTexto.isEmpty() || cadenaTexto.length()<3) {
				JOptionPane.showMessageDialog("Mal ingresado");
				return false;
			}
			else {
				JOptionPane.showMessageDialog("Ingresado correctamente");
				return true;
			}
		
	}
    

	public boolean validacionNumerosVacios(String cadenaNumerica) { //valida cadenas numericas que no esten vacias
			
			if(cadenaNumerica.isBlank() || cadenaNumerica.isEmpty()) {
				JOptionPane.showMessageDialog("Mal ingresado");
				return false;
			}
			else {
				JOptionPane.showMessageDialog("Ingresado correctamente");
				return true;
			}
		
	}
 
	public static boolean validarPassword(String cadenaTexto) {
		
		if(cadenaTexto.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$")){
			JOptionPane.showMessageDialog("Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog("La contraseña no cumple con los requisitos");
		}

		return cadenaTexto.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$");
		
	}

	public boolean validacionContrasenia(String clave) {

		if(clave.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{8,32}$")){
			JOptionPane.showMessageDialog("Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog("La contraseña no cumple con los requisitos (Debe tener numeros, letras, caracteres especiales, sin espacios y ser de mínimo 8 caracteres");
		}

		return clave.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{8,32}$")//valida que la contraseña contenga numeros, letras, caracteres especiales, no contenga espacios y sea entre 8 - 32 caracteres.

	}

	public boolean validacionCodPostal(String codigoPostal) {

		if(codigoPostal.matches("^[0-9]{4}$")){
			JOptionPane.showMessageDialog("Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog("El código postal esta conformado por 4 números");
		}

		return codigoPostal.matches("^[0-9]{4}$")//expresiones regulares permitidas numeros del 0-9 (4 en total)

	}

	public boolean validarTelefono(String telefono) {
		
		if(telefono.matches("^[0-9]$")){
			JOptionPane.showMessageDialog("Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog("Mal ingresado");
		}

		return telefono.matches("^[0-9]$"); //expresiones regulares permitidas numeros del 0-9 
	}

}
	
	
