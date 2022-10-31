package IU;

import javax.swing.*;

public class InterfazGeneral {

    public static void MenuPrincipal() {

        int opcion = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Qué desea realizar ?\n " + "1-Mostrar lista productos\n"
                        + "2-Agregar un producto\n" + "3-Modificar un producto\n" + "4-Eliminar un producto\n"));

        switch (opcion) {
            case 1:
                MostrarProductos();
                break;

            case 2:
                AgregarProducto();
                break;

            case 3:
                ModificarProducto();
                break;

            case 4:
                EliminarProducto();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelva a preguntar");
                MenuPrincipal();
                break;

        }


    }
