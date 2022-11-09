package proyectoMineria;

import javax.swing.JOptionPane;

public class Validaciones {
	


	public static boolean validarTexto(String cadenaTexto) { 

		if(cadenaTexto.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")){
			JOptionPane.showMessageDialog(null,"Cadena de texto valida");
			return true;
		} else {
			JOptionPane.showMessageDialog(null,"La cadena de texto es invalida.");
			return false;		
				}


		}


	
	public static boolean validarDNI(String dniPersona) {
		
		if(dniPersona.matches("^[0-9]{8}$")){
			JOptionPane.showMessageDialog(null, "Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Mal ingresado, El dni esta conformado por 8 números");
		}

		return dniPersona.matches("^[0-9]{8}$"); //expresiones regulares permitidas numeros del 0-9 (8 en total)
	}
	

	
	public boolean validacionTextoVacio(String cadenaTexto) { //valida si una cadena de texto esta vacia y si es menor a 3
		
			if(cadenaTexto.isBlank() || cadenaTexto.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Cadena de texto vacia");
				return false;
			}
			else {
				JOptionPane.showMessageDialog(null,"Ingresado correctamente");
				return true;
			}
		
	}
    

	public boolean validacionNumerosVacios(String cadenaNumerica) { //valida cadenas numericas que no esten vacias
    		int errorMaterial=0;
            errorMaterial = Integer.parseInt(cadenaNumerica);

			if(cadenaNumerica.matches("^[0-9].{0,2}$") && errorMaterial <= 100) {
				JOptionPane.showMessageDialog(null, "Ingresado correctamente");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al ingresar numero tiene que ser entre 0 y 100 la pureza");
				return false;
			}
		
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
					validador = false;
				}
				else {
					validador = true;
				}
		
		}
		return validador;
		
	}
 
	public boolean validacionContrasenia(String clave) {

		if(clave.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$")){
			JOptionPane.showMessageDialog(null, "Ingresado correctamente");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "La contraseña no cumple con los requisitos (Debe tener numeros, letras, caracteres especiales, sin espacios y ser de mínimo 8 caracteres");
			return false;
		}


	}

	public boolean validacionCodPostal(String codigoPostal) {

		if(codigoPostal.matches("^[0-9]{4}$")){
			JOptionPane.showMessageDialog(null,"Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog(null,"El código postal esta conformado por 4 números");
		}

		return codigoPostal.matches("^[0-9]{4}$");//expresiones regulares permitidas numeros del 0-9 (4 en total)

	}

	public boolean validarTelefono(String telefono) {
		
		if(telefono.matches("^[0-9].{9}$")){
			JOptionPane.showMessageDialog(null,"Ingresado correctamente");
		} else {
			JOptionPane.showMessageDialog(null,"Mal ingresado");
		}


		return telefono.matches("^[0-9]$"); //expresiones regulares permitidas numeros del 0-9 
	}
	
	public boolean validarCantidad(String cantidad) {
		if(cantidad.matches("[0-9].{0,4}$")) {
			JOptionPane.showMessageDialog(null,"Ingresado la cantidad: "+cantidad);
			return true;
		}
		else {
			System.out.println("Error al ingresar la cantidad indicada");
			return false;
		}
	}

}
	
	
