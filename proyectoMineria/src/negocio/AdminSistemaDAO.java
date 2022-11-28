package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

import proyectoMineria.AdminSistema;
import proyectoMineria.AdminVentas;

public class AdminSistemaDAO {

	
	Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
 // metodo privado q crea la conexion y se conecta a la DB
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }
    
    public Boolean validarLogInSistema(AdminSistema adminAValidar) {

        try {

            conexion = getConnection();
            
            String query = "SELECT nombre_usuario, clave FROM admin_sistema;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();

            ArrayList<AdminSistema> listaDeAdminSistema = new ArrayList<>();
            while (resultSet.next()) {
                
                String nombre_usuario = resultSet.getString("nombre_usuario");
                String clave = resultSet.getString("clave");
                
                AdminSistema ventas = new AdminSistema(nombre_usuario, clave, "ventas", true, null);

                listaDeAdminSistema.add(ventas);

            }
            Predicate<AdminSistema> coincideNombre = ventas -> ventas.getNombreUsuario().equals(adminAValidar.getNombreUsuario());
            Predicate<AdminSistema> coincideClave = ventas -> ventas.getClave().equals(adminAValidar.getClave());
            Predicate<AdminSistema> validacionFinal = coincideNombre.and(coincideClave);
            
            System.out.println(listaDeAdminSistema.stream().
                    anyMatch(validacionFinal));
            
            return listaDeAdminSistema.stream().
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


}
