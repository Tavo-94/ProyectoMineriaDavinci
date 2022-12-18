package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyectoMineria.AdminVentas;
import proyectoMineria.Cliente;
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
    
    public DireccionCliente obtenerTodosLosDatosPorId (Integer idCliente) {
    	DireccionCliente direccionDeLaDB = null;
		
       try {
       	
           conexion = getConnection();


           String query = "SELECT * FROM direccion WHERE cliente_idcliente = ?;";

           ptmt = conexion.prepareStatement(query);
           
           ptmt.setInt(1, idCliente);

           resultSet = ptmt.executeQuery();
           
           if (resultSet.next()) {

               Integer iddireccion = resultSet.getInt(1);
               String calle = resultSet.getString(2);
               String numero = resultSet.getString(3);
               String codigoPostal = resultSet.getString(4);
               String ciudad = resultSet.getString(5);
               
               direccionDeLaDB = new DireccionCliente(calle, numero, codigoPostal, ciudad);
               
               direccionDeLaDB.setIdDireccion(iddireccion);
               

           }


           return direccionDeLaDB;

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
    
    public void hacerUnUpdatePorId(DireccionCliente direccionAModificar) {
    	
        try {
            conexion = getConnection();

            String query = "UPDATE `direccion` SET `calle`= ?,`numero`= ?,`codigo_postal`= ?,`ciudad`= ? WHERE iddireccion = ?";


           
            ptmt = conexion.prepareStatement(query);
            ptmt.setString(1, direccionAModificar.getCalle());
            ptmt.setString(2, direccionAModificar.getAltura());
            ptmt.setString(3, direccionAModificar.getCodigoPostal());
            ptmt.setString(4, direccionAModificar.getCiudad());
            ptmt.setInt(5, direccionAModificar.getIdDireccion());
            
           

            ptmt.executeUpdate();
            System.out.println("Actualizado con exito");
            
            

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
    
    public void eliminarDireccion(Integer idCliente) {
        try {
            conexion = getConnection();

            String query = "DELETE FROM direccion WHERE cliente_idcliente = ?";


            ptmt = conexion.prepareStatement(query);
            ptmt.setInt(1, idCliente);

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
    
    
    


}
