package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import proyectoMineria.AdminSistema;
import proyectoMineria.AdminStock;

public class AdminStockDAO {

    
    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }
    
    public void agregarNuevoAdminStock(AdminStock nuevoStock, AdminSistema adminSistema) {
        try {
            String queryString = "INSERT INTO admin_stock(nombre, apellido, nombre_usuario, clave, deposito_iddeposito, admin_sistema_nombre_usuario) VALUES(?,?,?,?,?,?)";
            conexion = getConnection();
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevoStock.getNombre());
            ptmt.setString(2, nuevoStock.getApellido());
            ptmt.setString(3, nuevoStock.getNombreUsuario());
            ptmt.setString(4, nuevoStock.getClave());
            ptmt.setInt(5, 1);
            ptmt.setString(6, adminSistema.getNombreUsuario());
            ptmt.executeUpdate();
            System.out.println("Se agrego con exito");
        } catch (SQLException e) {
            
            
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (conexion != null)
                    conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    
    public void eliminarAdminStock() {
        try {
            conexion = getConnection();

            String query = "DELETE FROM admin_stock WHERE nombre_usuario = ?";

            Object[] opciones = this.obtenerListaDeUsuariosStock();

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
    private Object[] obtenerListaDeUsuariosStock() {
        try {

            String query = "SELECT nombre_usuario FROM admin_stock;";

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

    
}
