package IU;

import javax.swing.*;
import java.util.Scanner;

public class InterfazLogin {

    static Scanner JObject = new Scanner(System.in);

    public static void main(String[] args) {

        String Username, Password;

        for (int i=0; i<3;i++)
        {
            Username = JOptionPane.showInputDialog("Ingrese su usuario:");
            Password = JOptionPane.showInputDialog("Ingrese su contraseña:");

            if(Username.equals("admin") || (Username.equals("adminventas")) || (Username.equals("adminstock")) && (Password.equals("1234")))
            {
                JOptionPane.showMessageDialog(null, "Acceso exitoso","SIGN IN", JOptionPane.INFORMATION_MESSAGE);

                break;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            if (i==1){
                JOptionPane.showMessageDialog(null,"1 intento restante.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            if (i>=2){
                JOptionPane.showMessageDialog(null,"INTENTE MAS TARDE.", "Aviso", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }

    }

}
