package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyectoMineria.AdminSistema;
import proyectoMineria.AdminVentas;

public class AdminVentasDao {

    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    
    //metodo privado q crea la conexion y se conecta a la DB
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }
    
    public void agregarNuevoAdminVentas(AdminVentas nuevoVentas, AdminSistema adminSistema) {
        try {
            
            //defino la query
            String queryString = "INSERT INTO admin_ventas(nombre, apellido, nombre_usuario, clave, admin_sistema_nombre_usuario) VALUES(?,?,?,?,?)";
            //armo la conexion
            conexion = getConnection();
            
            //preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevoVentas.getNombre());
            ptmt.setString(2, nuevoVentas.getApellido());
            ptmt.setString(3, nuevoVentas.getNombreUsuario());
            ptmt.setString(4, nuevoVentas.getClave());
            ptmt.setString(5, adminSistema.getNombreUsuario());
            ptmt.executeUpdate();
            System.out.println("Se agrego con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //siempre cierro el Statement y la conexion al finalizar el metodo
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
    
    public Boolean validarNombreDeUsuario(String nombreDeUsuario) {
        
        // Falta implementar
        
        return null;
    }
}
