package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import proyectoMineria.AdminSistema;
import proyectoMineria.AdminVentas;
import proyectoMineria.Cliente;
import proyectoMineria.DireccionCliente;

public class ClienteDAO {
    Connection conexion = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConexionDB.getInstance().getConnection();
        return conn;
    }

    public void agregarNuevoCliente(Cliente nuevoCliente, AdminVentas adminVentas) {
        try {

            // defino la query
            String queryString = "INSERT INTO cliente(nombre, apellido, telefono, admin_ventas_nombre_usuario) VALUES(?,?,?,?)";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, nuevoCliente.getNombre());
            ptmt.setString(2, nuevoCliente.getApellido());
            ptmt.setString(3, nuevoCliente.getTelefono());
            ptmt.setString(4, adminVentas.getNombreUsuario());

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

    public Integer obtenerUltimoIDDeCliente() {

        try {
            conexion = getConnection();

            String query = "SELECT MAX(idcliente) AS ultimo_id FROM cliente;";

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
    
    
    public Cliente obtenerDatosPorId(Integer id) {
        try {

            // defino la query
            String queryString = "SELECT `idcliente`, `nombre`, `apellido`, `telefono` FROM `cliente` WHERE idcliente = ?";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setInt(1, id);
            
            resultSet = ptmt.executeQuery();
            
            if (resultSet.next()) {

            	Integer idcliente = resultSet.getInt(1);
            	String nombre = resultSet.getString(2);
            	String apellido = resultSet.getString(3);
            	String telefono = resultSet.getString(4);
            	
            	Cliente clientePorId = new Cliente (idcliente, nombre, apellido, telefono);
            	
            	return clientePorId;
			}
            
            
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
		return null;

    }

	public DefaultTableModel modeloParaJTable() {
		// TODO Auto-generated method stub
		try {
			conexion = getConnection();

			// id deposito hardcodeado a 1 porque hay un solo deposito
			String query = "SELECT * FROM cliente WHERE 1;";

			ptmt = conexion.prepareStatement(query);

			resultSet = ptmt.executeQuery();

			DefaultTableModel modeloDeTabla = new DefaultTableModel();

			Integer numeroDeColumnas = resultSet.getMetaData().getColumnCount();
			Object[] labelDeColumnas = new Object[numeroDeColumnas];

			for (int i = 0; i < numeroDeColumnas; i++) {
				labelDeColumnas[i] = resultSet.getMetaData().getColumnLabel(i + 1);
			}

			modeloDeTabla.setColumnIdentifiers(labelDeColumnas);

			while (resultSet.next()) {

				Object[] fila = new Object[numeroDeColumnas];

				for (int i = 0; i < numeroDeColumnas; i++) {
					fila[i] = resultSet.getObject(i + 1);
				}

				modeloDeTabla.addRow(fila);
			}

			return modeloDeTabla;
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
	
	
	   public void hacerUnUpdatePorId(Cliente clienteAModificar) {
	    	
	        try {
	            conexion = getConnection();

	            String query = "UPDATE `cliente` SET `nombre`= ?,`apellido`= ?,`telefono`= ? WHERE idcliente = ?";


	           
	            ptmt = conexion.prepareStatement(query);
	            ptmt.setString(1, clienteAModificar.getNombre());
	            ptmt.setString(2, clienteAModificar.getApellido());
	            ptmt.setString(3, clienteAModificar.getTelefono());
	            ptmt.setInt(4, clienteAModificar.getIdCliente());
	            
	           

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
	   
	   public void eliminarCliente(Integer idCliente) {
	        try {
	            conexion = getConnection();

	            String query = "DELETE FROM cliente WHERE idcliente = ?";


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
