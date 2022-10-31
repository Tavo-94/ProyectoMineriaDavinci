package IU;

import javax.swing.*;
import static javax.swing.JOptionPane.*;

public class InterfazGeneral {

    public static void MenuPrincipal() {

        int menuPrincipal;

        menuPrincipal = Integer.parseInt(showInputDialog(
                "Bienvenido al menu principal. Por favor seleccione una opción para continuar: \n1) Signup \n 2) Login.\n3) Productos. \n4) Clientes."));

        if (menuPrincipal == 1) {
            // SIGNUP //
            ImageIcon signup = new ImageIcon("/img/contrasena.png");
            showMessageDialog(null,
                    "",
                    "SIGNUP/LOGIN", WARNING_MESSAGE, signup);
        } else if (menuPrincipal == 2) {
            // LOGIN //
            ImageIcon login = new ImageIcon("/img/contrasena.png");
            showMessageDialog(null,
                    "",
                    "SIGNUP/LOGIN", WARNING_MESSAGE, login);
        } else if (menuPrincipal == 3) {
            // PRODUCTOS //
            ImageIcon producto = new ImageIcon("/img/producto.png");
            showMessageDialog(null,
                    "",
                    "SIGNUP/LOGIN", WARNING_MESSAGE, producto);
        } else if (menuPrincipal == 4) {
            // CLIENTES //
            ImageIcon cliente = new ImageIcon("/img/usuario.png");
            showMessageDialog(null,
                    "",
                    "SIGNUP/LOGIN", WARNING_MESSAGE, cliente);

        } else {
            showMessageDialog(null, "Error en el ingreso!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        switch (menuPrincipal) {
            case 1:
                SignUp();
                break;

            case 2:
                Login();
                break;

            case 3:
                Producto();
                break;

            case 4:
                Cliente();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelva a preguntar");
                MenuPrincipal();
                break;
        }
    }

    public static void SignUp() {

    }

    public static void Login() {

    }

    public static void Producto() {

    }

    public static void Cliente() {

    }

}
