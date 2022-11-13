package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyectoMineria.AdminVentas;
import proyectoMineria.DireccionCliente;

public class DireccionDAO {

    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }
    
    public void agregarNuevadireccion(DireccionCliente nuevaDireccion) {
        try {
            
            //defino la query
            String queryString = "INSERT INTO direccion(calle, numero, codigo_postal, ciudad, cliente_idcliente) VALUES(?,?,?,?,?)";
            //armo la conexion
            conexion = getConnection();
            
            //preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevaDireccion.getCalle());
            ptmt.setString(2, nuevaDireccion.getAltura());
            ptmt.setString(3, nuevaDireccion.getCodigoPostal());
            ptmt.setString(4, nuevaDireccion.getCiudad());
            ptmt.setInt(5, nuevaDireccion.getIdCliente());
            
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
    
    //metodo q devuelve id de la direccion
    
    public int obtenerIdDeDireccion(DireccionCliente direccion) {
        try {
            
            //defino la query
            String queryString = "SELECT iddireccion FROM direccion where calle = ? AND altura = ?";
            //armo la conexion
            conexion = getConnection();
            
            //preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, direccion.getCalle());
            ptmt.setString(2, direccion.getAltura());
            
            resultSet = ptmt.executeQuery();
            
            
            return resultSet.getInt("iddireccion");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //siempre cierro el Statement y la conexion al finalizar el metodo
            try {
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
        
        return 0;
        
    }
    
    
    


}
