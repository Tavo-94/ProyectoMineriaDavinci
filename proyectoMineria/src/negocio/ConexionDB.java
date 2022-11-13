package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    String driverClassName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/mineria";
    String dbUser = "root";
    String dbPwd = "";

    private static ConexionDB conexion = null;

    //constructor privado para encapsular la conexion
    private ConexionDB() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    //metodo q realiza la conexion a la base de datos
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    //metodo q crea la conexion
    public static ConexionDB getInstance() {
        //si la conexion no existe -> le asigno una nueva instacia llamando al constructor
        if (conexion == null) {
            conexion = new ConexionDB();
        }
        return conexion;
    }
}
