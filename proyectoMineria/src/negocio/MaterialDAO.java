package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
    

    // Metodos tabla material
    public ArrayList<Material> visualizarStock() {
        try {
            conexion = getConnection();

            // id deposito hardcodeado a 1 porque hay un solo deposito
            String query = "SELECT idmaterial, tipo, pureza, cantidad FROM material WHERE deposito_iddeposito = 1;";

            ptmt = conexion.prepareStatement(query);

            resultSet = ptmt.executeQuery();

            ArrayList<Material> listaDeMateriales = new ArrayList<>();

            while (resultSet.next()) {
                Material material = new Material(resultSet.getInt("idmaterial"), resultSet.getString("tipo"),
                        resultSet.getString("pureza"), resultSet.getDouble("cantidad"));

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

    //elimino los registros necesarios de la tabla material en funcion de la cantidad y la pureza del material comprado
    public void eliminarMaterialCompradoDeLaTablaMaterial(Material materialComprado) {
        
        //obtengo la lista de materiales completa
        ArrayList<Material> listaDeMateriales = new ArrayList<>();

        listaDeMateriales = this.visualizarStock();

        //la filtro en funcion de la pureza del material comprado
        ArrayList<Material> listaFiltradaPorPureza = listaDeMateriales.stream()
                .filter(mat -> mat.getPureza() == materialComprado.getPureza())
                .collect(Collectors.toCollection(ArrayList::new));

        //recorro la lista filtrada
        for (Material material : listaFiltradaPorPureza) {
            if (material.getCantidad() <= materialComprado.getCantidad()) {
                //si la cantidad comprada es mayor o igual a la del registro entonces...
                //lo elimino de la tabla pasando su id como parametro
                this.eliminarRegistroMaterial(material.getIdMaterial());
                
                //actualizo la cantiadad de material comprado restandole lo que ya elimine de la base de datos
                materialComprado.setCantidad(materialComprado.getCantidad() - material.getCantidad());
            } else if (material.getCantidad() > materialComprado.getCantidad()) {
                
                //si la cantidad del registro es mayor a la cantiadad de material comrprado entonces...
                //Realizo un update de este registro en su columna cantidad restandole la cantidad del material pedido
                material.setCantidad(material.getCantidad() - materialComprado.getCantidad());

                //ejecuto el update pasando el id del registro y la cantidad actualizada
                this.modificarCantidadDeUnRegistroMaterial(material.getIdMaterial(), material.getCantidad());

                //actualizo la cantidad de material comprado a 0
                materialComprado.setCantidad(0d);
            }

            //si la cantidad del material comprado = 0 rompo el loop
            if (materialComprado.getCantidad() == 0) {
                break;
            }
        }
    }

    private void eliminarRegistroMaterial(Integer idMaterial) {

        try {

            // defino la query
            String queryString = "DELETE FROM material WHERE idmaterial = ?";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setInt(1, idMaterial);

            ptmt.executeUpdate();
            System.out.println("Se elimino con exito");
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

    private void modificarCantidadDeUnRegistroMaterial(Integer idMaterial, Double cantidad) {

        try {

            // defino la query
            String queryString = "UPDATE material SET cantidad = ? WHERE idmaterial = ?";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setDouble(1, cantidad);
            ptmt.setInt(2, idMaterial);

            ptmt.executeUpdate();
            System.out.println("Se elimino con exito");
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

    // Metodos tabla material_pedido
    public void agregarNuevoMaterialPedido(Material material) {
        try {

            // defino la query
            String queryString = "INSERT INTO material_pedido(tipo, pureza, cantidad, precio) VALUES(?,?,?,?)";
            // armo la conexion
            conexion = getConnection();

            // preparo el statement que ejecuta la query
            ptmt = conexion.prepareStatement(queryString);
            ptmt.setString(1, material.getTipo());
            ptmt.setString(2, material.getPureza());
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
