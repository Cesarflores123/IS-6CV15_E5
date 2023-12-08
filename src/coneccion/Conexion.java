package coneccion;

import javax.swing.JOptionPane;
import java.sql.*;

public class Conexion {
    
    private static Connection conexion;
    
    private static Conexion instancia;
    
    private static final String URL = "jdbc:mysql://localhost/igsfull";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
            //JOptionPane.showMessageDialog(null,"Conexion exitosa");
            
            return conexion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " +  e);
        }
        return conexion;
    }
    public void cerrarConexion() throws SQLException{
        try{
            conexion.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: " + e);
            conexion.close();
        } finally{
            conexion.close();
        }
    }
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
        
}    

