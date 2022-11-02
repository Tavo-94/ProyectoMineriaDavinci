package proyectoMineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Conexion {

    Connection con = null ;
    

    public Connection conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            JOptionPane.showMessageDialog(null, "se conecto");
            this.setCon(con);
            
                        
        } catch (Exception e) {
    
            JOptionPane.showMessageDialog(null, "error al conectarse");
        }
        return con;     
    }
    
    public void mostrarTodaLaTabla() {
        try {
            
            String query = "SELECT * FROM mytable";
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                
                String nombre = rs.getString("name");//("name") es el nombre de la columna
                String numero = rs.getString("phone");//("phone")es el nombre de la columna
                String email = rs.getString("email");//("email") es el nombre de la columna
                String pais = rs.getString("country");//("country") es el nombre de la columna
                
                //printeo los resultados en consola
                System.out.println(nombre);
                System.out.println(numero);
                System.out.println(email);
                System.out.println(pais);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Connection getCon() {
        return con;
    }
    
    public void setCon(Connection con) {
        this.con = con;
    }
}
