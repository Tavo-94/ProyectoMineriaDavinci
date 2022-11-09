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
import proyectoMineria.Mineria;
import proyectoMineria.Validaciones;

public class AdminStockDAO {

    
    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    Validaciones v = new Validaciones();
    
    public AdminStockDAO(String nombreUsuario, String clave, String cargo, Boolean estadoActivo, Mineria mineria) {
        super();
    }

	public AdminStockDAO() {
		// TODO Auto-generated constructor stub
	}

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
    
    
    public void agregarMaterial (Material material ) {
    	try {
    		Material m = new Material();
    		 String query = "INSERT INTO material(tipo, pureza, cantidad, deposito_iddeposito) VALUES(?,?,?,1)";
             conexion = getConnection();
             ptmt = conexion.prepareStatement(query);
             m.setTipo(JOptionPane.showInputDialog("ingrese tipo de material"));
             ptmt.setString(1, m.getTipo());
             m.setPureza(Double.parseDouble(JOptionPane.showInputDialog("ingrese pureza")));
             ptmt.setDouble(2, m.getPureza());
             m.setCantidad(Double.parseDouble(JOptionPane.showInputDialog("ingrese cantidad")));
             ptmt.setDouble(3, m.getCantidad());
             ptmt.executeUpdate();
             
            JOptionPane.showMessageDialog(null,"Se agrego con exito");
             
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
	
		public void mostrarStock () {
    	try {
			
    		String query = "SELECT * FROM material";
    		conexion = getConnection();
    		ptmt = conexion.prepareStatement(query);
            resultSet = ptmt.executeQuery(query);
            
            while (resultSet.next()) {
            	int ID = resultSet.getInt(1);
            	String Material = resultSet.getString(2);
            	double Pureza = resultSet.getDouble(3);
            	double Cantidad = resultSet.getDouble(4);
            	int ID_Deposito = resultSet.getInt(5);
            	
            	System.out.println("ID: " + ID + 
            			" | Material: " + Material + 
            			" | Pureza: " + Pureza + 
            			" | Cantidad: " + Cantidad + 
            			" | ID_Deposito: " + ID_Deposito);
            	
			}
    		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        try {
        	if (ptmt != null)
                ptmt.close();
        	if (conexion != null)
                conexion.close();
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
		
	    public void mostrarStockTipo(String tipo) {	
	    	try {
				
	    		String query = "SELECT tipo, pureza, SUM(cantidad) FROM material WHERE tipo = '?' GROUP BY cantidad";
	    		conexion = getConnection();
	    		ptmt = conexion.prepareStatement(query);
	    		tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
	    		ptmt.setString(2, tipo);
	            resultSet = ptmt.executeQuery();
	            
	            while (resultSet.next()) {
	            	int ID = resultSet.getInt(1);
	            	String Material = resultSet.getString(2);
	            	double Pureza = resultSet.getDouble(3);
	            	double Cantidad = resultSet.getDouble(4);
	            	int ID_Deposito = resultSet.getInt(5);
	            	
	            	System.out.println("ID: " + ID + 
	            			" | Material: " + Material + 
	            			" | Pureza: " + Pureza + 
	            			" | Cantidad: " + Cantidad + 
	            			" | ID_Deposito: " + ID_Deposito);
	            }
	    		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
	        try {
	        	if (ptmt != null)
	                ptmt.close();
	        	if (conexion != null)
	                conexion.close();
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
    
    public void mostrarStockTipoPurezaAlta(String tipo) {
    	try {
			
    		String query = "SELECT tipo, pureza, SUM(cantidad) AS cantidad_total FROM material WHERE tipo = '?' AND pureza BETWEEN 70 AND 100 GROUP BY cantidad";
    		conexion = getConnection();
    		ptmt = conexion.prepareStatement(query);
    		tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		ptmt.setString(1, tipo);
            ptmt.executeUpdate();
            
            resultSet = ptmt.executeQuery();
    		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        try {
        	if (ptmt != null)
                ptmt.close();
        	if (conexion != null)
                conexion.close();
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
    
    public void mostrarStockTipoPurezaMedia(String tipo ) {
    	try {
			
    		String query = "SELECT tipo, pureza, SUM(cantidad) AS cantidad_total FROM material WHERE tipo = '?' AND pureza BETWEEN 50 AND 69 GROUP BY cantidad";
    		conexion = getConnection();
    		ptmt = conexion.prepareStatement(query);
    		tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		ptmt.setString(1, tipo);
            ptmt.executeUpdate();
            
            resultSet = ptmt.executeQuery();
    		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        try {
        	if (ptmt != null)
                ptmt.close();
        	if (conexion != null)
                conexion.close();
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
    
    public void mostrarStockTipoPurezaBaja (String tipo) {
    	try {
			
    		String query = "SELECT tipo, pureza, SUM(cantidad) AS cantidad_total FROM material WHERE tipo = '?' AND pureza <= 49 GROUP BY cantidad";
    		conexion = getConnection();
    		ptmt = conexion.prepareStatement(query);
    		tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		ptmt.setString(1, tipo);
            ptmt.executeUpdate();
            
            resultSet = ptmt.executeQuery();
    		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        try {
        	if (ptmt != null)
                ptmt.close();
        	if (conexion != null)
                conexion.close();
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
    
    
    public void buscarMaterial (String tipo ) {
    	
    	try {
			
    		String query = "SELECT * FROM material WHERE tipo = '?'";
    		conexion = getConnection();
    		ptmt = conexion.prepareStatement(query);
    		tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		ptmt.setString(1, tipo);
    		
            ptmt.executeQuery();
    		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        try {
        	if (ptmt != null)
                ptmt.close();
        	if (conexion != null)
                conexion.close();
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
    
    public void eliminarMaterial() {
        try {
            conexion = getConnection();
            
            String query = "DELETE FROM material WHERE idmaterial = ?";
            
            String materialAEliminar = (String) JOptionPane.showInputDialog
            		(null, "Seleccionar material a eliminar", "Eliminar", JOptionPane.DEFAULT_OPTION);
            ptmt = conexion.prepareStatement(query);
            ptmt.setString(1, materialAEliminar);
            
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Eliminado con exito");
            
            
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