package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import proyectoMineria.AdminSistema;
import proyectoMineria.AdminVentas;

public class AdminVentasDao {

    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    // metodo privado q crea la conexion y se conecta a la DB
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }

    public void agregarNuevoAdminVentas(AdminVentas nuevoVentas, AdminSistema adminSistema) {
        try {

            // defino la query
            String queryString = "INSERT INTO admin_ventas(nombre, apellido, nombre_usuario, clave, deposito_iddeposito, admin_sistema_nombre_usuario) VALUES(?,?,?,?,?,?)";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevoVentas.getNombre());
            ptmt.setString(2, nuevoVentas.getApellido());
            ptmt.setString(3, nuevoVentas.getNombreUsuario());
            ptmt.setString(4, nuevoVentas.getClave());
            ptmt.setInt(5, 1); //hardcode de id deposito = 1 xq hay un solo deposito
            ptmt.setString(6, adminSistema.getNombreUsuario());

            ptmt.executeUpdate();
            System.out.println("Se agrego con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // siempre cierro el Statement y la conexion al finalizar el metodo
            try {
                if (ptmt != null) {
                    ptmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void eliminarAdminVentas() {
        try {
            conexion = getConnection();

            String query = "DELETE FROM admin_ventas WHERE nombre_usuario = ?";

            Object[] opciones = this.obtenerListaDeUsuariosVentas();

            String usuarioAEliminar = (String) JOptionPane.showInputDialog(null, "Seleccionar usuario a eleminar",
                    "Eliminar", JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);

            ptmt = conexion.prepareStatement(query);
            ptmt.setString(1, usuarioAEliminar);

            ptmt.executeUpdate();
            System.out.println("Eliminado con exito");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null) {
                    ptmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // creo un array que contiene todos los nombres de usuario de la tabla
    private Object[] obtenerListaDeUsuariosVentas() {
        try {

            String query = "SELECT nombre_usuario FROM admin_ventas;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();

            ArrayList<String> lista = new ArrayList<>();
            while (resultSet.next()) {

                lista.add(resultSet.getString("nombre_usuario"));

            }
            return lista.toArray();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public Boolean validarLoginVentas(AdminVentas adminAValidar) {

        try {

            conexion = getConnection();
            
            String query = "SELECT nombre_usuario, clave FROM admin_ventas;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();

            ArrayList<AdminVentas> listaDeAdminVentas = new ArrayList<>();
            while (resultSet.next()) {
                
                String nombre_usuario = resultSet.getString("nombre_usuario");
                String clave = resultSet.getString("clave");
                
                AdminVentas ventas = new AdminVentas(nombre_usuario, clave, "ventas", true, null);

                listaDeAdminVentas.add(ventas);

            }
            Predicate<AdminVentas> coincideNombre = ventas -> ventas.getNombreUsuario().equals(adminAValidar.getNombreUsuario());
            Predicate<AdminVentas> coincideClave = ventas -> ventas.getClave().equals(adminAValidar.getClave());
            Predicate<AdminVentas> validacionFinal = coincideNombre.and(coincideClave);
            
            System.out.println(listaDeAdminVentas.stream().
                    anyMatch(validacionFinal));
            
            return listaDeAdminVentas.stream().
                    anyMatch(validacionFinal);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {

                if (conexion != null) {
                    conexion.close();
                }
                if (ptmt != null) {
                    ptmt.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public Boolean validarNombreDeUsuario(String nombreDeUsuario) {

        // Falta implementar

        return null;
    }
}
