package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import proyectoMineria.Material;

public class MaterialDAO {

    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }
    
    //Metodos tabla material
    public ArrayList<Material> visualizarStock() {
        try {
            conexion = getConnection();

            //id deposito hardcodeado a 1 porque hay un solo deposito
            String query = "SELECT idmaterial, tipo, pureza, cantidad FROM material WHERE deposito_iddeposito = 1;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();
            
            ArrayList<Material> listaDeMateriales = new ArrayList<>();
            
            while (resultSet.next()) {
                Material material = new Material(resultSet.getInt("idmaterial"), resultSet.getString("tipo"), resultSet.getDouble("pureza"), resultSet.getDouble("cantidad"));
            
                listaDeMateriales.add(material);
            }

            return listaDeMateriales;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
        return null;
    }
    
    
    //Metodos tabla material_pedido
    public void agregarNuevoMaterialPedido(Material material) {
        try {

            // defino la query
            String queryString = "INSERT INTO material_pedido(tipo, pureza, cantidad, precio) VALUES(?,?,?,?)";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, material.getTipo());
            ptmt.setDouble(2, material.getPureza());
            ptmt.setDouble(3, material.getCantidad());
            ptmt.setDouble(4, material.getPrecioBase());

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
    
    public Integer obtenerUltimoIDMaterialPedido() {

        try {
            conexion = getConnection();

            String query = "SELECT MAX(idmaterial) AS ultimo_id FROM material_pedido;";

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
