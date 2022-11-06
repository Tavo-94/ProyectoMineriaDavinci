package IU;


import proyectoMineria.Main;

import javax.swing.*;

public class InterfazGeneral {

    static Main menu = new Main();

    public static void MenuPrincipal() {

        String Username, Password;

        String adminSistema = "adminsistema";
        String adminSistemaPassword = "1234";
        String adminVentas = "adminventas";
        String adminVentasPassword = "1234";
        String adminStock = "adminstock";
        String adminStockPassword = "1234";


        JOptionPane.showMessageDialog(null,
                "Bienvenido!\n" + "A continuación ingrese su usuario y contraseña para poder continuar.",
                "Main Menu", JOptionPane.WARNING_MESSAGE,
                new ImageIcon(InterfazGeneral.class.getResource("")));

        Username = JOptionPane.showInputDialog("Ingrese su usuario:");
        Password = JOptionPane.showInputDialog("Ingrese su contraseña:");

        // ====== ADMINVSISTEMAS MENU ======= //
        if (Username.equals(adminSistema) && Password.equals(adminSistemaPassword)) {

            JOptionPane.showMessageDialog(null, "Acceso exitoso", "SIGN IN", JOptionPane.INFORMATION_MESSAGE);

            int ingresoAdminSistema;
            ingresoAdminSistema = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué desea realizar ?\n" + "1) Ingresar nuevo Admin Ventas. \n"
                    + "2) Ingresar nuevo Admin Stock.\n" + "3) Salir."));

            switch (ingresoAdminSistema) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Cerrando applicacion a continuacion",
                            "Main Menu", JOptionPane.WARNING_MESSAGE,
                            new ImageIcon(InterfazGeneral.class.getResource("")));
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Cerrando applicacion a continuacion",
                            "Main Menu", JOptionPane.WARNING_MESSAGE,
                            new ImageIcon(InterfazGeneral.class.getResource("")));
                    MenuPrincipal();
                    break;
            }
        }
            // ====== ADMINVENTAS MENU ======= //
            else if (Username.equals(adminVentas) && Password.equals(adminVentasPassword)) {

            JOptionPane.showMessageDialog(null, "Acceso exitoso", "SIGN IN", JOptionPane.INFORMATION_MESSAGE);

            int ingresoAdminVentas;
            ingresoAdminVentas = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué desea realizar ?\n" + "1) Venta. \n"
                    + "2) Ingresar nuevo cliente.\n" + "3) Consultar Stock.\n" + "4) Realizar balance.\n" + "5) Salir."));

            switch (ingresoAdminVentas) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Cerrando applicacion a continuacion",
                            "Main Menu", JOptionPane.WARNING_MESSAGE,
                            new ImageIcon(InterfazGeneral.class.getResource("")));
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Cerrando applicacion a continuacion",
                            "Main Menu", JOptionPane.WARNING_MESSAGE,
                            new ImageIcon(InterfazGeneral.class.getResource("")));
                    MenuPrincipal();
                    break;

            }
        }
                // ====== ADMINSTOCK MENU ======= //
            else if (Username.equals(adminStock) && Password.equals(adminStockPassword)) {

            JOptionPane.showMessageDialog(null, "Acceso exitoso", "SIGN IN", JOptionPane.INFORMATION_MESSAGE);

                    int ingresoAdminStock;
                    ingresoAdminStock = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué desea realizar ?\n" + "1) Ingresar nuevo stock. \n"
                            + "2) Actualizar el stock.\n" + "3) Salir."));

                    switch (ingresoAdminStock) {
                        case 1:
                            break;

                        case 2:
                            break;

                        case 3:
                            JOptionPane.showMessageDialog(null,
                                    "Cerrando applicacion a continuacion",
                                    "Main Menu", JOptionPane.WARNING_MESSAGE,
                                    new ImageIcon(InterfazGeneral.class.getResource("")));
                            System.exit(0);
                            break;

                        default:
                            JOptionPane.showMessageDialog(null,
                                    "Cerrando applicacion a continuacion",
                                    "Main Menu", JOptionPane.WARNING_MESSAGE,
                                    new ImageIcon(InterfazGeneral.class.getResource("")));
                            MenuPrincipal();
                            break;

                    }

            } else {
            JOptionPane.showMessageDialog(null, "Datos ingresados incorrectos!\n" + "Vuelva a intentarlo.");
            MenuPrincipal();
                }
            }
        }


