package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyectoMineria.AdminVentas;
import proyectoMineria.Cliente;
import proyectoMineria.Material;
import proyectoMineria.TicketOperacion;

public class TicketOperacionDAO {

    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }
    
    public void agregarNuevoTicketOperacionDelPedido(TicketOperacion nuevoTicketOperacion, AdminVentas vendedor, Cliente cliente, Material materialPedido) {
        try {

            // defino la query
            String queryString = "INSERT INTO pedido(fecha, total, admin_ventas_nombre_usuario, cliente_idcliente, material_pedido_idmaterial) VALUES(?,?,?,?,?)";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setDate(1, java.sql.Date.valueOf(nuevoTicketOperacion.getFechaDeOperacion()));
            ptmt.setDouble(2, nuevoTicketOperacion.getTotal());
            ptmt.setString(3, vendedor.getNombreUsuario());
            ptmt.setInt(4, Long.valueOf(cliente.getIdCliente()).intValue());
            ptmt.setInt(5, materialPedido.getIdMaterial());

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
    

}
