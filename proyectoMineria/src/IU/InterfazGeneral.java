package IU;


import negocio.AdminVentasDao;
import proyectoMineria.Deposito;
import proyectoMineria.Main;

import javax.swing.*;

public class InterfazGeneral {

    static Main menu = new Main();

    public void MenuPrincipal() {

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
            ingresoAdminSistema = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué desea realizar ?\n" + "1) Ingresar Admin Ventas panel. \n"
                    + "2) Ingresar Admin Stock panel.\n" + "3) Salir."));

            switch (ingresoAdminSistema) {
                case 1:
                    AdminVentas();
                    break;

                case 2:
                    AdminStock();
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
                    Venta();
                    break;

                case 2:
                    AgregarCliente();
                    break;

                case 3:
                    ConsultarStock();
                    break;

                case 4:
                    RealizarBalance();
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
                            AgregarStock();
                            break;

                        case 2:
                            ActualizarStock();
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

            //-------------------------- ADMINSISTEMAS . adminventas ---------------------------//
            public void AdminVentas(){
                int adminVentas;
                adminVentas = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué desea realizar ?\n" + "1) Ingresar nuevo Admin Ventas. \n"
                        + "2) Modificar un Admin Ventas.\n" + "3) Eliminar un Admin Ventas.\n" + "4) Salir."));

                switch (adminVentas) {
                    case 1:
                        AgregarAdminVentas();
                        break;

                    case 2:
                        ModificarAdminVentas();
                        break;

                    case 3:
                        EliminarAdminVentas();
                        break;

                    case 4:
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

            public static void AgregarAdminVentas(){

                String UsernameVentas, PasswordVentas;

                UsernameVentas = JOptionPane.showInputDialog("Ingrese su usuario:");
                PasswordVentas = JOptionPane.showInputDialog("Ingrese su contraseña:");


            }

            public static void ModificarAdminVentas(){



            }

            public void EliminarAdminVentas(){

                AdminVentasDao ventasDAO = new AdminVentasDao();
                ventasDAO.eliminarAdminVentas();

            }


            //-------------------------- ADMINSISTEMAS . adminstock ---------------------------//

            public void AdminStock(){
                int adminStock;
                adminStock = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué desea realizar ?\n" + "1) Ingresar nuevo Admin Stock. \n"
                        + "2) Modificar un Admin Stock.\n" + "3) Eliminar un Admin Stock.\n" + "4) Salir."));

                switch (adminStock) {
                    case 1:
                        AgregarAdminStock();
                        break;

                    case 2:
                        ModificarAdminStock();
                        break;

                    case 3:
                        EliminarAdminStock();
                        break;

                    case 4:
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

            public static void AgregarAdminStock(){

                String UsernameStock, PasswordStock;

                UsernameStock = JOptionPane.showInputDialog("Ingrese su usuario:");
                PasswordStock = JOptionPane.showInputDialog("Ingrese su contraseña:");


             }

            public static void ModificarAdminStock(){

            }

            public static void EliminarAdminStock(){

            }


            //-------------------------- ADMINVENTAS ---------------------------//

            public static void Venta(){

            }

            public static Deposito ConsultarStock(){

                return null;
            }

            public static void AgregarCliente(){

            }

            public static void RealizarBalance(){

            }



            //-------------------------- ADMINSTOCK ---------------------------//

            public  static void AgregarStock(){

            }

            public static void ActualizarStock(){

            }


        }


