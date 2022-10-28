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
    
    public void agregarNuevoCliente(Cliente nuevoCliente, AdminVentas adminVentas, DireccionCliente nuevaDireccion) {
        try {
            
            //defino la query
            String queryString = "INSERT INTO cliente(nombre, apellido, telefono, direccion_iddireccion, admin_ventas_nombre_usuario) VALUES(?,?,?,?,?)";
            //armo la conexion
            conexion = getConnection();
            
            DireccionDAO dirDAO = new DireccionDAO();
            int iddireccion = dirDAO.obtenerIdDeDireccion(nuevaDireccion);
            
            //preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevoCliente.getNombre());
            ptmt.setString(2, nuevoCliente.getApellido());
            ptmt.setString(3, nuevoCliente.getTelefono());
            ptmt.setInt(4, iddireccion); //id direccion
            ptmt.setString(5, adminVentas.getNombreUsuario());
            
            ptmt.executeUpdate();
            System.out.println("Se agrego con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //siempre cierro el Statement y la conexion al finalizar el metodo
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

    
}
