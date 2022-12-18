package negocio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.function.Predicate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import proyectoMineria.AdminSistema;
import proyectoMineria.AdminStock;
import proyectoMineria.AdminVentas;
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
        	String queryString = "INSERT INTO admin_stock(nombre, apellido, nombre_usuario, clave, admin_sistema_nombre_usuario, deposito_iddeposito) VALUES(?,?,?,?,?,?)";
            //String queryString = "INSERT INTO admin_stock(nombre, apellido, nombre_usuario, clave, admin_sistema_nombre_usuario) VALUES(?,?,?,?,?)";
            conexion = getConnection();
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevoStock.getNombre());
            ptmt.setString(2, nuevoStock.getApellido());
            ptmt.setString(3, nuevoStock.getNombreUsuario());
            ptmt.setString(4, nuevoStock.getClave());
            ptmt.setString(5, adminSistema.getNombreUsuario());
            ptmt.setInt(6, 1);
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
    
    public void eliminarAdminStock() {
        try {
            conexion = getConnection();

            String query = "DELETE FROM admin_stock WHERE nombre_usuario = ?";

            Object[] opciones = this.obtenerListaDeUsuariosStock();

            String usuarioAEliminar = (String) JOptionPane.showInputDialog(null, "Seleccionar usuario a eleminar",
                    "Eliminar", JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);

            ptmt = conexion.prepareStatement(query);
            ptmt.setString(1, usuarioAEliminar);

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

    // creo un array que contiene todos los nombres de usuario de la tabla
    private Object[] obtenerListaDeUsuariosStock() {
        try {

            String query = "SELECT nombre_usuario FROM admin_stock;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();

            ArrayList<String> lista = new ArrayList<>();
            while (resultSet.next()) {

                lista.add(resultSet.getString("nombre_usuario"));

            }
            return lista.toArray();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {

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
    
    public void mostrarStock() {
        try {

            // defino la query
            // Crea una tabla con las columnas: | nombre | apellido | calle | numero | ciudad | tipo | cantidad | pureza | vendedor | fecha | total |
            String queryString = "SELECT * FROM material ORDER BY fecha_de_ingreso DESC";
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
    
    public void mostrarStockTipo(String tipo) {
        try {

        	tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		String queryString = "SELECT tipo, pureza, SUM(cantidad) AS cantidad_total FROM material WHERE tipo = '"+tipo+"' GROUP BY pureza ORDER BY fecha_de_ingreso DESC";
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
	
    public void mostrarStockTipoPurezaAlta(String tipo) {
        try {

        	tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		String queryString = "SELECT tipo, pureza, fecha_de_ingreso,  cantidad FROM material WHERE tipo = '"+tipo+"' AND pureza = 'ALTA'";
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

    public void mostrarStockTipoPurezaMedia(String tipo) {
        try {

        	tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		String queryString = "SELECT tipo, pureza, fecha_de_ingreso,  cantidad FROM material WHERE tipo = '"+tipo+"' AND pureza = 'MEDIA'";
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
    
    public void mostrarStockTipoPurezaBaja(String tipo) {
        try {

        	tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		String queryString = "SELECT tipo, pureza, fecha_de_ingreso,  cantidad FROM material WHERE tipo = '"+tipo+"' AND pureza = 'BAJA'";
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
	
    public void agregarMaterial (Material material) {
    	try {
    		Material m = new Material();
    		 String query = "INSERT INTO material(tipo, pureza, cantidad, deposito_iddeposito) VALUES(?,?,?,1)";
             conexion = getConnection();
             ptmt = conexion.prepareStatement(query);
             m.setTipo(JOptionPane.showInputDialog("ingrese tipo de material"));
             ptmt.setString(1, m.getTipo());
             m.setPureza(JOptionPane.showInputDialog("ingrese pureza"));
             ptmt.setString(2, m.getPureza());
             m.setCantidad(Double.parseDouble(JOptionPane.showInputDialog("ingrese cantidad")));
             ptmt.setDouble(3, m.getCantidad());
             ptmt.executeUpdate();
             
            JOptionPane.showMessageDialog(null,"Se agrego con exito");
            
            String query2 = "SELECT * FROM material ORDER BY fecha_de_ingreso DESC";
            conexion = getConnection();
    		ptmt = conexion.prepareStatement(query2);
            resultSet = ptmt.executeQuery(query2);
            
            DefaultTableModel modeloDeTabla = new DefaultTableModel();
            
            Integer numeroDeColumnas = resultSet.getMetaData().getColumnCount();
            Object[] labelDeColumnas = new Object[numeroDeColumnas];
            
            for (int i = 0; i < numeroDeColumnas; i++) {
                labelDeColumnas[i] = resultSet.getMetaData().getColumnLabel(i+1);
            }
            
            modeloDeTabla.setColumnIdentifiers(labelDeColumnas);
            
            while (resultSet.next()) {

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
	 
    public void buscarMaterial (String tipo, String pureza) {
    	
    	try {
			
    		String query = "SELECT * FROM material WHERE tipo = ? AND pureza = ?";
    		conexion = getConnection();
    		ptmt = conexion.prepareStatement(query);
    		tipo = JOptionPane.showInputDialog("ingrese tipo de material requerido");
    		ptmt.setString(1, tipo);
    		pureza = JOptionPane.showInputDialog("ingrese tipo de pureza requerido");
    		ptmt.setString(2, pureza);
            ptmt.executeQuery();
            
            resultSet = ptmt.executeQuery();
            
            DefaultTableModel modeloDeTabla = new DefaultTableModel();
            
            Integer numeroDeColumnas = resultSet.getMetaData().getColumnCount();
            Object[] labelDeColumnas = new Object[numeroDeColumnas];
            
            for (int i = 0; i < numeroDeColumnas; i++) {
                labelDeColumnas[i] = resultSet.getMetaData().getColumnLabel(i+1);
            }
            
            modeloDeTabla.setColumnIdentifiers(labelDeColumnas);
            
            while (resultSet.next()) {

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
    
    public Boolean validarLogInStock(AdminStock adminAValidar) {

        try {

            conexion = getConnection();
            
            String query = "SELECT nombre_usuario, clave FROM admin_stock;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();

            ArrayList<AdminStock> listaDeAdminStock = new ArrayList<>();
            while (resultSet.next()) {
                
                String nombre_usuario = resultSet.getString("nombre_usuario");
                String clave = resultSet.getString("clave");
                
                AdminStock ventas = new AdminStock(nombre_usuario, clave, "ventas", true, null);

                listaDeAdminStock.add(ventas);

            }
            Predicate<AdminStock> coincideNombre = stock -> stock.getNombreUsuario().equals(adminAValidar.getNombreUsuario());
            Predicate<AdminStock> coincideClave = stock -> stock.getClave().equals(adminAValidar.getClave());
            Predicate<AdminStock> validacionFinal = coincideNombre.and(coincideClave);
            
            System.out.println(listaDeAdminStock.stream().
                    anyMatch(validacionFinal));
            
            return listaDeAdminStock.stream().
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


            
           /* while (resultSet.next()) {
            	int ID = resultSet.getInt(1);
            	String Material = resultSet.getString(2);
            	double Pureza = resultSet.getDouble(3);
            	double Cantidad = resultSet.getDouble(4);
            	Date Fecha_Ingreso = resultSet.getDate(5);
            	int ID_Deposito = resultSet.getInt(6);
            	
            	
            	System.out.println("ID: " + ID + 
            			" | Material: " + Material + 
            			" | Pureza: " + Pureza + 
            			" | Cantidad: " + Cantidad + 
            			" | ID_Deposito: " + ID_Deposito +
            			" | Fecha_Ingreso: " + Fecha_Ingreso);
            	
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
    }*/
    
    private Object[] listaDeMateriales() {
    	try {
    		
    		String query = "SELECT idmaterial FROM material;";
    		
    		ptmt = conexion.prepareStatement(query);
    		
    		resultSet = ptmt.executeQuery();
    		
    		ArrayList<String> listaMaterial = new ArrayList<>();
    		
    		while (resultSet.next()) {
    			
    			listaMaterial.add(resultSet.getString("idmaterial"));
    			}
    		return listaMaterial.toArray();
    		} catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
             } finally {
            	 try {
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

    
    public void eliminarMaterial() {
        try {
            conexion = getConnection();
            
            String query = "DELETE FROM material WHERE idmaterial = ?";
            
            Object[] opciones = this.listaDeMateriales();
            
            String materialAEliminar = (String) JOptionPane.showInputDialog(null, "Seleccionar material a eliminar", "Eliminar", 
            		JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
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

	public void hacerUnUpdatePorId(AdminStock adminStockAModificar) {
		// TODO Auto-generated method stub
    	
        try {
            conexion = getConnection();

            String query = "UPDATE `admin_stock` SET `nombre`= ?,`apellido`= ?,`clave`= ? WHERE nombre_usuario = ?";


           
            ptmt = conexion.prepareStatement(query);
            ptmt.setString(1, adminStockAModificar.getNombre());
            ptmt.setString(2, adminStockAModificar.getApellido());
            ptmt.setString(3, adminStockAModificar.getClave());
            ptmt.setString(4, adminStockAModificar.getNombreUsuario());
            
           

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

	public Object[] obtenerListaDeIdsStock() {
		// TODO Auto-generated method stub
		
        try {
        	
            conexion = getConnection();


            String query = "SELECT nombre_usuario FROM admin_stock;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();

            ArrayList<String> lista = new ArrayList<>();
            while (resultSet.next()) {

                lista.add(resultSet.getString("nombre_usuario"));

            }
            return lista.toArray();

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

	public AdminStock obtenerTodosLosDatosPorId(String nombreDeUsuario) {
		// TODO Auto-generated method stub
AdminStock stockDeLaDB = null;
		
        try {
        	
            conexion = getConnection();


            String query = "SELECT * FROM admin_stock WHERE nombre_usuario = ?;";

            ptmt = conexion.prepareStatement(query);
            
            ptmt.setString(1, nombreDeUsuario);

            resultSet = ptmt.executeQuery();
            
            if (resultSet.next()) {

                String nombre = resultSet.getString(1);
                String apellido = resultSet.getString(2);
                String nombreid = resultSet.getString(3);
                String clave = resultSet.getString(4);
                Long idDeposito = resultSet.getLong(6);
                
               stockDeLaDB = new AdminStock(nombre, apellido, nombreid, clave, idDeposito.intValue());
                
                

            }


            return stockDeLaDB;

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

	public void eliminarAdminStockPorId(String nombreDeUsuarioAEliminar) {
		// TODO Auto-generated method stub
    	try {
    		conexion = getConnection();
    		
    		String query = "DELETE FROM admin_stock WHERE nombre_usuario = ?";

    		
    		ptmt = conexion.prepareStatement(query);
    		ptmt.setString(1, nombreDeUsuarioAEliminar);
    		
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