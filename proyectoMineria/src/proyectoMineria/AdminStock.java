package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import proyectoMineria.AdminSistema;
import proyectoMineria.AdminStock;
import proyectoMineria.Deposito;
import proyectoMineria.Material;

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
            String queryString = "INSERT INTO admin_stock(nombre, apellido, nombre_usuario, clave, admin_sistema_nombre_usuario) VALUES(?,?,?,?,?)";
            conexion = getConnection();
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevoStock.getNombre());
            ptmt.setString(2, nuevoStock.getApellido());
            ptmt.setString(3, nuevoStock.getNombreUsuario());
            ptmt.setString(4, nuevoStock.getClave());
            ptmt.setString(5, adminSistema.getNombreUsuario());
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
    
    public void agregarMaterial (Material agregarMaterial ) {
    	try {
    		 String query = "INSERT INTO material(idmaterial, tipo, pureza, cantidad, deposito_iddeposito) VALUES(?,?,?,?,?)";
             conexion = getConnection();
             ptmt = conexion.prepareStatement(query);
             ptmt.setString(1, agregarMaterial.getTipo());
             ptmt.setDouble(2, agregarMaterial.getPureza());
             ptmt.setDouble(3, agregarMaterial.getCantidad());
             ptmt.setInt(4, 0);
             
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
    
    public Deposito buscarMaterial (Material buscarMaterial ) {
    	
    	try {
			
    		String query = "SELECT tipo, SUM(cantidad) FROM material WHERE tipo = '?' GROUP BY cantidad";
    		conexion = getConnection();
    		ptmt = conexion.prepareStatement(query);
    		ptmt.setString(0, query);
    		
            ptmt.executeUpdate();
    		
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
		return null;
    	
    }
    
    public void eliminarMaterial() {
        try {
            conexion = getConnection();
            
            String query = "DELETE FROM material WHERE idmaterial = ?";
            
            String materialAEliminar = (String) JOptionPane.showInputDialog
            		(null, "Seleccionar material a eliminar", "Eliminar", JOptionPane.DEFAULT_OPTION);
            ptmt = conexion.prepareStatement(query);
            ptmt.setString(1, materialAEliminar);
            
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
