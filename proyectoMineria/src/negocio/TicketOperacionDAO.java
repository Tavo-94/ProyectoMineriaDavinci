package negocio;

import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    //muestro todas la ventas

    public void mostrarTodasLasOperaciones() {
        try {

            // defino la query
            // Crea una tabla con las columnas: | nombre | apellido | calle | numero | ciudad | tipo | cantidad | pureza | vendedor | fecha | total |
            String queryString = "SELECT cliente_con_direccion.nombre,\r\n"
                    + "    cliente_con_direccion.apellido,\r\n"
                    + "    cliente_con_direccion.calle,\r\n"
                    + "    cliente_con_direccion.numero,\r\n"
                    + "    cliente_con_direccion.ciudad,\r\n"
                    + "    material_pedido.tipo,\r\n"
                    + "    material_pedido.cantidad,\r\n"
                    + "    material_pedido.pureza,\r\n"
                    + "    pedido.admin_ventas_nombre_usuario AS vendedor,\r\n"
                    + "    pedido.fecha,\r\n"
                    + "    pedido.total\r\n"
                    + "FROM (\r\n"
                    + "    SELECT * FROM cliente\r\n"
                    + "    INNER JOIN direccion\r\n"
                    + "        ON cliente.idcliente = direccion.cliente_idcliente\r\n"
                    + ")AS cliente_con_direccion\r\n"
                    + "JOIN pedido\r\n"
                    + "    on pedido.cliente_idcliente = cliente_con_direccion.idcliente\r\n"
                    + "JOIN material_pedido\r\n"
                    + "    ON pedido.material_pedido_idmaterial = material_pedido.idmaterial\r\n"
                    + ";";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            
            resultSet = ptmt.executeQuery();
            
            DefaultTableModel modeloDeTabla = new DefaultTableModel();
            
            Integer numeroDeColumnas = resultSet.getMetaData().getColumnCount();
            Object[] labelDeColumnas = new Object[numeroDeColumnas];
            
            for (int i = 0; i < numeroDeColumnas; i++) {
                labelDeColumnas[i] = resultSet.getMetaData().getColumnLabel(i+1);
            }
            
            modeloDeTabla.setColumnIdentifiers(labelDeColumnas);
            
            while (resultSet.next()) {

                System.out.println(resultSet.getString("nombre") + " | " + resultSet.getString("apellido"));
                Object[] fila = new Object[numeroDeColumnas];
                
                for (int i = 0; i < numeroDeColumnas; i++) {
                    fila[i] = resultSet.getObject(i+1);
                }
                
                modeloDeTabla.addRow(fila);
            }
            
            JTable tabla = new JTable(modeloDeTabla);
            
            JFrame cuadrito = new JFrame("Test de Cuadrito");
            
            cuadrito.add(tabla);
            
            JOptionPane.showMessageDialog(null, new JScrollPane(tabla));
            
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
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
