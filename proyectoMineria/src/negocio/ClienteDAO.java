package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyectoMineria.AdminSistema;
import proyectoMineria.AdminVentas;
import proyectoMineria.Cliente;
import proyectoMineria.DireccionCliente;

public class ClienteDAO {
    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }

    public void agregarNuevoCliente(Cliente nuevoCliente, AdminVentas adminVentas) {
        try {

            // defino la query
            String queryString = "INSERT INTO cliente(nombre, apellido, telefono, admin_ventas_nombre_usuario) VALUES(?,?,?,?)";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevoCliente.getNombre());
            ptmt.setString(2, nuevoCliente.getApellido());
            ptmt.setString(3, nuevoCliente.getTelefono());
            ptmt.setString(4, adminVentas.getNombreUsuario());

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

    public Integer obtenerUltimoIDDeCliente() {

        try {
            conexion = getConnection();

            String query = "SELECT MAX(idcliente) AS ultimo_id FROM cliente;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();
            
            if (resultSet.next()) {
                resultSet.first();
                System.out.println(resultSet.getInt("ultimo_id"));
                return resultSet.getInt("ultimo_id");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

}
